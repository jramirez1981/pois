package ar.com.curso.poi.kata.tdd;

public class Cerradura {
	
	private int claveInicial;
	private boolean estaCerrada = true;
	private boolean estaBloqueada;
	private int intentos;
	private int intentosFallidos = 0;
	
	public Cerradura (int claveApertur, int intentos) {
		this.claveInicial = claveApertur;
		this.intentos = intentos;
	}
    
	public boolean estaBloqueada() {
		return estaBloqueada;
	}
	public boolean estaCerrada() {
		return estaCerrada;
	}

	public void abrir(int clave) {
		if (clave == claveInicial) {
			estaCerrada = false;
			intentosFallidos = 0;
		}else {
			estaCerrada = true;
			intentosFallidos ++;
			if( intentosFallidos == intentos ) {
				this.estaBloqueada = true;
			}
		}
		
	}

}
