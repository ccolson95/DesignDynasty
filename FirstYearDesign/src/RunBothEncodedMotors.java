import rxtxrobot.*;

public class RunBothEncodedMotors {
	
	public static void main(String[] args) 
	{ 
		RXTXRobot r = new ArduinoNano(); // Create RXTXRobot object 
		r.setPort("/dev/tty.wch ch341 USB=>RS232 410"); // Set port to COM2 
		r.connect(); 
		//We don't have to attach anything because these motors are 
		//attached by default 

		r.runEncodedMotor(RXTXRobot.MOTOR1, 200, 1200, RXTXRobot.MOTOR2, -220, 1200); //speed, ticks

		//r.runEncodedMotor(RXTXRobot.MOTOR1, 200, 250, RXTXRobot.MOTOR2, 200, 250); 

		r.close(); 
	} 
	
}
