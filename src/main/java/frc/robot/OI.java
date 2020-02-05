/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.HighGoalShoot;
import frc.robot.commands.LowGoalShoot;
import frc.robot.commands.Align;
import frc.robot.commands.LoadCells;
import frc.robot.commands.UnloadCells;
import frc.robot.commands.LowerIntake;
import frc.robot.commands.RaiseIntake;
import frc.robot.commands.SnapToAngle;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  Joystick leftJoy = RobotMap.leftJoy;
  Joystick righJoy = RobotMap.rightJoy;
  Joystick tablet = RobotMap.tablet;

  public OI(){
    JoystickButton highGoalShoot = new JoystickButton(tablet, 1);
    JoystickButton lowGoalShoot = new JoystickButton(tablet, 2);
    JoystickButton alignWithGoal = new JoystickButton(tablet, 3);
    JoystickButton lowerIntake = new JoystickButton(tablet, 4);
    JoystickButton raiseIntake = new JoystickButton(tablet, 5);
    JoystickButton loadCells = new JoystickButton(tablet, 6);
    JoystickButton unloadCells = new JoystickButton(tablet, 7);
    JoystickButton snapToAngle = new JoystickButton(tablet, 8);
    JoystickButton loadCells = new JoystickButton(rightJoy, 1);
    
    highGoalShoot.whileHeld(new HighGoalShoot());
    lowGoalShoot.whileHeld(new LowGoalShoot());
    
    alignWithGoal.whenPressed(new Align());
    
    lowerIntake.whenPressed(new LowerIntake());
    raiseIntake.whenPressed(new RaiseIntake());
    
    loadCells.whileHeld(LoadCells());
    unloadCells.whileHeld(UnoadCells());
    
    snapToAngle.whileHeld(new SnapToAngle());
  }

  public Joystick getLeftJoy(){
    return leftJoy;
  }
  public Joystick getRightJoy() {
    return righJoy;
  }
  public Joystick getTablet(){
    return tablet;
  }
  
}
