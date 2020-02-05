/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

public class ClimbingMech extends Subsystem {

  double flyWheelSpeed = RobotMap.flyWheelVictor.getMotorOutputPercent();

  public ClimbingMech() {
  }

  public double getFlyWheelSpeed() {
    return flyWheelSpeed;
  }

  public void extendClimbingArm(){
    RobotMap.climbingArmMotor.set(ControlMode.PercentOutput, 0.75);
  }

  public void retractClimbingArm(){
    RobotMap.climbingArmMotor.set(ControlMode.PercentOutput, 0.5);
  }

  public void winchUp(){

    RobotMap.winchMotor1.set(ControlMode.PercentOutput, 0.60);
    RobotMap.winchMotor2.set(ControlMode.PercentOutput, -0.60); // This is the reversed motor

  }

  public void winchDown(){

    RobotMap.winchMotor1.set(ControlMode.PercentOutput, -0.60);
    RobotMap.winchMotor2.set(ControlMode.PercentOutput, 0.60); // This is the reversed motor

  }

  @Override
  protected void initDefaultCommand() {
  }
}
