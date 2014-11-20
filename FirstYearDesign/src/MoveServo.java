import rxtxrobot.*;

public class MoveServo {
	
	public static void main(int numberTurns) 
	{ 
		RXTXRobot r = new ArduinoNano(); // Create RXTXRobot object 
	 
		r.moveServo(RXTXRobot.SERVO1, 84);
		
		r.moveServo(RXTXRobot.SERVO1, 30); // Move Servo 1 to location 30 
		r.sleep(750);
		
		r.moveServo(RXTXRobot.SERVO1, 84); // Move Servo 1 to location 30 
		
		r.sleep(1000);
		r.close();
	} 
}
