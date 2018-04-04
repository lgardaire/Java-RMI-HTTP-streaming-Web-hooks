package fr.unice.polytech.garbou.rmipubsubserver;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by Nassim B on 4/4/18.
 */
public interface PubSubServer extends Remote {

	boolean  Subscribe() throws RemoteException;
}
