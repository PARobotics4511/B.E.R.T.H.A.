package org.usfirst.frc.team4511.BERTHA.commands;

import org.usfirst.frc.team4511.BERTHA.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoDriveStraight extends Command {
	
	public double kP = .03;
	public double angle;
	double i = 0;

    public AutoDriveStraight() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.soulTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.soulTrain.gyro.reset();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	angle = Robot.soulTrain.gyro.getAngle();
    	Robot.soulTrain.mecanumDrive(0,-.5,-angle*kP);
    	i++;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if (i > 85) return true;
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.soulTrain.driveOff();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
