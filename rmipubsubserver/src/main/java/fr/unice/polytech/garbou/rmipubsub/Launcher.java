package fr.unice.polytech.garbou.rmipubsub;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Nassim B on 4/4/18.
 */
public class Launcher {
    public static String sendMessage() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static void main(String[] args) {
        try {
            PubSubServerImpl server = new PubSubServerImpl();
            LocateRegistry.createRegistry(1099);
            String url = "rmi://localhost/PubSubServer";
            Naming.rebind(url, server);
            System.out.println("[INFO] Service is up on port 1099 at " + url);
			Timer timer = new Timer();

			timer.schedule(new SendTime(server), 0, 5000);
            while (true) {
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("[ERROR] Problem when launching the server");
        }


    }
}
class SendTime extends TimerTask {
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	PubSubServerImpl server;
	int messageCounter = 0;
	public SendTime (PubSubServerImpl serv) {
		this.server = serv;
	}
	public void run() {
		messageCounter++;
		String time = LocalDateTime.now().format(formatter);
		String message = "Message n°" + messageCounter + " " + time + " to " + this.server.howManyClients() + " clients";
		this.server.publish(message);
		System.out.println("Server ## Message sended : " + message);
	}
}