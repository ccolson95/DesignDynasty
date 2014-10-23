import java.awt.Robot;

public class RunTime {

	public static void main(String[] args){
		robot myRobot = new robot();
		
		int pingVal = myRobot.checkDistance();
		
		
		if(pingVal > 100){
			myRobot.moveForward(100);
		}
		
		
		
		
		
		
		
		
		
		
		
		
		myRobot.close();
	}
	
	
}
