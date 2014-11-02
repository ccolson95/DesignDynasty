//import javax.xml.bind.ValidationEvent;

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
			
			
		}
		
		
		public void checkSalinity(){
			
			
		}
		
		public void determineMaterials(){
			
			
		}
		
		public void close(){
			r.close(); 
		}
}
