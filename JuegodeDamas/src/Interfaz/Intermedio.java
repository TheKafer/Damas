package Interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Codigo.Juego;
import javax.swing.JButton;
import java.awt.event.ActionListener;
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
				juego.establecerConnexion();
				
				JuegoOnline juego=new JuegoOnline(1);
				
			}
		});
		contentPane.add(btnEstablecerConexion, BorderLayout.CENTER);
	}

}
