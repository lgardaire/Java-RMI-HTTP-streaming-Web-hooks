package fr.unice.polytech.garbou.rmipubsub;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

/**
 * Created by Nassim B on 4/4/18.
 */
public class PubSubClient extends UnicastRemoteObject implements ClientHook {
	protected PubSubClient() throws RemoteException {
	}

	public static void main(String[] args) {
		PubSubServer server = null;
		String url = "rmi://localhost/PubSubServer";
		String urlClient = "rmi://localhost/PubSubClient";
		int portClient;
		Scanner scanner = new Scanner(System.in);
		System.out.print("Which port : ");
		portClient = scanner.nextInt();

		try {
			LocateRegistry.createRegistry(portClient);
			Naming.rebind(urlClient, new PubSubClient());
			System.out.println("[INFO] Service is up on port " + portClient + " at " + url);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Problem...");
		}

		try {
			server = (PubSubServer) Naming.lookup(url);
			System.out.println(server);
			server.subscribe(urlClient, portClient);
		} catch (NotBoundException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	public boolean receive(String message) throws RemoteException {
		System.out.println(message);
		return false;
	}
}
