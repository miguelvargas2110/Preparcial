package persistencia;

import model.Empleado;
import model.Producto;

import java.io.IOException;

public class Persistencia {
	public static final String RUTA_ARCHIVO_PRODUCTOS = "Persistencia/src/persistencia/archivoProductos.txt";
	public static final String RUTA_ARCHIVO_EMPLEADOS = "Persistencia/src/persistencia/archivoEmpleados.txt";

	public static void guardarProducto(Producto producto) throws IOException {
		String contenido = "";
		contenido += producto.toString() + "\n";
		ArchivoUtil.guardarArchivo(RUTA_ARCHIVO_PRODUCTOS, contenido, true);
	}

	public static void guardarEmpleados(Empleado empleado) throws IOException {
		String contenido = "";
		contenido += empleado.toString() + "\n";
		ArchivoUtil.guardarArchivo(RUTA_ARCHIVO_EMPLEADOS, contenido, true);
	}

}
