package ar.com.curso.poi.controladores;
//LLLLLLL
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ar.com.curso.poi.model.Pois;

@Path("/buenos-aires-turismos")
public class BuenosAiresTurismos {

	private List<Pois> pois = new ArrayList<Pois>();
	private Pois p = new Pois();

	public BuenosAiresTurismos() {
		super();
		this.pois = p.LlenarPoisArray();
	}

	@GET
	@Path("/pois")
	@Produces(MediaType.APPLICATION_XML)
	public List<Pois> mostrarPois(){
		return this.pois;
	}
	
	@GET
	@Path("/pois-vacios")
	@Produces(MediaType.APPLICATION_XML)
	public List<Pois> mostrarPoisVacios(){
		
		return new ArrayList<Pois>();
	}

	@GET
	@Path("/pizzerias-de-buenos-aires/pois")
	@Produces({MediaType.APPLICATION_XML})
	public List<Pois> pizzerias(){
		List<Pois> poisPizzerias = new ArrayList<>();
		for (Pois poi : this.pois) {
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
	@Path("/poi-mas-cercanos/{latitud}/{longitud}")
	@Produces({MediaType.APPLICATION_XML})
	public Pois poiMasCercanos(@PathParam("latitud") Double latitudInicial, @PathParam("longitud") Double longitudInicial){
		DistanciaCalculo calculo = new DistanciaCalculo();
		Pois poiMasCercano = new Pois();
		poiMasCercano = calculo.obtenerDistanciaMasCorta(latitudInicial, longitudInicial);
		return poiMasCercano;
	}
	
	public static <K, V> void printMap(Map<K, V> map) {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            System.out.println("Key : " + entry.getKey()
				+ " Value : " + entry.getValue());
        }
    }
	
	
	/*@GET
	@Path("/poi-mas-cercanos/{latitud}/{longitud}")
	@Produces({MediaType.APPLICATION_XML})
	public void poiMasCercanos2(@PathParam("latitud") Double latitudInicial, @PathParam("longitud") Double longitudInicial){
		Haversine calculador = new Haversine();
		Map<Double, String> map1 = new HashMap<>();
		for (Pois poi : this.pois) {
				System.out.println("Distancias: " + calculador.distance(latitudInicial, longitudInicial, poi.getLat(), poi.getLon()) + " - " + poi.getName());
				map1.put(calculador.distance(latitudInicial, longitudInicial, poi.getLat(), poi.getLon()), poi.getName());
		}
		
		Map<Double, String> treeMap = new TreeMap<Double, String>(
                new Comparator<Double>() {
                    @Override
                    public int compare(Double o1, Double o2) {
                        return o2.compareTo(o1);
                    }
                });


        treeMap.putAll(map1);

        printMap(treeMap.);


		try {

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static <K, V> void printMap(Map<K, V> map) {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            System.out.println("Key : " + entry.getKey()
				+ " Value : " + entry.getValue());
        }
    }*/
	
	
}
