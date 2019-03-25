package damas;

class Movimiento {
	private Fichas ficha;
	private int x, y;
	private Movimiento next,prev;
	
	Movimiento(Fichas f,int x,int y){
		ficha = f;
		this.x=x;
		this.y = y;
		next = null;
		prev=null;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public Fichas getFicha(){
		return ficha;
	}

	
	public void setNext(Movimiento next) {
		this.next = next; 
	}

	public void setPrev(Movimiento prev) {
		this.prev = prev; 
	}
	
	public void realizarMovimiento(){
		ficha.moverFicha(x,y);
	}

	public Movimiento getNext() {
		return (this.next); 
	}

	public Movimiento getPrev() {
		return (this.prev); 
	}
}
