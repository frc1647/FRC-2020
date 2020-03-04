/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.BaseMotorController;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.SensorUtil;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.FlyWheel;
import frc.robot.subsystems.Swerve.Swerve;
import frc.robot.subsystems.Swerve.SwerveDrivetrain;
import frc.robot.subsystems.Swerve.SwerveMath;
import frc.robot.subsystems.Swerve.*;
import frc.robot.subsystems.Vision;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.BallFeeder;
import frc.robot.subsystems.ClimbingMech;
import frc.robot.subsystems.AutoSwitches;
import frc.robot.commands.AutoCases.*;
import frc.robot.commands.Movement.AutoForward;
import frc.robot.commands.Movement.turnTo;
import frc.robot.commands.Shooter.FeedShooter;
import frc.robot.commands.Shooter.HighGoalShoot;
import frc.robot.commands.Shooter.HighShoot3;
import frc.robot.OI;

import frc.robot.commands.*;
/* Motor testing Stuff */

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  public static ExampleSubsystem m_subsystem = new ExampleSubsystem();
  public static SwerveDrivetrain drivetrain = new SwerveDrivetrain();
  public static SwerveDirective directive = new SwerveDirective();
  public static SwerveMath swerveMath = new SwerveMath(1, 1);
  public static FlyWheel flywheel = new FlyWheel();
  public static Vision vision = new Vision();
  public static Intake intake = new Intake();
  public static ClimbingMech climbingMech = new ClimbingMech();
  public static BallFeeder feeder = new BallFeeder();
  public static AutoSwitches autoSwitches = new AutoSwitches();
  public static String mode;
  
  public static OI oi;
  Command m_autonomousCommand;
  SendableChooser<Command> m_chooser = new SendableChooser<>();

  Command autoCase;
  
  double speedR = 0;
  double speedL = 0;

  Command driveOff = new AutoForward();
  Command turnTo = new turnTo();
  Command high3 = new HighShoot3();
  Command shoot = new FeedShooter();
  //Command highSpeed = new HighGoalShoot();

  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  @Override
  public void robotInit() {
    oi = new OI();
    m_chooser.setDefaultOption("Default Auto", new ExampleCommand());
    // chooser.addOption("My Auto", new MyAutoCommand());
    SmartDashboard.putData("Auto mode", m_chooser);
    CameraServer.getInstance().startAutomaticCapture();
  }

  /**
   * This function is called every robot packet, no matter the mode. Use
   * this for items like diagnostics that you want ran during disabled,
   * autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    
  }

  /**
   * This function is called once each time the robot enters Disabled mode.
   * You can use it to reset any subsystem information you want to clear when
   * the robot is disabled.
   */
  @Override
  public void disabledInit() {
    vision.lightsOff();
  }

  @Override
  public void disabledPeriodic() {
    Scheduler.getInstance().run();
    vision.lightsOff();
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable
   * chooser code works with the Java SmartDashboard. If you prefer the
   * LabVIEW Dashboard, remove all of the chooser code and uncomment the
   * getString code to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional commands to the
   * chooser code above (like the commented example) or additional comparisons
   * to the switch structure below with additional strings & commands.
   */
  @Override
  public void autonomousInit() {
    m_autonomousCommand = m_chooser.getSelected();
    driveOff.start();
    //highSpeed.start();
    /*
     * String autoSelected = SmartDashboard.getString("Auto Selector",
     * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
     * = new MyAutoCommand(); break; case "Default Auto": default:
     * autonomousCommand = new ExampleCommand(); break; }
     */

    // schedule the autonomous command (example7
    
    if (m_autonomousCommand != null) {
      m_autonomousCommand.start();
      
    }
    
    vision.lightsOn();
    int caseNum = autoSwitches.getAutoSwitches();
    /*
    switch(caseNum){
      case 1: autoCase = new case1();
              break;
      case 2: autoCase = new case2();
              break;
      case 3: autoCase = new case3();
              break;
      case 4: autoCase = new case4();
              break;
      case 5: autoCase = new case5();
              break;
      case 6: autoCase = new case6();
              break;
      case 7: autoCase = new case7();
              break;
      case 8: autoCase = new case8();
              break;
      case 9: autoCase = new case9();
              break;
      case 10: autoCase = new case10();
              break;
      case 11: autoCase = new case11();
              break;
      case 12: autoCase = new case12();
              break;
      case 13: autoCase = new case13();
              break;
      default: break;
    }//*/
    //autoCase = new caseDefault();
    //autoCase.start();
    SmartDashboard.putNumber("Auto Case", caseNum);
    
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
    //driveOff.start();
    //turnTo.start();
    //high3.start();
  }

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
    
    vision.lightsOn();
    //driveOff.start();
    //vision.lightsOff();
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
    //turnToCommand.start();
    SmartDashboard.putNumber("Vision ty", vision.getLimeY());
    SmartDashboard.putNumber("Vision Distance", vision.getDistance());
    //driveOff.start();
    vision.lightsOn();

    //int caseNum = autoSwitches.getAutoSwitches();
    //SmartDashboard.putNumber("Auto Case", caseNum);
    //boolean isDown = RobotMap.leftJoy.getTrigger();
    //RobotMap.feederSolenoid.set(isDown);
    //RobotMap.feederSolenoid.set(RobotMap.leftJoy.getTrigger()); 

    //testFlywheel.start();
    /* MOTOR CONTROLLER TEST CODE
    if(RobotMap.rightJoy.getRawButtonReleased(3) && speedR < 1){
      speedR += 0.05;
    } else if(RobotMap.rightJoy.getRawButtonReleased(2) && speedR > -1){
      speedR -= 0.05;
    } 
    if(RobotMap.rightJoy.getRawButtonPressed(1)){
      speedR = 0;
    }
    RobotMap.testTalon1.set(speedR);   
    SmartDashboard.putNumber("Right Joy TEST Speed", speedR);

    if(RobotMap.leftJoy.getRawButtonReleased(3) && speedL < 1){
      speedL += 0.05;
    } else if(RobotMap.leftJoy.getRawButtonReleased(2) && speedL > -1){
      speedL -= 0.05;
    } 
    if(RobotMap.leftJoy.getRawButtonPressed(1)){
      speedL = 0;
    }
    RobotMap.testTalon2.set(speedL);    
    SmartDashboard.putNumber("Left Joy TEST Speed", speedL);
    //*/

  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
    
  }


}
