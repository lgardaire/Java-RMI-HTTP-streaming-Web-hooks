package fr.unice.polytech.garbou.rmipubsubserver;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by Nassim B on 4/4/18.
 */
public class PubSubServerImpl extends UnicastRemoteObject implements PubSubServer {

	protected PubSubServerImpl() throws RemoteException {
	}

	public boolean subscribe() throws RemoteException {
		System.out.println("A client joined");
		return false;
	}
}
