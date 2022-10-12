package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Universidad implements Serializable {

	public Universidad() {

	}
	// Constructor con nombre
	public Universidad(String nombre) {
		super();
		this.nombre = nombre;
	}

	// Constructor con nombre, estudiantes y productos
	public Universidad(String nombre, ArrayList<Estudiante> estudiantes) {
		super();
		this.nombre = nombre;
		this.estudiantes = estudiantes;

	}

	public Estudiante crearEstudiante(String nombre, String codigo, ArrayList<Double> notas){
		Estudiante estudiante = new Estudiante(nombre, codigo, notas);
		return estudiante;
	}

	private String nombre = "";
	private ArrayList<Estudiante> estudiantes = new ArrayList<>();

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Estudiante> getEstudiantes() {
		return estudiantes;
	}

	public void setEstudiantes(ArrayList<Estudiante> estudiantes) {
		this.estudiantes = estudiantes;
	}

	public void eliminarEstudiante(String codigo) {
		for(int i = 0; i < getEstudiantes().size(); i++){
			if(getEstudiantes().get(i).getCodigo().equals(codigo)){
				getEstudiantes().remove(i);
			}
		}

	}

	public void actualizarEstudiante(String nombre, String codigo, ArrayList<Double> notas) {
		for(int i = 0; i < getEstudiantes().size(); i++){
			if(getEstudiantes().get(i).getCodigo().equals(codigo)){
				getEstudiantes().get(i).setCodigo(codigo);
				getEstudiantes().get(i).setNombre(nombre);
				getEstudiantes().get(i).setNotas(notas);
			}
		}
	}

	public Estudiante buscarEstudiante(String codigo) {
		for(int i = 0; i < getEstudiantes().size(); i++) {
			if (getEstudiantes().get(i).getCodigo().equals(codigo)) {
				return getEstudiantes().get(i);
			}
		}
		return null;
	}
}
