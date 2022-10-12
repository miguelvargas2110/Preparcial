package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Estudiante implements Serializable {

	private String nombre = "";
	private String codigo = "";
	private ArrayList<Double> notas = new ArrayList<>();

	public Estudiante(String nombre, String codigo, ArrayList<Double> notas) {
		super();
		this.nombre = nombre;
		this.codigo = codigo;
		this.notas = notas;
	}

	public Estudiante() {
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public ArrayList<Double> getNotas() {
		return notas;
	}

	public void setNotas(ArrayList<Double> notas) {
		this.notas = notas;
	}

	@Override
	public String toString() {
		String contenido = "";

		contenido = nombre + "," + codigo;

		for (int i = 0; i < notas.size(); i++) {
			contenido += "," + notas.get(i);
		}

		return contenido;
	}
}
