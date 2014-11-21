import rxtxrobot.*;

public class MoveServo {
	
	public static void main(String [] args) 
	{ 
		RXTXRobot r = new ArduinoNano(); // Create RXTXRobot object 
		r.setPort("/dev/tty.wch ch341 USB=>RS232 1410"); 
		r.connect();
		r.attachServo(RXTXRobot.SERVO1, 8);
		r.moveServo(RXTXRobot.SERVO1, 30);
		
		r.sleep(1000);
		r.close();
	} 
}
