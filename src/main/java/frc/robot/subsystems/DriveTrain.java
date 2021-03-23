package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.XboxController;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import frc.robot.Constants;

public class DriveTrain extends SubsystemBase {
    private final WPI_VictorSPX frontRightMotor;
    private final WPI_TalonSRX backRightMotor;
    private final WPI_VictorSPX frontLeftMotor;
    private final WPI_TalonSRX backLeftMotor;
    private final SpeedControllerGroup left_motor;
    private final SpeedControllerGroup right_motor;
    private final DifferentialDrive m_robotDrive;

    public DriveTrain() {
        frontRightMotor = new WPI_VictorSPX(Constants.FRONT_RIGHT);
        backRightMotor = new WPI_TalonSRX(Constants.BACK_RIGHT);
        frontRightMotor.set(ControlMode.Follower, Constants.BACK_RIGHT);

        frontLeftMotor = new WPI_VictorSPX(Constants.FRONT_LEFT);
        backLeftMotor = new WPI_TalonSRX(Constants.BACK_LEFT);
        frontLeftMotor.set(ControlMode.Follower, Constants.BACK_LEFT);

        left_motor = new SpeedControllerGroup(backLeftMotor, frontLeftMotor);
        right_motor = new SpeedControllerGroup(backRightMotor, frontRightMotor);
        m_robotDrive = new DifferentialDrive(left_motor, right_motor);
    }

    public void periodic() {
    }
    
    public void driveWithJoysticks(XboxController controller, double speed) {
        m_robotDrive.arcadeDrive(controller.getRawAxis(Constants.XBOX_LEFT_Y_AXIS) * -speed, controller.getRawAxis(Constants.XBOX_LEFT_X_AXIS) * speed);
        System.out.println("Right: " + backRightMotor.getSelectedSensorVelocity() + " - Left: " + backLeftMotor.getSelectedSensorVelocity());
    }

    public void driveForward(double speed) {
        backRightMotor.set(ControlMode.PercentOutput, speed);
        backLeftMotor.set(ControlMode.PercentOutput, speed);
        // m_robotDrive.tankDrive(speed, speed);
    }

    public void stop() {
        backRightMotor.set(ControlMode.PercentOutput, 0);
        backLeftMotor.set(ControlMode.PercentOutput, 0);
        // m_robotDrive.stopMotor();
    }
}
