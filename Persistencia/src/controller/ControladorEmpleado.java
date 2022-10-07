package controller;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.Empleado;
import model.Empresa;
import persistencia.Persistencia;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControladorEmpleado implements Initializable {

    @FXML
    private TextField txtNombreEmpleado;
    @FXML
    private TextField txtCodigoEmpleado;
    @FXML
    private TextField txtSueldoEmpleado;

    @FXML
    private Label lblConfirmarEmpleado;

    @FXML
    private void guardarEmpleado(ActionEvent event) throws IOException, InterruptedException {
        try {
            Integer.parseInt(txtSueldoEmpleado.getText());
        } catch (NumberFormatException e) {
            lblConfirmarEmpleado.setText("Ingrese numeros en el valor del sueldo");
        }
        String nombreEmpleado = txtNombreEmpleado.getText();
        String codigoEmpleado = txtCodigoEmpleado.getText();
        int sueldoEmpleado = Integer.parseInt(txtSueldoEmpleado.getText());
        Empleado empleado = new Empleado(nombreEmpleado, codigoEmpleado, sueldoEmpleado);
        guardarEmpleadoArchivo(empleado);
        lblConfirmarEmpleado.setText("Se ha guardado el empleado!");
    }

    private void guardarEmpleadoArchivo(Empleado empleado) throws IOException {
        Persistencia.guardarEmpleados(empleado);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}