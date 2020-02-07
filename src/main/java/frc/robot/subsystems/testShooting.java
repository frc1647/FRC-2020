/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.BaseMotorController;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class testShooting extends SubsystemBase {
  /**
   * Creates a new testShooting.
   */

  public static Spark m_shoot = RobotMap.testSpark;

  public testShooting() {
    
  }
  public void shoot(Boolean speed){
    m_shoot.set(0.1);
  }
  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
