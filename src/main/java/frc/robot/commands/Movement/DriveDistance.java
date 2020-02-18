/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.Movement;

import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class DriveDistance extends Command {

  boolean isFinished = false;
  double motorSpeed;

  // distance is in inches, velocity is in inches/sec, time is in s
  double distance = 0;
  double velocity = 166.4173;
  double time;

  public DriveDistance(double inches) {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.drivetrain);
    this.distance = inches;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {

    time = distance / velocity;

    //for time t, set the motor speed to 1. when time is up, set motor speed to 0. wait 20ms between each iteration.
    for (double t = 0; t <= time; t += 0.02) {
      motorSpeed = 1;
      Robot.drivetrain.frDrive.set(ControlMode.PercentOutput, motorSpeed);
      Robot.drivetrain.flDrive.set(ControlMode.PercentOutput, motorSpeed);
      Robot.drivetrain.rrDrive.set(ControlMode.PercentOutput, motorSpeed);
      Robot.drivetrain.rlDrive.set(ControlMode.PercentOutput, motorSpeed);
      if (t == time) {
        motorSpeed = 0;
        Robot.drivetrain.frDrive.set(ControlMode.PercentOutput, motorSpeed);
        Robot.drivetrain.flDrive.set(ControlMode.PercentOutput, motorSpeed);
        Robot.drivetrain.rrDrive.set(ControlMode.PercentOutput, motorSpeed);
        Robot.drivetrain.rlDrive.set(ControlMode.PercentOutput, motorSpeed);
      }

      try {
        wait(20, 0);
      } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      }
      isFinished = true;
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
    isFinished = true;
  }

  /*
  void integrateAcceleration(){
    acceleration = gyro.getAccelFullScaleRangeG();
    velocity = (Math.pow(acceleration, 2) / 2);
    position = (Math.pow(velocity, 2) / 2); 
  }
*/
}
