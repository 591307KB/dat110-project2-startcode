package no.hvl.dat110.iotsystem;

import no.hvl.dat110.client.Client;

public class TemperatureDevice {

	private static final int COUNT = 10;

	public static void main(String[] args) {

		// simulated / virtual temperature sensor
		TemperatureSensor sn = new TemperatureSensor();

		Client cli = new Client("sensor",Common.BROKERHOST,Common.BROKERPORT);
		
		cli.connect();
		
		for(int i=0;i<COUNT;i++) {
			String temp=""+sn.read();
			System.out.println("READING: "+temp);
			cli.publish(Common.TEMPTOPIC, ""+temp);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
		}
		
		cli.disconnect();
		
		// create a client object and use it to

		// - connect to the broker - user "sensor" as the user name
		// - publish the temperature(s)
		// - disconnect from the broker


		System.out.println("Temperature device stopping ... ");

	}
}
