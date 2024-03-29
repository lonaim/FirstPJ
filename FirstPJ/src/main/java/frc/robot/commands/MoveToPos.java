// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants.ArmConstants;
import frc.robot.subsystems.ArmSubsystem;

public class MoveToPos extends CommandBase {
  private final ArmSubsystem arm = ArmSubsystem.getInstance();
  double pos;

  /** Creates a new MoveToPos. */
  public MoveToPos(double pos) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.addRequirements(arm);
    this.pos = pos;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    if(arm.getPlace()<pos){
      arm.setMotor(ArmConstants.CollectMotorSpeed);
    }
    if(arm.getPlace()>pos){
      arm.setMotor(-1*(ArmConstants.CollectMotorSpeed));
    }
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    arm.setMotor(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return arm.getPlace()==pos;
  }
}
