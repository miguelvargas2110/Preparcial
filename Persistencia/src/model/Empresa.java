package model;

import java.util.ArrayList;

public class Empresa {
	// Constructor con nombre
	public Empresa(String nombre) {
		super();
		this.nombre = nombre;
	}

	// Constructor con nombre, empleados y productos
	public Empresa(String nombre, ArrayList<Empleado> empleados, ArrayList<Producto> productos) {
		super();
		this.nombre = nombre;
		this.empleados = empleados;
		this.productos = productos;
	}

	private String nombre;
	private ArrayList<Empleado> empleados;
	private ArrayList<Producto> productos;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Empleado> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(ArrayList<Empleado> empleados) {
		this.empleados = empleados;
	}

	public ArrayList<Producto> getProductos() {
		return productos;
	}

	public void setProductos(ArrayList<Producto> productos) {
		this.productos = productos;
	}
}
