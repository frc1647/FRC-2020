/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
/**
 * Add your docs here.
 */
public class Vision extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  NetworkTable table = NetworkTableInstance.getDefault().getTable("Limelight");
  NetworkTableEntry tx = table.getEntry("tx");
  NetworkTableEntry ty = table.getEntry("ty");
  NetworkTableEntry ta = table.getEntry("ta");
  NetworkTableEntry tv = table.getEntry("tv");
  
  double x;
  double y;
  double area;
  boolean target;

  //Inches and degrees
  final double camHeight = 12;
  final double goalHeight = 98; //middle of the high goal port
  final double camAngle = 30;
  double distance;

  public Vision(){

  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public double getDistance(){
    distance = (goalHeight - camHeight)/Math.tan(Math.toRadians(getLimeY() + camAngle));
    return distance;
  }

  public boolean targeting(){
    if(tv.getDouble(0.0) == 1){
      target = true;
    }else if(tv.getDouble(0.0) == 0){
      target = false;
    }
    return target;
  }
  
  public double getLimeX(){
    x = tx.getDouble(0.0);
    return x;
  }

  public double getLimeY(){
    y = ty.getDouble(0.0);
    return y;
  }

  public double getLimeArea(){
    area = ta.getDouble(0.0);
    return area;
  }
}
