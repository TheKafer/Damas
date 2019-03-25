package damas;

class GestorFichas {
    private FichaRoja inicioR;
    private FichaNegra inicioN;
    private int fichasR, fichasN;
    
    private Fichas fichaSeleccionada, obligada;
    private boolean turnoR;
    private int mode;

    GestorFichas(){
    	inicioR = null;
    	inicioN = null;
        agregarRojas();
        agregarNegras();
        fichasR = 12;
        fichasN = 12;
    }

	public boolean getTurnoR() {
		return (this.turnoR); 
	}

	public int getMode() {
		return (this.mode); 
	}


	public void setTurnoR(boolean turnoR) {
		this.turnoR = turnoR; 
	}
	
 	public boolean puedeMoverse(Fichas f){
    	Fichas fr = new FichaNegra(1,1);
	  	if(f.getCorona())
	    	if(f.esRoja()){
	    		if(f.getYp()>1&&f.getXp()>1&&(fr =buscarFicha(f.getXp()-1,f.getYp()-1))==null)
	    				return true;
	    		if(!fr.esRoja()&&f.getXp()>2&&f.getYp()>2&&buscarFicha(f.getXp()-2,
	    			f.getYp()-2)==null)
	    				return true;
	    				
	    		if(f.getYp()>1&&f.getXp()<8&&(fr = buscarFicha(f.getXp()+1,f.getYp()-1))==null)
	    				return true;
	    		if(!fr.esRoja()&&f.getXp()<7&&f.getYp()>2&&buscarFicha(f.getXp()+2,
	    			f.getYp()-2)==null)
	    				return true;	
	    		
	    	}else{
	    		if(f.getYp()<8&&f.getXp()<8&&(fr = buscarFicha(f.getXp()+1,f.getYp()+1))==null)
	    				return true;
	    		if(fr.esRoja()&&f.getXp()<7&&f.getYp()<7&&buscarFicha(f.getXp()+2,
	    			f.getYp()+2)==null)
	    				return true;
	    				
	    		if(f.getYp()<8&&f.getXp()>1&&(fr = buscarFicha(f.getXp()-1,f.getYp()+1))==null)
	    				return true;
	    		if(fr.esRoja()&&f.getXp()>2&&f.getYp()<7&&buscarFicha(f.getXp()-2,
	    			f.getYp()+2)==null)
	    				return true;	
	    		
	    	}
	    	
		if(f.esRoja()){
	    	if(f.getYp()<8&&f.getXp()>1&&(fr = buscarFicha(f.getXp()-1,f.getYp()+1))==null)
	    			return true;
	    	if(!fr.esRoja()&&f.getXp()>2&&f.getYp()<7&&buscarFicha(f.getXp()-2,
	    		f.getYp()+2)==null)
	    			return true;
	    			
	    	if(f.getYp()<8&&f.getXp()<8&&(fr = buscarFicha(f.getXp()+1,f.getYp()+1))==null)
	    			return true;
	    	if(!fr.esRoja()&&f.getXp()<7&&f.getYp()<7&&buscarFicha(f.getXp()+2,
	    		f.getYp()+2)==null)
	    			return true;	
	    	
	   	}else{
	   		if(f.getYp()>1&&f.getXp()<8&&(fr = buscarFicha(f.getXp()+1,f.getYp()-1))==null)
	   				return true;
	   		if(fr.esRoja()&&f.getXp()<7&&f.getYp()>2&&buscarFicha(f.getXp()+2,
	   			f.getYp()-2)==null)
	   				return true;
	   				
	   		if(f.getYp()>1&&f.getXp()>1&&(fr = buscarFicha(f.getXp()-1,f.getYp()-1))==null)
	   				return true;
	   		if(fr.esRoja()&&f.getXp()>2&&f.getYp()>2&&buscarFicha(f.getXp()-2,
	   			f.getYp()-2)==null)
	   				return true;	
	   		
	   	}
	   	
	   	return false;
	
    }
    
    public boolean hayMovimiento(){
    	Fichas[] ficha;
    	int i;
    	if(turnoR){
    		ficha = this.fichasRojas();
    		
    		for(i=0; i<ficha.length; i++)
    			if(puedeMoverse(ficha[i])){
    				return true;
    			}
    		
    	}else
    	{
    		ficha = this.fichasNegras();
    		
    		for(i = 0; i<ficha.length; i++)
    			if(puedeMoverse(ficha[i]))
    				return true;
    	}
    	
    	return false;
    }
    
    public boolean puedeComer(Fichas f){
    	if(f.getXp()<7&&f.getYp()<7)
    	if(buscarFicha(f.getXp()+1,f.getYp()+1)!=null&&buscarFicha(f.getXp()+1,f.getYp()+1).esRoja()!=f.esRoja())
    		if(buscarFicha(f.getXp()+2,f.getYp()+2)==null)
    			if(f.esRoja())
    				return true;
    			else if(f.getCorona())
    					return true;
    			
    	if(f.getXp()>2&&f.getYp()<7)
    	if(buscarFicha(f.getXp()-1,f.getYp()+1)!=null&&buscarFicha(f.getXp()-1,f.getYp()+1).esRoja()!=f.esRoja())
    		if(buscarFicha(f.getXp()-2,f.getYp()+2)==null)
    			if(f.esRoja())
    				return true;
    			else if(f.getCorona())
    					return true;
    					
    	if(f.getXp()<7&&f.getYp()>2)
    	if(buscarFicha(f.getXp()+1,f.getYp()-1)!=null&&buscarFicha(f.getXp()+1,f.getYp()-1).esRoja()!=f.esRoja())
    		if(buscarFicha(f.getXp()+2,f.getYp()-2)==null)
    			if(!f.esRoja())
    				return true;
    			else if(f.getCorona())
    					return true;
    					
    	if(f.getXp()>2&&f.getYp()>2)
    	if(buscarFicha(f.getXp()-1,f.getYp()-1)!=null&&buscarFicha(f.getXp()-1,f.getYp()-1).esRoja()!=f.esRoja())
    		if(buscarFicha(f.getXp()-2,f.getYp()-2)==null)
    			if(!f.esRoja())
    				return true;
    			else if(f.getCorona())
    					return true;
    	return false;
 
    }
    
    public boolean posibilidadComer(){
    	Fichas [] f;
    	int i;
    	
    	if(turnoR){
    		 f = fichasRojas();
    		for(i = 0;i<getFichasR(); i++){
    			if(this.puedeComer(f[i]))
    				return true;
    		}
    	}else
    	{
    		f = fichasNegras();
    		
    		for(i=0; i<getFichasN(); i++)
    			if(this.puedeComer(f[i]))
    				return true;
    	}
    	
    	return false;
    }
    
    public boolean posibilidadComerE(){
    	Fichas [] f;
    	int i;
    	
    	if(!turnoR){
    		 f = fichasRojas();
    		for(i = 0;i<getFichasR(); i++){
    			if(this.puedeComer(f[i]))
    				return true;
    		}
    	}else
    	{
    		f = fichasNegras();
    		
    		for(i=0; i<getFichasN(); i++)
    			if(this.puedeComer(f[i]))
    				return true;
    	}
    	
    	return false;
    }
    
    public void seleccinarFicha(int x, int y){
    	Fichas f;
    	f = buscarFicha(x,y);
    	
    	if(f!=null){
    	if(obligada==null){
    	if(f.isSelect()){
    		f.deseleccionar();
    		fichaSeleccionada = null;
    	}else{
    		if(!posibilidadComer()){
	    		if(puedeMoverse(f)){
	    			if(fichaSeleccionada == null){
		    			f.seleccionar();
		    			fichaSeleccionada = f;
	    			}else
	    			{
	    				fichaSeleccionada.deseleccionar();
	    				f.seleccionar();
	    				fichaSeleccionada = f;
	    			}
	    		}
    		}
	    	else
	    		if(puedeComer(f))
	    			if(fichaSeleccionada == null){
		    			f.seleccionar();
		    			fichaSeleccionada = f;
	    			}else
	    			{
	    				fichaSeleccionada.deseleccionar();
	    				f.seleccionar();
	    				fichaSeleccionada = f;
	    			}
	    				
    	}
    	}else
    		if(f==obligada){
    			if(obligada.isSelect()){
    				f.deseleccionar();
    				fichaSeleccionada = null;
    			}else{
    				f.seleccionar();
    				fichaSeleccionada = f;
    			}
    		}
    	}
    }

   
	
	public void setMode(int mode) {
		this.mode = mode; 
	}

	public boolean moverPieza(int x, int y){
		int a,b;
		a = x-fichaSeleccionada.getXp();
		b = y-fichaSeleccionada.getYp();
		
		if(signo(a)<=2&&signo(b)<=2){
			if(fichaSeleccionada.esRoja()){
				if(!puedeComer(fichaSeleccionada))
				if(signo(a)==1&&signo(b)==1){
					if(fichaSeleccionada.getCorona()){
						fichaSeleccionada.setLocation((x-1)*60,(8-y)*60);
						fichaSeleccionada.moverFicha(x,y);
						fichaSeleccionada.deseleccionar();
						obligada = null;
						fichaSeleccionada = null;
						return true;
					}
					
					if(y > fichaSeleccionada.getYp()){
						fichaSeleccionada.setLocation((x-1)*60,(8-y)*60);
						fichaSeleccionada.moverFicha(x,y);
						fichaSeleccionada.deseleccionar();
						obligada = null;
						if(y==8)
							fichaSeleccionada.coronar();
						fichaSeleccionada = null;
						return true;
					}
					return false;
				}
				
				if(a>0&&b>0){
					if(buscarFicha(x-1,y-1)!=null&&!buscarFicha(x-1,y-1).esRoja()){
						//buscarFicha(x-1,y-1).setLocation(1000,1000);
						comerNegra((FichaNegra)buscarFicha(x-1,y-1));
						fichaSeleccionada.setLocation((x-1)*60,(8-y)*60);
						fichaSeleccionada.moverFicha(x,y);
						fichaSeleccionada.deseleccionar();
						obligada = null;
						if(y==8)
							fichaSeleccionada.coronar();
						if(puedeComer(fichaSeleccionada)){
							turnoR =!turnoR;
							obligada = fichaSeleccionada;
						}
						fichaSeleccionada = null;
						
						return true;
					}
					return false;
				}
				
				if(a<0&&b>0)
				{
					if(buscarFicha(x+1,y-1)!=null&&!buscarFicha(x+1,y-1).esRoja()){
						//buscarFicha(x+1,y-1).setLocation(1000,1000);
						comerNegra((FichaNegra)buscarFicha(x+1,y-1));
						fichaSeleccionada.setLocation((x-1)*60,(8-y)*60);
						fichaSeleccionada.moverFicha(x,y);
						fichaSeleccionada.deseleccionar();
						obligada = null;
						if(y==8)
							fichaSeleccionada.coronar();
						if(puedeComer(fichaSeleccionada)){
							turnoR =!turnoR;
							obligada = fichaSeleccionada;
						}
						fichaSeleccionada = null;
						return true;
					}
					return false;	
				}
				
				if(fichaSeleccionada.getCorona()){
					if(a>0&&b<0){
						if(buscarFicha(x-1,y+1)!=null&&!buscarFicha(x-1,y+1).esRoja()){
							//buscarFicha(x-1,y+1).setLocation(1000,1000);
							comerNegra((FichaNegra)buscarFicha(x-1,y+1));
							fichaSeleccionada.setLocation((x-1)*60,(8-y)*60);
							fichaSeleccionada.moverFicha(x,y);
							fichaSeleccionada.deseleccionar();
							obligada = null;
							if(puedeComer(fichaSeleccionada)){
								turnoR =!turnoR;
								obligada = fichaSeleccionada;
							}
							fichaSeleccionada = null;
							return true;
						}
						return false;
					}
					
					if(a<0&&b<0)
					{
						if(buscarFicha(x+1,y+1)!=null&&!buscarFicha(x+1,y+1).esRoja()){
							buscarFicha(x+1,y+1).setLocation(1000,1000);
							comerNegra((FichaNegra)buscarFicha(x+1,y+1));
							fichaSeleccionada.setLocation((x-1)*60,(8-y)*60);
							fichaSeleccionada.moverFicha(x,y);
							fichaSeleccionada.deseleccionar();
							obligada = null;
							if(puedeComer(fichaSeleccionada)){
								turnoR =!turnoR;
								obligada = fichaSeleccionada;
							}
							fichaSeleccionada = null;
							return true;
						}
						return false;	
					}
				}
			}else
			{
				if(!puedeComer(fichaSeleccionada))
				if(signo(a)==1&&signo(b)==1){
					if(fichaSeleccionada.getCorona()){
						fichaSeleccionada.setLocation((x-1)*60,(8-y)*60);
						fichaSeleccionada.moverFicha(x,y);
						fichaSeleccionada.deseleccionar();
						obligada = null;
						fichaSeleccionada = null;
						return true;
					}
					
					if(y < fichaSeleccionada.getYp()){
						fichaSeleccionada.setLocation((x-1)*60,(8-y)*60);
						fichaSeleccionada.moverFicha(x,y);
						fichaSeleccionada.deseleccionar();
						obligada = null;
						if(y==1)
							fichaSeleccionada.coronar();
						fichaSeleccionada = null;
						return true;
					}
					return false;
				}
				
				if(a<0&&b<0){
					if(buscarFicha(x+1,y+1)!=null&&buscarFicha(x+1,y+1).esRoja()){
						//buscarFicha(x+1,y+1);
						comerRoja((FichaRoja)buscarFicha(x+1,y+1));
						fichaSeleccionada.setLocation((x-1)*60,(8-y)*60);
						fichaSeleccionada.moverFicha(x,y);
						fichaSeleccionada.deseleccionar();
						obligada = null;
						if(y==1)
							fichaSeleccionada.coronar();
						if(puedeComer(fichaSeleccionada)){
							turnoR =! turnoR;
							obligada = fichaSeleccionada;
						}
						fichaSeleccionada = null;
						return true;
					}
					return false;
				}
				
				if(a>0&&b<0)
				{
					if(buscarFicha(x-1,y+1)!=null&&buscarFicha(x-1,y+1).esRoja()){
						comerRoja((FichaRoja)buscarFicha(x-1,y+1));
						//buscarFicha(x-1,y+1).moverFicha(15,0);
						fichaSeleccionada.setLocation((x-1)*60,(8-y)*60);
						fichaSeleccionada.moverFicha(x,y);
						fichaSeleccionada.deseleccionar();
						obligada = null;
						if(y==1)
							fichaSeleccionada.coronar();
						if(puedeComer(fichaSeleccionada)){
							turnoR =! turnoR;
							obligada = fichaSeleccionada;
						}
						fichaSeleccionada = null;
						return true;
					}
					return false;	
				}
				
				if(fichaSeleccionada.getCorona()){
					if(a>0&&b>0){
						if(buscarFicha(x-1,y-1)!=null&&buscarFicha(x-1,y-1).esRoja()){
							//buscarFicha(x-1,y-1).setLocation(1000,1000);
							comerRoja((FichaRoja)buscarFicha(x-1,y-1));
							fichaSeleccionada.setLocation((x-1)*60,(8-y)*60);
							fichaSeleccionada.moverFicha(x,y);
							fichaSeleccionada.deseleccionar();
							obligada = null;
							if(puedeComer(fichaSeleccionada)){
								turnoR =! turnoR;
								obligada = fichaSeleccionada;
							}
							fichaSeleccionada = null;
							return true;
						}
						return false;
					}
					
					if(a<0&&b>0)
					{
						if(buscarFicha(x+1,y-1)!=null&&buscarFicha(x+1,y-1).esRoja()){
							//buscarFicha(x+1,y-1).setLocation(1000,1000);
							comerRoja((FichaRoja)buscarFicha(x+1,y-1));
							fichaSeleccionada.setLocation((x-1)*60,(8-y)*60);
							fichaSeleccionada.moverFicha(x,y);
							fichaSeleccionada.deseleccionar();
							obligada = null;
							if(puedeComer(fichaSeleccionada)){
								turnoR =!turnoR;
								obligada = fichaSeleccionada;
							}
							fichaSeleccionada = null;
							return true;
						}
						return false;	
					}
				}
			}
			return false;	
		}
		
		return false;
	}
	
	public boolean consumirTurno(int x, int y){
		x = x/60+1;
		y = 8-y/60;
		Fichas f = buscarFicha(x,y);
		
		if(f!=null){
			if(f.esRoja()&&turnoR){
				this.seleccinarFicha(x,y);
			}
			if(!f.esRoja()&&!turnoR){
				this.seleccinarFicha(x,y);
			}	
			return false;		
		}
		
		if(fichaSeleccionada!=null){
				if(moverPieza(x,y)){
					turnoR = !turnoR;
					return true;
				}
		}
		return false;
	}
		
	public int signo(int x){
		if(x<0)
			x = x*-1;
			
		return x;
	}
	
	
	
	public int cantidadMover(){
		Fichas[] mov;
		int i=0,j;
		if(turnoR){
			mov = fichasRojas();
			if(!posibilidadComer())
			for(j=0;j< mov.length; j++){
				if(puedeMoverse(mov[j]))
					i++;
			}
			if(posibilidadComer())
			for(j=0;j< mov.length; j++){
				if(puedeComer(mov[j]))
					i++;
			}
			
			
		}else{
			mov = fichasNegras();
			if(!posibilidadComer())
			for(j=0;j< mov.length; j++){
				if(puedeMoverse(mov[j]))
					i++;
			}
			if(posibilidadComer())
			for(j=0;j< mov.length; j++){
				if(puedeComer(mov[j]))
					i++;
			}
		}
		
		return i;
	}
	
	public int cantidadMoverE(){
		Fichas[] mov;
		int i=0,j;
		if(!turnoR){
			mov = fichasRojas();
			if(!posibilidadComerE())
			for(j=0;j< mov.length; j++){
				if(puedeMoverse(mov[j]))
					i++;
			}
			if(posibilidadComerE())
			for(j=0;j< mov.length; j++){
				if(puedeComer(mov[j]))
					i++;
			}
			
			
		}else{
			mov = fichasNegras();
			if(!posibilidadComerE())
			for(j=0;j< mov.length; j++){
				if(puedeMoverse(mov[j]))
					i++;
			}
			if(posibilidadComerE())
			for(j=0;j< mov.length; j++){
				if(puedeComer(mov[j]))
					i++;
			}
		}
		
		return i;
	}
	
	public Fichas[] fichasMovimiento(){
		int i,j;
		Fichas[] mover = new Fichas[cantidadMover()];
		Fichas[] a;
		if(obligada!=null){
			mover = new Fichas[1];
			mover[0] = obligada;
			return mover;
		}
		
		if(turnoR){
			a = fichasRojas();
			j=0;
			if(!this.posibilidadComer())
			for(i=0;i<a.length;i++){
				if(puedeMoverse(a[i]))
					mover[j++]=a[i];
			}
			
			if(this.posibilidadComer())
			for(i=0;i<a.length;i++){
				if(puedeComer(a[i]))
					mover[j++]=a[i];
			}
		}else{
			a = fichasNegras();
			j=0;
			if(!this.posibilidadComer())
			for(i=0;i<a.length;i++){
				if(puedeMoverse(a[i]))
					mover[j++]=a[i];
			}
			
			if(this.posibilidadComer())
			for(i=0;i<a.length;i++){
				if(puedeComer(a[i]))
					mover[j++]=a[i];
			}
		}
		
		return mover;
	}
	
	public Fichas[] fichasMovimientoE(){
		int i,j;
		Fichas[] mover = new Fichas[this.cantidadMoverE()];
		Fichas[] a;
		
		if(!turnoR){
			a = fichasRojas();
			j=0;
			if(!this.posibilidadComerE())
			for(i=0;i<a.length;i++){
				if(puedeMoverse(a[i]))
					mover[j++]=a[i];
			}
			
			if(this.posibilidadComerE())
			for(i=0;i<a.length;i++){
				if(puedeComer(a[i]))
					mover[j++]=a[i];
			}
		}else{
			a = fichasNegras();
			j=0;
			if(!this.posibilidadComerE())
			for(i=0;i<a.length;i++){
				if(puedeMoverse(a[i]))
					mover[j++]=a[i];
			}
			
			if(this.posibilidadComerE())
			for(i=0;i<a.length;i++){
				if(puedeComer(a[i]))
					mover[j++]=a[i];
			}
		}
		
		return mover;
	}

    public void moverNegrasPC(){
		Fichas[] pM = fichasMovimiento();
		Movimiento[] mE = new GestorMovimiento(this,fichasMovimientoE()).getMovimientos();
		Movimiento[] m = new GestorMovimiento(this,pM).getMovimientos();
		Movimiento[] aux;
		Fichas auxi;
		int i,x,y,xx,yy;
		if(!posibilidadComer()){
			if(mE.length!=0&&puedeComer(mE[0].getFicha())){
				for(i = 0; i<mE.length; i++){
					for(int j=0; j<m.length; j++){
						if(mE[i].getX()==m[j].getX()&&mE[i].getY()==m[j].getY()){
							fichaSeleccionada = m[j].getFicha();
							if(moverPieza(m[j].getX(),m[j].getY()))
								turnoR = !turnoR;
							return;
						}
					}
				}

				for(i = 0; i<mE.length; i++){
					for(int j=0; j<m.length; j++){
						x = ((mE[i].getX()-mE[i].getFicha().getXp())<0)?mE[i].getX()+1:mE[i].getX()-1;
						y = ((mE[i].getY()-mE[i].getFicha().getYp())<0)?mE[i].getY()+1:mE[i].getY()-1;
						if(buscarFicha(x,y).equals(m[j].getFicha()))
						{
							x = m[j].getFicha().getXp();
							y = m[j].getFicha().getYp();
							m[j].realizarMovimiento();
							aux = new GestorMovimiento(this,fichasMovimientoE()).getMovimientos();
							if(aux.length!=0&&puedeComer(aux[0].getFicha())){
								m[j].getFicha().moverFicha(x,y);
								break;
							}
							m[j].getFicha().moverFicha(x,y);
							fichaSeleccionada = m[j].getFicha();
							if(moverPieza(m[j].getX(),m[j].getY()))
								turnoR = !turnoR;
							return;
						}
					}
				}

				for(i=0;i<m.length;i++){
					if(m[i].getY()==1&&!m[i].getFicha().getCorona()){
						fichaSeleccionada = m[i].getFicha();
						if(moverPieza(m[i].getX(),m[i].getY()))
							turnoR = !turnoR;
						return;
					}
				}

				i =(int)(Math.random()*m.length);

				fichaSeleccionada = m[i].getFicha();
				if(moverPieza(m[i].getX(),m[i].getY()))
					turnoR = !turnoR;
				return;

			}else{
				for(i=0;i<m.length;i++){
					if(m[i].getY()==1&&!m[i].getFicha().getCorona()){
						fichaSeleccionada = m[i].getFicha();
						if(moverPieza(m[i].getX(),m[i].getY()))
							turnoR = !turnoR;
						return;
					}
				}

				for(i=0; i<m.length; i++){
					x = m[i].getFicha().getXp();
					y = m[i].getFicha().getYp();
					m[i].realizarMovimiento();
					aux = new GestorMovimiento(this,fichasMovimientoE()).getMovimientos();
					if(aux.length!=0&&puedeComer(aux[0].getFicha())){
						m[i].getFicha().moverFicha(x,y);
						i++;
						continue;
					}
					m[i].getFicha().moverFicha(x,y);
					fichaSeleccionada = m[i].getFicha();
					if(moverPieza(m[i].getX(),m[i].getY()))
						turnoR = !turnoR;
					return;
				}

				i =(int)(Math.random()*m.length);

				fichaSeleccionada = m[i].getFicha();
				if(moverPieza(m[i].getX(),m[i].getY()))
					turnoR = !turnoR;
				return;

			}

		}else{
			if(obligada!=null){
				for(i = 0; i<m.length; i++){
					x = m[i].getFicha().getXp();
					y = m[i].getFicha().getYp();
					m[i].realizarMovimiento();
					aux = GestorMovimiento.movFicha(this,m[i].getFicha());
					for(int j=0; j<aux.length; j++){
						if(aux[j].getX()!=x||aux[j].getY()!=y){
							xx = aux[j].getFicha().getXp();
							yy = aux[j].getFicha().getYp();
							aux[j].realizarMovimiento();
							if(GestorMovimiento.movFicha(this,aux[j].getFicha()).length<1&&
								aux[j].getFicha().getCorona())
							{
									m[i].getFicha().moverFicha(x,y);
									fichaSeleccionada = m[i].getFicha();
									if(moverPieza(m[i].getX(),m[i].getY()))
										turnoR = !turnoR;
									return;
							}
							if(GestorMovimiento.movFicha(this,aux[j].getFicha()).length<0&&
								!aux[j].getFicha().getCorona()){
									m[i].getFicha().moverFicha(x,y);
									fichaSeleccionada = m[i].getFicha();
									if(moverPieza(m[i].getX(),m[i].getY()))
										turnoR = !turnoR;
									return;

							}
							aux[j].getFicha().moverFicha(xx,yy);
						}

					}
					m[i].getFicha().moverFicha(x,y);
				}

			}

			for(i = 0; i<m.length; i++){
				x = m[i].getFicha().getXp();
				y = m[i].getFicha().getYp();
				m[i].realizarMovimiento();
				aux = GestorMovimiento.movFicha(this,m[i].getFicha());
				for(int j=0; j<aux.length; j++){
					if(aux[j].getX()!=x||aux[j].getY()!=y){
						xx = aux[j].getFicha().getXp();
						yy = aux[j].getFicha().getYp();
						aux[j].realizarMovimiento();
						if(GestorMovimiento.movFicha(this,aux[j].getFicha()).length<1&&
							aux[j].getFicha().getCorona())
						{
								m[i].getFicha().moverFicha(x,y);
								fichaSeleccionada = m[i].getFicha();
								if(moverPieza(m[i].getX(),m[i].getY()))
									turnoR = !turnoR;
								return;
						}
						if(GestorMovimiento.movFicha(this,aux[j].getFicha()).length<0&&
							!aux[j].getFicha().getCorona()){
								m[i].getFicha().moverFicha(x,y);
								fichaSeleccionada = m[i].getFicha();
								if(moverPieza(m[i].getX(),m[i].getY()))
									turnoR = !turnoR;
								return;

						}
						aux[j].getFicha().moverFicha(xx,yy);
					}

				}
				m[i].getFicha().moverFicha(x,y);
			}



			for(i = 0; i<m.length; i++){
				x = m[i].getFicha().getXp();
				y = m[i].getFicha().getYp();
				xx = ((m[i].getX()-m[i].getFicha().getXp())<0)?m[i].getX()+1:m[i].getX()-1;
				yy = ((m[i].getY()-m[i].getFicha().getYp())<0)?m[i].getY()+1:m[i].getY()-1;
				m[i].realizarMovimiento();
				comerRoja((FichaRoja)buscarFicha(xx,yy));
				aux = new GestorMovimiento(this,fichasMovimientoE()).getMovimientos();
				if(aux.length!=0&&!puedeComer(aux[0].getFicha())){
					agregarRoja(xx,yy);
					m[i].getFicha().moverFicha(x,y);
								fichaSeleccionada = m[i].getFicha();
								if(moverPieza(m[i].getX(),m[i].getY()))
									turnoR = !turnoR;
								return;
				}
				agregarRoja(xx,yy);
				m[i].getFicha().moverFicha(x,y);
			}

			i =(int)(Math.random()*m.length);

			fichaSeleccionada = m[i].getFicha();
			if(moverPieza(m[i].getX(),m[i].getY()))
				turnoR = !turnoR;
			return;

		}


	}
	
	public void moverRojasPC(){
		Fichas[] pM = fichasMovimiento();
		Movimiento[] mE = new GestorMovimiento(this,fichasMovimientoE()).getMovimientos();
		Movimiento[] m = new GestorMovimiento(this,pM).getMovimientos();
		Movimiento[] aux;
		Fichas auxi;
		int i,x,y,xx,yy;
		if(!posibilidadComer()){
			if(mE.length!=0&&puedeComer(mE[0].getFicha())){
				for(i = 0; i<mE.length; i++){
					for(int j=0; j<m.length; j++){
						if(mE[i].getX()==m[j].getX()&&mE[i].getY()==m[j].getY()){
							fichaSeleccionada = m[j].getFicha();
							if(moverPieza(m[j].getX(),m[j].getY()))
								turnoR = !turnoR;
							return;
						}
					}
				}
				
				for(i = 0; i<mE.length; i++){
					for(int j=0; j<m.length; j++){
						x = ((mE[i].getX()-mE[i].getFicha().getXp())<0)?mE[i].getX()+1:mE[i].getX()-1;
						y = ((mE[i].getY()-mE[i].getFicha().getYp())<0)?mE[i].getY()+1:mE[i].getY()-1;
						if(buscarFicha(x,y).equals(m[j].getFicha()))
						{
							x = m[j].getFicha().getXp();
							y = m[j].getFicha().getYp();
							m[j].realizarMovimiento();
							aux = new GestorMovimiento(this,fichasMovimientoE()).getMovimientos();
							if(aux.length!=0&&puedeComer(aux[0].getFicha())){
								m[j].getFicha().moverFicha(x,y);
								break;
							}
							m[j].getFicha().moverFicha(x,y);
							fichaSeleccionada = m[j].getFicha();
							if(moverPieza(m[j].getX(),m[j].getY()))
								turnoR = !turnoR;
							return;
						}
					}
				}
				
				for(i=0;i<m.length;i++){
					if(m[i].getY()==8&&!m[i].getFicha().getCorona()){
						fichaSeleccionada = m[i].getFicha();
						if(moverPieza(m[i].getX(),m[i].getY()))
							turnoR = !turnoR;
						return;
					}
				}
				
				i =(int)(Math.random()*m.length);
				
				fichaSeleccionada = m[i].getFicha();
				if(moverPieza(m[i].getX(),m[i].getY()))
					turnoR = !turnoR;
				return;
				
			}else{
				for(i=0;i<m.length;i++){
					if(m[i].getY()==8&&!m[i].getFicha().getCorona()){
						fichaSeleccionada = m[i].getFicha();
						if(moverPieza(m[i].getX(),m[i].getY()))
							turnoR = !turnoR;
						return;
					}
				}
				
				for(i=0; i<m.length; i++){
					x = m[i].getFicha().getXp();
					y = m[i].getFicha().getYp();
					m[i].realizarMovimiento();
					aux = new GestorMovimiento(this,fichasMovimientoE()).getMovimientos();
					if(aux.length!=0&&puedeComer(aux[0].getFicha())){
						m[i].getFicha().moverFicha(x,y);
						i++;
						continue;
					}
					m[i].getFicha().moverFicha(x,y);
					fichaSeleccionada = m[i].getFicha();
					if(moverPieza(m[i].getX(),m[i].getY()))
						turnoR = !turnoR;
					return;
				}
				
				i =(int)(Math.random()*m.length);
				
				fichaSeleccionada = m[i].getFicha();
				if(moverPieza(m[i].getX(),m[i].getY()))
					turnoR = !turnoR;
				return;
					
			}
			
		}else{
			if(obligada!=null){
				for(i = 0; i<m.length; i++){
					x = m[i].getFicha().getXp();
					y = m[i].getFicha().getYp();
					m[i].realizarMovimiento();
					aux = GestorMovimiento.movFicha(this,m[i].getFicha());
					for(int j=0; j<aux.length; j++){
						if(aux[j].getX()!=x||aux[j].getY()!=y){
							xx = aux[j].getFicha().getXp();
							yy = aux[j].getFicha().getYp();
							aux[j].realizarMovimiento();
							if(GestorMovimiento.movFicha(this,aux[j].getFicha()).length>1&&
								aux[j].getFicha().getCorona())
							{
									m[i].getFicha().moverFicha(x,y);
									fichaSeleccionada = m[i].getFicha();
									if(moverPieza(m[i].getX(),m[i].getY()))
										turnoR = !turnoR;
									return;		
							}
							if(GestorMovimiento.movFicha(this,aux[j].getFicha()).length>0&&
								!aux[j].getFicha().getCorona()){
									m[i].getFicha().moverFicha(x,y);
									fichaSeleccionada = m[i].getFicha();
									if(moverPieza(m[i].getX(),m[i].getY()))
										turnoR = !turnoR;
									return;	
									
							}
							aux[j].getFicha().moverFicha(xx,yy);
						}
						
					}
					m[i].getFicha().moverFicha(x,y);
				}
				
			}
			
			for(i = 0; i<m.length; i++){
				x = m[i].getFicha().getXp();
				y = m[i].getFicha().getYp();
				m[i].realizarMovimiento();
				aux = GestorMovimiento.movFicha(this,m[i].getFicha());
				for(int j=0; j<aux.length; j++){
					if(aux[j].getX()!=x||aux[j].getY()!=y){
						xx = aux[j].getFicha().getXp();
						yy = aux[j].getFicha().getYp();
						aux[j].realizarMovimiento();
						if(GestorMovimiento.movFicha(this,aux[j].getFicha()).length<1&&
							aux[j].getFicha().getCorona())
						{
								m[i].getFicha().moverFicha(x,y);
								fichaSeleccionada = m[i].getFicha();
								if(moverPieza(m[i].getX(),m[i].getY()))
									turnoR = !turnoR;
								return;		
						}
						if(GestorMovimiento.movFicha(this,aux[j].getFicha()).length<0&&
							!aux[j].getFicha().getCorona()){
								m[i].getFicha().moverFicha(x,y);
								fichaSeleccionada = m[i].getFicha();
								if(moverPieza(m[i].getX(),m[i].getY()))
									turnoR = !turnoR;
								return;	
								
						}
						aux[j].getFicha().moverFicha(xx,yy);
					}
					
				}
				m[i].getFicha().moverFicha(x,y);
			}
			
			
			
			for(i = 0; i<m.length; i++){
				x = m[i].getFicha().getXp();
				y = m[i].getFicha().getYp();
				xx = ((m[i].getX()-m[i].getFicha().getXp())<0)?m[i].getX()+1:m[i].getX()-1;
				yy = ((m[i].getY()-m[i].getFicha().getYp())<0)?m[i].getY()+1:m[i].getY()-1;
				m[i].realizarMovimiento();
				comerNegra((FichaNegra)buscarFicha(xx,yy));
				aux = new GestorMovimiento(this,fichasMovimientoE()).getMovimientos();
				if(aux.length!=0&&!puedeComer(aux[0].getFicha())){
					agregarNegra(xx,yy);
					m[i].getFicha().moverFicha(x,y);
								fichaSeleccionada = m[i].getFicha();
								if(moverPieza(m[i].getX(),m[i].getY()))
									turnoR = !turnoR;
								return;	
				}
				agregarNegra(xx,yy);
				m[i].getFicha().moverFicha(x,y);
			}
			
			i =(int)(Math.random()*m.length);
			
			fichaSeleccionada = m[i].getFicha();
			if(moverPieza(m[i].getX(),m[i].getY()))
				turnoR = !turnoR;
			return;
			
		}
		
		
	}
	
	public int fichasRR(){
		int i, cont = 0;
		for(i=0;i<fichasR;i++)
			if(fichasRojas()[i].getCorona()){
				cont++;
			}
		return cont;
	}
	
	public int fichasNR(){
		int i, cont = 0;
		for(i=0;i<fichasN;i++)
			if(fichasNegras()[i].getCorona()){
				cont++;
			}
		return cont;
	}

	public Fichas[] fichasNegras(){
		Fichas[] negras = new Fichas[fichasN];
		
		FichaNegra temp = inicioN;
		
		int i = 0;
		
		while(temp!=null){
			negras[i++] = temp;
			temp = temp.getNext();
		}
		
		return negras;
	}
	
	public Fichas[] fichasRojas(){
		Fichas[] rojas = new Fichas[fichasR];
		
		FichaRoja temp = inicioR;
		
		int i = 0;
		
		while(temp!=null){
			rojas[i++] = temp;
			temp = temp.getNext();
		}
		
		return rojas;
	}

    public Fichas[] getFichas(){
        Fichas[] todas = new Fichas[fichasR+fichasN];
        FichaRoja temp = inicioR;
        FichaNegra temp2 = inicioN;
        int ind = 0;
        
        while(temp!=null){
            todas[ind++]=temp;
            temp = temp.getNext();
        }
        while(temp2!=null){
            todas[ind++] = temp2;
            temp2 = temp2.getNext();
        }
        
        return todas;
    }

    public int getFichasN() {
        return fichasN;
    }

    public int getFichasR() {
        return fichasR;
    }

    public void comerRoja(FichaRoja comida)
    {
        if(comida.getPrev()!=null)
            comida.getPrev().setNext(comida.getNext());
        else
            inicioR = inicioR.getNext();
        if(comida.getNext()!=null)
            comida.getNext().setPrev(comida.getPrev());
        fichasR--;

    }

    public void comerNegra(FichaNegra comida){
        if(comida.getPrev()!=null)
            comida.getPrev().setNext(comida.getNext());
        else
            inicioN = inicioN.getNext();
        if(comida.getNext()!=null)
            comida.getNext().setPrev(comida.getPrev());
        fichasN--;

    }

    public Fichas buscarFicha(int x, int y){
        int i;
        FichaRoja tempR = inicioR;
        FichaNegra tempN = inicioN;

        for(i=0;i<fichasR+fichasN; i++){
            if(tempR!=null){
                if(tempR.getXp()==x&&tempR.getYp()==y)
                    return tempR;
                tempR = tempR.getNext();
            }else{
                if(tempN.getXp()==x&&tempN.getYp()==y)
                    return tempN;
                tempN = tempN.getNext();
            }
        }
        return null;
    }

    private void agregarRojas(){
        int i,j;
        for(i=1; i<4; i++)
            if(i%2 == 0)
                for(j = 2; j<9; j=j+2)
                    agregarRoja(j,i);
            else
                for(j=1; j<8; j = j+2)
                    agregarRoja(j,i);
    }

    private void agregarNegras(){
        int i,j;
        for(i=6; i<9; i++)
            if(i%2 == 0)
                for(j = 2; j<9; j=j+2)
                    agregarNegra(j,i);
            else
                for(j=1; j<8; j = j+2)
                    agregarNegra(j,i);

    }

    public void agregarNegra(int x, int y){
        FichaNegra ficha = new FichaNegra(x,y);

		if(inicioN==null)
			inicioN = ficha;
		else{
	   		inicioN.setPrev(ficha);
       		ficha.setNext(inicioN);
       		inicioN = ficha;
		}
		fichasN++;
    }

    public void agregarRoja(int x,int y){
       FichaRoja ficha = new FichaRoja(x,y);

		if(inicioR==null)
			inicioR = ficha;
		else{
	       	inicioR.setPrev(ficha);
	       	ficha.setNext(inicioR);
	       	inicioR = ficha;
		}
		fichasR++;
    }


}
