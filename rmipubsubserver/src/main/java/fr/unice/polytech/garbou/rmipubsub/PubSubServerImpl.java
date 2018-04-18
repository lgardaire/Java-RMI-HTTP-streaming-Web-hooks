package fr.unice.polytech.garbou.rmipubsub;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Semaphore;

/**
 * Created by Nassim B on 4/4/18.
 */
public class PubSubServerImpl extends UnicastRemoteObject implements PubSubServer {
    List<ClientHook> clients = new Vector<>();

    protected PubSubServerImpl() throws RemoteException {
    }

    public void publish(String message) {

        Iterator clientIT = this.clients.iterator();

        while (clientIT.hasNext()) {
            ClientHook client = (ClientHook) clientIT.next();
            try {
                client.receive(message);
            } catch (RemoteException e) {
                System.err.println("A client can't be joined, he'll be removed from client list");
                clientIT.remove();
            }
        }
    }

    public boolean subscribe(ClientHook client) throws RemoteException {
        this.clients.add(client);
        System.out.println("A new client joined");
        return true;
    }

    public boolean unsubscribe(ClientHook client) throws RemoteException {
        return this.clients.remove(client);
    }

    public int howManyClients() {
        return this.clients.size();
    }
}
