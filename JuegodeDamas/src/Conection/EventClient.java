package Conection;

import java.net.URI;
import java.util.Scanner;

import javax.websocket.ContainerProvider;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;


public class EventClient
{
    public static void main(String[] args)
    {
    	//cambiar a dirección donde se ca a conectar (servidor)
        URI uri = URI.create("ws://192.168.0.200:8080");

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
                while(true) {
                	Scanner teclado = new Scanner(System.in);
                    texto=teclado.nextLine();
                    session.getBasicRemote().sendText(texto);
                    System.out.println("holi "+session.getRequestURI().toString());
                }
                
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
    
}