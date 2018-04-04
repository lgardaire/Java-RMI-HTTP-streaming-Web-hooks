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

		try {
			ClientHook client = new PubSubClient();
			server = (PubSubServer) Naming.lookup(url);
			System.out.println("Webhook server : " + server);
			server.subscribe(client);
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
