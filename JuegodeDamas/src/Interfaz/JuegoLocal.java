package Interfaz;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import Codigo.Juego;

public class JuegoLocal {
   private static final int COLUMNAS = 8;
   private static final int FILAS = 8;
   private JFrame v;
   private Juego juego;
   private JButton[][] botones;

   public JuegoLocal() {
	      v = new JFrame();
	      juego=new Juego(0);
	      v.getContentPane().setLayout(new GridLayout(FILAS,COLUMNAS));
			
	      botones = new JButton [FILAS][COLUMNAS];
	      for (int i=0;i<FILAS;i++)
	         for (int j=0;j<COLUMNAS;j++)
	         {
	            botones[i][j] = new JButton();
	            v.getContentPane().add(botones[i][j]);
	         }
	      v.pack();
	      v.setExtendedState(JFrame.MAXIMIZED_BOTH); 
	      pintarTablero();
	      actualizarTablero();
	      v.setVisible(true);
	      v.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
   }
   
   public void actualizarTablero() {
	   ImageIcon imagen_negra=new ImageIcon("Imagenes/fichaNn.jpg");
	   ImageIcon imagen_blanca=new ImageIcon("Imagenes/fichaRn.jpg");
	   //Icon icono=new ImageIcon(imagen.getImage().getScaledInstance(botones[1][0].getWidth(), botones[1][0].getHeight(), Image.SCALE_DEFAULT));
		for(int i=0;i<8;i++) {
			for(int j=0;j<8;j++) {
				if(juego.getTablero().getMatriz()[i][j]!=null) {	
					if(juego.getTablero().getMatriz()[i][j].getColor()==0) {
						botones[i][j].setIcon(imagen_negra);	
					}else {
						botones[i][j].setIcon(imagen_blanca);
					}
					
				}
		}
	}
   }
   
   public void pintarTablero() {
	   for(int i=0;i<8;i++) {
			for(int j=0;j<8;j++) {
				if(j%2==0) {
					if(i%2==0) {
						botones[i][j].setBackground(Color.white);
					}else {
						botones[i][j].setBackground(new Color(225,187,0));
					}
				}else {
					if(i%2==0) {
						botones[i][j].setBackground(new Color(225,187,0));
					}else {
						botones[i][j].setBackground(Color.white);
					}
				}
			}
	   }
   }
   
   public JFrame getV() {
	   return v;
   }

   public void setV(JFrame v) {
	   this.v = v;
   }

   public Juego getJuego() {
	   return juego;
   }

   public void setJuego(Juego juego) {
	   this.juego = juego;
   }

   public JButton[][] getBotones() {
	   return botones;
   }

   public void setBotones(JButton[][] botones) {
	   this.botones = botones;
   }
	
   
   
}
