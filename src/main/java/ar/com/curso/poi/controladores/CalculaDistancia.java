package ar.com.curso.poi.controladores;

import java.util.ArrayList;
import java.util.List;

import ar.com.curso.poi.model.Pois;

public class CalculaDistancia {
	
		private double DistaActual;
		private double no_usado;
	    private static final int EARTH_RADIUS = 6371; // Approx Earth radius in KM

	    public double distance(double startLat, double startLong,
	                                  double endLat, double endLong) {

	        double dLat  = Math.toRadians((endLat - startLat));
	        double dLong = Math.toRadians((endLong - startLong));

	        startLat = Math.toRadians(startLat);
	        endLat   = Math.toRadians(endLat);

	        double a = haversin(dLat) + Math.cos(startLat) * Math.cos(endLat) * haversin(dLong);
	        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

	        return EARTH_RADIUS * c; // <-- d
	    }

	    public static double haversin(double val) {
	        return Math.pow(Math.sin(val / 2), 2);
	    }
	    
	    public Pois obtenerDistanciaMasCorta(String servicio, double latitudUbicacion, double longitudUbicacion) throws Exception
		{
	    	List<Pois> LlenarPoisArrayX = new ArrayList<Pois>() ;
	    	
			Pois Rs = new Pois();
			Pois Actual = new Pois();
						
			//LlenarPoisArrayX = lista.LlenarPoisArray();
			LlenarPoisArrayX = Servicios.obtener(servicio);
			
			DistanciaCalculo distancia = new DistanciaCalculo();
			Double minima = 999999999999.00;
			for(int i=0; i<LlenarPoisArrayX.size();i++) {
				Actual = LlenarPoisArrayX.get(i);
				
				DistaActual=distancia.distance(latitudUbicacion,longitudUbicacion,Actual.getLat(), Actual.getLon());
				if( DistaActual < minima ) {
					minima = DistaActual;
					Rs = Actual;
				}
			}	
			return Rs;
			
		}
	}
