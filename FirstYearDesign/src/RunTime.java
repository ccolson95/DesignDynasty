import java.awt.Robot;

import rxtxrobot.RXTXRobot;

public class RunTime 
{

	public static void main(String[] args){

		Mech mechRobot = new Mech(); //creates a new Mechanical robot system
		Env envRobot = new Env(); // creates a new Environmental robot system		
		
		//set servo to angle 0
		mechRobot.setServo();
		mechRobot.setServo2();
		
		mechRobot.moveForward(0, 180, 34); //sends time, speed, and distance buffer, 0 denotes infinite time
		mechRobot.sleep(1500);
		mechRobot.stopMotors();
		//find water
		//use ping sensor to locate the distance to the wall
		mechRobot.moveForward(0, 180, 38); //sends time, speed, and distance buffer, 0 denotes infinite time
		
		//test water		
		double salinity = envRobot.checkSalinity();
		double turbidity = envRobot.checkTurbidity();
		
		//locate first station
		mechRobot.moveBackward(0, 180, 20);
		System.out.println("turn right");
		mechRobot.turnRight();
		System.out.println("move forward");
		
		mechRobot.moveForward(0, 180, 43);
		mechRobot.sleep(1500);
		mechRobot.stopMotors();
		
		mechRobot.dispenseSmallUnitBalls(turbidity);
		 
		
		//locate second station
		System.out.println("move backward");
		mechRobot.moveBackward(0, 180, 40);
		mechRobot.turnLeft();
		mechRobot.moveBackward(0, 180, 70);
		mechRobot.turnRight();
		mechRobot.moveForward(0, 180, 49);
		mechRobot.sleep(1500);
		mechRobot.stopMotors();
		mechRobot.dispenseLargeUnitBalls(9);
		
		//locate third station
		mechRobot.moveBackward(0, 180, 35);
		mechRobot.turnLeft();
		mechRobot.turnLeft();
		mechRobot.moveForward(0, 180, 45);
		mechRobot.sleep(1500);
		mechRobot.stopMotors();
		mechRobot.dispenseSmallUnitBalls(10);
		
		//locate fourth station
		mechRobot.moveBackward(0, 180, 35);
		mechRobot.turnRight();
		mechRobot.moveForward(0, 180, 60);
		mechRobot.turnLeft();
		mechRobot.moveForward(0, 180, 45);
		mechRobot.sleep(1500);
		mechRobot.stopMotors();
		mechRobot.dispenseTenBalls(10);

		*/
		//find bridge
		//mechRobot.findBridge(0, 150, 65);
		//mechRobot.turnLeft();
		mechRobot.moveForward(0, 200, 200);
		
		
		//swing claw to knock out ping pong balls into bucket
		//use if statements to choose between using dispenseEven or dispenseOdd functions
		
		
		//mechRobot.turn180();
>>>>>>> Stashed changes
		
		//locate bridge
		mechRobot.moveBackward(0, 180, 40);
		mechRobot.turnRight();
		mechRobot.moveBackward(0, 180, 60);
		mechRobot.turnLeft();
		mechRobot.sleep(1500);
		mechRobot.stopMotors();
		mechRobot.findBridge(0, 150, 65);

		//System.out.println(envRobot.getConductivity()); //SALINITY 
		
		//System.out.println(envRobot.testWaterTurbidity()); //TURBIDITY
		
		mechRobot.close(); //closing connection
		//envRobot.close(); //closing connection
*/
	}
	
}	


