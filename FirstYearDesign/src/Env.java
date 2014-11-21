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
			r.setVerbose(true);
			r.setPort("/dev/tty.wch ch341 USB=>RS232 640"); 

			r.connect(); 
		}

		public double checkTurbidity(){
	
			double y = 0.0;
			r.refreshAnalogPins(); // Cache the Analog pin information
			int temp = r.getAnalogPin(3).getValue(); 
			r.sleep(100); 
			y = -0.6612 * temp + 640.94;
			System.out.println("Turbidity sensor has value: " + y);  //prints voltage
			return y;
		}
	
		public double checkSalinity(){
			double x = r.getConductivity();
			double y = 0.9352*x + 79.848;
			double z = (4.826/(y*8.82))*1000000;
			double w = 2.0534*z -1545.8;
			System.out.println("Salinity sensor has value: " + w);  //prints voltage
			r.refreshAnalogPins();
			return w;
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
