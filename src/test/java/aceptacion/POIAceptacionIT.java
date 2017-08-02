package aceptacion;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import static org.assertj.core.api.Assertions.*;

import org.junit.Test;

public class POIAceptacionIT {

	@Test
	public void poiMasCercanoAMiUbicacion() throws Exception{
		String latitud = "-34.603765";
		String longitud = "-58.381570";
		
		String url = "http://localhost:8080/pois-app/buenos-aires-turismo/poi-mas-cercanos/"+latitud+"/"+longitud;
		
		String respuesta = this.obtenerContenidoRespuesta(url);
		assertThat(respuesta).contains("Cuartetas");
	}
	
	private String obtenerContenidoRespuesta(String url) throws Exception{
		HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
		connection.connect();
		return new BufferedReader(new InputStreamReader(connection.getInputStream())).readLine();
	}
	
}
