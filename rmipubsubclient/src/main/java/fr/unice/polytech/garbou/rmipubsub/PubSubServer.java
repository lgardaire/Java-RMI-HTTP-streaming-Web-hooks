package fr.unice.polytech.garbou.rmipubsub;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by Nassim B on 4/4/18.
 */
public interface PubSubServer extends Remote {
    boolean subscribe(String url, int port) throws RemoteException;

    boolean unsubscribe(String url, int port) throws RemoteException;
}
