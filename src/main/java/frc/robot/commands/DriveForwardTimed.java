package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;
import edu.wpi.first.wpilibj.Timer;
import frc.robot.Constants;

public class DriveForwardTimed extends CommandBase {
  private final DriveTrain driveTrain;
  private boolean finish = false;
  private final Timer timer;

  public DriveForwardTimed(DriveTrain dt) {
    driveTrain = dt;
    addRequirements(driveTrain);
    timer = new Timer();
  }

  public void initialize() {
    timer.reset();
    timer.start();
    while (timer.get() < Constants.DRIVE_FORWARD_TIME) {
      driveTrain.driveForward(Constants.AUTONOMOUS_SPEED);
    }
    finish = true;
  }

  public void execute() {
  }

  public void end(boolean interrupted) {
  }

  public boolean isFinished() {
    return finish;
  }
}
