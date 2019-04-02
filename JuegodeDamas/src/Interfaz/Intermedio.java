package Interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.websocket.ContainerProvider;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;

import Codigo.Juego;
import Conection.EventClient;
import Conection.EventSocket;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.net.URI;
import java.util.Scanner;
import java.awt.event.ActionEvent;

public class Intermedio extends JFrame {

	private JPanel contentPane;
	

	
	/**
	 * Create the frame.
	 * @param juego 
	 */
	public Intermedio(Juego juego) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JButton btnEstablecerConexion = new JButton("Establecer Conexion");
		btnEstablecerConexion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//cambiar a dirección donde se ca a conectar (servidor)
		        URI uri = URI.create("ws://localhost:8080");
               
		        try
		        {
		            WebSocketContainer container = ContainerProvider.getWebSocketContainer();

		            try
		            {
		                // Attempt Connect
		                Session session = container.connectToServer(EventSocket.class,uri);
		                // Send a message
		                session.getBasicRemote().sendText("Hello");
		                // Close session
		                //session.close();
		                String texto;
		                
		                
		            }
		            finally
		            {
		            }
		        }
		        catch (Throwable t)
		        {
		            t.printStackTrace(System.err);
		        }
				
				
			}
		});
		contentPane.add(btnEstablecerConexion, BorderLayout.CENTER);
	}

}
