package persistencia;

import model.Estudiante;
import model.Universidad;

import java.io.IOException;

public class Persistencia {
	public static final String RUTA_ARCHIVO_PRODUCTOS = "Persistencia/src/persistencia/archivoProductos.txt";
	public static final String RUTA_ARCHIVO_EMPLEADOS = "Persistencia/src/persistencia/archivoEmpleados.txt";


	public static void cargarDatosArchivos(Universidad universidad) throws FileNotFoundException, IOException {
		universidad.setEstudiantes(cargarEstudiantes());
	}

	public static void guardarEstudiantes(ArrayList<Estudiante> estudiantes) throws IOException {
		String contenido = "";
		for(Estudiante empleado: estudiantes){
			contenido += empleado.toString() + "\n";
		}
		ArchivoUtil.guardarArchivo(RUTA_ARCHIVO_ESTUDIANTES, contenido, false);
	}

}
