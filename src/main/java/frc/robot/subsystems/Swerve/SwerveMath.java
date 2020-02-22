/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems.Swerve;

import java.lang.Math;

import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class SwerveMath {
    private final double length;
    private final double width;
    private final double diagonal;

    boolean FR_isReversed = false;
    boolean FL_isReversed = false;
    boolean RR_isReversed = false;
    boolean RL_isReversed = false;
    
    static double last_fra;
    static double last_fla;
    static double last_rra;
    static double last_rla;


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
    /* WORKING SWERVE CODE
        //Module sun gears face the OUTER RIM of the robot.
        double a = str - rcw*(length/diagonal);
        double b = str + rcw*(length/diagonal);
        double c = fwd - rcw*(width/diagonal);
        double d = fwd + rcw*(width/diagonal);

        double frs = Math.sqrt(Math.pow(b,2)+Math.pow(c,2)); 
        double fls = -Math.sqrt(Math.pow(b,2)+Math.pow(d,2));
        double rrs = Math.sqrt(Math.pow(a,2)+Math.pow(d,2));
        double rls = -Math.sqrt(Math.pow(a,2)+Math.pow(c,2));
        
        double fra = Math.atan2(b,c)*180/Math.PI;
        double fla = Math.atan2(b,d)*180/Math.PI;
        double rra = Math.atan2(a,d)*180/Math.PI;
        double rla = Math.atan2(a,c)*180/Math.PI; 

        if(rcw != 0 && fwd == 0 && str == 0){
            fra = Math.atan2(b,c)*180/Math.PI - 90;
            fla = Math.atan2(b,d)*180/Math.PI + 90;
        }//*/

        ///*EXPERIMENTAL REVERSE CODE
        double a = str - rcw*(length/diagonal);
        double b = str + rcw*(length/diagonal);
        double c = fwd - rcw*(width/diagonal);
        double d = fwd + rcw*(width/diagonal);

        

        double fra = Math.atan2(b,c)*180/Math.PI;
        double fla = Math.atan2(b,d)*180/Math.PI;
        double rra = Math.atan2(a,d)*180/Math.PI;
        double rla = Math.atan2(a,c)*180/Math.PI; 
        
        if(rcw != 0 && fwd == 0 && str == 0){
            fra = Math.atan2(b,c)*180/Math.PI - 90;
            fla = Math.atan2(b,d)*180/Math.PI + 90;
        }

        double FR_angle1 = Math.abs(fra - last_fra);
        double FL_angle1 = Math.abs(fla - last_fla);
        double RR_angle1 = Math.abs(rra - last_rra);
        double RL_angle1 = Math.abs(rla - last_rla);

        double FR_angle2 = Math.abs(180 - FR_angle1);
        double FL_angle2 = Math.abs(180 - FL_angle1);
        double RR_angle2 = Math.abs(180 - RR_angle1);
        double RL_angle2 = Math.abs(180 - RL_angle1);

        fra = (FR_angle1 <= FR_angle2) ? fra : -(180 - fra);
        FR_isReversed = (FR_angle1 <= FR_angle2) ? false : true;

        fla = (FL_angle1 <= FL_angle2) ? fla : -(180 - fla);
        FL_isReversed = (FL_angle1 <= FL_angle2) ? false : true;

        rra = (RR_angle1 <= RR_angle2) ? rra : -(180 - rra);
        RR_isReversed = (RR_angle1 <= RR_angle2) ? false : true;
        
        rla = (RL_angle1 <= RL_angle2) ? rla : -(180 - rla);
        RL_isReversed = (RL_angle1 <= RL_angle2) ? false : true;

        double frs = Math.sqrt(Math.pow(b,2)+Math.pow(c,2)); 
        double fls = -Math.sqrt(Math.pow(b,2)+Math.pow(d,2));
        double rrs = Math.sqrt(Math.pow(a,2)+Math.pow(d,2));
        double rls = -Math.sqrt(Math.pow(a,2)+Math.pow(c,2));
        
        frs = FR_isReversed ? -frs : frs;
        fls = FL_isReversed ? -fls : fls;
        rrs = RR_isReversed ? -rrs : rrs;
        rls = RL_isReversed ? -rls : rls;

        last_fra = fra;
        last_fla = fla;
        last_rra = rra;
        last_rla = rla;
        //*/
    
/* EXPERIMENTAL ROTATION CODE
    double a;
    double b;
    double c;
    double d;

    double frs;
    double fls;
    double rrs;
    double rls;

    double fra;
    double fla;
    double rra;
    double rla;

    a = str - rcw*(length/diagonal);
    b = str + rcw*(length/diagonal);
    c = fwd - rcw*(width/diagonal);
    d = fwd + rcw*(width/diagonal);

    if(rcw != 0 && fwd == 0 && str == 0){ //might need to fix root cause
        if(rcw > 0){
            a = str - rcw*(length/diagonal);
            b = str + rcw*(length/diagonal);
            c = fwd - rcw*(width/diagonal);
            d = fwd + rcw*(width/diagonal);
        } else if(rcw < 0){
            a = str - Math.abs(rcw)*(length/diagonal);
            b = str + Math.abs(rcw)*(length/diagonal);
            c = fwd - Math.abs(rcw)*(width/diagonal);
            d = fwd + Math.abs(rcw)*(width/diagonal);

            frs *= -1;
            fls *= -1;
            rrs *= -1;
            rls *= -1;
        }

        fra = Math.atan2(b,c)*180/Math.PI - 90;
        fla = Math.atan2(b,d)*180/Math.PI + 90;
        rra = Math.atan2(a,d)*180/Math.PI;
        rla = Math.atan2(a,c)*180/Math.PI;
    } else {
        fra = Math.atan2(b,c)*180/Math.PI;
        fla = Math.atan2(b,d)*180/Math.PI;
        rra = Math.atan2(a,d)*180/Math.PI;
        rla = Math.atan2(a,c)*180/Math.PI;
    }//*/

    SmartDashboard.putNumber("FR ANGLE", fra);
    SmartDashboard.putNumber("FL ANGLE", fla);
    SmartDashboard.putNumber("RR ANGLE", rra);
    SmartDashboard.putNumber("RL ANGLE", rla);

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

    
    if(rcw == 0){        
        setDirective(swerveDirectives[0], fra + RobotMap.navx.getAngle()%360, frs);
        setDirective(swerveDirectives[1], fla + RobotMap.navx.getAngle()%360, fls);
        setDirective(swerveDirectives[2], rra + RobotMap.navx.getAngle()%360, rrs);
        setDirective(swerveDirectives[3], rla + RobotMap.navx.getAngle()%360, rls);
    }else{
        setDirective(swerveDirectives[0], fra, frs);
        setDirective(swerveDirectives[1], fla, fls);
        setDirective(swerveDirectives[2], rra, rrs);
        setDirective(swerveDirectives[3], rla, rls);
    }
    /*
        setDirective(swerveDirectives[0], fra + RobotMap.navx.getAngle()%360, frs);
        setDirective(swerveDirectives[1], fla + RobotMap.navx.getAngle()%360, fls);
        setDirective(swerveDirectives[2], rra + RobotMap.navx.getAngle()%360, rrs);
        setDirective(swerveDirectives[3], rla + RobotMap.navx.getAngle()%360, rls);
    */
    }

    private void setDirective(SwerveDirective swerveDirective, double angle, double speed){
        swerveDirective.setAngle(angle);
        swerveDirective.setSpeed(speed);
    }

}