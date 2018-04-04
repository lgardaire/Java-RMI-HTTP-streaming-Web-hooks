package fr.unice.polytech.garbou.rmipubsub;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.util.Scanner;

/**
 * Created by Nassim B on 4/4/18.
 */
public class Launcher {
	public static String sendMessage() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}

	public static void main(String[] args) {
		try {
			PubSubServerImpl server = new PubSubServerImpl();
			LocateRegistry.createRegistry(1099);
			String url = "rmi://localhost/PubSubServer";
			Naming.rebind(url, server);
			System.out.println("[INFO] Service is up on port 1099 at " + url);
			while (true) {
				System.out.print("message >");
				server.publish(Launcher.sendMessage());
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Problem...");
		}


	}
}
