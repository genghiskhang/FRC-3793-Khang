package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
/*
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.XboxController;
*/

public class Robot extends TimedRobot {
  private Command m_autonomousCommand;
  private RobotContainer m_robotContainer;

  /*
   * private final Talon frontRightMotor = new Talon(0); private final Talon
   * backRightMotor = new Talon(1); private final Talon frontLeftMotor = new
   * Talon(3); private final Talon backLeftMotor = new Talon(2); private final
   * SpeedControllerGroup left_motor = new SpeedControllerGroup(backLeftMotor,
   * frontLeftMotor); private final SpeedControllerGroup right_motor = new
   * SpeedControllerGroup(backRightMotor, frontRightMotor); private final
   * DifferentialDrive m_robotDrive = new DifferentialDrive(left_motor,
   * right_motor); private final XboxController m_stick = new XboxController(0);
   * private final Timer m_timer = new Timer();
   */
  public void robotInit() {
    m_robotContainer = new RobotContainer();
  }

  public void robotPeriodic() {
    CommandScheduler.getInstance().run();
  }

  public void disabledInit() {

  }

  public void disabledPeriodic() {

  }

  public void autonomousInit() {
    m_autonomousCommand = m_robotContainer.getAutonomousCommand();
    if (m_autonomousCommand != null) {
      m_autonomousCommand.schedule();
    }
    /*
     * m_timer.reset(); m_timer.start();
     */
  }

  public void autonomousPeriodic() {
    /*
     * if (m_timer.get() < 2.0) { m_robotDrive.arcadeDrive(0.5, 0.0); // drive
     * forwards half speed } else if (m_timer.get() >= 2.0 && m_timer.get() < 4.0) {
     * m_robotDrive.arcadeDrive(0.0, 0.5); } else if (m_timer.get() >= 4.0 &&
     * m_timer.get() < 5.0) { m_robotDrive.arcadeDrive(0.5, 0.0); } else {
     * m_robotDrive.stopMotor(); // stop robot }
     */
  }

  public void teleopInit() {

  }

  public void teleopPeriodic() {
    // m_robotDrive.arcadeDrive(m_stick.getY() * -1, m_stick.getX());
  }

  public void testInit() {
    CommandScheduler.getInstance().cancelAll();
  }

  public void testPeriodic() {
 
  }
}