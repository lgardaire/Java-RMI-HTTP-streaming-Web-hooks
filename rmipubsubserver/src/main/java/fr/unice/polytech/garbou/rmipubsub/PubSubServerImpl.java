package fr.unice.polytech.garbou.rmipubsub;

import java.rmi.RemoteException;
import java.rmi.server.RemoteServer;
import java.rmi.server.ServerNotActiveException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by Nassim B on 4/4/18.
 */
public class PubSubServerImpl extends UnicastRemoteObject implements PubSubServer {

	protected PubSubServerImpl() throws RemoteException {
	}

	public boolean subscribe() throws RemoteException {
		try {
			String ref = getClientHost();
			System.out.println("A client referenced : " + ref + "joined with " + this);
		} catch (ServerNotActiveException e) {
			e.printStackTrace();
		}
		return false;
	}
}
