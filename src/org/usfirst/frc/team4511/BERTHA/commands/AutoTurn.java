package org.usfirst.frc.team4511.BERTHA.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team4511.BERTHA.Robot;

/**
 *
 */
public class AutoTurn extends Command {
	
	double angle;

    public AutoTurn() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.soulTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	angle = Robot.soulTrain.gyro.getAngle();
    	
    	Robot.soulTrain.drive(.2);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if (angle >= 60) return true;
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
