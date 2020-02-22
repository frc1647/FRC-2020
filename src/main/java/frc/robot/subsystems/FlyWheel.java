/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.subsystems.Vision;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class FlyWheel extends Subsystem {

  Vision vision = Robot.vision;
  private final WPI_TalonSRX flyWheelTalon = RobotMap.flyWheelTalon;

  double flyWheelSpeed = RobotMap.flyWheelTalon.getMotorOutputPercent();

  public FlyWheel() {
  }

  public double getFlyWheelSpeed() {
    return flyWheelSpeed;
  }

  public void stopFlyWheel(){
    flyWheelTalon.set(ControlMode.PercentOutput, 0);
  }

  public void setSpeed(double speed){
    flyWheelTalon.set(ControlMode.PercentOutput, -speed);
  }

  @Override
  protected void initDefaultCommand() {
  }
}
