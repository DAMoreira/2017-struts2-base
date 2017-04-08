package utn.frd.action;

import com.opensymphony.xwork2.ActionSupport;
import java.io.*;
import unt.frd.db.PersistentManager;
import utn.frd.bean.MessageStore;
import utn.frd.bean.Persona;
import java.util.ArrayList;
import java.util.List;

public class PersonaAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private String name;
	private String age;
	private String gender;
	private List<Persona> personas;
	private String id;
	private String alta;
	public String save(){
		personas = PersistentManager.getInstance();
		int edad = 0;

		try{
			edad = Integer.parseInt(age);
		}catch(Exception e){
			addActionError("Ocurrió un error con la edad");
			return ERROR;
		}

		Persona loquito = new Persona(personas.size(), name, edad, gender, true);
		PersistentManager.getInstance().add(loquito);
		return SUCCESS;
	}
	public String execute(){
		List<Persona> personas1 = PersistentManager.getInstance();
		ArrayList<Persona> personas2 = new ArrayList<Persona>();
		for(int i = 0; i < personas1.size();i++) {
			Persona per = personas1.get(i);
			if (per.getAlta() == true) {
				personas2.add(per);
			}	
		}
		personas = personas2;
//		Persona p = personas.get(0);
		return SUCCESS;
	}
	public String eliminar(){
		personas = PersistentManager.getInstance();
		int ide=0;
		try{
			ide = Integer.parseInt(id);
		}catch(Exception e){
			addActionError("Ocurrió un error con el ID");
			return ERROR;
		}
		for(int i = 0; i < personas.size();i++) {
			Persona p = PersistentManager.getInstance().get(i);
			if (p.getId() == ide) {
//				PersistentManager.getInstance().remove(i);	
				p.setAlta(false);
//				PersistentManager.getInstance().add(i,p);	
			}
			
		}
		return SUCCESS;
	}
	public String modificar(){
		int ide=0;
		int edad=0;
		boolean alta2;
		personas = PersistentManager.getInstance();
		try{
			ide = Integer.parseInt(id);
		}catch(Exception e){
			addActionError("Ocurrió un error con el ID");
			return ERROR;
		}
		try{
			edad = Integer.parseInt(age);
		}catch(Exception e){
			addActionError("Ocurrió un error con la edad");
			return ERROR;
		}
		for(int i = 0; i < personas.size();i++) {
			Persona p = PersistentManager.getInstance().get(i);
			if (p.getId() == ide) {
				p.setName(name);
				p.setAge(edad);
				p.setGender(gender);
				char[] a = alta.toCharArray();
				if (a[0]=='t') {
					alta2 = true;
					p.setAlta(alta2);
				}
				else {
					alta2 = false;
					p.setAlta(alta2);
				}
//				p.setAlta(alta2);
			}
		} 
		return SUCCESS;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public List<Persona> getPersonas() {
		return personas;
	}
	public void setPersonas(List<Persona> personas) {
		this.personas = personas;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAlta() {
		return alta;
	}
	public void setAlta(String alta) {
		this.alta = alta;
	}
}
