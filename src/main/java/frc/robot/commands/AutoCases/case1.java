/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.AutoCases;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.commands.Movement.TurnAngle;
import frc.robot.commands.Shooter.LowShoot3;
import frc.robot.commands.Movement.DriveDistance;

public class case1 extends CommandGroup {
  /**
   * Add your docs here.
   */
  public case1() {
    // Add Commands here:
    // e.g. addSequential(new Command1());
    // addSequential(new Command2());
    // these will run in order.

    addSequential(new TurnAngle(235));
    addSequential(new DriveDistance(144));

    addSequential(new TurnAngle(180));
    addSequential(new DriveDistance(20));
    addSequential(new LowShoot3());

    /*addSequential(new LowGoalShoot());
    addParallel(new LoadCells());
    try {
      Thread.sleep(1000, 0);
    } catch (InterruptedException e1) {
      // TODO Auto-generated catch block
      e1.printStackTrace();
    }
    
    for (int i = 0; i < 3; i++) {
      addSequential(new FeedShooter());
      try {
        Thread.sleep(500, 0);
      } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
    //speed down shooter? */
    

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
