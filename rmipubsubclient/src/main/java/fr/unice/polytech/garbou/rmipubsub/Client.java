package fr.unice.polytech.garbou.rmipubsub;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.Scanner;

public class Client {
    PubSubServer server = null;
    String url = "rmi://localhost/PubSubServer";
    String urlClient = "rmi://localhost/PubSubClient";
    int portClient;

    public Client() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Which port : ");
        portClient =scanner.nextInt();
        try {
            LocateRegistry.createRegistry(portClient);
            Naming.rebind(urlClient, new PubSubClient());
            System.out.println("[INFO] Service is up on port " + portClient + " at " + url);
            server = (PubSubServer) Naming.lookup(url);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("[ERROR] Problem when launching the server");
        }
    }

    public void subscribe(){
        try {
            System.out.println(server);
            server.subscribe(urlClient, portClient);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void unsubscribe(){
        try {
            System.out.println(server);
            server.unsubscribe(urlClient, portClient);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
