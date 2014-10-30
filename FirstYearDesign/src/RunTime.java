import java.awt.Robot;

public class RunTime {

	public static void main(String[] args){
		Mech mechRobot = new Mech(); //creates a new Mechanical robot system
		//Env envRobot = new Env(); // creates a new Environmental robot system
		
		//begin search for water
		//use ping sensor to locate the distance to the wall, needs to be 12.7 centimeters (5 inches) from the wall
		mechRobot.moveForward(0, 255, 12.7); //sends time then speed, 0 denotes infinite time
			
		
		//rotate servo motor attached to the sensor arm by -90 degrees
			//code for servo motor
			
		//get sensor data
			//code for environmental robot
			
		//rotate servo motor back to original position (positive 90 degrees)
		
	
		
		
		
	
		
		mechRobot.close(); //closing connection
		//envRobotclose(); //closing connection
	}
}	
	

