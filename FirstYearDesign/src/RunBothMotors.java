import rxtxrobot.*;

public class RunBothMotors {

	public static void main(String[] args) 
	{ 
		RXTXRobot r = new ArduinoNano(); // Create RXTXRobot object 
		r.setPort("/dev/tty.wch ch341 USB=>RS232 1410"); // Set port to COM2 
		r.connect(); 
		r.runMotor(RXTXRobot.MOTOR1, 200, RXTXRobot.MOTOR2, 200, 0); // Run both motors forward indefinitely 
		r.sleep(5000); // Pause execution for 5 seconds, but the motors keep running. 
		r.runMotor(RXTXRobot.MOTOR1,0,RXTXRobot.MOTOR2,0,0); // Stop both motors 
		r.close(); 
	} 
	
}
