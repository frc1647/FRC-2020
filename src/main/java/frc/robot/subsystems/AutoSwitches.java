/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

public class AutoSwitches extends Subsystem {
  
  private int AutoCase;

  private boolean switch1 = RobotMap.switch1.get();
  private boolean switch2  = RobotMap.switch2.get();
  private boolean switch3 = RobotMap.switch3.get();
  private boolean switch4 = RobotMap.switch4.get();

  public void switches() {
    
    if (switch1==false && switch2==false && switch3==false && switch4==false){ //Case 1 - Off, Off, Off, Off
      AutoCase = 1;
    }

    else if (switch1==false && switch2==false && switch3==false && switch4==true){ //Case 2 - Off, Off, Off, On
      AutoCase = 2;
    }

    else if (switch1==false && switch2==false && switch3==true && switch4==false){ // Case 3 - Off, Off, On, Off
      AutoCase = 3;
    }

    else if (switch1==false && switch2==false && switch3==true && switch4==true){ // Case 4 - Off, Off, On, On
      AutoCase = 4;
    }

    else if (switch1==false && switch2==true && switch3==false && switch4==false){ // Case 5 - Off, On, Off, Off
      AutoCase = 5;
    }

    else if (switch1==false && switch2==true && switch3==false && switch4==true){ // Case 6 - Off, On, Off, On
      AutoCase = 6;
    }

    else if (switch1==false && switch2==true && switch3==true && switch4==false){ // Case 7 - Off, On, On, Off
      AutoCase = 7;
    }

    else if (switch1==false && switch2==true && switch3==true && switch4==true){ // Case 8 - Off, On, On, On
      AutoCase = 8;
    }

    else if (switch1==true && switch2==false && switch3==false && switch4==false){ // Case 9 - On, Off, Off, Off
      AutoCase = 9;
    }

    else if (switch1==true && switch2==false && switch3==false && switch4==true){ // Case 10 - On, Off, Off, On
      AutoCase = 10;
    }
    
    else if (switch1==true && switch2==false && switch3==true && switch4==false){ // Case 11 - On, Off, On, Off
      AutoCase = 11;
    }

    else if (switch1==true && switch2==false && switch3==true && switch4==true){ // Case 12 - On, Off, On, On
      AutoCase = 12;
    }

    else if (switch1==true && switch2==true && switch3==false && switch4==false){ // Case 13 - On, On, Off, Off
      AutoCase = 13;
    }

    else if (switch1==true && switch2==true && switch3==false && switch4==true){ // Case 14 - On, On, Off, On - Same as 13
      AutoCase = 13;
    }

    else if (switch1==true && switch2==true && switch3==true && switch4==false){ // Case 15 - On, On, On, Off - Same as 13
      AutoCase = 13;
    }

    else if (switch1==true && switch2==true && switch3==true && switch4==true){ // Case 16 - On, On, On, On - Same as 13
      AutoCase = 13;
    }


    else{
      AutoCase = 13; //Defualt Case
    }
  }

  public int getAutoSwitches(){
    return AutoCase;
  }

  @Override
  public void initDefaultCommand() {
  }

}
