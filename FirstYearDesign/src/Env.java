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
			r.setPort("/dev/tty.wch ch341 USB=>RS232 1410"); 
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
}
