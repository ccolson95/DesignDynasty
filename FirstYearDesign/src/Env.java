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

		public double checkTurbidity(){
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
		
		
		public void checkSalinity(){
			
			
		}
		
		public void determineMaterials(){
			
			
		}
		
		public void close(){
			r.close(); 
		}
}
