/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.subsystems.Swerve.SwerveDirective;

public class ResetEnc extends Command {

public ResetEnc() {
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

    
    //RobotMap.FLTalonS.set(ControlMode.Position, 0);
    //RobotMap.FRTalonS.set(ControlMode.Position, 0);
    //RobotMap.RLTalonS.set(ControlMode.Position, 0);
    //RobotMap.RRTalonS.set(ControlMode.Position, 0);
    
    //RobotMap.FRTalonS.setSelectedSensorPosition(0);
    //RobotMap.FLTalonS.setSelectedSensorPosition(0);
    //RobotMap.RRTalonS.setSelectedSensorPosition(0);
    //RobotMap.RLTalonS.setSelectedSensorPosition(0);
    
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
