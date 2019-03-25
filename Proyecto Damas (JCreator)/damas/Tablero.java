package damas;

import javax.swing.*;
import java.awt.event.*;

public class Tablero extends JPanel implements MouseListener {
    private GestorFichas fichas;
    private JLabel fondo;
    private boolean comenzado;
    
    public static final int MODO_HVH = 0,MODO_PVH = 2, MODO_HVP=1, MODO_PVP=3;
    
    public Tablero(){
        this.setSize(480,480);
        this.setLayout(null);
        setVisible(true);
        setOpaque(false);
        comenzado = false;
        fondo = new JLabel();
        fondo.setIcon(new ImageIcon("imagenes\\Tablero.jpg"));
        add(fondo);
        fondo.setBounds(0,0,480,480);
    }

	public void cambiarModo(int modo){
		fichas.setMode(modo);
	}
	
  	public void comenzarPartida(int modo){
        fichas = new GestorFichas();
        fichas.setTurnoR(true);
        fichas.setMode(modo);
		comenzado = true;
        pintar();
        repaint();
  	}
    
    public void definirGanador(){
		if(fichas.getFichasR() == fichas.getFichasN()){
			if(fichas.fichasNR()==fichas.fichasRR()){
				JOptionPane.showMessageDialog(this,"Empate!!!");
			}else if(fichas.fichasNR()<fichas.fichasRR())
				JOptionPane.showMessageDialog(this,"Rojas Ganan!");
				else
					JOptionPane.showMessageDialog(this,"Negras Ganan!");
			
		}else if(fichas.getFichasN()<fichas.getFichasR()){
			JOptionPane.showMessageDialog(this,"Rojas Ganan!");
		}else
			JOptionPane.showMessageDialog(this,"Negras Ganan!");
			
		comenzado = false;
	}
    
	public void pintar(){
		Fichas[] f = fichas.getFichas();
		removeAll();
		for(int i= 0; i<f.length; i++){
                        add(f[i]);
			f[i].setBounds((f[i].getXp()-1)*60,(8-f[i].getYp())*60,60,60);
		}
                add(fondo);
	}
	
	public void mouseClicked(MouseEvent e) {
		// TODO: Add your code here
		
	}

	public void mousePressed(MouseEvent e) {
		// TODO: Add your code here
		
	if(comenzado){
		if(fichas.getMode() == MODO_HVH){
			if(fichas.consumirTurno(e.getX(),e.getY()))
			{
				pintar();
				if(!fichas.hayMovimiento()){
					definirGanador();
				}
				return;
			}
		}
		
		if(fichas.getMode() == MODO_HVP){
			if(fichas.getTurnoR())
			if(fichas.consumirTurno(e.getX(),e.getY()))
			{
				pintar();
				if(!fichas.hayMovimiento()){
					definirGanador();
				}
				return;
			}
			
			if(!fichas.getTurnoR()){
	        	fichas.moverNegrasPC();
	            pintar();
	            if(!fichas.hayMovimiento())
	            	this.definirGanador();
	            return;
	        }
		}
		
		if(fichas.getMode() == this.MODO_PVH){
			if(!fichas.getTurnoR())
			if(fichas.consumirTurno(e.getX(),e.getY()))
			{
				pintar();
				if(!fichas.hayMovimiento()){
					definirGanador();
				}
				return;
			}
			
			if(fichas.getTurnoR()){
	                    fichas.moverRojasPC();
	                    pintar();
	                    if(!fichas.hayMovimiento())
	                        this.definirGanador();
	                    return;
			}
			
		}
		
		if(fichas.getMode() == this.MODO_PVP){
			if(fichas.getTurnoR()){
	                    fichas.moverRojasPC();
	                    pintar();
	                    if(!fichas.hayMovimiento())
	                        this.definirGanador();
	                    return;
			}
	
	        if(!fichas.getTurnoR()){
	        	fichas.moverNegrasPC();
	            pintar();
	            if(!fichas.hayMovimiento())
	            	this.definirGanador();
	                return;
	        }
		}
	}
	}
	
	public void mouseReleased(MouseEvent e) {
		// TODO: Add your code here
	}
	
	public void mouseEntered(MouseEvent e) {
		// TODO: Add your code here
	}
	
	public void mouseExited(MouseEvent e) {
		// TODO: Add your code here
	}

	public boolean getComenzado() {
		return (this.comenzado); 
	}

}
