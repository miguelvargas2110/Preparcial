package model;

public class Empleado {

	public Empleado(String nombre, String codigo, int sueldo) {
		super();
		this.nombre = nombre;
		this.codigo = codigo;
		this.sueldo = sueldo;
	}

	private String nombre;
	private String codigo;
	private int sueldo;

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

	public int getSueldo() {
		return sueldo;
	}

	public void setSueldo(int sueldo) {
		this.sueldo = sueldo;
	}

	@Override
	public String toString() {
		return ("Nombre: " + nombre + ", Codigo: " + codigo + ", sueldo: " + sueldo);
	}
}
