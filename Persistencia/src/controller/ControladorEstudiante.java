package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.Estudiante;
import model.services.Singleton;

import javax.swing.*;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

public class ControladorEstudiante implements  Serializable{
    @FXML
    private TextField txtNombreEstudiante;
    @FXML
    private TextField txtCodigoEstudiante;
    @FXML
    private TextField txtNota1;
    @FXML
    private TextField txtNota2;
    @FXML
    private TextField txtNota3;
    @FXML
    private Label lblConfirmarEstudiante;
    @FXML
    private TextField txtBuscarEstudiante;
    @FXML
    private Label lblNombre;
    @FXML
    private Label lblCodigo;
    @FXML
    private Label lblNota1;
    @FXML
    private Label lblNota2;
    @FXML
    private Label lblNota3;
    @FXML
    private void guardarEstudiante(ActionEvent event) throws IOException, InterruptedException {
        ArrayList<Double> notasEstudiantes = new ArrayList<>();
        try {
            Double.valueOf(txtNota1.getText());
            Double.valueOf(txtNota2.getText());
            Double.valueOf(txtNota3.getText());
        } catch (NumberFormatException e) {
            lblConfirmarEstudiante.setText("Recuerde que las notas se dan en numeros");
        }
        if(txtNombreEstudiante.getText() != ""  && txtCodigoEstudiante.getText() != ""){
            if((Double.valueOf(txtNota1.getText()) >= 0 && Double.valueOf(txtNota1.getText()) <= 5)  &&
                    (Double.valueOf(txtNota2.getText()) >= 0 && Double.valueOf(txtNota2.getText()) <= 5) &&
                    (Double.valueOf(txtNota3.getText()) >= 0 && Double.valueOf(txtNota3.getText()) <= 5)){
                String nombreEstudiante = txtNombreEstudiante.getText();
                String codigoEstudiante = txtCodigoEstudiante.getText();
                notasEstudiantes.add(Double.valueOf(txtNota1.getText()));
                notasEstudiantes.add(Double.valueOf(txtNota2.getText()));
                notasEstudiantes.add(Double.valueOf(txtNota3.getText()));
                Estudiante estudiante = Singleton.getInstance().crearEstudiante(nombreEstudiante, codigoEstudiante, notasEstudiantes);
                Singleton.getInstance().guardarEstudianteArchivo(estudiante);
                lblConfirmarEstudiante.setText("Se ha guardado el estudiante!");
                Singleton.getInstance().guardarRegistroLog("Se ha guardado el estudiante " + nombreEstudiante + " con exito", 1, "guardarEstudiante");
                txtCodigoEstudiante.setText("");
                txtNombreEstudiante.setText("");
                txtNota1.setText("");
                txtNota2.setText("");
                txtNota3.setText("");
            }else{
                lblConfirmarEstudiante.setText("Las notas deben estar entre 0 y 5");
            }
        }else{
            lblConfirmarEstudiante.setText("Porfavor rellene todos los espacios");
        }

    }
    @FXML
    private void buscarEstudiante(ActionEvent event) {
        Estudiante estudiante = Singleton.getInstance().buscarEstudiante(txtBuscarEstudiante.getText());
        if(estudiante == null){
            JOptionPane.showMessageDialog(null,  "Porfavor, ingrese el codigo de un estudiante registrado");
        }else{
            lblNombre.setText(estudiante.getNombre());
            lblCodigo.setText(estudiante.getCodigo());
            lblNota1.setText(String.valueOf(estudiante.getNotas().get(0)));
            lblNota2.setText(String.valueOf(estudiante.getNotas().get(1)));
            lblNota3.setText(String.valueOf(estudiante.getNotas().get(2)));
        }
    }

}