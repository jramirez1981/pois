package ar.com.curso.poi.kata.tdd;

import java.util.List;

import org.junit.Test;

import ar.com.curso.poi.controladores.Servicios;
import ar.com.curso.poi.model.Pois;
import static org.assertj.core.api.Assertions.*;

public class TestBuenosAiresTurismos {

	@Test
	public void buscarLosPOisDeTurismoBuenosAiresDebeDevolverCuatroPois() throws Exception {
		List<Pois> pois = Servicios.obtener("buenos-aires-turismo");
		assertThat(pois).hasSize(4);
	}
	
	@Test
	public void buscarLosPOisDeUnServicioQueNoNoTienePoisDeListaVacia() throws Exception {
		List<Pois> pois = Servicios.obtener("buenos-aires");
		assertThat(pois).isEmpty();
	}
	
	@Test(expected=Exception.class)
	public void buscarLosPOisDeUnServicioQueNoExisteDebeDarError() throws Exception {
		Servicios.obtener("buenos-airesWWWW");
	}
}
