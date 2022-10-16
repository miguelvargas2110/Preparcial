package model;

import java.io.Serializable;

public class Programa implements Serializable {
    private String nombre = "";
    private String codigo = "";
    private String modalidad;

    public Programa() {
    }

    public Programa(String nombre, String codigo, String modalidad) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.modalidad = modalidad;
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

    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }


    @Override
    public String toString() {
        return nombre +"," + "," + codigo + "," + modalidad;
    }
}
