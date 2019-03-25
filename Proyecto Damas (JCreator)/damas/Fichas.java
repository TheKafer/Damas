package damas;

import javax.swing.*;

abstract class Fichas extends JLabel {
    
    protected static final ImageIcon ROJA_N =
            new ImageIcon("imagenes\\fichaRn.jpg");

    protected static final ImageIcon NEGRA_N =
            new ImageIcon("imagenes\\fichaNn.jpg");

    protected static final ImageIcon ROJA_S =
            new ImageIcon("imagenes\\fichaRs.jpg");

    protected static final ImageIcon NEGRA_S =
            new ImageIcon("imagenes\\fichaNs.jpg");

    protected static final ImageIcon ROJA_RN =
            new ImageIcon("imagenes\\fichaRRn.jpg");

    protected static final ImageIcon NEGRA_RN =
            new ImageIcon("imagenes\\fichaRNn.jpg");

    protected static final ImageIcon ROJA_RS =
            new ImageIcon("imagenes\\fichaRRs.jpg");

    protected static final ImageIcon NEGRA_RS =
            new ImageIcon("imagenes\\fichaRNs.jpg");
            
    private int x,y;

    private boolean corona;
    
    private boolean selec;

    Fichas(int x,int y){
        this.x = x;
        this.y = y;
        corona = false;
    }


    public int getXp(){
        return this.x;
    }

    public int getYp(){
        return this.y;
    }
    
    public boolean  isSelect(){
    	return selec;
    }
    
    protected void select(boolean b){
    	selec = b;
    }

    public void moverFicha(int x,int y){
        this.x = x;
        this.y = y;
    }

    protected void corona(){
        this.corona = true;
    }

    protected boolean getCorona(){
        return corona;
    }

    public abstract void coronar();

    public abstract void seleccionar();

    public abstract void deseleccionar();

    public abstract boolean esRoja();

}
