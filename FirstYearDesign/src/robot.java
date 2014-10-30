import javax.xml.bind.ValidationEvent;

import rxtxrobot.AnalogPin;
import rxtxrobot.ArduinoNano;
import rxtxrobot.RXTXRobot;

public class robot {
	RXTXRobot r;
	final private static int PING_PIN = 12; 
	
	public robot(){
		r = new ArduinoNano(); // Create RXTXRobot object 
		r.setPort("/dev/tty.wch ch341 USB=>RS232 1410"); 
		r.connect(); 
	}
	
	
	
	
	public void close(){
		r.close(); 
	}
	
	
	
	
	
}
