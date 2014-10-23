import javax.xml.bind.ValidationEvent;

import rxtxrobot.AnalogPin;
import rxtxrobot.ArduinoNano;
import rxtxrobot.RXTXRobot;
//testing git hub
public class robot {
	RXTXRobot r;
	final private static int PING_PIN = 12; 
	
	public robot(){
		r = new ArduinoNano(); // Create RXTXRobot object 
		r.setPort("/dev/tty.wch ch341 USB=>RS232 1410"); 
		r.connect(); 
	}
	
	
	public int checkDistance(){
		 	
		int val = 0;
		for (int x = 0; x < 10; ++x) { 
			//Read the ping sensor value, which is connected to pin 12 
			val = r.getPing(PING_PIN);
			r.sleep(300); 
		} 
		
		return val;  
		
	}
	
	public void moveForward(int time){ //rotates wheels forwards
		
		r.runMotor(RXTXRobot.MOTOR1, time, RXTXRobot.MOTOR2, -time, 0);  
		
	}
	
	public void moveBackward(int time){ //rotates wheels backwards
		
		r.runMotor(RXTXRobot.MOTOR1, -time, RXTXRobot.MOTOR2, time, 0); 
		 	
	}
	
	public void turnRight(int time){ //turns robot right
		
		r.runMotor(RXTXRobot.MOTOR1, 125, time); // Run motor 1 forward (speed of 125) for 5 seconds 
		// Program stops until the command above is completed (5 seconds) 
		r.runMotor(RXTXRobot.MOTOR1, -125, time); // Run motor 1 backward (speed of 125) for 3 seconds 
		
	}
	
	public void turnLeft(int time){ //turns robot left
		
		r.runMotor(RXTXRobot.MOTOR2, 125, time); // Run motor 1 forward (speed of 125) for 5 seconds 
		// Program stops until the command above is completed (5 seconds) 
		r.runMotor(RXTXRobot.MOTOR2, -125, time); // Run motor 1 backward (speed of 125) for 3 seconds 
		
	}
	
	//sample from FYD
	public void moveServo(){
		
		r.setVerbose(true); // Turn on debugging messages 
		r.attachServo(RXTXRobot.SERVO1, 7); //Connect the servos to the Arduino 
		//r.attachServo(RXTXRobot.SERVO2, 7); 
		r.moveServo(RXTXRobot.SERVO1, 0); // Move Servo 1 to location 30 
		r.sleep(10000);
		r.moveServo(RXTXRobot.SERVO2, 170); // Move Servo 2 to location 170 
		
	}
	
	//samples from FYD
	public void moveBothServos(int angle1, int angle2){
		 
		r.attachServo(RXTXRobot.SERVO1, 9); //Connect the servos to the Arduino 
		r.attachServo(RXTXRobot.SERVO2, 10); 
		r.attachServo(RXTXRobot.SERVO3, 11); 
		r.moveAllServos(angle1, angle2, 0); // Move Servo 1 to position 20, Servo 2 to position 170, and Servo 3 to position 0. 
		
	}
	
	public void openClaw(){
		
		//servo code
		
	}
	
	public void closeClaw(){
		
		//servo code
		
	}
	
	public void swingClaw(){
		
		//servo code
		
	}
	
	public void lowerSensor(){
		
		//servo code
		
	}
	
	public void raiseSensor(){
		
		//servo code
		
	}
	
	public void bothEncodedMotors(int numberTicks){
		 
		r.runEncodedMotor(RXTXRobot.MOTOR1, 255, numberTicks, RXTXRobot.MOTOR2, 255, numberTicks); 
		//90 ticks = 1 rotation
	}
	
	public void checkTurbidity(){
		
		
	}
	
	
	public void checkSalinity(){
		
		
		
	}
	
	public void close(){
		r.close(); 
	}
	
	
	
	
	
}
