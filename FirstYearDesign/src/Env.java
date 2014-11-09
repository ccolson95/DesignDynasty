import javax.xml.bind.ValidationEvent;

import java.util.ArrayList;
import java.util.Random;

import rxtxrobot.RXTXRobot;
import rxtxrobot.AnalogPin;
import rxtxrobot.ArduinoNano;

public class Env {

		RXTXRobot r;
		final private static int PING_PIN = 12; 
		
		public Env(){
			r = new ArduinoNano(); // Create RXTXRobot object 
			r.setPort("/dev/tty.wch ch341 USB=>RS232 1450"); 

			r.connect(); 
		}

		public void checkTurbidity(){
	
			for (int x=0; x <= 10 ; ++x) 
			{ 
				AnalogPin temp = r.getAnalogPin(1); 
				r.sleep(100);
				r.refreshAnalogPins(); // Cache the Analog pin information 
				System.out.println("Sensor " + x + " has value: " + temp.getValue());  //prints voltage
			} 
			double turbidityPingPongBalls = determineTurbidityMaterials(); //gets the value to determine how many ping pong balls we need
		}
	
		public void checkSalinity(){
			
			for (int x=0; x <= 10 ; ++x) 
			{ 
				AnalogPin temp = r.getAnalogPin(1); 
				r.sleep(100);
				r.refreshAnalogPins(); // Cache the Analog pin information 
				System.out.println("Sensor " + x + " has value: " + temp.getValue());  //prints voltage
			}
			double salinityPingPongBalls = determineSalinityMaterials(); //gets the value to determine how many ping pong balls we need
		}
		
		public double determineTurbidityMaterials(){ //conver
			return 0; //this will return the turbidity value
		}
		
		public double determineSalinityMaterials(){
			return 0; //this will return the salinity value
		}
		
		public void close(){
			r.close(); 
		}
		
		// gets code difference in order to find conductivity
		public int getConductivity(){
			return r.getConductivity();	
		}
		
		public double testWaterTurbidity(){ //this should work for us
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

			return h;
		}
		
}
