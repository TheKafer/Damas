package Codigo;

import java.util.ArrayList;

public class Juego {
	
	private Tablero tablero;
	private int turno;// 0 es el jugador con damas negras y 1 el de damas blancas
	private int terminado;
	private Ficha fichaenespera;
	
	
	public Juego(int turno) {
		tablero=new Tablero();
		this.turno=turno;
		terminado=0;// el juego ha terminado? es 1 si ya ha terminado
		fichaenespera=null;
		
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

	

	public void setTurno(int turno) {
		this.turno = turno;
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

	

}
