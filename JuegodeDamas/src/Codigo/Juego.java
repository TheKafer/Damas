package Codigo;

import java.util.ArrayList;

public class Juego {
	
	private Tablero tablero;
	private int turno;// 0 es el jugador con damas negras y 1 el de damas blancas
	private int terminado;
	private Ficha fichaenespera;
	public Conexion conexion;
	private ArrayList<ArrayList<Integer>> movDeTurno;
	
	public Juego(int turno) {
		tablero=new Tablero();
		turno=0;
		terminado=0;// el juego ha terminado? es 1 si ya ha terminado
		fichaenespera=null;
		conexion = null;
		movDeTurno = new ArrayList<ArrayList<Integer>>();
		
	}

	public Tablero getTablero() {
		return tablero;
	}

	public void setTablero(Tablero tablero) {
		this.tablero = tablero;
	}

	public int getTurno() {
		return turno;
	}

	public ArrayList<ArrayList<Integer>> setTurno(int turno) {
		this.turno = turno;
		ArrayList<ArrayList<Integer>> res = movDeTurno;
		this.movDeTurno = new ArrayList<ArrayList<Integer>>();
		return res;
	}

	public int getTerminado() {
		return terminado;
	}

	public void setTerminado(int terminado) {
		this.terminado = terminado;
	}

	public Ficha getFichaenespera() {
		return fichaenespera;
	}

	public void setFichaenespera(Ficha fichaenespera) {
		this.fichaenespera = fichaenespera;
	}

	public Conexion getConexion() {
		return conexion;
	}

	public void setConexion(Conexion conexion) {
		this.conexion = conexion;
	}

	public void establecerConnexion() {
		conexion = new Conexion();
		conexion.start();
		
	}
	
	

}
