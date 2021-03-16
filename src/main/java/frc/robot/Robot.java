// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.XboxController;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends TimedRobot {
  private final SpeedControllerGroup left_motor = new SpeedControllerGroup(new Talon(2), new Talon(3));
  private final SpeedControllerGroup right_motor = new SpeedControllerGroup(new Talon(1), new Talon(0));
  private final DifferentialDrive m_robotDrive = new DifferentialDrive(left_motor, right_motor);
  private final XboxController m_stick = new XboxController(0);
  private final Timer m_timer = new Timer();

  public void robotInit() {
    
  }

  public void autonomousInit() {
    m_timer.reset();
    m_timer.start();
  }

  public void autonomousPeriodic() {
    if (m_timer.get() < 2.0) {
      m_robotDrive.arcadeDrive(0.5, 0.0); // drive forwards half speed
    } else {
      m_robotDrive.stopMotor(); // stop robot
    }
  }

  public void teleopInit() {

  }

  public void teleopPeriodic() {
    m_robotDrive.arcadeDrive(m_stick.getY() * -1, m_stick.getX());
  }

  public void testInit() {
    
  }

  public void testPeriodic() {

  }
}