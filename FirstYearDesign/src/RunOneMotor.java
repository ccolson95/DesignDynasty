import rxtxrobot.*;

public class RunOneMotor {
	
	public static void main(String[] args) 
	{ 
		RXTXRobot r = new ArduinoNano(); // Create RXTXRobot object 
		r.setPort("/dev/tty.wch ch341 USB=>RS232 1410"); // Set port to COM3 
		r.connect(); 
		r.runMotor(RXTXRobot.MOTOR2, 125, 500); // Run motor 1 forward (speed of 125) for 5 seconds 
		// Program stops until the command above is completed (5 seconds) 
		r.runMotor(RXTXRobot.MOTOR2, -125, 300); // Run motor 1 backward (speed of 125) for 3 seconds 
		r.close(); 
	}
	
}
