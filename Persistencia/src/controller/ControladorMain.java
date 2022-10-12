package controller;

import application.Main;
import javafx.fxml.Initializable;
import model.Universidad;

import java.io.Serializable;
import java.net.URL;
import java.util.ResourceBundle;

public class ControladorMain implements Initializable {

    Main aplicacion = new Main();

    private Universidad universidad = new Universidad("A");

    public void onActionEmpleado(){ aplicacion.Empleado(); }

    public void onActionProducto() { aplicacion.Producto(); }
}
