package model.services;


import java.io.IOException;
import java.util.ArrayList;

import model.Estudiante;
import model.Universidad;
import persistencia.Persistencia;

public class Singleton {

        private static Singleton instancia;

    Universidad universidad = new Universidad();


    //------------------------------  Singleton ------------------------------------------------
    public static Singleton getInstance(){
        if(instancia == null){
            instancia = new Singleton();
        }
        return instancia;
    }

    private Singleton() {
        cargarDatosDesdeArchivos();
        guardarResourceBinario();
        cargarResourceBinario();
        //4. Guardar y Cargar el recurso serializable XML
        //Siempre se debe verificar si la raiz del recurso es null
        if(universidad == null) {
            System.out.println("es null");
            guardarResourceXML();
        }

    }

    public void guardarRegistroLog(String mensaje, int nivel, String accion){
        Persistencia.guardaRegistroLog(mensaje, nivel, accion);
    }

    public void guardarEstudianteArchivo(Estudiante estudiante) throws IOException {
        System.out.println(universidad);
        universidad.getEstudiantes().add(estudiante);
        Persistencia.guardarEstudiantes(universidad.getEstudiantes());
    }

    private void cargarDatosDesdeArchivos() {

        try {

            Persistencia.cargarDatosArchivos(getUniversidad());

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void cargarResourceBinario() {

        universidad = Persistencia.cargarRecursoBancoBinario();
    }


    public void guardarResourceBinario() {

        Persistencia.guardarRecursoBancoBinario(universidad);
    }


    public void cargarResourceXML() {

        universidad = Persistencia.cargarRecursoBancoXML();
    }


    public void guardarResourceXML() {

        Persistencia.guardarRecursoBancoXML(universidad);
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

    public Estudiante buscarEstudiante(String codigo) {
        Estudiante estudiante = getUniversidad().buscarEstudiante(codigo);
        return estudiante;
    }

}

