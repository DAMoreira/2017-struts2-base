package unt.frd.db;

import java.util.ArrayList;
import java.util.List;
import utn.frd.bean.Persona;

public class PersistentManager {
//	public PersistentManager() {
		private static List<Persona> listaCopada = new ArrayList<Persona>();
//	}
	public static List<Persona> getInstance(){
		return listaCopada;
	}
	public static void guardar(Persona personas){
		listaCopada.add(personas);
	}
	public static void reemplazar( List<Persona> personas) {
		listaCopada = personas;
	}
}