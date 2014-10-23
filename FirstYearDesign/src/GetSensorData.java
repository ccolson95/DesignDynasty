import rxtxrobot.*;

public class GetSensorData {

	 public static void main(String[] args) 
	    {     
		    // All sensor data will be read from the analog pins 
			 
		    RXTXRobot r = new ArduinoNano(); //Create RXTXRobot object 
	 
			r.setPort("/dev/tty.wch ch341 USB=>RS232 1410"); // Sets the port to COM5 
			 
			r.connect(); 
	 
	 
			for (int x=0; x <= 50 ; ++x) 
			{ 
				AnalogPin temp = r.getAnalogPin(1); 
				r.sleep(100);
				r.refreshAnalogPins(); // Cache the Analog pin information 
				System.out.println("Sensor " + x + " has value: " + temp.getValue()); 
			} 
			r.close(); 
	    } 
	 
}
