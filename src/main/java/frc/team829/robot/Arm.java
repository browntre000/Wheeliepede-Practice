package frc.team829.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.Joystick;

public class Arm {
  //Create 4 TalonSRX
  TalonSRX one, two;

  //
  public Arm() {
    try {
      one = new TalonSRX(RobotMap.ARM1);
      two = new TalonSRX(RobotMap.ARM2);
    }
    catch(Exception e) {
      System.out.println("SRX initialization failed");
    }
  }

  //Checking for button press
  public void update(Joystick dualA, Joystick dualB) {
    if (dualA.getRawButton(RobotMap.ARM_1_BUT)) {
      move(15, one);
    } else if (dualB.getRawButton(RobotMap.ARM_2_BUT)) {
      move(15, two);
    } else {
      move(0, one);
      move(0, two);
    }
  }
  //MOving the arm
  public void move(double speed, TalonSRX talon) {
    talon.set(ControlMode.PercentOutput, speed);
  }



}
