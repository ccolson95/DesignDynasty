import rxtxrobot.*;

public class MoveServo {
	
	public static void main(String[] args) 
	{ 
		RXTXRobot r = new ArduinoNano(); // Create RXTXRobot object 
		r.setPort("/dev/tty.wch ch341 USB=>RS232 1420"); // Set the port to COM3 
		r.setVerbose(true); // Turn on debugging messages 
		r.connect(); 
		r.attachServo(RXTXRobot.SERVO1, 8); //Connect the servos to the Arduino 
		//r.attachServo(RXTXRobot.SERVO2, 7);
		for( int i =8; i <8; i++){
		r.moveServo(RXTXRobot.SERVO1, 90); // Move Servo 1 to location 30 
		}
		r.sleep(1000);
	} 
}
