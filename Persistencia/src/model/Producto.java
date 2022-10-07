package model;

public class Producto {

	public Producto(String nombre, String codigoProducto, int valor) {
		super();
		this.nombre = nombre;
		this.codigoProducto = codigoProducto;
		this.valor = valor;
	}

	private String nombre;
	private String codigoProducto;
	private int valor;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCodigoProducto() {return codigoProducto;}

	public void setCodigoProducto(String codigoProducto) {
		this.codigoProducto = codigoProducto;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return ("Nombre producto: " + nombre + ", Codigo del producto: " + codigoProducto + ", valor: " + valor);
	}

}

