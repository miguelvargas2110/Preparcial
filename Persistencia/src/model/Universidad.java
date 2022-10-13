package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Universidad implements Serializable {

	private String nombre = "";
	private ArrayList<Estudiante> estudiantes = new ArrayList<>();
	private ArrayList<Programa> programas = new ArrayList<>();

	public Universidad() {

	}

	public Universidad(String nombre) {
		super();
		this.nombre = nombre;
	}

	public Universidad(String nombre, ArrayList<Estudiante> estudiantes) {
		super();
		this.nombre = nombre;
		this.estudiantes = estudiantes;

	}

	public Estudiante crearEstudiante(String nombre, String codigo, ArrayList<Double> notas){
		Estudiante estudiante = new Estudiante(nombre, codigo, notas);
		return estudiante;
	}

	public Programa crearPrograma(String nombre, String codigo, String modalidad){
		Programa programa = new Programa(nombre, codigo, modalidad);
		return programa;
	}

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

	public ArrayList<Programa> getProgramas() {
		return programas;
	}

	public void setProgramas(ArrayList<Programa> programas) {
		this.programas = programas;
	}

	public Estudiante buscarEstudiante(String codigo) {
		for(int i = 0; i < getEstudiantes().size(); i++) {
			if (getEstudiantes().get(i).getCodigo().equals(codigo)) {
				return getEstudiantes().get(i);
			}
		}
		return null;
	}

	public Programa buscarPrograma(String codigo) {
		for(int i = 0; i < getProgramas().size(); i++) {
			if (getProgramas().get(i).getCodigo().equals(codigo)) {
				return getProgramas().get(i);
			}
		}
		return null;
	}
}
