package org.usfirst.frc.team4511.BERTHA;

import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.Joystick;
import org.usfirst.frc.team4511.BERTHA.commands.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
	static Joystick stick0;
	static Joystick stick1;
	static JoystickButton butt1;
	static JoystickButton butt11;
	static JoystickButton butt2;
	static JoystickButton butt21;
	static JoystickButton butt3;
	static JoystickButton butt31;
	static JoystickButton butt4;
	static JoystickButton butt5;
	
	static double deadzoneX;
	static double deadzone;
	
	public OI() {
		
		deadzoneX = .03;
		deadzone = .1;
		
		//sticks
		stick0 = new Joystick(0);
		stick1 = new Joystick(1);
		System.out.println("This code is up to date");
		
		//buttons
		butt1 = new JoystickButton(stick0, 1);
		butt11 = new JoystickButton(stick1, 1);
		butt2 = new JoystickButton(stick0, 2);
		butt21 = new JoystickButton(stick1, 2);
		butt3 = new JoystickButton(stick0, 3);
		butt31 = new JoystickButton(stick1, 3);
		butt4 = new JoystickButton(stick0, 4);
		butt5 = new JoystickButton(stick1, 5);
		
		//arm pneumatics controls
		butt1.whenPressed(new ArmIn());
		butt11.whenPressed(new ArmOut());
		
		//precision drive controls
		//butt2.whenPressed(new JoystickDriveSlow());
		//butt21.whenPressed(new JoystickDrive());
		
		//arm manual override
		butt3.whenPressed(new ArmUp());
		butt3.whenReleased(new ArmStop());
		butt31.whenPressed(new ArmDown());
		butt31.whenReleased(new ArmStop());
		butt4.whenPressed(new PowahUp());
		butt4.whenReleased(new ArmStop());
		butt5.whenPressed(new PowahDown());
		butt5.whenReleased(new ArmStop());
		butt21.whenPressed(new LiftDownSlow());
		butt21.whenReleased(new ArmStop());
	}
	
	public static double getXInput() {
		if (Math.abs(stick0.getX()) > deadzoneX) return stick0.getX();
		return 0;
	}
	
	public static double getYInput() {
		if (Math.abs(stick0.getY()) > deadzone) return stick0.getY();
		return 0;
	}
	
	public static double getZInput() {
		if (Math.abs(stick1.getX()) > deadzone) return stick1.getX();
		return 0;
	}
	
	public static double getXInputSlow() {
		if (Math.abs(stick0.getX()) > deadzone) return stick0.getX()/3;
		return 0;
	}
	
	public static double getYInputSlow() {
		if (Math.abs(stick0.getY()) > deadzone) return stick0.getY()/3;
		return 0;
	}
	
	public static double getZInputSlow() {
		if (Math.abs(stick1.getX()) > deadzone) return stick1.getX()/3;
		return 0;
	}
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
}

