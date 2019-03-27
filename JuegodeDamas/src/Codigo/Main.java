package Codigo;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tablero t=new Tablero();
		t.imprimirMatriz();
		t.moverFicha(t.getMatriz()[2][1], 3, 0);
		System.out.println("");
		System.out.println("");
		System.out.println("");
		t.imprimirMatriz();
		System.out.println("");
		System.out.println("");
		System.out.println("");
		t.moverFicha(t.getMatriz()[5][2], 4, 1);
		t.imprimirMatriz();
		System.out.println("");
		System.out.println("");
		System.out.println("");
		t.comerFichaNormal(t.getMatriz()[3][0], t.getMatriz()[4][1]);
		t.imprimirMatriz();
	}

}
