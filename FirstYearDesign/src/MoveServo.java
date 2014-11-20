import rxtxrobot.*;

public class MoveServo {
	
	public static void main(String[] args) 
	{ 
		RXTXRobot r = new ArduinoNano(); // Create RXTXRobot object 
		r.setPort("/dev/tty.wch ch341 USB=>RS232 410"); // Set the port to COM3 
		r.setVerbose(true); // Turn on debugging messages 
		r.connect(); 
		r.attachServo(RXTXRobot.SERVO1, 7); //Connect the servos to the Arduino 
		r.moveServo(RXTXRobot.SERVO1, 84);
		
		for (int x = 0; x < 6; x++)
		{
			System.out.println(x);
			r.sleep(500);
			
		}
		
		r.moveServo(RXTXRobot.SERVO1, 30); // Move Servo 1 to location 30 
		r.sleep(750);
		
		r.moveServo(RXTXRobot.SERVO1, 84); // Move Servo 1 to location 30 
		
		r.sleep(1000);
		r.close();
	} 
}
