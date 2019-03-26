package Codigo;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tablero t=new Tablero();
		t.imprimirMatriz();
		t.moverFicha(t.getMatriz()[1][2], 0, 3);
		System.out.println("");
		System.out.println("");
		System.out.println("");
		t.imprimirMatriz();
		System.out.println("");
		System.out.println("");
		System.out.println("");
		t.moverFicha(t.getMatriz()[2][5], 1, 4);
		t.imprimirMatriz();
		System.out.println("");
		System.out.println("");
		System.out.println("");
		t.comerFichaNormal(t.getMatriz()[0][3], t.getMatriz()[1][4]);
		t.imprimirMatriz();
	}

}
