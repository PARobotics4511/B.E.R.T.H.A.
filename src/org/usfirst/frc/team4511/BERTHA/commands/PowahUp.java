package org.usfirst.frc.team4511.BERTHA.commands;

import org.usfirst.frc.team4511.BERTHA.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class PowahUp extends Command {

    public PowahUp() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.lift);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double addPower= .1;
    	Robot.lift.liftTalon.set(-.65);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
