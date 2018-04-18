package fr.unice.polytech.garbou.rmipubsub;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Client extends UnicastRemoteObject implements ClientHook {

    public Client() throws RemoteException {
        super();
    }

    public boolean receive(String message) throws RemoteException {
        System.out.println(message);
        return true;
    }
}
