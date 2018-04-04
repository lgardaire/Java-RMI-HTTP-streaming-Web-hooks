package fr.unice.polytech.garbou.rmipubsubserver;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

/**
 * Created by Nassim B on 4/4/18.
 */
public class Launcher {
	public static void main(String[] args) {
		try {
			LocateRegistry.createRegistry(1099);
			String url = "rmi://localhost/PubSubServer";
			Naming.rebind(url, new PubSubServerImpl());
			System.out.println("[INFO] Service is up on port 1099 at " + url);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Problem...");
		}
	}
}
