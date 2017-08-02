package ar.com.curso.poi.controladores;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ar.com.curso.poi.model.Pois;

@Path("/")
public class ControladorHome {

	@GET
	@Path("/test")
	public String hola(){
		return "Test OK!";
	}
	
	@GET
	@Path("/{servicio}/pois")
	@Produces(MediaType.APPLICATION_XML)
	public RespuestaServicio mostrarPois(@PathParam("servicio") String servicio) {
		RespuestaServicio respuesta = new RespuestaServicio();
		try {
			respuesta.setResultado(Servicios.obtener(servicio));
			respuesta.setStatus("OK");
		} catch (Exception e) {
			respuesta.setStatus(e.getMessage());
		}
		return respuesta;
	}
	
//	@GET
//	@Path("/pois-vacios")
//	@Produces(MediaType.APPLICATION_XML)
//	public List<Pois> mostrarPoisVacios(){
//		List<Pois> poisVacios = this.pois;
//		poisVacios.clear();
//		
//		return poisVacios;
//	}

	@GET
	@Path("{servicio}/pizzerias-de-buenos-aires/pois")
	@Produces({MediaType.APPLICATION_XML})
	public List<Pois> pizzerias(@PathParam("servicio") String servicio) throws Exception{
		List<Pois> poisPizzerias = new ArrayList<>();
		for (Pois poi : Servicios.obtener(servicio)) {
			if (poi.getType().equals("Pizzeria")) {
				poisPizzerias.add(poi);
			}
		}

		return poisPizzerias;
	}

	@GET
	@Path("/pois-cercanos")
	@Produces({MediaType.APPLICATION_XML})
	public String poisCercanos(@PathParam("latitud") Double latitudInicial, @PathParam("longitud") Double longitudInicial){
		String respuesta = "{\"status\":\"FAIL\"}";

		/*Haversine calculador = new Haversine();

		for (Pois poi : this.pois) {
			if (poi.getType().equals("Pizzeria")) {
				System.out.println("Distancias: " + calculador.distance(latitudInicial, longitudInicial, poi.getLat(), poi.getLon()) + " - " + poi.getName());
			}
		}*/


		try {

		} catch (Exception e) {
			e.printStackTrace();
		}


		return respuesta;
	}

	@GET
	@Path("{servicio}/poi-mas-cercanos/{latitud}/{longitud}")
	@Produces({MediaType.APPLICATION_XML})
	public Pois poiMasCercanos(@PathParam("servicio") String servicio,@PathParam("latitud") Double latitudInicial, @PathParam("longitud") Double longitudInicial) throws Exception{
		CalculaDistancia calculo = new CalculaDistancia();
		Pois poiMasCercano = new Pois();
		poiMasCercano = calculo.obtenerDistanciaMasCorta(servicio,latitudInicial, longitudInicial);
		return poiMasCercano;
	}
	
	
}
