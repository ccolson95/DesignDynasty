import rxtxrobot.*; 
 
public class testing 
{ 
	final private static int PING_PIN = 11; 
	final private static int PING_PIN2 = 12; 
	
	public static void main(String[] args) 
	{ 
		RXTXRobot r = new ArduinoNano(); // Create RXTXRobot object 
		
		r.setPort("/dev/tty.wch ch341 USB=>RS232 410"); // Set port to COM2 
		r.connect(); 
		
		//r.runMotor(RXTXRobot.MOTOR2, 125, 500); // Run motor 1 forward (speed of 125) for 5 seconds 
		// Program stops until the command above is completed (5 seconds) 
		//r.runMotor(RXTXRobot.MOTOR1, -125, 300); // Run motor 1 backward (speed of 125) for 3 seconds 
		
		// Run motors for testing
		//r.runMotor(RXTXRobot.MOTOR1, 200, RXTXRobot.MOTOR2, -200, 4000); // Run both motors forward indefinitely 
		//r.sleep(2000); // Pause execution for 5 seconds, but the motors keep running. 
		//r.runMotor(RXTXRobot.MOTOR1,0,RXTXRobot.MOTOR2,0,0); //  Stop both motors 
		
		
		
		
		 // Test Ping
		
		for (int x=0; x < 30; ++x) 
		{ 
			//Read the ping sensor value, which is connected to pin 12 
			System.out.println("Response1: " + r.getPing(PING_PIN) + " cm"); 
			System.out.println("Response2: " + r.getPing(PING_PIN2) + " cm"); 
			r.sleep(300); 
		} 
		
		/*
		while (r.getPing(PING_PIN2) > 20)
		{
			r.runMotor(RXTXRobot.MOTOR1,250,RXTXRobot.MOTOR2,-250,0);
			System.out.println("Response1: " + r.getPing(PING_PIN2) + " cm");
		}
		
		r.runMotor(RXTXRobot.MOTOR1,0,RXTXRobot.MOTOR2,0,0);
		 */	
		//r.runEncodedMotor(RXTXRobot.MOTOR1, 255, 200, RXTXRobot.MOTOR2, -255, 200); // Run both motors forward, one for 100,000 ticks and one for 50,000 ticks.
		
		/*r.attachServo(RXTXRobot.SERVO1, 9); //Connect the servos to the Arduino  
		r.attachServo(RXTXRobot.SERVO2, 10);
		r.moveServo(RXTXRobot.SERVO1, 110); // Move Servo 1 to location 30
		
		r.moveServo(RXTXRobot.SERVO2, 0);*/
		
		//r.attachServo(RXTXRobot.SERVO2, 10); //Connect the servos to the Arduino 
		//r.attachServo(RXTXRobot.SERVO1, 8); 
		//r.attachServo(RXTXRobot.SERVO3, 11); 
		//r.moveAllServos(20,170, 0);
		r.moveServo(RXTXRobot.SERVO2, 0);
		
		r.close(); 
		
	} 
} 
