//import javax.xml.bind.ValidationEvent;

import rxtxrobot.RXTXRobot;
import rxtxrobot.AnalogPin;
import rxtxrobot.ArduinoNano;

public class Mech {

		RXTXRobot r;
		final private static int PING_PIN = 12; 
		
		public Mech(){
			r = new ArduinoNano(); // Create RXTXRobot object 
			r.setPort("/dev/tty.wch ch341 USB=>RS232 1410"); 
			r.connect(); 
		}
		
		//reads the ping sensor value
		public int checkDistance(){
			int val = 0;
			for (int x = 0; x < 10; ++x) { 
				val = r.getPing(PING_PIN);
				r.sleep(300); 
			} 
			return val;  
		}
		
		/*rotates tracks forward
		 * accepts following variables: 
		 * int time: duration of run
		 * int speed: ticks on encoded motors 
		 * double distanceBuffer: distance from the wall
		 * returns nothing
		 */
		public void moveForward(int time, int speed, double distanceBuffer){ 
			//get pingVal distance 
			int pingVal = checkDistance(); 	
			
			//ping distance in centimeters
			while(pingVal > distanceBuffer){ 		
				r.runMotor(RXTXRobot.MOTOR1, -speed, RXTXRobot.MOTOR2, speed, time);  
			}
			
			//stop robot
			r.runMotor(RXTXRobot.MOTOR1, 0, RXTXRobot.MOTOR2, 0, 0);
			
		}
		
		/*rotates tracks backward
		 * accepts following variables: 
		 * int time: duration of run
		 * int speed: ticks on encoded motors 
		 * ----------double distanceBuffer: distance from the wall
		 * returns nothing
		 */
		public void moveBackward(int time, int speed, double distanceBuffer ){ 
			
			r.runMotor(RXTXRobot.MOTOR1, speed, RXTXRobot.MOTOR2, -speed, time); 
			 	
		}
		
		//turns robot right using ticks
		public void turnRight(){ 
			
			r.runEncodedMotor(RXTXRobot.MOTOR1, 255, 160, RXTXRobot.MOTOR2, 255, 160); //speed, ticks
			
		}
		
		//turns robot left using ticks
		public void turnLeft(){ 
			
			r.runEncodedMotor(RXTXRobot.MOTOR1, -255, 160, RXTXRobot.MOTOR2, -255, 160); //speed, ticks
			
		}
		
		//turns robot 180 degrees using ticks
		public void turn180(){
			
			r.runEncodedMotor(RXTXRobot.MOTOR1, 255, 320, RXTXRobot.MOTOR2, 255, 320); //speed, ticks
		}
		
		//moves arm to knock out even number of ping pong balls
		public void dispenseEven(){
			
			r.setVerbose(true); // Turn on debugging messages 
			r.attachServo(RXTXRobot.SERVO1, 8); //Connect the servos to the Arduino 
			r.moveServo(RXTXRobot.SERVO1, 0); // Move Servo 1 to specified angle 
			r.sleep(10000);
			r.close(); //this makes the servo go back to 90 degrees and dispensing another ping pong ball 
			
		}
		
		//moves arm to knock out odd number of ping pong balls
		public void dispenseOdd(){
			
			r.setVerbose(true); // Turn on debugging messages 
			r.attachServo(RXTXRobot.SERVO1, 8); //Connect the servos to the Arduino 
			r.moveServo(RXTXRobot.SERVO1, 0); // Move Servo 1 to specified angle 
			r.sleep(10000);
			//no close here or it would knock out another ping pong ball
			
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
		
		public void close(){
			r.close(); 
		}
		
		
}
