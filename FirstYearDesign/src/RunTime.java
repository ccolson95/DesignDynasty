import java.awt.Robot;

import rxtxrobot.RXTXRobot;

public class RunTime 
{

	public static void main(String[] args){

		Mech mechRobot = new Mech(); //creates a new Mechanical robot system
		Env envRobot = new Env(); // creates a new Environmental robot system		
		
		//set servo to angle 0
		mechRobot.setArmServo();
		mechRobot.setBallGateServo();
		mechRobot.setSensorServo();
		
		mechRobot.moveForward(0, 180, 34); //sends time, speed, and distance buffer, 0 denotes infinite time
		mechRobot.sleep(1500);
		mechRobot.stopMotors();
		mechRobot.lowerSensor();
		mechRobot.sleep();
		mechRobot.raiseSensor();
		
		//find water
		//use ping sensor to locate the distance to the wall
		
		//test water	
		/*mechRobot.lowerSensor();
		mechRobot.sleep();
		mechRobot.raiseSensor();
		double salinity = envRobot.checkSalinity();
		double turbidity = envRobot.checkTurbidity();
		*/
		
		//locate first station
		mechRobot.moveBackward(0, 180, 20);
		mechRobot.lowerSensor2();
		System.out.println("turn right");
		mechRobot.turnRight();
		System.out.println("move forward");
		
		mechRobot.moveForward(0, 180, 43);
		mechRobot.sleep(1500);
		mechRobot.stopMotors();
		
		mechRobot.dispenseSmallUnitBalls(310);
		 
		
		//locate second station
		System.out.println("move backward");
		mechRobot.moveBackward(0, 180, 40);
		mechRobot.turnLeft();
		mechRobot.moveBackward(0, 180, 70);
		mechRobot.turnRight();
		mechRobot.moveForward(0, 180, 49);
		mechRobot.sleep(1500);
		mechRobot.stopMotors();
		mechRobot.dispenseLargeUnitBalls(300);
		
		//locate third station
		mechRobot.moveBackward(0, 180, 35);
		mechRobot.turnLeft();
		mechRobot.turnLeft();
		mechRobot.moveForward(0, 180, 45);
		mechRobot.sleep(1500);
		mechRobot.stopMotors();
		mechRobot.dispenseLargeUnitBalls(330);
		
		//locate fourth station
		mechRobot.moveBackward(0, 180, 35);
		mechRobot.turnRight();
		mechRobot.moveForward(0, 180, 60);
		mechRobot.turnLeft();
		mechRobot.moveForward(0, 180, 45);
		mechRobot.sleep(1500);
		mechRobot.stopMotors();
		mechRobot.dispenseSmallUnitBalls(320);

		//find bridge
		mechRobot.moveBackward(0, 180, 35);
		mechRobot.turnLeft();
		mechRobot.moveBackward(0, 180, 65);
		mechRobot.turnLeft();
		mechRobot.findBridge(0, 150, 65);
		mechRobot.turnLeft();
		mechRobot.moveForward(0, 200, 70);

		
		mechRobot.close(); //closing connection
		//envRobot.close(); //closing connection

	}
	
}	


