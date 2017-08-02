package ar.com.curso.poi.kata.tdd;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;


public class TestCerradura {
		
	Cerradura cerradura = new Cerradura(1234,3);
	
	@Test 
	public void alAbrirConClaveIncorrectaMasdeNVecesNoConsecutivasNoDeberiaBloquearse() {
		cerradura.abrir(3);
		cerradura.abrir(3);
		cerradura.abrir(12343);
		cerradura.abrir(3);
		assertThat(cerradura.estaBloqueada()).isFalse();
	}
	
	@Test 
	public void alAbrirConClaveErroneaMenosdeNVecesNoSeDeberiaBloquear() {
		cerradura.abrir(3);
		assertThat(cerradura.estaBloqueada()).isFalse();
	}
	
	@Test 
	public void alAbrirConClaveIncorrectaNVecesConsecutivasDeberiaBloquear() {
		cerradura.abrir(3);
		cerradura.abrir(3);
		cerradura.abrir(3);
		assertThat(cerradura.estaBloqueada()).isTrue();
	}
	
	@Test 
	public void abrirCerraduraClaveIncorrecta() {
		assertThat(cerradura.estaCerrada()).isFalse();
	}
	@Test
	public void abrirCerraduraClaveCorrecta() {
			cerradura.abrir(1234);
			assertThat(cerradura.estaCerrada()).isFalse();
	}
	
	@Test
	public void alAbrirConClaveIncorrectaNoDeberiaAbrirLaCerradura() {
		cerradura.abrir(1);
		assertThat(cerradura.estaCerrada()).isTrue();
	}
	

}
