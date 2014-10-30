import java.awt.Robot;

public class RunTime {

	public static void main(String[] args){
		robot myRobot = new robot(); //creates a new robot object
		
		int pingVal = myRobot.checkDistance(); //get pingVal distance
		
		if(pingVal > 10){ //ping distance in centimeters
			myRobot.moveForward(0, 255); //sends time then speed
			myRobot.moveForward(0, 0);
		}
		
	
		
		
		
		
		
		myRobot.close();
	}
	
	
}
