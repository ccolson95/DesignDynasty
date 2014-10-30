import java.awt.Robot;

public class RunTime {

	public static void main(String[] args){
		Mech mechRobot = new Mech(); //creates a new Mechanical robot system
		//Env envRobot = new Env(); // creates a new Environmental robot system
		
		//begin search for water
		
		int pingVal = mechRobot.checkDistance(); //get pingVal distance
		
		if(pingVal > 10){ //ping distance in centimeters
			mechRobot.moveForward(0, 255); //sends time then speed
			mechRobot.moveForward(0, 0); //sends a speed of 0 to stop the robot
		}
		
	
		
		mechRobot.close(); //closing connection
		//envRobotclose(); //closing connection
	}
	
	
}
