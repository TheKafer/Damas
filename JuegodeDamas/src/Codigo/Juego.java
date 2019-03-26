package Codigo;

public class Juego {
	
	private Tablero tablero;
	private int turno;// 0 es el jugador con damas negras y 1 el de damas blancas
	
	public Juego(int turno) {
		tablero=new Tablero();
		turno=0;
		
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
	
	

}
