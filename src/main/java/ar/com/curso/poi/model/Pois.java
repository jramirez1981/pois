package ar.com.curso.poi.model;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Pois {

	private String name;
	private double lat;
	private double lon;
	private String type;
	private String description;
	private double distancia;
	
	
	public double getDistancia() {
		return distancia;
	}
	public void setDistancia(double distancia) {
		this.distancia = distancia;
	}
	
	@XmlElement(name="NombreLugar")
	public String getName() {
		return name;	
	}
	
	@XmlElement(name="Descripcion")
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@XmlElement(name="TipoLugar")
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	@XmlElement(name="Latitud")
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	
	@XmlElement(name="Longitud")
	public double getLon() {
		return lon;
	}
	public void setLon(double lon) {
		this.lon = lon;
	}
	
	
	public ArrayList<Pois> LlenarPoisArray() {
		ArrayList<Pois> pois = new ArrayList<Pois>();
					
		Pois p1 = new Pois();
		p1.setName("Pizzería Las Cuartetas");
		p1.setDescription("De las mejores pizzas de Buenos Aires, cerveza tirada y sopa inglesa");
		p1.setType("Pizzeria");
		p1.setLat(-34.603327);
		p1.setLon(-58.378554);
		pois.add(p1);
		
		Pois p2 = new Pois();
		p2.setName("Pizzería El Cuartito");
		p2.setDescription("Una pizza bien argenta, con buena masa, mucho queso y velocidad en recibir el pedido.");
		p2.setType("Pizzeria");
		p2.setLat(-34.597598);
		p2.setLon(-58.385457);
		pois.add(p2);
		
		Pois p3 = new Pois();
		p3.setName("Pizzería El Palacio de la Pizza");
		p3.setDescription("Excelente pizza, a la piedra o al molde, muy rica masa, y exceso de buena muzzarella. La pizza suele salir rápido, caliente y rica");
		p3.setType("Pizzeria");
		p3.setLat(-34.603105);
		p3.setLon(-58.377335);
		pois.add(p3);
		
		Pois p4 = new Pois();
		p4.setName("El Cavildo de Buenos Aires");
		p4.setDescription(" Museo Histórico Nacional del Cabildo y de la Revolución de Mayo.");
		p4.setType("Museo");
		p4.setLat(-34.608501);
		p4.setLon(-58.373808);
		pois.add(p4);
		
		return pois;
	}
	
}
