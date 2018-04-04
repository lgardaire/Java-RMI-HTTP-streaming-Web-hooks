package fr.unice.polytech.garbou.rmipubsub;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by Nassim B on 4/4/18.
 */
public interface ClientHook extends Remote {
	boolean receive(String message) throws RemoteException;
}
