/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.XboxController;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

  // Swerve Motor Controllers 
  public static WPI_TalonSRX FRTalonD = new WPI_TalonSRX(3);
  public static WPI_TalonSRX FRTalonS = new WPI_TalonSRX(2);
  public static VictorSPX FLTalonD = new VictorSPX(1);
  public static WPI_TalonSRX FLTalonS = new WPI_TalonSRX(6);
  public static VictorSPX RRTalonD = new VictorSPX(2);
  public static WPI_TalonSRX RRTalonS = new WPI_TalonSRX(7);
  public static VictorSPX RLTalonD = new VictorSPX(0);
  public static WPI_TalonSRX RLTalonS = new WPI_TalonSRX(1);
  public static Solenoid intakeSolenoidR = new Solenoid(8);
  public static Solenoid intakeSolenoidL = new Solenoid(9);
  public static WPI_TalonSRX intakeTalon = new WPI_TalonSRX(10);
  public static WPI_TalonSRX conveyorTalon = new WPI_TalonSRX(11);
  
  
  //Motor Controllers
  public static WPI_TalonSRX flyWheelVictor = new WPI_TalonSRX(20);

  //Joysticks
  public static Joystick leftJoy = new Joystick(1);
  public static Joystick rightJoy = new Joystick(2);
  public static Joystick tablet = new Joystick(0);

  // Other Attachments
  public static Encoder driveEncoder = new Encoder(8 , 9);
  public static AHRS navx = new AHRS(SPI.Port.kMXP);
}
