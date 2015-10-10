package org.usfirst.frc.team4511.BERTHA.subsystems;

import org.usfirst.frc.team4511.BERTHA.RobotMap;
import org.usfirst.frc.team4511.BERTHA.commands.JoystickDrive;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.CANTalon;

/**
 *
 */
public class SoulTrain extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	//Driving Talons
	CANTalon frontLeft;
	CANTalon backLeft;
	CANTalon frontRight;
	CANTalon backRight;
	
	//RobotDrive
	RobotDrive soulTrain;
	
	public Gyro gyro;
	
	public SoulTrain() {
		
		gyro = new Gyro(1);
		
		frontLeft = new CANTalon(RobotMap.frontLeft);
		frontRight = new CANTalon(RobotMap.frontRight);
		backLeft = new CANTalon(RobotMap.backLeft);
		backRight = new CANTalon(RobotMap.backRight);
		
		soulTrain = new RobotDrive(frontLeft, backLeft, frontRight, backRight);
		soulTrain.setInvertedMotor(RobotDrive.MotorType.kFrontRight, true);
		soulTrain.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);
		//soulTrain.setInvertedMotor(RobotDrive.MotorType.kFrontLeft, true);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new JoystickDrive());
    }
    
    public void mecanumDrive(double x, double y, double z) {
    	soulTrain.mecanumDrive_Cartesian(x, y, z, 0);
    }
    
    public void drive(double x) {
    	soulTrain.drive(.5, x);
    }
    public void drive2(double x) {
    	soulTrain.drive(-.5, x);
    }
    public void driveOff() {
    	soulTrain.drive(0, 0);
    }
}

