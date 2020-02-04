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

public class FlyWheel extends Subsystem {

  double flyWheelSpeed = RobotMap.flyWheelVictor.getMotorOutputPercent();

  public FlyWheel() {
  }

  public double getFlyWheelSpeed() {
    return flyWheelSpeed;
  }

  public void highGoalShoot(){
    RobotMap.flyWheelVictor.set(ControlMode.PercentOutput, 0.75);
  }

  public void lowGoalShoot(){
    RobotMap.flyWheelVictor.set(ControlMode.PercentOutput, 0.5);
  }

  public void stopFlyWheel(){
    RobotMap.flyWheelVictor.set(ControlMode.PercentOutput, 0);
  }

  @Override
  protected void initDefaultCommand() {
  }
}
