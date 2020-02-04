/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems.Swerve;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.BaseMotorController;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Add your docs here.
 */
public class SwerveModule {

private String name;
private double gearRatio;

private BaseMotorController driveMotor;
private BaseMotorController steerMotor;
private double encTicPerRotate = 28 *59.16666666;

private boolean reverseEncoder = false;
private boolean reverseSteer = false;

    public SwerveModule(String name, BaseMotorController drive, BaseMotorController steer, double gearRatio){
        this.name = name;
        driveMotor = drive;
        steerMotor = steer;
        this.gearRatio = gearRatio;
    }

    public void stop(){
        driveMotor.set(ControlMode.PercentOutput, 0);
        steerMotor.set(ControlMode.PercentOutput, 0);
        //driveMotor.stopMotor();
        //steerMotor.stopMotor();
    }

    public void setSpeed(double speed){
        driveMotor.set(ControlMode.PercentOutput, speed);
    }

    /*public static void setSpeedTest(double speed){
        driveMotor.set(ControlMode.PercentOutput, speed);
    }*/

    public void setAngle(double angle){
        if (reverseSteer){
            //steerMotor.set(ControlMode.Position, -1 * angle * gearRatio);
            steerMotor.set(ControlMode.Position, angle);
        }
        else{ 
            //steerMotor.set(ControlMode.Position, 1 * angle * gearRatio); 
            steerMotor.set(ControlMode.Position, angle);
        }
        //steerMotor.set(ControlMode.Position, (reverseSteer ? -1 : 1) * angle * encTicPerRotate);
    }

    public void setEncoder(int postion){
        steerMotor.setSelectedSensorPosition(postion, 0, 10);
    }

    public BaseMotorController getDrive(){
        return driveMotor;
    }

    public BaseMotorController getSteer(){
        return steerMotor;
    }

    public void move(double speed, double angle){
        int encPosition = getEncPosition();
        angle = convertAngle(angle, encPosition);
        
        setSpeed(speed);
        if (speed != 0.0) { setAngle(angle); 
            //System.out.println(angle);
        }
    }

    //checks if the wheel is at a spot to reverse to get to desired direction
    //The subsequen \t set and get angles all work towards making sure the wheel will turn the right direction
    public boolean shouldReverse(double wa, double encoderValue){
        double ea = SwerveUtil.convertEncoderValue(encoderValue, gearRatio);
		
		if(wa < 0)	wa += 1;
		
		double longDiff = Math.abs(wa - ea);
		
		double diff = Math.min(longDiff, 1.0-longDiff);
		
		if(diff > 0.25) { 
            return true; }
		else {return false; }
    }
    
    private double convertAngle(double angle, double encoderValue){
        SmartDashboard.putNumber("convAng inAngle", angle);
        SmartDashboard.putNumber("convAng encValue", encoderValue);
        double encPos = modPos(encoderValue, encTicPerRotate);
        double currAngle = encPos/encTicPerRotate;
        angle = angle < 0 ? angle + 360 : angle; // maps [-180, 180] to [0, 360]
        double targAngle = angle/360;

        double output = encoderValue;
        double offset = Math.min(Math.abs(targAngle-currAngle), 1 - Math.abs(targAngle-currAngle));
        offset *= encTicPerRotate; // scale to enc ticks

        if((targAngle - currAngle + 1) % 1 < 0.5) {
            output += offset;
        } else {
            output -= offset;
        }
        SmartDashboard.putNumber("Output", output);

        return output;
        
        //original convertAngle code, almost exactly the same as 4048's
        /*double encPos = encoderValue / encTicPerRotate;
        double temp = angle;
        temp += (int)encPos;

        encPos = encPos % 1;

        if((angle - encPos) >  0.5) temp -= 1;

		if((angle - encPos) < -0.5) temp += 1;
		
        return temp;*/
    }

    private double modPos(double in, double m){
        double mod = in % m;
        if(in < 0) {
            mod += m;
        }
        return mod;
    }

    public void setEncPosition(int position){
		steerMotor.setSelectedSensorPosition(position, 0, 10);
    }
    
    public int getEncPosition(){
        int reverse;// = reverseEncoder ? -1 : 1;
        if(reverseEncoder){
            reverse = 1; // FIXED SWERVE, -1 TO +1
        }
        else{ reverse = 1; }
		return reverse * steerMotor.getSelectedSensorPosition(0); //may be BAD
    }

    public boolean isReverseEncoder(){
		return reverseEncoder;
	}
	
	public void setReverseEncoder(boolean reverseEncoder){
		this.reverseEncoder = reverseEncoder;
	}
	
	public void setReverseSteerMotor(boolean reverseSteer){
		this.reverseSteer = reverseSteer;
	}
}
