//import javax.xml.bind.ValidationEvent;

import rxtxrobot.RXTXRobot;
import rxtxrobot.AnalogPin;
import rxtxrobot.ArduinoNano;

public class Mech {

		RXTXRobot r;
		final private static int PING_PIN = 10; 
		final private static int PING_PIN2 = 11; 

		
		public Mech(){
			r = new ArduinoNano(); // Create RXTXRobot object 
			r.setPort("/dev/tty.wch ch341 USB=>RS232 1450"); 
			r.setPort("/dev/tty.wch ch341 USB=>RS232 1410"); 

			//r.setVerbose(true);

			r.connect(); 
		}
		
		//reads the ping sensor value
		
		public int checkDistance(){
			return r.getPing(PING_PIN);
		}
		
		public int checkDistance2(){
			return r.getPing(PING_PIN2);
		}
		
		/*rotates tracks forward
		 * accepts following variables: 
		 * int time: duration of run
		 * int speed: ticks on encoded motors 
		 * double distanceBuffer: distance from the wall
		 * returns nothing
		 */
		
		public void findBridge(int time, int speed, int distanceBuffer ){ 
			r.runMotor(RXTXRobot.MOTOR1, -speed, RXTXRobot.MOTOR2, speed+20, time);
			//get pingVal distance 
			int pingVal = checkDistance2(); 	
			System.out.println(pingVal);
			//ping distance in centimeters
			while(pingVal > distanceBuffer){ 		
				pingVal = checkDistance2();
				System.out.println(pingVal);
			}
			 r.sleep(1500);	
		}
		
		public void moveForward(int time, int speed, double distanceBuffer){
			r.runMotor(RXTXRobot.MOTOR1, speed-15, RXTXRobot.MOTOR2, -speed, time);
			//get pingVal distance 
			int pingVal = checkDistance(); 	
			System.out.println(pingVal);
			//ping distance in centimeters
			while(pingVal > distanceBuffer){ 		
				pingVal = checkDistance();
				System.out.println(pingVal);
			}
			 r.sleep(1500);	
			
		}
		
		/*rotates tracks backward
		 * accepts following variables: 
		 * int time: duration of run
		 * int speed: ticks on encoded motors 
		 * ----------double distanceBuffer: distance from the wall
		 * returns nothing
		 */
		public void moveBackward(int time, int speed, int distanceBuffer ){ 
			r.runMotor(RXTXRobot.MOTOR1, -speed, RXTXRobot.MOTOR2, speed+24, time);
			//get pingVal distance 
			int pingVal = checkDistance(); 	
			System.out.println(pingVal);
			//ping distance in centimeters
			while(pingVal < distanceBuffer){ 		
				pingVal = checkDistance();
				System.out.println(pingVal);
			}
			 r.sleep(1500);	
		}
		
		//turns robot right using ticks
		public void turnRight(){ 
			
			r.runEncodedMotor(RXTXRobot.MOTOR1, 200, 155, RXTXRobot.MOTOR2, 200, 180); //speed, ticks
			r.sleep(1500);
		}
		
		//turns robot left using ticks
		public void turnLeft(){ 
			
			r.runEncodedMotor(RXTXRobot.MOTOR1, -240, 170, RXTXRobot.MOTOR2, -240, 177); //speed, ticks
			r.sleep(1500);
		}
		
		//turns robot 180 degrees using ticks
		public void turn180(){
			
			r.runEncodedMotor(RXTXRobot.MOTOR1, 255, 320, RXTXRobot.MOTOR2, 255, 320); //speed, ticks
		}
		
		public void turbidityMaterials(int turbidityValue){ //calculates the number of turbidity ping pong balls needed
			
			int numberFiftyBalls = turbidityValue / 50;
			int numberTenBalls = (turbidityValue % 50) / 10;
			//dispensePingPongBalls(numberFiftyBalls, numberTenBalls);
			
		}
		
		//sets servo to angle 0
		public void setServo(){
			r.attachServo(RXTXRobot.SERVO1, 7);
			r.moveServo(RXTXRobot.SERVO1, 0); // Move Servo 1 to specified angle 
		}
		
		//dispenses the 10 unit ping pong balls
		public void dispenseTenBalls(int numberTenBalls){ 
			
			r.setVerbose(true); // Turn on debugging messages 
			//r.attachServo(RXTXRobot.SERVO1, 7); //Connect the servos to the Arduino 
			if(numberTenBalls / 2 == 0){ //dispense the 50 turbidity
				for( int i = 0; i < numberTenBalls/2; i++){
					r.moveServo(RXTXRobot.SERVO1, 0); // Move Servo 1 to specified angle 
					r.sleep(1000);

					r.moveServo(RXTXRobot.SERVO1, 180);
					r.sleep(1000);
				}
			}else{
				for( int i = 0; i < numberTenBalls/2; i++){
					r.moveServo(RXTXRobot.SERVO1, 0); // Move Servo 1 to specified angle 
					r.sleep(1000);
					r.moveServo(RXTXRobot.SERVO1, 180);
					r.sleep(1000);
				}
				r.moveServo(RXTXRobot.SERVO1, 0); // Move Servo 1 to specified angle 

			}
		}
		
		//dispenses the 50 unit balls
		public void dispenseFiftyBalls(int numberFiftyBalls){ 
			if(numberFiftyBalls / 2 == 0){ //dispense the 10 turbidity
				for( int i = 0; i < numberFiftyBalls/2; i++){
					r.moveServo(RXTXRobot.SERVO1, 0); // Move Servo 1 to specified angle 
					r.sleep(1000);
					r.moveServo(RXTXRobot.SERVO1, 180);
					r.sleep(1000);
				}
			}else{
				for( int i = 0; i < numberFiftyBalls/2; i++){
					r.moveServo(RXTXRobot.SERVO1, 0); // Move Servo 1 to specified angle 
					r.sleep(1000);
					r.moveServo(RXTXRobot.SERVO1, 180);
					r.sleep(1000);
				}
				r.moveServo(RXTXRobot.SERVO1, 0); // Move Servo 1 to specified angle 

			}
			
		}	
		
		public void lowerSensor(){
			
			//servo code
			
		}
		
		public void raiseSensor(){
			
			//servo code
			
		}
		
		public void bothEncodedMotors(int numberTicks){
			r.runEncodedMotor(RXTXRobot.MOTOR1, 190, numberTicks, RXTXRobot.MOTOR2, -190, numberTicks); 
			//90 ticks = 1 rotation
		}
		
		public void close(){
			r.close(); 
		}
		
		
}
