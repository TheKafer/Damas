package Codigo;

public abstract class Ficha {
	
	protected boolean corona;//indica si la ficha es reina o no, reina=true Noreina=false
	protected int color; //indica si la ficha es blanca o negra, blanca =true negra=false
	protected int x;
	protected int y;
	
	public Ficha(int x, int y) {
		this.corona=false;
		this.x=x;
		this.y=y;
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

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	

}
