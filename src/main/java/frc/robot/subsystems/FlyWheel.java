/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.subsystems.Vision;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class FlyWheel extends Subsystem {

  Vision vision = Robot.vision;

  double flyWheelSpeed = RobotMap.flyWheelVictor.getMotorOutputPercent();
  double speedToRPMConstant = 1;

  public FlyWheel() {
  }

  public double getFlyWheelSpeed() {
    return flyWheelSpeed;
  }

  public void highGoalSpeed(){
    RobotMap.flyWheelVictor.set(ControlMode.PercentOutput, 0.75);
  }

  public void lowGoalSpeed(){
    RobotMap.flyWheelVictor.set(ControlMode.PercentOutput, 0.5);
  }

  public void stopFlyWheel(){
    RobotMap.flyWheelVictor.set(ControlMode.PercentOutput, 0);
  }

  public void setSpeed(double speed){
    RobotMap.flyWheelVictor.set(ControlMode.PercentOutput, speed);
  }

  @Override
  protected void initDefaultCommand() {
  }
}
