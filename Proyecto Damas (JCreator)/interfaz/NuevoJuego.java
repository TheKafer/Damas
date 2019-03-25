package interfaz;

import damas.Tablero;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

class NuevoJuego extends JDialog implements ActionListener {
	private Tablero tab;
	private JLabel rojas, negras;
	private JButton aceptar, cancelar;
	private String[] modos = {
			"H vs H",
			"H vs PC",
			"PC vs H",
			"PC vs PC"
		};
	private JComboBox comboModos;
	NuevoJuego(Tablero t){
		tab = t;
		
		this.setTitle("Nuevo Juego");
		setSize(300,100);
		setLocationRelativeTo(null);
		setResizable(false);
		setLayout(new FlowLayout());
		setModal(true);
		
		modos = new String[] {
			"H vs H",
			"H vs PC",
			"PC vs H",
			"PC vs PC"
		};
		
		rojas = new JLabel("Rojas - ");
		negras = new JLabel(" - Negras");
		comboModos = new JComboBox(modos);
		aceptar = new JButton("Comenzar Juego");
		cancelar = new JButton("Cancelar");
		
		comboModos.setEditable(false);
		
		add(rojas);
		add(comboModos);
		add(negras);
		add(aceptar);
		add(cancelar);
		
		aceptar.addActionListener(this);
		cancelar.addActionListener(this);
		
		repaint();
		
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource().equals(aceptar)){
			tab.comenzarPartida(comboModos.getSelectedIndex());
		}
		
		comboModos.setSelectedIndex(0);
		this.dispose();
		
	}
}
