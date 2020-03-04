/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.Movement;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj2.command.ScheduleCommand;
import frc.robot.Robot;
import frc.robot.subsystems.Vision;
import frc.robot.subsystems.Swerve.*;

public class turnTo extends Command {
  
  Vision vision = Robot.vision;
  double kp = 0.5;
  double minCommand = 0.05;
  //boolean isFinished  false;
  double threshold = 1.0;
  double maxAngle = 60;

  public turnTo() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.vision);
    requires(Robot.drivetrain);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    double headingError = vision.getLimeX();
    double steeringAdjust = 0.0;
    
    if(headingError >= threshold){
      steeringAdjust = kp*headingError/maxAngle - minCommand;
    } else if(headingError <= -threshold){
      steeringAdjust = kp*headingError/maxAngle + minCommand;
    } else {
      steeringAdjust = 0;
    }
    Robot.drivetrain.move(0.0, 0.0, steeringAdjust);
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
}
