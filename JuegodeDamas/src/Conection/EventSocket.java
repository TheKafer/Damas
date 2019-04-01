package Conection;

import javax.websocket.ClientEndpoint;
import javax.websocket.CloseReason;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;

import Interfaz.JuegoOnline;



@ClientEndpoint
public class EventSocket
{
	
	public JuegoOnline getJuego() {
		return juego;
	}

	public void setJuego(JuegoOnline juego) {
		this.juego = juego;
	}

	private JuegoOnline juego;
	private Session sesion;
	
    @OnOpen
    public void onWebSocketConnect(Session sess)
    {
    	sesion=sess;
        System.out.println("Socket Connected: " + sess.hashCode());
    }
    
    @OnMessage
    public void onWebSocketText(String message)
    {
    	if(message.compareTo("fid;1")==0) {
    		juego=new JuegoOnline(0,sesion);
    		juego.getV().setVisible(true);
    		System.out.println(message);
    	}else if(message.compareTo("fid;0")==0){
    		juego=new JuegoOnline(1,sesion);
    		System.out.println(message);
    		juego.getV().setVisible(true);
    	}
    	//System.out.println("Received message: " + message);
    	if(message.compareTo("fid;1")==0 || message.compareTo("fid;0")==0) {
    		
    	}else {
    		String[] mov = message.split(";");
    		if(mov[0].compareTo("mov")==0) {
    			if(mov[5].compareTo("0")==0) {
    				juego.recibirMensaje(Integer.parseInt(mov[3]), Integer.parseInt(mov[4]), Integer.parseInt(mov[1]), Integer.parseInt(mov[2]), 1);
    			}else {
    				juego.recibirMensaje(Integer.parseInt(mov[3]), Integer.parseInt(mov[4]), Integer.parseInt(mov[1]), Integer.parseInt(mov[2]), 0);
    			}
    		}
    	}
    	
    	
        
    }
    
    @OnClose
    public void onWebSocketClose(CloseReason reason)
    {
        System.out.println("Socket Closed: " + reason);
    }
    
    @OnError
    public void onWebSocketError(Throwable cause)
    {
        cause.printStackTrace(System.err);
    }
}