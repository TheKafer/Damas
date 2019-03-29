package Codigo;

import java.io.*;
import java.net.Socket;

public class Conexion extends Thread{

    private String nombreDelServidor;
    private int puertoDelServidor;
    private String sesion;
    private String cuarto;
    private Socket socket;
    Estado estado;
    private InputStream in;
    private OutputStream out;
    private BufferedReader bf;

    public enum Estado {
        PENDIENTE,
        ACTIVO,
        INACTIVO
    };

    @Override
    public void run() {
        Conexion s = new Conexion();
        if(s.iniciarSesion()) {
            try {
                System.out.println("llego");
                s.setToken();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    //Constructor

    public Conexion() {
        super();
        this.nombreDelServidor = "localhost";
        this.puertoDelServidor = 8080;
        this.estado = Estado.PENDIENTE;
    }

    //Methods


    /**
     * @return
     */
    public boolean iniciarSesion() {
        try {
            socket = new Socket(nombreDelServidor, puertoDelServidor);
            out = socket.getOutputStream();
            in = socket.getInputStream();
            estado = Estado.ACTIVO;
            this.bf = new BufferedReader(new InputStreamReader(in));

            return true;

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;

    }


    public void setToken() throws IOException{
        String str = bf.readLine();
        if(str != null) {
            System.out.println(str);
        }


    }


    /**
     * @return
     */
    public void cerrarSesion() {
        try {
            socket.close();
            estado = Estado.INACTIVO;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }


    public void  enviarMov( Ficha fichaMovida, int[][] posiciones) throws IOException {

        String  msg = "mov " + cuarto +" "+ sesion + " " + getMovimientos( fichaMovida,  posiciones) ;

        out.write(msg.getBytes());
    }

    private String getMovimientos(Ficha fichaMovida, int[][] posisciones) {
    	 
        return null;

    }






    public static void main(String[] args) {
        Conexion s = new Conexion();
        s.start();
    }

	

}

