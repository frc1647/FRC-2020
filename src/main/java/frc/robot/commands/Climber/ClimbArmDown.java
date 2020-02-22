/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.Climber;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class ClimbArmDown extends Command {
  
  public ClimbArmDown() {

    requires(Robot.climbingMech);

  }

  @Override
  protected void initialize() {
  }

  @Override
  protected void execute() {

    Robot.climbingMech.retractClimbingArm();

  }

  @Override
  protected boolean isFinished() {
    return false;
  }

  @Override
  protected void end() {
  }

  @Override
  protected void interrupted() {
  }
}
