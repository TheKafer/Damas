package Codigo;

import java.util.ArrayList;

public class Tablero {
	
	private Ficha[][] matriz;
	
	public Tablero() {
		matriz=new Ficha[8][8];
		matriz[0][1]=new Ficha_Negra(0,1);
		matriz[0][3]=new Ficha_Negra(0,3);
		matriz[0][5]=new Ficha_Negra(0,5);
		matriz[0][7]=new Ficha_Negra(0,7);
		matriz[1][0]=new Ficha_Negra(1,0);
		matriz[1][2]=new Ficha_Negra(1,2);
		matriz[1][4]=new Ficha_Negra(1,4);
		matriz[1][6]=new Ficha_Negra(1,6);
		matriz[2][1]=new Ficha_Negra(2,1);
		matriz[2][3]=new Ficha_Negra(2,3);
		matriz[2][5]=new Ficha_Negra(2,5);
		matriz[2][7]=new Ficha_Negra(2,7);
	
		matriz[6][1]=new Ficha_Blanca(6,1);
		matriz[6][3]=new Ficha_Blanca(6,3);
		matriz[6][5]=new Ficha_Blanca(6,5);
		matriz[6][7]=new Ficha_Blanca(6,7);
		matriz[7][0]=new Ficha_Blanca(7,0);
		matriz[7][2]=new Ficha_Blanca(7,2);
		matriz[7][4]=new Ficha_Blanca(7,4);
		matriz[7][6]=new Ficha_Blanca(7,6);
		matriz[5][0]=new Ficha_Blanca(5,0);
		matriz[5][2]=new Ficha_Blanca(5,2);
		matriz[5][4]=new Ficha_Blanca(5,4);
		matriz[5][6]=new Ficha_Blanca(5,6);
	
	}

	public Ficha[][] getMatriz() {
		return matriz;
	}

	public void setMatriz(Ficha[][] matriz) {
		this.matriz = matriz;
	}
	
	
	public void imprimirMatriz() {
		for(int i=0;i<8;i++) {
			for(int j=0;j<8;j++) {
				if(matriz[i][j]!=null) {
					System.out.print(matriz[i][j].getColor());
				}else {
					System.out.print(" ");
				}
				System.out.print(" ");
			}
			System.out.println();
		}
	}
	
	
	public void moverFicha(Ficha ficha,int fila,int columna) {
		
			if((fila>=0 && fila<=8) && (columna>=0 && columna<=8) ) {
				if(matriz[fila][columna]==null) {
					if(ficha.getColor()==0) {
						matriz[fila][columna]=new Ficha_Negra(fila,columna);
					}else {
						matriz[fila][columna]=new Ficha_Blanca(fila,columna);
					}
				
					eliminarFicha(ficha.getFila(),ficha.getColumna());
				}else {
					System.out.println("Hay una ficha en la posición a mover");
				}
			}else {
				System.out.println("Se sale de las corordenadas del tablero");
			
			}
			
	   
    }
	
	public void eliminarFicha(int fila,int columna) {
		matriz[fila][columna]=null;
	}
	
	public ArrayList<int[]> movimientosPosibles(Ficha ficha) {
		int fila=ficha.getFila();
		int columna=ficha.getColumna();
	ArrayList<int[]> lista=new ArrayList<int[]>();
		
		
		if(ficha.getColor()==0) {
			if((columna+1<8 && columna+1>=0) && (fila+1<8 && fila+1>=0) && (matriz[fila+1][columna+1]==null)) {
				int[] vector=new int[2];
				vector[0]=fila+1;
				vector[1]=columna+1;
				lista.add(vector);
			}
			
			if((columna-1<8 && columna-1>=0) && (fila+1<8 && fila+1>=0) && (matriz[fila+1][columna-1]==null)) {
				int[] vector=new int[2];
				vector[0]=fila+1;
				vector[1]=columna-1;
				lista.add(vector);
			}
			
			
		}else {
			if((columna+1<8 && columna+1>=0) && (fila-1<8 && fila-1>=0) && (matriz[fila-1][columna+1]==null)) {
				int[] vector=new int[2];
				vector[0]=fila-1;
				vector[1]=columna+1;
				lista.add(vector);
			}
			
			if((columna-1<8 && columna-1>=0) && (fila-1<8 && fila+1>=0) && (matriz[fila-1][columna-1]==null)) {
				int[] vector=new int[2];
				vector[0]=fila-1;
				vector[1]=columna-1;
				lista.add(vector);
			}
		}
		
		
		return lista;
	}
	
	public ArrayList<Ficha> posibilidadesComerNegras(){
		ArrayList<Ficha> fichas=new ArrayList<Ficha>();
		for(int i=0;i<8;i++) {
			for(int j=0;j<8;j++) {
				if(matriz[i][j]!=null) {
					if(matriz[i][j].getColor()==0) {
					ArrayList<int[]> arreglo=posibilidadComer(matriz[i][j]);
				
				if(arreglo.size()!=0) {
					fichas.add(matriz[i][j]);
				}
				}
				
				}
			}
		}
		return fichas;
	}
	
	public ArrayList<Ficha> posibilidadesComerBlancas(){
		ArrayList<Ficha> fichas=new ArrayList<Ficha>();
		for(int i=0;i<8;i++) {
			for(int j=0;j<8;j++) {
				if(matriz[i][j]!=null) {
					if(matriz[i][j].getColor()==1) {
					ArrayList<int[]> arreglo=posibilidadComer(matriz[i][j]);
				
				if(arreglo.size()!=0) {
					fichas.add(matriz[i][j]);
				}
				}
				
				}
			}
		}
		return fichas;
	}
	
	public ArrayList<int[]> posibilidadComer(Ficha ficha) {
		int fila=ficha.getFila();
		int columna=ficha.getColumna();
		ArrayList<int[]> lista=new ArrayList<int[]>();
		
		if(ficha.getColor()==0) {
			if((fila+1<8 && fila+1>=0) && (columna+1<8 && columna+1>=0)) {
				if(matriz[fila+1][columna+1]!=null) {
				if(matriz[fila+1][columna+1].getColor()==1 ) {
					if((fila+2<8 && fila+2>=0) && (columna+2<8 && columna+2>=0)) {
						if(matriz[fila+2][columna+2]==null) {
							int[] vector=new int[2];
							vector[0]=fila+2;
							vector[1]=columna+2;
							lista.add(vector);
						}
					}
				}
				}
			}
			
			if((fila+1<8 && fila+1>=0) && (columna-1<8 && columna-1>=0)) {
				if(matriz[fila+1][columna-1]!=null) {
				if(matriz[fila+1][columna-1].getColor()==1 ) {
					if((fila+2<8 && fila+2>=0) && (columna-2<8 && columna-2>=0)) {
						if(matriz[fila+2][columna-2]==null) {
							int[] vector=new int[2];
							vector[0]=fila+2;
							vector[1]=columna-2;
							lista.add(vector);
						}
					}
				}
				}
			}
			
			
		}else {
			
			if((fila-1<8 && fila-1>=0) && (columna+1<8 && columna+1>=0)) {
				if(matriz[fila-1][columna+1]!=null) {
				if(matriz[fila-1][columna+1].getColor()==0 ) {
					if((fila-2<8 && fila-2>=0) && (columna+2<8 && columna+2>=0)) {
						if(matriz[fila-2][columna+2]==null) {
							int[] vector=new int[2];
							vector[0]=fila-2;
							vector[1]=columna+2;
							lista.add(vector);
						}
					}
				}
				}
			}
			
			if((fila-1<8 && fila-1>=0) && (columna-1<8 && columna-1>=0)) {
				if(matriz[fila-1][columna-1]!=null) {
				if(matriz[fila-1][columna-1].getColor()==0 ) {
					if((fila-2<8 && fila-2>=0) && (columna-2<8 && columna-2>=0)) {
						if(matriz[fila-2][columna-2]==null) {
							int[] vector=new int[2];
							vector[0]=fila-2;
							vector[1]=columna-2;
							lista.add(vector);
						}
					}
				}
			}
			}
			
			
		}
		
		return lista;
	}
	
	public void comerFichaNormal(Ficha cazadora,Ficha victima) {
		int posicion_fila_cazadora=cazadora.getFila();
		int posicion_columna_cazadora=cazadora.getColumna();
		int posicion_fila_victima=victima.getFila();
		int posicion_columna_victima=victima.getColumna();
		
		if(posicion_fila_victima<posicion_fila_cazadora && posicion_columna_victima>posicion_columna_cazadora) {
			if(matriz[ posicion_fila_cazadora-2][posicion_columna_cazadora+2]==null) {
				if(cazadora.getColor()==0) {
					matriz[ posicion_fila_cazadora-2][posicion_columna_cazadora+2]=new Ficha_Negra(posicion_fila_cazadora-2,posicion_columna_cazadora+2);
				}
				
				if(cazadora.getColor()==1) {
					matriz[ posicion_fila_cazadora-2][posicion_columna_cazadora+2]=new Ficha_Blanca(posicion_fila_cazadora-2,posicion_columna_cazadora+2);
				}
				
				eliminarFicha(posicion_fila_cazadora,posicion_columna_cazadora);
				eliminarFicha( posicion_fila_victima,posicion_columna_victima);
				
			}else {
				System.out.println("la posición para comer no esta vacía");
			}
			
		}
		
		if(posicion_fila_victima>posicion_fila_cazadora && posicion_columna_victima>posicion_columna_cazadora) {
			if(matriz[ posicion_fila_cazadora+2][posicion_columna_cazadora+2]==null) {
				if(cazadora.getColor()==0) {
					matriz[ posicion_fila_cazadora+2][posicion_columna_cazadora+2]=new Ficha_Negra(posicion_fila_cazadora+2,posicion_columna_cazadora+2);
				}
				
				if(cazadora.getColor()==1) {
					matriz[ posicion_fila_cazadora+2][posicion_columna_cazadora+2]=new Ficha_Blanca(posicion_fila_cazadora+2,posicion_columna_cazadora+2);
				}
				
				eliminarFicha(posicion_fila_cazadora,posicion_columna_cazadora);
				eliminarFicha( posicion_fila_victima,posicion_columna_victima);
				
			}else {
				System.out.println("la posición para comer no esta vacía");
			}
			
		}
		
		
		if(posicion_fila_victima>posicion_fila_cazadora && posicion_columna_victima<posicion_columna_cazadora) {
			if(matriz[ posicion_fila_cazadora+2][posicion_columna_cazadora-2]==null) {
				if(cazadora.getColor()==0) {
					matriz[ posicion_fila_cazadora+2][posicion_columna_cazadora-2]=new Ficha_Negra(posicion_fila_cazadora+2,posicion_columna_cazadora-2);
				}
				
				if(cazadora.getColor()==1) {
					matriz[ posicion_fila_cazadora+2][posicion_columna_cazadora-2]=new Ficha_Blanca(posicion_fila_cazadora+2,posicion_columna_cazadora-2);
				}
				
				eliminarFicha(posicion_fila_cazadora,posicion_columna_cazadora);
				eliminarFicha( posicion_fila_victima,posicion_columna_victima);
				
			}else {
				System.out.println("la posición para comer no esta vacía");
			}
			
		}
		
		
		if(posicion_fila_victima<posicion_fila_cazadora && posicion_columna_victima<posicion_columna_cazadora) {
			if(matriz[ posicion_fila_cazadora-2][posicion_columna_cazadora-2]==null) {
				if(cazadora.getColor()==0) {
					matriz[ posicion_fila_cazadora-2][posicion_columna_cazadora-2]=new Ficha_Negra(posicion_fila_cazadora-2,posicion_columna_cazadora-2);
				}
				
				if(cazadora.getColor()==1) {
					matriz[ posicion_fila_cazadora-2][posicion_columna_cazadora-2]=new Ficha_Blanca(posicion_fila_cazadora-2,posicion_columna_cazadora-2);
				}
				
				eliminarFicha(posicion_fila_cazadora,posicion_columna_cazadora);
				eliminarFicha( posicion_fila_victima,posicion_columna_victima);
				
			}else {
				System.out.println("la posición para comer no esta vacía");
			}
			
		}
		
	}
	

}
