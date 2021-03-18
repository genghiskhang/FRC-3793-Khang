package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Talon;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.Constants;

public class DriveTrain extends SubsystemBase {
    private final Talon frontRightMotor;
    private final Talon backRightMotor;
    private final Talon frontLeftMotor;
    private final Talon backLeftMotor;
    private final SpeedControllerGroup left_motor;
    private final SpeedControllerGroup right_motor;
    private final DifferentialDrive m_robotDrive;


    public DriveTrain() {
        frontRightMotor = new Talon(Constants.FRONT_RIGHT);
        backRightMotor = new Talon(Constants.BACK_RIGHT);
        frontLeftMotor = new Talon(Constants.FRONT_LEFT);
        backLeftMotor = new Talon(Constants.BACK_LEFT);
        left_motor = new SpeedControllerGroup(backLeftMotor, frontLeftMotor);
        right_motor = new SpeedControllerGroup(backRightMotor, frontRightMotor);
        m_robotDrive = new DifferentialDrive(left_motor, right_motor);
    }

    public void periodic() {
    }

    public void driveWithJoysticks(XboxController controller, double speed) {
        m_robotDrive.arcadeDrive(controller.getRawAxis(Constants.XBOX_LEFT_Y_AXIS) * speed, controller.getRawAxis(Constants.XBOX_LEFT_X_AXIS) * speed);
    }

    public void driveForward(double speed) {
        m_robotDrive.tankDrive(speed, speed);
    }

    public void stop() {
        m_robotDrive.stopMotor();
    }
}
