package org.usfirst.frc.team4511.BERTHA.subsystems;

import org.usfirst.frc.team4511.BERTHA.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;

/**
 *
 */
public class Lift extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public Compressor compressor;
	public Solenoid sol0;
	public Solenoid sol1;
	
	public CANTalon liftTalon;
	
	public DigitalInput photoBot;
	public DigitalInput photoTop;
	
	public Lift() {
		compressor = new Compressor(RobotMap.comp);
		sol0 = new Solenoid(RobotMap.sol0);
		sol1 = new Solenoid(RobotMap.sol1);
		
		liftTalon = new CANTalon(RobotMap.lift);
		
		photoBot = new DigitalInput(0);
		photoTop = new DigitalInput(1);
		
	}
	

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

