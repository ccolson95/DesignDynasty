

public class RunTime 
{

	public static void main(String[] args){

		Mech mechRobot = new Mech(); //creates a new Mechanical robot system
		Env envRobot = new Env(); // creates a new Environmental robot system		
		
		for(int i = 0; i < 300; i++){
			System.out.println("PING: " + mechRobot.checkDistance2() + ", PING2: " + mechRobot.checkDistance());
		}
		
		//set servo to angle 0
		/*mechRobot.setServo();
        mechRobot.setServo2();
		mechRobot.setServo3();
//		
//		//find water
	mechRobot.moveForward(0, 180, 36); //sends time, speed, and distance buffer, 0 denotes infinite time
	mechRobot.sleep(1000);
	mechRobot.stopMotors();
//mechRobot.

		//test water
		//mechRobot.lowerSensor();
		//mechRobot.sleep(15000);
		double salinity = envRobot.checkSalinity();
		double turbidity = envRobot.checkTurbidity();
		//mechRobot.raiseSensor();
//		
//		//locate first station
mechRobot.moveBackward(0, 180, 20);
		mechRobot.stopMotors();
		mechRobot.setServo4();
		//System.out.println("turn right");
		mechRobot.turnRight();
		//System.out.println("move forward");		
	mechRobot.moveForward(0, 180, 65);
	mechRobot.sleep(1500);
	mechRobot.stopMotors();
		
		mechRobot.dispenseSmallUnitBalls(310);
		
		//locate second station
		System.out.println("move backward");
		mechRobot.moveBackward(0, 180, 40);
		mechRobot.turnLeft();
		mechRobot.moveBackward(0, 180, 70);
		mechRobot.turnRight();
		mechRobot.moveForward(0, 180, 65);
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
		mechRobot.dispenseSmallUnitBalls(10);
		
		//locate fourth station
		mechRobot.moveBackward(0, 180, 35);
		mechRobot.turnRight();
		mechRobot.moveForward(0, 180, 60);
		mechRobot.turnLeft();
		mechRobot.moveForward(0, 180, 45);
		mechRobot.sleep(1500);
		mechRobot.stopMotors();
		mechRobot.dispenseSmallUnitBalls(10);


		//find bridge
		//mechRobot.findBridge(0, 150, 65);
		//mechRobot.turnLeft();
		mechRobot.moveForward(0, 200, 200);
		
		
		//swing claw to knock out ping pong balls into bucket
		//use if statements to choose between using dispenseEven or dispenseOdd functions
			
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
		envRobot.close(); //closing connection*/

	}
	
}	


