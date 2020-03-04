/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.Climber;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.ClimbingMech;

public class WinchUp extends Command {

  ClimbingMech winch = Robot.climbingMech;

  public WinchUp() {

    requires(Robot.climbingMech);

  }

  @Override
  protected void initialize() {
  }

  @Override
  protected void execute() {
    winch.winchUp();
  }

  @Override
  protected boolean isFinished() {
    return false;
  }

  @Override
  protected void end() {
    winch.winchStop();
  }

  @Override
  protected void interrupted() {
    winch.winchStop();
  }
}
