package ar.com.curso.poi.kata.tdd;

public class Cerradura {
	
	private int claveInicial;
	private boolean estaCerrada = true;
	private int IntentosValidos;
	private boolean estaBloqueada;
	
	public Cerradura (int claveApertur, int intentos) {
		this.claveInicial = claveApertur;
		this.IntentosValidos = intentos;
	}
    
	public boolean estaBloqueada() {
		return estaBloqueada;
	}
	public boolean estaCerrada() {
		// TODO Auto-generated method stub
		return estaCerrada;
	}

	public void abrir(int clave) {
		if (clave == claveInicial) {
			estaCerrada = false;
			this.IntentosValidos = 0;
		}else {
			estaCerrada = true;
			this.IntentosValidos ++;
			if( this.IntentosValidos> 3 ) {
				this.estaBloqueada = true;
			}
		}
		
	}

}
