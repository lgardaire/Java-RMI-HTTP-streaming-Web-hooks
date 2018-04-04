package fr.unice.polytech.garbou.rmipubsub;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nassim B on 4/4/18.
 */
public class PubSubServerImpl extends UnicastRemoteObject implements PubSubServer {
	List<ClientHook> clients = new ArrayList<>();

	protected PubSubServerImpl() throws RemoteException {
	}

	public void publish(String message) {

		for (ClientHook client : this.clients) {
			try {
				client.receive(message);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}
	}

	public boolean subscribe(ClientHook client) throws RemoteException {
		//System.out.println("ServerLog : A client joined : " + url + ":" + port);
			this.clients.add(client);
			this.publish("A client joined : " + client);
			return true;
	}

	public boolean unsubscribe(String url, int port) throws RemoteException {
		return false;
	}
}
