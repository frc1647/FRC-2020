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

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.AnalogOutput;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.PWM;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.Button;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
  // For example to map the left and right motors, you could define the
  // following variables to use with your drivetrain subsystem.
  // public static int leftMotor = 1;
  // public static int rightMotor = 2;

  // If you are using multiple modules, make sure to define both the port
  // number and the module. For example you with a rangefinder:
  // public static int rangefinderPort = 1;
  // public static int rangefinderModule = 1;
  public static  WPI_TalonSRX RRTalonS = new WPI_TalonSRX(7); //Front right drive - Was Talon 2
  public static  VictorSPX RRTalonD = new VictorSPX(2); //front right steer - Correct
  public static  WPI_TalonSRX RLTalonS = new WPI_TalonSRX(1); //front left drive - Was Talon 6
  public static  VictorSPX RLTalonD = new VictorSPX(0); //front left steer - Correct
  public static  WPI_TalonSRX FRTalonD = new WPI_TalonSRX(3); //rear right drive -  Was Talon 3
  public static  WPI_TalonSRX FRTalonS = new WPI_TalonSRX(2); //rear right steer - Was Victor 1
  public static  WPI_TalonSRX FLTalonS = new WPI_TalonSRX(6); //rear left drive - Was Talon 3
  public static  VictorSPX FLTalonD = new VictorSPX(1); //rear left steer
  public static Spark testSpark = new Spark(0); // testing for mech.

  public static Joystick leftJoy = new Joystick(1);
  public static Joystick rightJoy = new Joystick(2);
  public static XboxController xboxController = new XboxController(0);

 // public static Button b1 = new Button();
  
  //public static Encoder frontRight = new Encoder(2 , 3);
  //public static Encoder frontLeft = new Encoder(4 , 5);
  //public static Encoder rearRight = new Encoder(0 , 1);
  //public static Encoder rearLeft = new Encoder(6 , 7);


  public static Encoder driveEncoder = new Encoder(8 , 9);

  public static AHRS navx = new AHRS(SPI.Port.kMXP);

}