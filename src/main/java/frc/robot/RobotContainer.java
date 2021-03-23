package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.DriveWithJoysticks;
import frc.robot.commands.DriveForwardTimed;
import frc.robot.subsystems.DriveTrain;

public class RobotContainer {
    private final DriveTrain driveTrain;
    private final DriveWithJoysticks driveWithJoysticks;
    private final DriveForwardTimed driveForwardTimed;
    public static XboxController driverJoystick;

    public RobotContainer() {
        driveTrain = new DriveTrain();
        driveWithJoysticks = new DriveWithJoysticks(driveTrain);
        driveWithJoysticks.addRequirements(driveTrain);
        driveTrain.setDefaultCommand(driveWithJoysticks);

        driveForwardTimed = new DriveForwardTimed(driveTrain);
        driveForwardTimed.addRequirements(driveTrain);

        driverJoystick = new XboxController(Constants.JOYSTICK_NUMBER);
        confgiureButtonBindings();
    }

    public void confgiureButtonBindings() {

    }

    public Command getAutonomousCommand() {
        return driveForwardTimed;
    }
}