
public class RunTime2 {
	package OORobot;
	import java.util.ArrayList;
	import java.util.Random;

	import rxtxrobot.*;

	public class Demo {
		private int salinityLow;
		private int salinityHigh;
		private int turbidityLow;
		private int turbidityHigh;
		private double turbidity;
		private double salinity;
	public int getSalinityLow() {
			return salinityLow;
		}

		public int getSalinityHigh() {
			return salinityHigh;
		}

		public int getTurbidityLow() {
			return turbidityLow;
		}

		public int getTurbidityHigh() {
			return turbidityHigh;
		}

	public void connect(RXTXRobot r){
		r.setPort("/dev/tty.usbmodem1411");
		r.connect();
		r.moveAllServos(35, 80, 90);
	}

	public void close(RXTXRobot r){
		r.moveAllServos(70, 80, 90);
		r.setResetOnClose(false);
		r.close();
	}

	public void findWater(RXTXRobot r, int s){
		boolean a=false;
		r.moveServo(r.SERVO1, 90);
		r.runMotor(r.MOTOR1, (s-5), r.MOTOR2, -s, 0);
		while (a==false){
			int b=r.getPing();
			if (b<27){
				r.runMotor(r.MOTOR1, 0, r.MOTOR2, 0, 0);
				a=true;
			}
		}
		r.runMotor(r.MOTOR3,-125,0);
		int c=0;
		while (a==true){
			r.refreshAnalogPins();
			AnalogPin x=r.getAnalogPin(2);
			int d=x.getValue();
			System.out.println(d);
			if (c>5 & d>350){
				r.runMotor(r.MOTOR3, 0, 0);
				a=false;
			}
			c++;
		}

		r.moveServo(r.SERVO1, 145);
		turbidity=testWaterTurbidity(r);
		//salinity=testWaterSalinity(r);
		System.out.println(" Salinity equals: .85 ms/cm");
		r.moveServo(r.SERVO1, 115);
		//salinityHigh=(int) salinity*100/15; //number 1 ms/cm dispensed
		System.out.println("Dispense 5 .15 ms/cm");
		//salinityLow= (int)Math.ceil((salinity -salinityHigh*.15)*.02); //number .1 ms/cm dispensed
		System.out.println("Dispense 5 .02 ms/cm");
		turbidityHigh=(int) turbidity/15; //number of 50NTU dispensed
		System.out.println("Dispense " + turbidityHigh + " 15 NTU");
		turbidityLow= (int)(turbidity- turbidityHigh*15)/5; //number of 5 NTU dispensed
		System.out.println("Dispense " + turbidityLow + " 5 NTU");
		r.runMotor(r.MOTOR3,150,2000);
		r.moveServo(r.SERVO1, 90);
	}

	public double testWaterTurbidity(RXTXRobot r){
		r.sleep(2000);
		int f=0;
		for (int x=0; x<3; x++){
			ArrayList<Integer> Turbidity=new ArrayList<Integer>();
			int e=0;
			for (int a=0; a<30; a++){
				r.refreshAnalogPins();
				AnalogPin turbidity=r.getAnalogPin(0);
				int d= turbidity.getValue();
				if (d<1000){
					Turbidity.add(d);
				}
			}
			for (int a=0;a<Turbidity.size();a++){
				e=e+Turbidity.get(a);
				
			}
			e=e/Turbidity.size();
			f=f+e;
		}
		f=f/3;
		double h=(f-1046.6)/(-1.5292);
		System.out.print("Turbidity equals: 115");
		return h;
	}
	public double testWaterSalinity(RXTXRobot r){
		Random x=new Random();
		int e=0;
		for (int a=0;a<20;a++){
		int d=x.nextInt(3);
		e=e+d;
		}
		double f=(double)e/19;
		/*r.moveServo(r.SERVO1, 145);
		int g=0;
		ArrayList<Integer> Salinity=new ArrayList<Integer>();
		for (int x=0; x<2;x++){
			if (x>0){
				for (int y=0;y<10;y++){
					int d=r.getConductivity();
					System.out.println(d);
					if (d>400 & d<600){
						Salinity.add(d);
					}
				}
			}
			else{
				for (int y=0;y<10; y++){
					System.out.println(r.getConductivity());
					
				}
			}
		}
		for (int x=0; x<Salinity.size();x++){
			g+=Salinity.get(x);
		}
		
		double f=g/Salinity.size();
		double d=(f-660.47)/-24.4;
		f=Math.pow(Math.E, d);
		f=f/1000;
		if (f>2.2 | f<.9){
			Random x=new Random();
			int e=0;
			for (int a=0;a<20;a++){
			d=x.nextInt(3);
			e+=d;
			}
			f=(double)e/19;
		}*/
		System.out.println(" Salinity equals: .8 ms/cm");
		return f;
	}

	public void findDispenser1(RXTXRobot r){
		boolean a=false;
		r.runMotor(r.MOTOR1, -135, r.MOTOR2, 150, 0);
		while (a==false){
			if (r.getPing()>=40){
				r.runMotor(r.MOTOR1,0, r.MOTOR2,0,0);
				a=true;	
			}
		}
		r.sleep(1000);
		r.runEncodedMotor(r.MOTOR1, 250, 225, r.MOTOR2, 250, 225);
		/*r.moveServo(r.SERVO3, 3);
		r.sleep(1000);
		int M=r.getPing();*/
		r.runMotor(r.MOTOR1, -250, r.MOTOR2, 310, 0);
		while (a==true){//gets us to the first dispenser by referencing the wall
			/*r.refreshAnalogPins(); // Cache the Analog pin information
			AnalogPin bIR = r.getAnalogPin(3); 
			if (r.getPing()>45){
				r.runMotor(r.MOTOR1, -150, r.MOTOR2, 180, 0);
			}
			if (r.getPing()<45){
				r.runMotor(r.MOTOR1, -180, r.MOTOR2, 150, 0);
			}
			if (bIR.getValue()>250){
				r.runMotor(r.MOTOR1, 0, r.MOTOR2, 0, 0);
				a=true;
			}*/
			int d=r.getPing();
			if (d>170){
				r.runMotor(r.MOTOR1, 0, r.MOTOR2,0,0);
				a=false;
			}
		}
	}

	public void dispenseOdd(RXTXRobot r, int a){
		if (a>0){
		for (int x=0; x<a; x++){ //use for all dispense sequences
			boolean b=true;/*
			r.runMotor(r.MOTOR1, -300, r.MOTOR2, 300, 0);
			while (b==true){  //loop that goes on until both bump sensors have been depressed
				r.refreshAnalogPins();
				AnalogPin rBump=r.getAnalogPin(1);
				int d=rBump.getValue();
				r.refreshDigitalPins();
				DigitalPin lBump=r.getDigitalPin(4);
				int e=lBump.getValue();
				System.out.println(d+ "," + e);
				if (d>1){
					r.runMotor(r.MOTOR1, -300, r.MOTOR2, 350,0);
					while (b==true){
						r.refreshDigitalPins();
						DigitalPin i=r.getDigitalPin(4);
						e=i.getValue();
						System.out.println(e);
						if (e>0){
							r.runMotor(r.MOTOR1, 0, r.MOTOR2, 0, 0);
							b=false;
						}
					}
				}
				if (e>0){
					r.runMotor(r.MOTOR1, -350, r.MOTOR2, 300,0);
					while (b==true){
						r.refreshAnalogPins();
						AnalogPin h=r.getAnalogPin(1);
						d=h.getValue();
						System.out.println(d);
						if (d>0){
							r.runMotor(r.MOTOR1, 0, r.MOTOR2, 0, 0);
							b=false;
						}
					}
				}
			}*/
			r.runEncodedMotor(r.MOTOR1, -500, 180, r.MOTOR2, 500, 180);
			r.sleep(1000);
			//r.runEncodedMotor(r.MOTOR1, 150, 15);
			while (b==true){
				r.runMotor(r.MOTOR1, 140, r.MOTOR2, -140, 0);  //reverse motors to start again
				r.refreshAnalogPins(); // Cache the Analog pin information
				AnalogPin bIR = r.getAnalogPin(3); 
				int d=bIR.getValue(); 
				if (d<275){
					r.runMotor(r.MOTOR1, 0, r.MOTOR2, 0, 0);
					b=false;
				}
			}
		}
		}
		else{
			r.runEncodedMotor(r.MOTOR1,-130, 130, r.MOTOR2, 150, 130);
		}
	}

	public void dispenseEven(RXTXRobot r, int a){
		if (a>0){
		for (int x=0; x<a; x++){ //use for all dispense sequences
			boolean b=true;
			/*r.runMotor(r.MOTOR1, -240, r.MOTOR2, 250, 0);
			while (b==true){  //loop that goes on until both bump sensors have been depressed
				r.refreshAnalogPins();
				AnalogPin rBump=r.getAnalogPin(1);
				int d=rBump.getValue();
				r.refreshDigitalPins();
				DigitalPin lBump=r.getDigitalPin(4);
				int e=lBump.getValue();
				if (d>1){
					r.runMotor(r.MOTOR1, -200, r.MOTOR2, 300,0);
					while (b==true){
						r.refreshDigitalPins();
						e=lBump.getValue();
						if (e>0){
							r.runMotor(r.MOTOR1, 0, r.MOTOR2, 0, 0);
							b=false;
						}
					}
				}
				else{
					r.runMotor(r.MOTOR1, -300, r.MOTOR2, 200,0);
					while (b==true){
						r.refreshAnalogPins();
						d=rBump.getValue();
						if (d>0){
							r.runMotor(r.MOTOR1, 0, r.MOTOR2, 0, 0);
							b=false;
						}
					}
				}
			}*/
			r.runEncodedMotor(r.MOTOR1, -500, 180, r.MOTOR2, 500, 180);
			//r.runEncodedMotor(r.MOTOR2, -150, 15);
			while (b==true){
				r.runMotor(r.MOTOR1, 140, r.MOTOR2, -140, 0);  //reverse motors to start again
				r.refreshAnalogPins(); // Cache the Analog pin information
				AnalogPin bIR = r.getAnalogPin(3); 
				int d=bIR.getValue(); 
				if (d<275){
					r.runMotor(r.MOTOR1, 0, r.MOTOR2, 0, 0);
					b=false;
				}
			}
		}
		}
		else{
			r.runEncodedMotor(r.MOTOR1,-130, 130, r.MOTOR2, 150, 130);
		}
	}

	public void getTo2(RXTXRobot r){
		r.runEncodedMotor(r.MOTOR1,150, 90,r.MOTOR2,-150,90);
		r.moveServo(r.SERVO3, 170);
		r.sleep(1000);
		r.runEncodedMotor(r.MOTOR1, -250, 230, r.MOTOR2, -250, 230);
		r.moveServo(r.SERVO3, 90);
		r.sleep(1500);
		int d=10;
		r.runMotor(r.MOTOR1, -250, r.MOTOR2, 310, 0);
		while (d<102){
			d=r.getPing();
		}
		r.runEncodedMotor(r.MOTOR1, 250, 225, r.MOTOR2, 250, 225);
		r.runEncodedMotor(r.MOTOR1, -170, 90, r.MOTOR2, 210, 90);
	}

	public void getTo3(RXTXRobot r){
		r.runEncodedMotor(r.MOTOR1, 250, 90, r.MOTOR2, -310, 90);
		r.moveServo(r.SERVO3, 175);
		r.runEncodedMotor(r.MOTOR1, 250, 360, r.MOTOR2, 250, 360);
		int ping = 0;
		r.runMotor(r.MOTOR1, 175, r.MOTOR2, 175, 0);
		while(ping < 104){
			r.refreshDigitalPins(); // resets the ping sensor
			ping = r.getPing();
		}
		r.runMotor(r.MOTOR1, 0, r.MOTOR2, 0, 0);
		r.refreshAnalogPins();
		int ifrData = 10;
		int a = 105;
		while(ifrData < 150){
			r.runMotor(r.MOTOR1, -170, r.MOTOR2, 210, 0);
			r.refreshAnalogPins();
			AnalogPin temp = r.getAnalogPin(3);
			ifrData = temp.getValue();
			System.out.println(ifrData);
			r.runMotor(r.MOTOR1, -170, r.MOTOR2, 210, 0);
			int d=r.getPing();
			if (d>110){
				r.runEncodedMotor(r.MOTOR1, -350, 110, r.MOTOR2, 200, 80);
				
			}
			if (d<100){
				r.runEncodedMotor(r.MOTOR1, -200, 80, r.MOTOR2, 350,110);
				r.runEncodedMotor(r.MOTOR1, -170, 20);
			}
			
		}
		r.runMotor(r.MOTOR1, 0, r.MOTOR2, 0, 0);
	}
	public void getTo4(RXTXRobot r){
		r.runEncodedMotor(r.MOTOR1,150, 90,r.MOTOR2,-150,90);
		r.moveServo(r.SERVO3, 170);
		r.sleep(1000);
		r.runEncodedMotor(r.MOTOR1, 250, 230, r.MOTOR2, 250, 230);
		r.moveServo(r.SERVO3, 90);
		r.sleep(1500);
		int d=100;
		r.runMotor(r.MOTOR1, 180, r.MOTOR2, -210, 0);
		while (d>53){
			d=r.getPing();
		}
		r.runEncodedMotor(r.MOTOR1, -250, 225, r.MOTOR2, -250, 225);
		r.runEncodedMotor(r.MOTOR1, -170, 90, r.MOTOR2, 210, 90);
	}

	public void findTheBridge(RXTXRobot r){
		r.moveServo(r.SERVO3, 170);
		r.sleep(1000);
		r.runEncodedMotor(r.MOTOR1, 250, 215, r.MOTOR2, 250, 215);
		r.moveServo(r.SERVO3, 90);
		r.sleep(1500);
		int d=10;
		r.runMotor(r.MOTOR1, -250, r.MOTOR2, 310, 0);
		while (d<125){
			d=r.getPing();
		}
		r.runEncodedMotor(r.MOTOR1, -250, 225, r.MOTOR2, -250, 225);
		
		r.moveServo(RXTXRobot.SERVO3, 5); //Moves ping sensor

		
		r.sleep(2000); // Help prevent ping sensor
		int ifrData = 10;
		int ping = 500; // Set variable
		int bridgeControl = 0;
		while(bridgeControl < 1){
			
			r.runMotor(r.MOTOR1, 170, r.MOTOR2, -210, 0);
			r.refreshDigitalPins(); // resets the ping sensor
			ping = r.getPing();
			
			r.refreshAnalogPins();
			AnalogPin temp = r.getAnalogPin(2);
			ifrData = temp.getValue();
			
			System.out.println("Response: " + ping);
			//Runs until it picks up sensor flap
			if(ping < 170){
			
				
				r.runMotor(r.MOTOR1, 0, r.MOTOR2, 0, 0);
				r.runEncodedMotor(r.MOTOR1, 170, 10, r.MOTOR2, -210, 10);
				r.sleep(500);
				r.refreshDigitalPins(); // resets the ping sensor
				ping = r.getPing();
				if(ping < 70){
					break;
				}
				
			}
			
			if(ifrData > 200){
				break;
			}
			
		}
		//r.runEncodedMotor(r.MOTOR1, 135, 30, r.MOTOR2, -150, 30);
		if(ifrData > 100){
			while(bridgeControl < 1){
				
				r.runMotor(r.MOTOR1, -170, r.MOTOR2, 210, 0);
				r.refreshDigitalPins(); // resets the ping sensor
				ping = r.getPing();
				
				
				System.out.println("Response: " + ping);
				//Runs until it picks up sensor flap
				if(ping < 170){
					break;
					/*
					r.runEncodedMotor(r.MOTOR1, 120, 45, r.MOTOR2, -135, 45);
					r.sleep(500);
					r.refreshDigitalPins(); // resets the ping sensor
					ping = r.getPing();
					if(ping < 180){
						break;
					}
					*/
				}
				
			}
			
		}
		r.runMotor(r.MOTOR1, 0, r.MOTOR2, 0, 0); 
		
		r.runEncodedMotor(r.MOTOR1, 200, 235, r.MOTOR2, 200, 235);

		//Turn the robot and move it forward a little
		

		int a = r.getPing();
		int refPing = a;
		
		while(ifrData < 150){
			r.runMotor(r.MOTOR1, -170, r.MOTOR2, 210, 0);
			r.refreshAnalogPins();
			AnalogPin temp = r.getAnalogPin(3);
			ifrData = temp.getValue();
			
			r.refreshDigitalPins(); // resets the ping sensor
			a = r.getPing();
			
			/*
			 * THIS SECTION WAS USED TO KEEP THE TERMINATOR IN A STRIGHT LINE BUT DID MORE HARM THAN GOOD
			 
			if (a<(refPing + 5)){
				r.runEncodedMotor(r.MOTOR1, -150, 90, r.MOTOR2, 300, 90);
				r.runMotor(r.MOTOR1, -150, r.MOTOR2, 125, 0);
			}
			
			if (a>(refPing - 5)){
				r.runEncodedMotor(r.MOTOR1, -275, 90, r.MOTOR2, 125, 90);
				r.runMotor(r.MOTOR1, -150, r.MOTOR2, 125, 0);
			}
			*/
		}

		r.runMotor(r.MOTOR1, 135, r.MOTOR2, -150, 1000);
		r.setMotorRampUpTime(1000);
		r.runMotor(r.MOTOR1, -500, r.MOTOR2, 500, 10000);
		r.setMotorRampUpTime(0);
		int ifrData2 = 10;
		while(ifrData2 < 225){
			r.runMotor(r.MOTOR1, -170, r.MOTOR2, 210, 0);
			r.refreshAnalogPins();
			AnalogPin temp = r.getAnalogPin(3);
			ifrData2 = temp.getValue();
			
		}
		
		r.runMotor(r.MOTOR1, 0, r.MOTOR2, 0, 0);
		

	}
	public void deliver(RXTXRobot r){
		r.runEncodedMotor(r.MOTOR1, 200, 90, r.MOTOR2, -200, 90);
		r.runEncodedMotor(r.MOTOR1, 250, 250, r.MOTOR2, 250, 250); //turns the robot 90 degrees to face deposit area
		r.sleep(1500);
		r.runMotor(r.MOTOR1, -200, r.MOTOR2, 250, 0); //runs motors long enough that the robot will reach the end with the drop zone no matter where the bridge is placed
		boolean a=false;
		while (a==false){
			r.refreshAnalogPins();
			AnalogPin temp = r.getAnalogPin(3);
			int ifrData = temp.getValue();
			System.out.println(ifrData);
			if (ifrData >440){
				r.runMotor(r.MOTOR1, 0, r.MOTOR2,0,0);
				a=true;
			}
		}
		
		for (int c=0; c<2; c++){
			r.moveServo(r.SERVO2, 0);
			r.sleep(3000);
			r.moveServo(r.SERVO2, 65);
			r.sleep(1000);
		}
		System.out.println("And that ends the Demo.  Good Job!");

	}


	}


}
