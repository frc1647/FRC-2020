/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems.Swerve;

import java.lang.Math;
import frc.robot.subsystems.Swerve.CentricMode;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class SwerveMath {
    private final double length;
    private final double width;
    private final double diagonal;

    private CentricMode centricMode = CentricMode.Field;

    public void setModeRobot() {
        centricMode = CentricMode.Robot;
    }

    public void setModeField() {
        centricMode = CentricMode.Field;
    }
    public CentricMode getCentricMode() {
		return centricMode;
    }
    public void toggleCentricMode() {
		switch(centricMode) {
		case Robot:
			centricMode=CentricMode.Field;
			break;
		case Field:
			centricMode=CentricMode.Robot;
			break;
			}
	}

    public SwerveMath(double width, double length){
        // frDrive.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute);
        // flDrive.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute);
        // rrDrive.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute);
        // rlDrive.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute);
        // frSteer.configSelectedFeedbackSensor(FeedbackDevice.Analog);
        // flSteer.configSelectedFeedbackSensor(FeedbackDevice.Analog);
        // rrSteer.configSelectedFeedbackSensor(FeedbackDevice.Analog);
        // rlSteer.configSelectedFeedbackSensor(FeedbackDevice.Analog);
    
        this.width = width;
        this.length = length;
        diagonal = Math.sqrt(Math.pow(length, 2) + Math.pow(width, 2));
    }

    public void move(double fwd, double str, double rcw, double gyroVal, SwerveDirective[] swerveDirectives){
    //4048's (and everyone else's) field centric math code
    if (isFieldCentric()){
        double gyro = (gyroVal * Math.PI) / 180;
        double temp = fwd * Math.cos(gyro) + str * Math.sin(gyro);
        str = -fwd * Math.sin(gyro) + str * Math.cos(gyro);
        fwd = temp;
    }

    //calculates how far off the robot angle is relative to the field
    //double gyroOffset = RobotMap.navx.getAngle();
    double gyroOffset = ((gyroVal % 360) + 360) % 360;

    /*while(gyroOffset > 360){
      gyroOffset -= 360;
    }
    while(gyroOffset < 0){
      gyroOffset += 360;
    }
    */
    if(gyroOffset > 180){
      gyroOffset = -(360 - gyroOffset);
    }
    /*if(gyroOffset < 180){
      gyroOffset = gyroOffset;
    }*/
    
    double a = str - rcw*(length/diagonal);
    double b = str + rcw*(length/diagonal);
    double c = fwd - rcw*(width/diagonal);
    double d = fwd + rcw*(width/diagonal);

    double frs = Math.sqrt(Math.pow(b,2)+Math.pow(c,2)); 
    double fls = Math.sqrt(Math.pow(b,2)+Math.pow(d,2));
    double rrs = Math.sqrt(Math.pow(a,2)+Math.pow(d,2));
    double rls = Math.sqrt(Math.pow(a,2)+Math.pow(c,2));
    
    double fra;
    double fla;
    double rra;
    double rla;

    /*if(isFieldCentric() && rcw == 0){
        fra = Math.atan2(b,c)*180/Math.PI + gyroOffset;
        fla = Math.atan2(b,d)*180/Math.PI + gyroOffset;
        rra = Math.atan2(a,d)*180/Math.PI + gyroOffset;
        rla = Math.atan2(a,c)*180/Math.PI + gyroOffset;
    }else{*/
    fra = Math.atan2(b,c)*180/Math.PI;
    fla = Math.atan2(b,d)*180/Math.PI;
    rra = Math.atan2(a,d)*180/Math.PI;
    rla = Math.atan2(a,c)*180/Math.PI;
    // __ = arctan(str, fwd)*180/pi - gyroOffset
    //}

    //double temp = (fwd*Math.cos(gyro.getAngle())) + str*Math.sin(gyro.getAngle());
    double max = frs; 
    if(fls>max){
    	max = fls;
    }
    if(rls>max){
    	max = rls;
    }
    if(rrs>max){
    	max = rrs;
    }
    if(max>1){
    	frs/=max;
    	fls/=max;
    	rrs/=max;
    	rls/=max;
    }
    //changes -180 to 180 angles to -0.5 to 0.5 angles 
    fra /= 360;
    fla /= 360;
    rra /= 360;
    rla /= 360;

    setDirective(swerveDirectives[0], fra, frs);
    setDirective(swerveDirectives[1], fla, fls);
    setDirective(swerveDirectives[2], rra, rrs);
    setDirective(swerveDirectives[3], rla, rls);

    }

private void setDirective(SwerveDirective swerveDirective, double angle, double speed){
    swerveDirective.setAngle(angle);
    swerveDirective.setSpeed(speed);
}
private boolean isFieldCentric(){
    return centricMode.equals(CentricMode.Field);
}

}