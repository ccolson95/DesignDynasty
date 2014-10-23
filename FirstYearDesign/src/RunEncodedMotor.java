import rxtxrobot.*;

public class RunEncodedMotor {

	public static void main(String[] args) 
	{ 
		RXTXRobot r = new ArduinoNano(); // Create RXTXRobot object 
		r.setPort("/dev/tty.wch ch341 USB=>RS232 1410"); // Set port to COM3 
		r.connect(); 
		r.runEncodedMotor(RXTXRobot.MOTOR1, 255, 443); // when running for 300 meters input 443
		// Program stops until the command above is completed 
		r.runEncodedMotor(RXTXRobot.MOTOR1, -255, 443); // Run motor 1 backward (speed of 255) for 100,000 ticks 
		r.close(); 
	}
	
}
