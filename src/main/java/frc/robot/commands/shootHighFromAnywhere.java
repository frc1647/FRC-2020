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
import frc.robot.subsystems.FlyWheel;;

public class shootHighFromAnywhere extends Command {

  Vision vision = Robot.vision;
  FlyWheel flywheel = Robot.flywheel;

  //inches and degrees
  double goalHeight = vision.getGoalHeight();
  double camHeight = vision.getCamHeight();
  double initialHeight = 18;
  double v1;
  double hoodAngle = 30;
  double g = 32.2*12; //gravity (in/s^2)
  double v1ToRpmConstant = 1; //relationship between actual v1 and 

  public shootHighFromAnywhere() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.flywheel);
    requires(Robot.vision);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    v1 = getV1() * v1ToRpmConstant;
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    flywheel.setSpeed(v1);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    flywheel.stopFlyWheel();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }

  //Calculates initial velocity of the ball based on distance from the goal
  private double getV1(){
    double v;
    v = Math.sqrt((vision.getDistance()*Math.tan(Math.toRadians(hoodAngle))-g*Math.pow(vision.getDistance(), 2)) / (2*(goalHeight-initialHeight)*Math.pow(Math.cos(Math.toRadians(hoodAngle)), 2)));
    return v;
  }
}
