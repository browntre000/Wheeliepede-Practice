package frc.team829.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Drive extends GoatSystem {

  // Objects
  TalonSRX backLeft, frontLeft, backRight, frontRight;

  // Constructor
  public Drive() {

    // Attempt to create motors and gyro
    try {

      backLeft = new TalonSRX(RobotMap.BACK_LEFT);
      backLeft.setInverted(true);
      frontLeft = new TalonSRX(RobotMap.FRONT_LEFT);
      backRight = new TalonSRX(RobotMap.BACK_RIGHT);
      frontRight = new TalonSRX(RobotMap.FRONT_RIGHT);

    } catch(Exception e) {
      System.out.println("Drive initialization failed");
    }

  }

  // Update Method
  @Override
  public void update(Joystick dualA, Joystick dualB) {

    try {
      // Drive using TankDrive
      drive(-dualA.getRawAxis(RobotMap.LEFT_DRIVE), -dualA.getRawAxis(RobotMap.RIGHT_DRIVE));
    } catch(Exception e) {
      System.out.println(e.getMessage());
    }

  }

  // Update Dashboard
  @Override
  public void dashboard() {

    SmartDashboard.putNumber("Left Speed", backLeft.getSensorCollection().getQuadratureVelocity() );
    SmartDashboard.putNumber("Right Speed", backRight.getSensorCollection().getQuadratureVelocity() );

  }

  // Drive motors at requested speed
  public void drive(double leftSpeed, double rightSpeed) {
    backLeft.set(ControlMode.PercentOutput, leftSpeed);
    frontLeft.set(ControlMode.PercentOutput, leftSpeed);
    backRight.set(ControlMode.PercentOutput, rightSpeed);
    frontRight.set(ControlMode.PercentOutput, rightSpeed);
  }

}

