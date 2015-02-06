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
	static JoystickButton butt2;
	static JoystickButton butt12;
	static JoystickButton butt3;
	static JoystickButton butt13;
	
	static double deadzone;
	
	public OI() {
		
		deadzone = .25;
		
		//sticks
		stick0 = new Joystick(0);
		stick1 = new Joystick(1);
		
		//buttons
		butt2 = new JoystickButton(stick0, 2);
		butt12 = new JoystickButton(stick1, 2);
		butt3 = new JoystickButton(stick0, 3);
		butt13 = new JoystickButton(stick1, 3);
		
		//arm motor controls
		butt2.whenPressed(new ArmDown());
		butt2.whenReleased(new ArmStop());
		butt12.whenPressed(new ArmUp());
		butt12.whenReleased(new ArmStop());
		
		//arm pneumatics controls
		butt3.whenPressed(new ArmIn());
		butt13.whenPressed(new ArmOut());
	}
	
	public static double getXInput() {
		if (Math.abs(stick0.getX()) > deadzone) return stick0.getX();
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

