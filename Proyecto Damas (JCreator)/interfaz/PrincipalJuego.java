
package interfaz;
import damas.Tablero;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class PrincipalJuego extends JFrame implements ActionListener {
    private Tablero mesa;
    private JMenuBar barraMenu;
    private JMenu mArchivo,mAyuda,mCambiarModo;
    private JMenuItem mAcercaDe, mNuevoJuego, mSalir, mHvH, mHvPC, mPCvH, mPCvPC;
    private NuevoJuego nuevo;
    private AcercaDe acerca;

    public PrincipalJuego(){
    	this.setTitle("Damas");
        setSize(485,535);
        this.setLayout(null);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
     
       	barraMenu = new JMenuBar();
        this.setJMenuBar(barraMenu);

        mArchivo = new JMenu("Archivo");
        barraMenu.add(mArchivo);

        mNuevoJuego = new JMenuItem("Nuevo Juego");
        mArchivo.add(mNuevoJuego);
        mNuevoJuego.addActionListener(this);

        mSalir = new JMenuItem("Salir");
        mArchivo.add(mSalir);
        mSalir.addActionListener(this);
        
        mCambiarModo = new JMenu("Cambiar Modo");
        barraMenu.add(mCambiarModo);
        
        mHvH = new JMenuItem("H vs H");
        mCambiarModo.add(mHvH);
        mHvH.addActionListener(this);
        
        mHvPC = new JMenuItem("H vs PC");
        mCambiarModo.add(mHvPC);
        mHvPC.addActionListener(this);
        
        mPCvH = new JMenuItem("PC vs H");
        mCambiarModo.add(mPCvH);
        mPCvH.addActionListener(this);
        
        mPCvPC = new JMenuItem("PC vs PC");
        mCambiarModo.add(mPCvPC);
        mPCvPC.addActionListener(this);
        
        mAyuda = new JMenu("Ayuda");
        barraMenu.add(mAyuda);
        
        mAcercaDe = new JMenuItem("Acerca de...");
        mAyuda.add(mAcercaDe);
        mAcercaDe.addActionListener(this);

        mesa = new Tablero();
        add(mesa);
        mesa.setBounds(0,0, 480,480);
        mesa.addMouseListener(mesa);
        
        nuevo = new NuevoJuego(mesa);
        acerca = new AcercaDe();
        
		
        this.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });
        repaint();
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(mNuevoJuego)){
            nuevo.show();
        }else if(e.getSource().equals(mSalir)){
            this.dispose(); 
        }else if(e.getSource().equals(mHvH)){
        	if(mesa.getComenzado())
        	mesa.cambiarModo(mesa.MODO_HVH);
        }else if(e.getSource().equals(mHvPC)){
        	if(mesa.getComenzado())
        	mesa.cambiarModo(mesa.MODO_HVP);
        }else if(e.getSource().equals(mPCvH)){
        	if(mesa.getComenzado())
        	mesa.cambiarModo(mesa.MODO_PVH);
        }else if(e.getSource().equals(mPCvPC)){
        	if(mesa.getComenzado())
        	mesa.cambiarModo(mesa.MODO_PVP);
        }else if(e.getSource().equals(mAcercaDe)){
        	acerca.show();
        }

    }



}
