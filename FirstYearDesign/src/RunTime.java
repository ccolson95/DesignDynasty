import java.awt.Robot;

public class RunTime {

	public static void main(String[] args){
		Mech mechRobot = new Mech(); //creates a new Mechanical robot system
		//Env envRobot = new Env(); // creates a new Environmental robot system
		
		//begin search for water
		//use ping sensor to locate the distance to the wall, needs to be 12.7 centimeters (5 inches) from the wall
		//rotate servo motor attached to the sensor arm by -90 degrees
		//get sensor data
		//rotate servo motor back to original position (positive 90 degrees)
		
		int pingVal = mechRobot.checkDistance(); //get pingVal distance
		
		while(pingVal > 12.7){ //ping distance in centimeters
			mechRobot.moveForward(0, 255); //sends time then speed, 0 denotes infinite time
			mechRobot.moveForward(0, 0); //0 denotes infinite time, sends a speed of 0 to stop the robot
		}
		
		
		
		
		
		
		mechRobot.close(); //closing connection
		//envRobotclose(); //closing connection
	}
}	
	

