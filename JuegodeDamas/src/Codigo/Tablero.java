package Codigo;

public class Tablero {
	
	private Ficha[][] matriz;
	
	public Tablero() {
		matriz=new Ficha[8][8];
		matriz[1][0]=new Ficha_Negra(1,0);
		matriz[3][0]=new Ficha_Negra(3,0);
		matriz[5][0]=new Ficha_Negra(5,0);
		matriz[7][0]=new Ficha_Negra(7,0);
		matriz[0][1]=new Ficha_Negra(0,1);
		matriz[2][1]=new Ficha_Negra(2,1);
		matriz[4][1]=new Ficha_Negra(4,1);
		matriz[6][1]=new Ficha_Negra(6,1);
		matriz[1][2]=new Ficha_Negra(1,2);
		matriz[3][2]=new Ficha_Negra(3,2);
		matriz[5][2]=new Ficha_Negra(5,2);
		matriz[7][2]=new Ficha_Negra(7,2);
	
		matriz[1][6]=new Ficha_Blanca(1,6);
		matriz[3][6]=new Ficha_Blanca(3,6);
		matriz[5][6]=new Ficha_Blanca(5,6);
		matriz[7][6]=new Ficha_Blanca(7,6);
		matriz[0][7]=new Ficha_Blanca(0,7);
		matriz[2][7]=new Ficha_Blanca(2,7);
		matriz[4][7]=new Ficha_Blanca(4,7);
		matriz[6][7]=new Ficha_Blanca(6,7);
		matriz[0][5]=new Ficha_Blanca(0,5);
		matriz[2][5]=new Ficha_Blanca(2,5);
		matriz[4][5]=new Ficha_Blanca(4,5);
		matriz[6][5]=new Ficha_Blanca(6,5);
	
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
	
	
	public void moverFicha(Ficha ficha,int x,int y) {
		
			if((x>=0 && x<=8) && (y>=0 && y<=8) ) {
				if(matriz[x][y]==null) {
					if(ficha.getColor()==0) {
						matriz[x][y]=new Ficha_Negra(x,y);
					}else {
						matriz[x][y]=new Ficha_Blanca(x,y);
					}
				
					eliminarFicha(ficha.getX(),ficha.getY());
				}else {
					System.out.println("Hay una ficha en la posición a mover");
				}
			}else {
				System.out.println("Se sale de las corordenadas del tablero");
			
			}
			
	   
    }
	
	public void eliminarFicha(int x,int y) {
		matriz[x][y]=null;
	}
	
	public void comerFichaNormal(Ficha cazadora,Ficha victima) {
		int posicion_x_cazadora=cazadora.getX();
		int posicion_y_cazadora=cazadora.getY();
		int posicion_x_victima=victima.getX();
		int posicion_y_victima=victima.getY();
		
		if(posicion_x_victima<posicion_x_cazadora && posicion_y_victima>posicion_y_cazadora) {
			if(matriz[ posicion_x_cazadora-2][posicion_y_cazadora+2]==null) {
				if(cazadora.getColor()==0) {
					matriz[ posicion_x_cazadora-2][posicion_y_cazadora+2]=new Ficha_Negra(posicion_x_cazadora-2,posicion_y_cazadora+2);
				}
				
				if(cazadora.getColor()==1) {
					matriz[ posicion_x_cazadora-2][posicion_y_cazadora+2]=new Ficha_Blanca(posicion_x_cazadora-2,posicion_y_cazadora+2);
				}
				
				eliminarFicha(posicion_x_cazadora,posicion_y_cazadora);
				eliminarFicha( posicion_x_victima,posicion_y_victima);
				
			}else {
				System.out.println("la posición para comer no esta vacía");
			}
			
		}
		
		if(posicion_x_victima>posicion_x_cazadora && posicion_y_victima>posicion_y_cazadora) {
			if(matriz[ posicion_x_cazadora+2][posicion_y_cazadora+2]==null) {
				if(cazadora.getColor()==0) {
					matriz[ posicion_x_cazadora+2][posicion_y_cazadora+2]=new Ficha_Negra(posicion_x_cazadora+2,posicion_y_cazadora+2);
				}
				
				if(cazadora.getColor()==1) {
					matriz[ posicion_x_cazadora+2][posicion_y_cazadora+2]=new Ficha_Blanca(posicion_x_cazadora+2,posicion_y_cazadora+2);
				}
				
				eliminarFicha(posicion_x_cazadora,posicion_y_cazadora);
				eliminarFicha( posicion_x_victima,posicion_y_victima);
				
			}else {
				System.out.println("la posición para comer no esta vacía");
			}
			
		}
		
		
		if(posicion_x_victima>posicion_x_cazadora && posicion_y_victima<posicion_y_cazadora) {
			if(matriz[ posicion_x_cazadora+2][posicion_y_cazadora-2]==null) {
				if(cazadora.getColor()==0) {
					matriz[ posicion_x_cazadora+2][posicion_y_cazadora-2]=new Ficha_Negra(posicion_x_cazadora+2,posicion_y_cazadora-2);
				}
				
				if(cazadora.getColor()==1) {
					matriz[ posicion_x_cazadora+2][posicion_y_cazadora-2]=new Ficha_Blanca(posicion_x_cazadora+2,posicion_y_cazadora-2);
				}
				
				eliminarFicha(posicion_x_cazadora,posicion_y_cazadora);
				eliminarFicha( posicion_x_victima,posicion_y_victima);
				
			}else {
				System.out.println("la posición para comer no esta vacía");
			}
			
		}
		
		
		if(posicion_x_victima<posicion_x_cazadora && posicion_y_victima<posicion_y_cazadora) {
			if(matriz[ posicion_x_cazadora-2][posicion_y_cazadora-2]==null) {
				if(cazadora.getColor()==0) {
					matriz[ posicion_x_cazadora-2][posicion_y_cazadora-2]=new Ficha_Negra(posicion_x_cazadora-2,posicion_y_cazadora-2);
				}
				
				if(cazadora.getColor()==1) {
					matriz[ posicion_x_cazadora-2][posicion_y_cazadora-2]=new Ficha_Blanca(posicion_x_cazadora-2,posicion_y_cazadora-2);
				}
				
				eliminarFicha(posicion_x_cazadora,posicion_y_cazadora);
				eliminarFicha( posicion_x_victima,posicion_y_victima);
				
			}else {
				System.out.println("la posición para comer no esta vacía");
			}
			
		}
		
	}
	

}
