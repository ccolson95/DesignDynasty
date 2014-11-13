import rxtxrobot.*;

public class RunOneMotor {
	
	public static void main(String[] args) 
	{ 
		RXTXRobot r = new ArduinoNano(); // Create RXTXRobot object 
		r.setPort("/dev/tty.wch ch341 USB=>RS232 1410"); // Set port to COM3 
		r.connect(); 
		r.setVerbose(true);
	
		r.runEncodedMotor(RXTXRobot.MOTOR1, 255, 100, RXTXRobot.MOTOR2, -255, 100); // Run both motors forward, one for 100,000 ticks and one for 50,000 ticks
		r.close(); 
	}
	
}
