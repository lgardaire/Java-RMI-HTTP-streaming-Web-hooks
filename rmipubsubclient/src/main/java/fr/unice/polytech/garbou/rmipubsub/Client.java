package fr.unice.polytech.garbou.rmipubsub;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

public class Client extends UnicastRemoteObject implements ClientHook {

    public Client() throws RemoteException {
        super();
    }

    public boolean receive(String message) throws RemoteException {
        System.out.println(message);
        return true;
    }
}
