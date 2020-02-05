/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class Intake extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  private final Solenoid intakePistonL = RobotMap.intakeSolenoidL;
  private final Solenoid intakePistonR = RobotMap.intakeSolenoidR;
  private final WPI_TalonSRX intakeMotor = RobotMap.intakeTalon;

  public void raise(){
    intakePistonL.set(false);
    intakePistonR.set(false);
    intakeMotor.set(0);
  }

  public void lower(){
    intakePistonL.set(true);
    intakePistonR.set(true);
    intakeMotor.set(0.75);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
