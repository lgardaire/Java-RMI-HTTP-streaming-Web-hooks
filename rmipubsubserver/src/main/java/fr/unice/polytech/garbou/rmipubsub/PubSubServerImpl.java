package fr.unice.polytech.garbou.rmipubsub;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.Vector;

/**
 * Created by Nassim B on 4/4/18.
 */
public class PubSubServerImpl extends UnicastRemoteObject implements PubSubServer {
    List<ClientHook> clients = new Vector<>();

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
        this.clients.add(client);
        this.publish("A client joined : " + client);
        return true;
    }

    public boolean unsubscribe(ClientHook client) throws RemoteException {
        return this.clients.remove(client);
    }
}
