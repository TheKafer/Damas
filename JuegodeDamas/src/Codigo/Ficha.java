package Codigo;

public abstract class Ficha {
	
	protected boolean corona;//indica si la ficha es reina o no, reina=true Noreina=false
	protected int color; //indica si la ficha es blanca o negra, blanca =true negra=false
	protected int fila;
	protected int columna;
	
	public Ficha(int fila, int columna) {
		this.corona=false;
		this.fila=fila;
		this.columna=columna;
	}

	public boolean isCorona() {
		return corona;
	}

	public void setCorona(boolean corona) {
		this.corona = corona;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

	public int getFila() {
		return fila;
	}

	public void setFila(int fila) {
		this.fila = fila;
	}

	public int getColumna() {
		return columna;
	}

	public void setColumna(int columna) {
		this.columna = columna;
	}

	
	
	

}
