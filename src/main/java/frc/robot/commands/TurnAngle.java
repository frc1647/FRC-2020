/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.subsystems.Vision;

public class TurnAngle extends Command {

  boolean isFinished = false;
  double targetAngle;
  Vision vision = Robot.vision;
  double minCommand = 0.05;
  double threshold = 3.0;
  double kp = 0.1;
  AHRS gyro = RobotMap.navx;

  public TurnAngle(double degrees) {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.drivetrain);
    this.targetAngle = degrees;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    double headingError = targetAngle - (gyro.getAngle() % 360);
    double steeringAdjust = 0.0;
    
      if(headingError > threshold){
        steeringAdjust = kp*headingError - minCommand;
      } else if(headingError < -threshold){
        steeringAdjust = kp*headingError + minCommand;
      }
      Robot.drivetrain.move(0.0, 0.0, steeringAdjust);
    
    if(headingError >= -threshold && headingError <= threshold){
      isFinished = true;
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return isFinished;
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
}
