package utn.frd.action;

import com.opensymphony.xwork2.ActionSupport;
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
	public String save(){
		List<Persona> personas = PersistentManager.getInstance();
		int edad = 0;

		try{
			edad = Integer.parseInt(age);
		}catch(Exception e){
			addActionError("Ocurrió un error con la edad");
			return ERROR;
		}

		Persona loquito = new Persona(personas.size(), name, edad, gender);
		PersistentManager.getInstance().add(loquito);
		
		return SUCCESS;
	}
	public String execute(){
		personas = PersistentManager.getInstance();
//		for(int i = 1; i <= personas.size();i=i+1) {
			Persona p = personas.get(1);
//		}
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
}