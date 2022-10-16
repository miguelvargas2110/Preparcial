package controller;


import java.io.IOException;
import java.util.ArrayList;

import model.Estudiante;
import model.Programa;
import model.Universidad;
import persistencia.Persistencia;

public class ModelFactoryController {

    private static ModelFactoryController instancia;

    Universidad universidad;


    //------------------------------  ModelFactoryController ------------------------------------------------
    public static ModelFactoryController getInstance() {
        if (instancia == null) {
            instancia = new ModelFactoryController();
        }
        return instancia;
    }

    private ModelFactoryController() {
        cargarDatosDesdeArchivos();

        if (Persistencia.cargarRecursoUniversidadXML() == null) {
            System.out.println("es null");
            guardarResourceXML();
            cargarResourceXML();
        }else{
            cargarResourceXML();
            guardarResourceXML();
        }
    }

    public ArrayList<String> cargarModalidades() throws IOException {
        ArrayList<String> modalidades = Persistencia.cargarModalidadesProperties();
        return modalidades;
    }

    public void guardarRegistroLog(String mensaje, int nivel, String accion) {
        Persistencia.guardaRegistroLog(mensaje, nivel, accion);
    }

    public void guardarEstudianteArchivo(Estudiante estudiante) throws IOException {
        universidad.getEstudiantes().add(estudiante);
        Persistencia.guardarEstudiantes(universidad.getEstudiantes());
        Persistencia.guardarRecursoUniversidadXML(universidad);
    }

    public void guardarPrograma(Programa programa) {
        universidad.getProgramas().add(programa);
        Persistencia.guardarRecursoUniversidadXML(universidad);
    }

    private void cargarDatosDesdeArchivos() {

        universidad = new Universidad();

        try {

            Persistencia.cargarDatosArchivos(getUniversidad());

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void cargarResourceXML() {

        universidad = Persistencia.cargarRecursoUniversidadXML();
    }

    public void guardarResourceXML() {

        Persistencia.guardarRecursoUniversidadXML(universidad);
    }

    public Universidad getUniversidad() {
        return universidad;
    }

    public void setUniversidad(Universidad universidad) {
        this.universidad = universidad;
    }

    public Estudiante crearEstudiante(String nombre, String codigo, ArrayList<Double> notas) {
        Estudiante estudiante;
        estudiante = getUniversidad().crearEstudiante(nombre, codigo, notas);
        return estudiante;
    }

    public Programa crearPrograma(String nombre, String documento, String modalidad) {
        Programa programa;
        programa = getUniversidad().crearPrograma(nombre, documento, modalidad);
        return programa;
    }

    public Estudiante buscarEstudiante(String codigo) {
        Estudiante estudiante = getUniversidad().buscarEstudiante(codigo);
        return estudiante;
    }

    public Programa buscarPrograma(String codigo) {
        Programa programa = getUniversidad().buscarPrograma(codigo);
        return programa;
    }

}

