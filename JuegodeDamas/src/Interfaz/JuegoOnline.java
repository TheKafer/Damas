package Interfaz;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import Codigo.Ficha;
import Codigo.Juego;

public class JuegoOnline {
   private static final int COLUMNAS = 8;
   private static final int FILAS = 8;
   private JFrame v;
   private Juego juego;
   private JButton[][] botones;
   private int soyyo;
   
   public JuegoOnline(int soyyo) {
	      v = new JFrame();
	      juego=new Juego(0);
	      v.getContentPane().setLayout(new GridLayout(FILAS,COLUMNAS));
			
	      botones = new JButton [FILAS][COLUMNAS];
	      for (int i=0;i<FILAS;i++)
	         for (int j=0;j<COLUMNAS;j++)
	         {
	            botones[i][j] = new JButton();
	            botones[i][j].addActionListener(new ActionListener() {
	    			public void actionPerformed(ActionEvent arg0) {
	    				for(int i=0;i<8;i++) {
	    					for(int j=0;j<8;j++) {
	    						if(botones[i][j]==arg0.getSource()) {
	    							seleccionarPosicion(i,j);
	    						}
	    					}
	    				}
	    			}
	    		});
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
	   
	   for(int i=0;i<8;i++) {
			for(int j=0;j<8;j++) {
				if(juego.getTablero().getMatriz()[i][j]==null) {	
					botones[i][j].setIcon(null);
					
				}
		}
			
			juego.getTablero().coronarReinaBlanca();
			juego.getTablero().coronarReinaNegra();
	}
	   
	   ImageIcon imagen_negra=new ImageIcon("Imagenes/fichaNn.jpg");
	   ImageIcon imagen_negra_Reina=new ImageIcon("Imagenes/fichaRNn.jpg");
	   ImageIcon imagen_blanca=new ImageIcon("Imagenes/fichaRn.jpg");
	   ImageIcon imagen_blanca_Reina=new ImageIcon("Imagenes/fichaRRn.jpg");
	   //Icon icono=new ImageIcon(imagen.getImage().getScaledInstance(botones[1][0].getWidth(), botones[1][0].getHeight(), Image.SCALE_DEFAULT));
		for(int i=0;i<8;i++) {
			for(int j=0;j<8;j++) {
				if(juego.getTablero().getMatriz()[i][j]!=null) {	
					if(juego.getTablero().getMatriz()[i][j].getColor()==0 && juego.getTablero().getMatriz()[i][j].isCorona()==false) {
						botones[i][j].setIcon(imagen_negra);	
					}else {
						if(juego.getTablero().getMatriz()[i][j].getColor()==0 && juego.getTablero().getMatriz()[i][j].isCorona()==true) {
							botones[i][j].setIcon(imagen_negra_Reina);
						}else {
							if(juego.getTablero().getMatriz()[i][j].getColor()==1 && juego.getTablero().getMatriz()[i][j].isCorona()==false) {
								botones[i][j].setIcon(imagen_blanca);
							}else {
								if(juego.getTablero().getMatriz()[i][j].getColor()==1 && juego.getTablero().getMatriz()[i][j].isCorona()==true) {
									botones[i][j].setIcon(imagen_blanca_Reina);
								}
							}
						}
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
   
   public void seleccionarPosicion(int x,int y) {
	   ArrayList<Ficha> fichas=new  ArrayList<Ficha>();
	   
	   if(juego.getTurno()==0) {
		   fichas=juego.getTablero().posibilidadesComerNegras();
		   fichas.addAll(juego.getTablero().posibilidadesComerNegrasReina());
	   }else {
		   fichas=juego.getTablero().posibilidadesComerBlancas();
		   fichas.addAll(juego.getTablero().posibilidadesComerBlancasReina());
	   }
	  
	  if(fichas.size()!=0) {
		  pintarPosibilidadesComer(fichas);
	  }
	   if(juego.getTablero().getMatriz()[x][y]!=null) {
		   if(juego.getTurno()==soyyo) {
		   		seleccionarFicha(juego.getTablero().getMatriz()[x][y]);
		   }else {
			   JOptionPane.showMessageDialog(v, "No es tu turno  -.-");
		   }
			   	   
	   }else {
		    posicionSeleccionada(x,y);
	   }
	  
   }
   
   public void pintarPosibilidadesComer(ArrayList<Ficha> fichas) {
	   Iterator<Ficha> i=fichas.iterator();
	   while(i.hasNext()) {
		   Ficha ficha=i.next();
		   ArrayList<int[]> casillas=juego.getTablero().posibilidadComer(ficha);
		   casillas.addAll(juego.getTablero().posibilidadComerReina(ficha));
		   Iterator<int[]> j=casillas.iterator();
		   while(j.hasNext()) {
			   int[] casilla=j.next();
			   botones[casilla[0]][casilla[1]].setBackground(Color.green);
		   }
	   }
   }
   
   public void seleccionarFicha(Ficha ficha) {
	   
	   ArrayList<Ficha> fichas=new  ArrayList<Ficha>();

	   if(juego.getTurno()==0) {
		   
		   fichas=juego.getTablero().posibilidadesComerNegras();
		   fichas.addAll(juego.getTablero().posibilidadesComerNegrasReina());
	   }else {
		   fichas=juego.getTablero().posibilidadesComerBlancas();
		   fichas.addAll(juego.getTablero().posibilidadesComerBlancasReina());
	   }
	   
	  
	   if(fichas.size()==0) {
	   juego.setFichaenespera(ficha);
	   
	   if(ficha.isCorona()==false) {
	   ArrayList<int[] >movimientos= juego.getTablero().movimientosPosibles(juego.getFichaenespera());
	   Iterator<int[]> i=movimientos.iterator();
	   pintarTablero();
	   while(i.hasNext()) {
		   int[] vector=i.next();
		   botones[vector[0]][vector[1]].setBackground(Color.yellow);
		   
	   }
	   
	   }else {
		   ArrayList<int[] >movimientos= juego.getTablero().movimientosPosiblesReina(ficha);
		   Iterator<int[]> i=movimientos.iterator();
		   pintarTablero();
		   while(i.hasNext()) {
			   int[] vector=i.next();
			   botones[vector[0]][vector[1]].setBackground(Color.yellow);
			   
		   }
	   }
	   
	   }else {
		   
		   Iterator<Ficha> i=fichas.iterator();
		   while(i.hasNext()) {
			   Ficha f=i.next();
			   if(ficha==f) {
				   juego.setFichaenespera(ficha);
			   }
			   
		   }
		   
	   }
   }
   
   public void posicionSeleccionada(int x,int y) {
	   if(juego.getFichaenespera()!=null) {
		   ArrayList<Ficha> fichas=new ArrayList<Ficha>();
		   if(juego.getTurno()==0) {
			   fichas=juego.getTablero().posibilidadesComerNegras();
			   fichas.addAll(juego.getTablero().posibilidadesComerNegrasReina());
		   }else {
			   fichas=juego.getTablero().posibilidadesComerBlancas();
			   fichas.addAll(juego.getTablero().posibilidadesComerBlancasReina());
		   }
		   
		   if(fichas.size()==0) {
			  if(!juego.getFichaenespera().isCorona()) { 
				  ArrayList<int[] >movimientos= juego.getTablero().movimientosPosibles(juego.getFichaenespera());
				  Iterator<int[]> i=movimientos.iterator();
				  while(i.hasNext()) {
				  int[] vector=i.next();
			   if(vector[0]==x && vector[1]==y) {
				   juego.getTablero().moverFicha(juego.getFichaenespera(), x, y);
				   actualizarTablero();
				   pintarTablero();
				   if(juego.getFichaenespera().getColor()==0) {
					   juego.setTurno(1);
					   juego.setFichaenespera(null);
				   }else {
					   juego.setTurno(0);
					   juego.setFichaenespera(null);
				   }
			   }
			   
				  }
			  }else {
				  
				  ArrayList<int[] >movimientos= juego.getTablero().movimientosPosiblesReina(juego.getFichaenespera());
				  Iterator<int[]> i=movimientos.iterator();
				  while(i.hasNext()) {
				  int[] vector=i.next();
			   if(vector[0]==x && vector[1]==y) {
				   juego.getTablero().moverFicha(juego.getFichaenespera(), x, y);
				   actualizarTablero();
				   pintarTablero();
				   if(juego.getFichaenespera().getColor()==0) {
					   juego.setTurno(1);
					   juego.setFichaenespera(null);
				   }else {
					   juego.setTurno(0);
					   juego.setFichaenespera(null);
				   }
			   }
			   
		   }
			  }
	   }else {
		   if(juego.getFichaenespera().isCorona()==false) {
			   ArrayList<int[] >movimientos= juego.getTablero().posibilidadComer(juego.getFichaenespera());
			   Iterator<int[]> i=movimientos.iterator();
			   while(i.hasNext()) {
				   int[] vector=i.next();
				   if(vector[0]==x && vector[1]==y) {
					    
					   if(x>juego.getFichaenespera().getFila() && y<juego.getFichaenespera().getColumna()) {
						   juego.getTablero().comerFichaNormal(juego.getFichaenespera(), juego.getTablero().getMatriz()[x-1][y+1]);
					   }
					   
					   if(x<juego.getFichaenespera().getFila() && y<juego.getFichaenespera().getColumna()) {
						   juego.getTablero().comerFichaNormal(juego.getFichaenespera(), juego.getTablero().getMatriz()[x+1][y+1]);
					   }
					   
					   if(x>juego.getFichaenespera().getFila() && y>juego.getFichaenespera().getColumna()) {
						   juego.getTablero().comerFichaNormal(juego.getFichaenespera(), juego.getTablero().getMatriz()[x-1][y-1]);
					   }
					   
					   if(x<juego.getFichaenespera().getFila() && y>juego.getFichaenespera().getColumna()) {
						   juego.getTablero().comerFichaNormal(juego.getFichaenespera(), juego.getTablero().getMatriz()[x+1][y-1]);
					   }
					   
					   ArrayList<int[]> movimientos2=juego.getTablero().posibilidadComer(juego.getTablero().getMatriz()[x][y]);
					   actualizarTablero();
					   pintarTablero();
					   
					   if(movimientos2.size()==0) {
					   	if(juego.getFichaenespera().getColor()==0) {
						   juego.setTurno(1);
						   juego.setFichaenespera(null);
					   	}else {
						   juego.setTurno(0);
						   juego.setFichaenespera(null);					   
						   }
					   
					   
				   		}else {
				   			juego.setFichaenespera(null);
				   		}
				   }
				   
			   }
			   }
			   else {
				   
				   ArrayList<int[] >movimientos= juego.getTablero().posibilidadComerReina(juego.getFichaenespera());
				   Iterator<int[]> i=movimientos.iterator();
				   while(i.hasNext()) {
					   int[] vector=i.next();
					   if(vector[0]==x && vector[1]==y) {
						    
						   if(x>juego.getFichaenespera().getFila() && y<juego.getFichaenespera().getColumna()) {
							   juego.getTablero().comerFichaNormal(juego.getFichaenespera(), juego.getTablero().getMatriz()[x-1][y+1]);
						   }
						   
						   if(x<juego.getFichaenespera().getFila() && y<juego.getFichaenespera().getColumna()) {
							   juego.getTablero().comerFichaNormal(juego.getFichaenespera(), juego.getTablero().getMatriz()[x+1][y+1]);
						   }
						   
						   if(x>juego.getFichaenespera().getFila() && y>juego.getFichaenespera().getColumna()) {
							   juego.getTablero().comerFichaNormal(juego.getFichaenespera(), juego.getTablero().getMatriz()[x-1][y-1]);
						   }
						   
						   if(x<juego.getFichaenespera().getFila() && y>juego.getFichaenespera().getColumna()) {
							   juego.getTablero().comerFichaNormal(juego.getFichaenespera(), juego.getTablero().getMatriz()[x+1][y-1]);
						   }
						   
						   
						   actualizarTablero();
						   pintarTablero();
						   if(juego.getFichaenespera().getColor()==0) {
							   juego.setTurno(1);
						   }else {
							   juego.setTurno(0);
						   }
					   }
					   
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
