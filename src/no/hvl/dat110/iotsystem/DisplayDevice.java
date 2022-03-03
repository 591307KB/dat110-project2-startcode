package no.hvl.dat110.iotsystem;

import no.hvl.dat110.client.Client;
import no.hvl.dat110.messages.Message;
import no.hvl.dat110.messages.PublishMsg;

public class DisplayDevice {
	
	private static final int COUNT = 10;
		
	public static void main (String[] args) {
		
		System.out.println("Display starting ...");
		
		Client cli = new Client("display",Common.BROKERHOST,Common.BROKERPORT);
		
		cli.connect();
		
		cli.createTopic(Common.TEMPTOPIC);
		cli.subscribe(Common.TEMPTOPIC);
		
		for(int i = 0;i<COUNT;i++) {
			PublishMsg m =(PublishMsg) cli.receive();
			System.out.println("DISPLAY: "+m.getMessage());
		}
		
		cli.unsubscribe(Common.TEMPTOPIC);
		cli.disconnect();
				
		// create a client object and use it to
		
		// - connect to the broker - use "display" as the username
		// - create the temperature topic on the broker
		// - subscribe to the topic
		// - receive messages on the topic
		// - unsubscribe from the topic
		// - disconnect from the broker
		
		
		System.out.println("Display stopping ... ");
		
		
	}
}
