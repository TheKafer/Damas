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
import javax.swing.ImageIcon;

public class Inicio extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicio frame = new Inicio();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Inicio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JButton btnJuegoLocal = new JButton("Juego local");
		btnJuegoLocal.setIcon(new ImageIcon("imagenes\fichaNn.jpg"));
		btnJuegoLocal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JuegoLocal juego=new JuegoLocal();
				juego.getV().setVisible(true);;
				dispose();
			}
		});
		contentPane.add(btnJuegoLocal, BorderLayout.NORTH);
		
		JButton btnJuegoOnline = new JButton("Juego online");
		btnJuegoOnline.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Juego juego = new Juego(0);
				Intermedio inter = new Intermedio(juego);
				inter.setVisible(true);
				dispose();
				
			}
		});
		contentPane.add(btnJuegoOnline, BorderLayout.SOUTH);
	}

}
