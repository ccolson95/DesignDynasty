import rxtxrobot.*;

public class GetPing {
	
	final private static int PING_PIN = 10; 
	//final private static int PING_PIN2 = 11; 


	public static void main(String[] args) 
	{ 
		RXTXRobot r = new ArduinoNano(); // Create RXTXRobot object 
		r.setPort("/dev/tty.wch ch341 USB=>RS232 1410"); // Set the port to COM3 
		r.connect(); 
		while (r.getPing(PING_PIN) < 200)
		{ 
			System.out.println("Response: " + r.getPing(PING_PIN) + " cm"); 
			r.sleep(300); 
		} 
		r.close(); 
	} 
	
}
