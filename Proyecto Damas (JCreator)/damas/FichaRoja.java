
package damas;

class FichaRoja extends Fichas {
    private FichaRoja prev,next;

    FichaRoja(int x, int y){
        super(x,y);
        setIcon(ROJA_N);
        prev = next = null;
    }

    public void coronar() {
        super.corona();
        super.setIcon(ROJA_RN);
    }

    public FichaRoja getNext() {
        return next;
    }

    public void setNext(FichaRoja next) {
        this.next = next;
    }

    public FichaRoja getPrev() {
        return prev;
    }

    public void setPrev(FichaRoja prev) {
        this.prev = prev;
    }

    public void seleccionar() {
    	super.select(true);
        if(this.getCorona())
            super.setIcon(ROJA_RS);
        else
            super.setIcon(ROJA_S);

    }


    public void deseleccionar() {
    	super.select(false);
        if(this.getCorona())
            super.setIcon(ROJA_RN);
        else
            super.setIcon(ROJA_N);

    }

    public boolean esRoja() {
        return true;
    }

}
