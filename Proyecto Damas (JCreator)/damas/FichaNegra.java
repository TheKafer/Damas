package damas;


class FichaNegra extends Fichas {
    private FichaNegra prev,next;

    FichaNegra(int x, int y){
        super(x,y);
        setIcon(NEGRA_N);
        prev = next = null;
    }

    public FichaNegra getNext() {
        return next;
    }

    public void setNext(FichaNegra next) {
        this.next = next;
    }

    public FichaNegra getPrev() {
        return prev;
    }

    public void setPrev(FichaNegra prev) {
        this.prev = prev;
    }

    public void coronar() {
        super.corona();
        super.setIcon(NEGRA_RN);
    }


    public void seleccionar() {
    	super.select(true);
        if(this.getCorona())
            super.setIcon(NEGRA_RS);
        else
            super.setIcon(NEGRA_S);

    }


    public void deseleccionar() {
    	super.select(false);
        if(this.getCorona())
            super.setIcon(NEGRA_RN);
        else
            super.setIcon(NEGRA_N);

    }

    public boolean esRoja() {
        return false;
    }

}