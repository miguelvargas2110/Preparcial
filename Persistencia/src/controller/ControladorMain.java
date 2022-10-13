package controller;

import application.Main;
import javafx.fxml.Initializable;
import model.Universidad;

import java.io.Serializable;
import java.net.URL;
import java.util.ResourceBundle;

public class ControladorMain implements Serializable {

    Main aplicacion = new Main();

    public void onActionEstudiante(){ aplicacion.Estudiante(); }

    public void onActionPrograma() { aplicacion.Programa(); }
}
