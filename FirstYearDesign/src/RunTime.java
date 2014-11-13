import java.awt.Robot;

import rxtxrobot.RXTXRobot;

public class RunTime 
{

	public static void main(String[] args){

		Mech mechRobot = new Mech(); //creates a new Mechanical robot system
		Env envRobot = new Env(); // creates a new Environmental robot system		
		
		//set servo to angle 0
		//mechRobot.setServo();
		
		//find water
		//use ping sensor to locate the distance to the wall, needs to be 12.7 centimeters (5 inches) from the wall
		//mechRobot.moveForward(0, 200, 23); //sends time, speed, and distance buffer, 0 denotes infinite time
		
		//locate first station
		mechRobot.moveBackward(0, 200, 60);
		//swing arm to dispense ping pong ball
		//mechRobot.turbidityMaterials(210);
	
		
		//lower sensor claw into water source using servo
		/*mechRobot.lowerSensor();
		
		//test water for salinity and turbidity
		envRobot.checkSalinity();
		envRobot.checkTurbidity();
		
		//raise sensor claw out of water source using servo
		mechRobot.raiseSensor();
		
		//analyze water source to determine what materials are needed (how many ping pong balls to dispense)
		envRobot.checkSalinity();
		envRobot.checkTurbidity();
			
		//locate first ping pong ball station
   		mechRobot.moveBackward(0, 255, 48.3);
		mechRobot.turnLeft();
		mechRobot.moveForward(0, 255, 12.7);
		
		//swing claw to knock out ping pong balls into bucket
		//use if statements to choose between using dispenseEven or dispenseOdd functions
		
		
		//locate second ping pong ball station
		mechRobot.moveBackward(0, 255, 21.3); //NEED TO MEASURE DISTANCE BUFFER
		mechRobot.turnLeft();
		mechRobot.moveForward(0, 255, 35); //need to determine distance between two stations
		mechRobot.turnRight();
		
		//swing claw to knock out ping pong balls into bucket
		//use if statements to choose between using dispenseEven or dispenseOdd functions

		
		//locate third ping pong ball station
		mechRobot.moveBackward(0, 255, 227.3);//NEED TO MEASURE DISTANCE BUFFER
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
	

