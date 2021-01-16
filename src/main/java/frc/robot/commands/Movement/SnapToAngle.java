/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.Movement;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;
import frc.robot.RobotMap;
import com.kauailabs.navx.frc.AHRS;

public class SnapToAngle extends Command {

  AHRS gyro = RobotMap.navx;
  int P, I, D = 1;
  double kp = 1;
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

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    //still need to apply PID to drive command
    double gyroAngle = gyro.getAngle()%360;
    
    joyX = Robot.oi.getRightJoy().getX();
    joyY = -Robot.oi.getRightJoy().getY();
    rawAngle = Math.toDegrees(Math.atan2(joyX, joyY));
    if(rawAngle < 0){
      rawAngle += 360;
    } else{
      
    }
    error = gyroAngle - approxAngle(rawAngle);
    /*while(target != rawAngle){
      PID();
      Robot.drivetrain.move(0, 0, error);
    }*/

    //gyro.getAngle() == approxAngle(rawAngle);
    turnTo();

    if((gyroAngle <= (approxAngle(rawAngle)) + 1.0) && gyroAngle >= (approxAngle(rawAngle) - 1.0)){
      isFinished = true;
    } else {
      isFinished = false;
    }
    SmartDashboard.putNumber("raw angle", rawAngle);
    SmartDashboard.putNumber("target angle", approxAngle(rawAngle));
    SmartDashboard.putNumber("angle error", error);
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
    double steeringAdjust = 0.0;
    if(headingError > 1.0){
      steeringAdjust = kp*headingError - minCommand;
    } else if(headingError < 1.0){
      steeringAdjust = kp*headingError + minCommand;
    }

    Robot.drivetrain.move(0.0, 0.0, steeringAdjust);
  }

  double approxAngle(double raw){
    double ang = 0;
    if(raw >= 337.5 || raw < 22.5){
      ang = 0;
    } else if(raw >= 22.5 && raw < 67.7){
      ang = 45;
    } else if(raw >= 67.5 && raw < 112.5){
      ang = 90;
    } else if(raw >= 112.5 && raw < 157.5){
      ang = 135;
    } else if(raw >= 157.5 && raw < 202.5){
      ang = 180;
    } else if(raw >= 202.5 && raw < 247.5){
      ang = 225;
    } else if(raw >= 247.5 && raw < 292.5){
      ang = 270;
    } else if(raw >= 292.5 && raw < 337.5){
      ang = 315;
    }
    return ang;
  }
}