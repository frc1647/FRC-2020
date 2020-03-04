/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

public class ClimbingMech extends Subsystem {

  VictorSPX armMotor = RobotMap.climbingArmTalon;
  VictorSPX winchMotor = RobotMap.winchTalon;

  public ClimbingMech() {
  }

  public void extendClimbingArm(){
    armMotor.set(ControlMode.PercentOutput, 0.5);
  }

  public void retractClimbingArm(){
    armMotor.set(ControlMode.PercentOutput, -0.15);
  }

  public void stopClimbingArm(){
    armMotor.set(ControlMode.PercentOutput, 0);
  }

  public void winchUp(){

    winchMotor.set(ControlMode.PercentOutput, 1);

  }

  public void winchDown(){

    //winchMotor.set(ControlMode.PercentOutput, -0.60);

  }

  public void winchStop(){

    winchMotor.set(ControlMode.PercentOutput, 0);

  }

  @Override
  protected void initDefaultCommand() {
  }
}
