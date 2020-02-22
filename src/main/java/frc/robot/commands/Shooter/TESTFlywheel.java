/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.Shooter;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.subsystems.FlyWheel;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class TESTFlywheel extends Command {

  FlyWheel flywheel = Robot.flywheel;
  Joystick rightJoy = RobotMap.rightJoy;
  static double speed = 0;

  public TESTFlywheel() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.flywheel);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    if(rightJoy.getRawButtonPressed(1)){
      flywheel.setSpeed(speed);
      if(rightJoy.getRawButtonReleased(3) && speed < 1){
        speed += 0.05;
      } else if(rightJoy.getRawButtonReleased(2) && speed > -1){
        speed -= 0.05;
      }
    }

    SmartDashboard.putNumber("Flywheel TEST Speed", speed);
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
