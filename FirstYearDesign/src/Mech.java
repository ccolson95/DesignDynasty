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
			r.setPort("/dev/tty.wch ch341 USB=>RS232 1410"); 
			r.connect(); 
		}
		
		//reads the ping sensor value
		public int checkDistance(){
			return r.getPing(PING_PIN);
		}
		
		public void sleep(double i){
			r.sleep((int) i);
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
			r.runMotor(RXTXRobot.MOTOR1, speed-24, RXTXRobot.MOTOR2, -speed, time);
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
		r.sleep(1500);
		}
		
		
		//dispenses the 10 unit ping pong balls
		public void dispenseSmallUnitBalls(double turbidityValue){ 
<<<<<<< HEAD
			double numberBalls = ((int)(turbidityValue % 50) / 10);
=======

			int numberBalls = (int)((turbidityValue % 50) / 10);
>>>>>>> FETCH_HEAD
			numberBalls *= 750;
			
			r.moveServo(RXTXRobot.SERVO1, 30); // Move Servo 1 to location 30 
			r.sleep((int)numberBalls);
			r.moveServo(RXTXRobot.SERVO1, 84); 
			r.sleep(100);
			r.close();
		}
		

		//dispenses the 50 unit balls
		public void dispenseLargeUnitBalls(double turbidityValue){ 
<<<<<<< HEAD
			double numberBalls = (int)(turbidityValue / 50);
=======
			int numberBalls = (int)(turbidityValue / 50);
>>>>>>> FETCH_HEAD
			numberBalls *= 750;

			r.moveServo(RXTXRobot.SERVO1, 30); // Move Servo 1 to location 30 
			r.sleep((int)numberBalls);
			r.moveServo(RXTXRobot.SERVO1, 84); 
			r.sleep(100);
			r.close();
		}
			
		//sets arm servo
		public void setArmServo(){
			r.attachServo(RXTXRobot.SERVO1, 7);
			r.moveServo(RXTXRobot.SERVO1, 0); // Move Servo 1 to specified angle
		}
		
		//sets ball gate servo
		public void setBallGateServo(){
			r.attachServo(RXTXRobot.SERVO2, 12);
			r.moveServo(RXTXRobot.SERVO2, 84); // Move Servo 1 to specified angle
		}
<<<<<<< HEAD
		
		public void setSensorServo(){ //sensor servo
			r.attachServo(RXTXRobot.SERVO3, 8);
			r.moveServo(RXTXRobot.SERVO3, 90);
		}
		
		public void setServo4(){
			r.moveServo(RXTXRobot.SERVO3, 30);
=======
			
		//sets sensor servo to angle 0
		public void setServo3(){
			r.attachServo(RXTXRobot.SERVO3, 8);
			r.moveServo(RXTXRobot.SERVO3, 90); // Move Servo 3 to specified angle
		}
		
		public void setServo4(){
			r.moveServo(RXTXRobot.SERVO3, 30); // Move Servo 3 to specified angle
>>>>>>> FETCH_HEAD
		}
				
		public void stopMotors() {
			r.runMotor(RXTXRobot.MOTOR1, 0, RXTXRobot.MOTOR2, 0, 0);
		}	
		
		public void lowerSensor(){
<<<<<<< HEAD
			for(int i=90; i>30; i--){
				r.moveServo(RXTXRobot.SERVO3, i);	
				r.sleep(20);
			}
		}
		
		public void lowerSensor2(){
			r.moveServo(RXTXRobot.SERVO1, 30);
		}
		
		public void raiseSensor(){
			r.moveServo(RXTXRobot.SERVO3, 90);
=======
			r.moveServo(RXTXRobot.SERVO3, 30); // Move Servo 3 to specified angle
		}
		
		public void raiseSensor(){
			
			r.moveServo(RXTXRobot.SERVO3, 90); // Move Servo 3 to specified angle
			
>>>>>>> FETCH_HEAD
		}
		
		public void bothEncodedMotors(int numberTicks){
			r.runEncodedMotor(RXTXRobot.MOTOR1, 190, numberTicks, RXTXRobot.MOTOR2, -190, numberTicks); 
			//90 ticks = 1 rotation
		}
		
		public void close(){
			r.close(); 
		}

		
		
}
