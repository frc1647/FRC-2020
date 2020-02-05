/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;
import com.kauailabs.navx.frc.AHRS;

public class SnapToAngle extends Command {

  AHRS gyro = RobotMap.navx;
  int P, I, D = 1;
  double kp = 0.1;
  double minCommand = 0.05;
  double integral, derivative, previousError = 0;
  double target;
  double joyX;
  double joyY;
  double rawAngle;
  double error;
  boolean isFinished = false;

  public SnapToAngle() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.drivetrain);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }
  
  /*//Calculates the PID for turning to an angle
  public void PID(){
    this.integral += (error * .02); 
    derivative = (error - this.previousError) / .02;
    this.target = P*error + I*this.integral + D*derivative;
    previousError = error;
  }*/

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    //still need to apply PID to drive command
    
    joyX = Robot.oi.getLeftJoy().getX();
    joyY = Robot.oi.getLeftJoy().getY();
    rawAngle = Math.toDegrees(Math.atan2(joyY, joyX));
    error = gyro.getAngle() - approxAngle(rawAngle);
    /*while(target != rawAngle){
      PID();
      Robot.drivetrain.move(0, 0, error);
    }*/

    //gyro.getAngle() == approxAngle(rawAngle);
    turnTo();

    if((gyro.getAngle() <= (approxAngle(rawAngle)) + 1.0) && gyro.getAngle() >= (approxAngle(rawAngle) - 1.0)){
      isFinished = true;
    } else {
      isFinished = false;
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }

  void turnTo(){
    double turnSpeed = 0.0;
    double headingError = error;
    headingError = error;
    double steeringAdjust = 0.0;
    if(headingError > 1.0){
      steeringAdjust = kp*headingError - minCommand;
    } else if(headingError < 1.0){
      steeringAdjust = kp*headingError + minCommand;
    }
    turnSpeed += steeringAdjust;
    Robot.drivetrain.move(0.0, 0.0, turnSpeed);
    }

  double approxAngle(double raw){
    double ang = 0;
    if(raw >= 337.5 && raw < 22.5){
      ang = 0;
    } else if(raw >= 337.5 && raw < 22.5){
      ang = 45;
    } else if(raw >= 22.5 && raw < 67.7){
      ang = 90;
    } else if(raw >= 67.5 && raw < 112.5){
      ang = 135;
    } else if(raw >= 112.5 && raw < 157.5){
      ang = 180;
    } else if(raw >= 157.5 && raw < 202.5){
      ang = 225;
    } else if(raw >= 202.5 && raw < 247.5){
      ang = 270;
    } else if(raw >= 247.5 && raw < 292.5){
      ang = 315;
    } else if(raw >= 292.5 && raw < 337.5){
      ang = 360;
    }
    return ang;
  }
}