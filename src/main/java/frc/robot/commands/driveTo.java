/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.Vision;
import frc.robot.subsystems.Swerve.*;

public class driveTo extends Command {
  
  Vision vision = Robot.vision;
  double kp = -0.1;
  double minCommand = 0.05;
  boolean isFinished = false;
  double threshold = 1.0;
  double distance;

  public driveTo(double distance) {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.vision);
    requires(Robot.drivetrain);

    distance = this.distance;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    double distanceError = vision.getDistance() - distance;
    double distanceAdjust = 0.0;
    if(vision.getDistance() > threshold){
      distanceAdjust = kp*distanceError - minCommand;
    } else if(vision.getDistance() < threshold){
      distanceAdjust = kp*distanceError + minCommand;
    }
    Robot.drivetrain.move(distanceAdjust, 0.0, 0.0);

    if(distanceError >= -threshold && distanceError <= threshold){
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
    isFinished = true;
  }
}
