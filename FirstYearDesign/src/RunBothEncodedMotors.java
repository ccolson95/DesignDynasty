import rxtxrobot.*;

public class RunBothEncodedMotors {
	
	public static void main(String[] args) 
	{ 
		RXTXRobot r = new ArduinoNano(); // Create RXTXRobot object 
		r.setPort("/dev/tty.wch ch341 USB=>RS232 1410"); // Set port to COM2 
		r.connect(); 
		//We don't have to attach anything because these motors are 
		//attached by default 
		r.runEncodedMotor(RXTXRobot.MOTOR1, 255, 1000, RXTXRobot.MOTOR2, -255, 1000); //speed, ticks
		r.close(); 
	} 
	
}
