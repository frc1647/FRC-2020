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
//import edu.wpi.first.wpilibj.Solenoid;
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

  
  //Motor Controllers
  public static VictorSPX flyWheelVictor = new VictorSPX(20);
  public static WPI_TalonSRX intakeTalon = new WPI_TalonSRX(10);
  public static WPI_TalonSRX conveyorTalon = new WPI_TalonSRX(11);
  public static WPI_TalonSRX winchMotor1 = new WPI_TalonSRX(12);
  public static WPI_TalonSRX winchMotor2 = new WPI_TalonSRX(13); // This one is the inverted one
  public static VictorSPX climbingArmMotor = new VictorSPX(0); 

  //Joysticks
  public static Joystick leftJoy = new Joystick(1);
  public static Joystick rightJoy = new Joystick(2);
  public static Joystick tablet = new Joystick(0);

  // Others
  public static Encoder driveEncoder = new Encoder(8 , 9);
  public static AHRS navx = new AHRS(SPI.Port.kMXP);
  //public static Solenoid intakeSolenoidR = new Solenoid(8);
  //public static Solenoid intakeSolenoidL = new Solenoid(9);
  
  // Auto Switches
  public static DigitalInput switch1 = new DigitalInput(0);
  public static DigitalInput switch2 = new DigitalInput(1);
  public static DigitalInput switch3 = new DigitalInput(2);
  public static DigitalInput switch4 = new DigitalInput(3);

}
