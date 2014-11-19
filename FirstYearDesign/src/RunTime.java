import java.awt.Robot;

import rxtxrobot.RXTXRobot;

public class RunTime 
{

	public static void main(String[] args){

		Mech mechRobot = new Mech(); //creates a new Mechanical robot system
		Env envRobot = new Env(); // creates a new Environmental robot system		
		
		//set servo to angle 0
		mechRobot.setServo();
		
		//find water
		//use ping sensor to locate the distance to the wall, needs to be 12.7 centimeters (5 inches) from the wall
		mechRobot.moveForward(0, 180, 38); //sends time, speed, and distance buffer, 0 denotes infinite time
		
		//test water
		//test water for salinity and turbidity
		//envRobot.checkSalinity();
		//envRobot.checkTurbidity();
		
		//locate first station
		mechRobot.moveBackward(0, 180, 23);
		System.out.println("turn right");
		mechRobot.turnRight();
		System.out.println("move forward");
		mechRobot.moveForward(0, 180, 50);
		
		//swing arm to dispense ping pong ball
		//mechRobot.turbidityMaterials(210);
	
		//locate second station
		System.out.println("move backward");
		mechRobot.moveBackward(0, 180, 40);
		mechRobot.turnLeft();
		mechRobot.moveBackward(0, 180, 65);
		mechRobot.turnRight();
		mechRobot.moveForward(0, 180, 50);	
		
		//locate third station
		mechRobot.moveBackward(0, 180, 35);
		mechRobot.turnLeft();
		mechRobot.turnLeft();
		mechRobot.moveForward(0, 180, 50);

		
		//raise sensor claw out of water source using servo
		//mechRobot.raiseSensor();
		
		//analyze water source to determine what materials are needed (how many ping pong balls to dispense)
		//envRobot.checkSalinity();
		//envRobot.checkTurbidity();
			
		//locate first ping pong ball station
   		/*mechRobot.moveBackward(0, 255, 48);
		mechRobot.turnLeft();
		mechRobot.moveForward(0, 255, 12);
		
		//swing claw to knock out ping pong balls into bucket
		//use if statements to choose between using dispenseEven or dispenseOdd functions
		
		//locate second ping pong ball station
		mechRobot.moveBackward(0, 255, 21); //NEED TO MEASURE DISTANCE BUFFER
		mechRobot.turnLeft();
		mechRobot.moveForward(0, 255, 35); //need to determine distance between two stations
		mechRobot.turnRight();
		
		//swing claw to knock out ping pong balls into bucket
		//use if statements to choose between using dispenseEven or dispenseOdd functions

		
		//locate third ping pong ball station
		mechRobot.moveBackward(0, 255, 227);//NEED TO MEASURE DISTANCE BUFFER
		mechRobot.turnLeft();
		mechRobot.moveForward(0, 255, distance); //need to determine distance between two stations
		mechRobot.turnRight();
		
		//swing claw to knock out ping pong balls into bucket
		//use if statements to choose between using dispenseEven or dispenseOdd functions

		
		//locate fourth ping pong ball station
		mechRobot.moveBackward(0, 255, distance);//NEED TO MEASURE DISTANCE BUFFER
		mechRobot.turnLeft();
		mechRobot.moveForward(0, 255, distance); //need to determine distance between two stations
		mechRobot.turnRight();
		
		//swing claw to knock out ping pong balls into bucket
		//use if statements to choose between using dispenseEven or dispenseOdd functions
		*/
		
		//mechRobot.turn180();
		
		//System.out.println(envRobot.getConductivity()); //SALINITY 
		
		//System.out.println(envRobot.testWaterTurbidity()); //TURBIDITY
		
		mechRobot.close(); //closing connection
		envRobot.close(); //closing connection
		
	}
}	
	

