import java.awt.Robot;

public class RunTime {

	public static void main(String[] args){
		Mech mechRobot = new Mech(); //creates a new Mechanical robot system
		Env envRobot = new Env(); // creates a new Environmental robot system
		
		//find water
		//use ping sensor to locate the distance to the wall, needs to be 12.7 centimeters (5 inches) from the wall
		mechRobot.moveForward(0, 255, 12.7); //sends time then speed, 0 denotes infinite time
		
		//lower sensor claw into water source using servo
		mechRobot.lowerSensor();
		
		//test water for salinity and turbidity
		envRobot.checkSalinity();
		envRobot.checkTurbidity();
		
		//raise sensor claw out of water source using servo
		mechRobot.raiseSensor();
		
		//analyze water source to determine what materials are needed (how many ping pong balls to dispense)
		envRobot.determineMaterials();
			
		//locate first ping pong ball station
		mechRobot.moveBackward(0, 255, distance);
		mechRobot.turnLeft(time);
		mechRobot.moveForward(0, 255, 12.7);
		
		//use claw to get ping pong balls
		
		
		//locate second ping pong ball station
		mechRobot.moveBackward(0, 255, distance);
		mechRobot.turnLeft(time);
		mechRobot.moveForward(0, 255, distance); //need to determine distance between two stations
		mechRobot.turnRight(time);
		
		//use claw to get ping pong balls
		
		//locate third ping pong ball station
		mechRobot.moveBackward(0, 255, distance);
		mechRobot.turnLeft(time);
		mechRobot.moveForward(0, 255, distance); //need to determine distance between two stations
		mechRobot.turnRight(time);
		
		//locate fourth ping pong ball station
		mechRobot.moveBackward(0, 255, distance);
		mechRobot.turnLeft(time);
		mechRobot.moveForward(0, 255, distance); //need to determine distance between two stations
		mechRobot.turnRight(time);
		
		mechRobot.close(); //closing connection
		//envRobotclose(); //closing connection
		
	}
}	
	

