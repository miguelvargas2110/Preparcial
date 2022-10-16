package persistencia;

import model.Estudiante;
import model.Universidad;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

public class Persistencia implements Serializable {
	public static final String RUTA_ARCHIVO_ESTUDIANTES = "Preparcial/Resources/archivoEstudiantes.txt";
	public static final String RUTA_ARCHIVO_LOG = "Preparcial/Resources/universidadLog.txt";
	public static final String RUTA_ARCHIVO_OBJETOS = "Preparcial/Resources/archivoObjetos.txt";

	public static final String RUTA_ARCHIVO_MODELO_UNIVERSIDAD_XML = "Preparcial/Resources/model.xml";

	public static final String RUTA_ARCHIVO_PROPERTIES_MODALIDADES = "Preparcial/Resources/modalidades.properties";


	public static void cargarDatosArchivos(Universidad universidad) throws FileNotFoundException, IOException {

		ArrayList<Estudiante> estudiantes = cargarEstudiantes();

		if(estudiantes.size() > 0){
			universidad.getEstudiantes().addAll(estudiantes);
		}

	}

	public static void guardarEstudiantes(ArrayList<Estudiante> estudiantes) throws IOException {
		String contenido = "";
		for(Estudiante Estudiante: estudiantes){
			contenido += Estudiante.toString() + "\n";
		}
		ArchivoUtil.guardarArchivo(RUTA_ARCHIVO_ESTUDIANTES, contenido, false);
	}

	private static ArrayList<Estudiante> cargarEstudiantes() throws IOException {

		ArrayList<Estudiante> Estudiantes =new ArrayList<Estudiante>();

		ArrayList<Double> notas = new ArrayList<Double>();

		ArrayList<String> contenido = ArchivoUtil.leerArchivo(RUTA_ARCHIVO_ESTUDIANTES);
		String linea="";

		for (int i = 0; i < contenido.size(); i++)
		{
			linea = contenido.get(i);
			Estudiante estudiante = new Estudiante();
			estudiante.setNombre(linea.split(",")[0]);
			estudiante.setCodigo(linea.split(",")[1]);
			for(int j = 2; j < 5; j++){
				estudiante.getNotas().add(Double.valueOf(linea.split(",")[j]));
			}
			Estudiantes.add(estudiante);
		}
		return Estudiantes;
	}


	public static Universidad cargarRecursoUniversidadXML() {

		Universidad universidad = null;

		try {
			universidad = (Universidad) ArchivoUtil.cargarRecursoSerializadoXML(RUTA_ARCHIVO_MODELO_UNIVERSIDAD_XML);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return universidad;

	}



	public static void guardarRecursoUniversidadXML(Universidad universidad) {

		try {
			ArchivoUtil.salvarRecursoSerializadoXML(RUTA_ARCHIVO_MODELO_UNIVERSIDAD_XML, universidad);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

	public static void guardaRegistroLog(String mensajeLog, int nivel, String accion)
	{
		ArchivoUtil.guardarRegistroLog(mensajeLog, nivel, accion, RUTA_ARCHIVO_LOG);
	}

	public static ArrayList<String> cargarModalidadesProperties() throws IOException {
		ArrayList<String> modalidades = ArchivoUtil.leerPropertiesModalidad(RUTA_ARCHIVO_PROPERTIES_MODALIDADES);
		return modalidades;
	}
}
