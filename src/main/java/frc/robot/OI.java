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

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  Joystick leftJoy = RobotMap.leftJoy;
  Joystick righJoy = RobotMap.rightJoy;
  Joystick tablet = RobotMap.tablet;

  public OI(){

    Joystick tablet = RobotMap.tablet;

    JoystickButton highGoalShoot = new JoystickButton(tablet, 1);
    JoystickButton lowGoalShoot = new JoystickButton(tablet, 2);
  
    highGoalShoot.whileHeld(new HighGoalShoot());
    lowGoalShoot.whileHeld(new LowGoalShoot());
  

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
