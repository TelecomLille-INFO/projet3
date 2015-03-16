package jeux;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;


public class Client {

	public static Socket socket = null;
	public static Thread t1;
	

	Client(String ip, int port) {	
		
	try {
		
		System.out.println("Demande de connexion");
		socket = new Socket(InetAddress.getByName(ip), port);
		System.out.println("Connexion établie avec le serveur, authentification :"); // Si le message s'affiche c'est que je suis connecté

		
		t1 = new Thread(new Connexion(socket));
		t1.start();
		
	} catch (UnknownHostException e) {
<<<<<<< HEAD
	  System.err.println("Impossible de se connecter a l'adresse " + ip);
	} catch (IOException e) {
	  System.err.println("Aucun serveur a l'ecoute du port " + port);
	}
	
	

	}

}
