/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.AutoCases;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.commands.TurnAngle;
import frc.robot.commands.DriveDistance;
import frc.robot.commands.HighShoot3;

public class case8 extends CommandGroup {
  /**
   * Add your docs here.
   */
  public case8() {
    // Add Commands here:
    // e.g. addSequential(new Command1());
    // addSequential(new Command2());
    // these will run in order.
    addSequential(new DriveDistance(24));
    addSequential(new TurnAngle(270));
    addSequential(new DriveDistance(67));
    addSequential(new TurnAngle(180));
    addSequential(new HighShoot3());
    // To run multiple commands at the same time,
    // use addParallel()
    // e.g. addParallel(new Command1());
    // addSequential(new Command2());
    // Command1 and Command2 will run in parallel.

    // A command group will require all of the subsystems that each member
    // would require.
    // e.g. if Command1 requires chassis, and Command2 requires arm,
    // a CommandGroup containing them would require both the chassis and the
    // arm.
  }
}
