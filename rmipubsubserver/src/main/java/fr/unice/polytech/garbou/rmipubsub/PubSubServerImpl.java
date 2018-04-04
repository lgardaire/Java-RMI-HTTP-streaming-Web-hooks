package fr.unice.polytech.garbou.rmipubsub;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.RemoteServer;
import java.rmi.server.ServerNotActiveException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Set;

/**
 * Created by Nassim B on 4/4/18.
 */
public class PubSubServerImpl extends UnicastRemoteObject implements PubSubServer {
	HashMap<String, ClientHook> clients = new HashMap<String, ClientHook>();

	protected PubSubServerImpl() throws RemoteException {
	}

	private void publish() {
		for (String set: this.clients.keySet()) {
			try {
				this.clients.get(set).receive();
			} catch (RemoteException e) {
				e.printStackTrace();
			}

		}
	}

	public boolean subscribe(String url, int port) throws RemoteException {
		System.out.println("A client joined : " + url);
		ClientHook client = null;

		try {
			client = (ClientHook) Naming.lookup(url);
			this.clients.put(url, client);
			this.publish();
			return true;
		} catch (NotBoundException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean unsubscribe(String url, int port) throws RemoteException {
		return false;
	}
}
