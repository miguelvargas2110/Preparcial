package controller;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.Empleado;
import model.Empresa;
import model.Producto;
import persistencia.Persistencia;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControladorMain implements Initializable {

    Main aplicacion = new Main();

    private Empresa empresa = new Empresa("A");

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void onActionEmpleado(){ aplicacion.Empleado(); }

    public void onActionProducto() { aplicacion.Producto(); }
}
