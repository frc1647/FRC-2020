/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.Shooter;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.FlyWheel;

public class LowGoalShoot extends Command {

FlyWheel flywheel = Robot.flywheel;

  public LowGoalShoot() {
    requires(Robot.flywheel);
  }

  @Override
  protected void initialize() {
  }

  @Override
  protected void execute() {
    flywheel.setSpeed(0.5);
  }

  @Override
  protected boolean isFinished() {
    return false;
  }

  @Override
  protected void end() {
    flywheel.stopFlyWheel();
  }

  @Override
  protected void interrupted() {
    flywheel.stopFlyWheel();
  }
}
