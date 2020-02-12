/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.Solenoid;

/**
 * Add your docs here.
 */
public class BallFeeder extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  //Solenoid rightPiston = RobotMap.feederSolenoidR;
  //Solenoid leftPiston = RobotMap.feederSolenoidL;
  
  public void raise(){
    //rightPiston.set(false);
    //leftPiston.set(false);
  }

  public void lower(){
    //rightPiston.set(true);
    //leftPiston.set(true);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
