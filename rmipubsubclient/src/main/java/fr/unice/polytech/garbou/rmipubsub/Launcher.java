package fr.unice.polytech.garbou.rmipubsub;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;


/**
 * Created by Nassim B on 4/4/18.
 */
public class Launcher {

	public static void main(String[] args) {
    	PubSubServer server = null;
		String url = "rmi://localhost/PubSubServer";

		try {
			server = (PubSubServer) Naming.lookup(url);
			System.out.println("Webhook server : " + server);
			ClientHook client = new Client();
			server.subscribe(client);
		} catch (NotBoundException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
}
