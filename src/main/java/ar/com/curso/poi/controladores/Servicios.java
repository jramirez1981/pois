package ar.com.curso.poi.controladores;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ar.com.curso.poi.model.Pois;

public class Servicios {
	private static Map<String, List<Pois>> pois = new HashMap<String, List<Pois>>();
	static {
		Pois p = new Pois();
		pois.put("buenos-aires-turismo", p.LlenarPoisArray());
		pois.put("buenos-aires", new ArrayList<Pois>());
		pois.put("santo-domingo", new ArrayList<Pois>());
	}
	
	public static List<Pois> obtener(String servicio) throws Exception{
		if(pois.containsKey(servicio)) {
			return pois.get(servicio);
		}
	 throw new Exception("El servicio solicitado no existe");
	}
}
