package org.usfirst.frc.team4511.BERTHA.commands;

import org.usfirst.frc.team4511.BERTHA.Robot; 

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class ArmAutoUp extends Command {
	
	int i = 0;
	
    public ArmAutoUp() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.lift);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	i = 0;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.lift.liftTalon.set(-.6);
    	SmartDashboard.putBoolean("running", true);
    	if (Robot.lift.photoTop.get() == true) {
    		i = 1;
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if (i == 1) return true;
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.lift.liftTalon.set(0);
    	SmartDashboard.putBoolean("running", false);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
