package fr.unice.polytech.garbou.rmipubsub;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by Nassim B on 4/4/18.
 */
public class PubSubClient extends UnicastRemoteObject implements ClientHook {
    protected PubSubClient() throws RemoteException {
    }

    public static void main(String[] args) {
        Client client = new Client();
        client.subscribe();
    }

    public boolean receive(String message) throws RemoteException {
        System.out.println(message);
        return false;
    }
}
