package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.Programa;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ControladorPrograma implements Initializable {

    ArrayList<String> modalidades = ModelFactoryController.getInstance().cargarModalidades();
    @FXML
    private ChoiceBox cbModalidad;
    @FXML
    private TextField txtNombrePrograma;
    @FXML
    private TextField txtCodigoPrograma;
    @FXML
    private Label lblConfirmarPrograma;
    @FXML
    private Label lblNombre;
    @FXML
    private Label lblCodigo;
    @FXML
    private Label lblModalidad;
    @FXML
    private TextField txtBuscarPrograma;
    ObservableList<String> opcionesChoiceBox = FXCollections.observableArrayList();

    public ControladorPrograma() throws IOException {
    }

    @FXML
    private void guardarPrograma(ActionEvent event){
        if(txtNombrePrograma.getText() != ""  && txtCodigoPrograma.getText() != ""){
            String nombrePrograma = txtNombrePrograma.getText();
            String codigoPrograma = txtCodigoPrograma.getText();
            String modalidad = cbModalidad.getValue().toString();
            Programa programa = ModelFactoryController.getInstance().crearPrograma(nombrePrograma, codigoPrograma, modalidad);
            ModelFactoryController.getInstance().guardarPrograma(programa);
            lblConfirmarPrograma.setText("Se ha guardado el Programa!");
            txtCodigoPrograma.setText("");
            txtNombrePrograma.setText("");
            cbModalidad.setValue(opcionesChoiceBox.get(0));

        }else{
            lblConfirmarPrograma.setText("Rellene todos los campos");
        }
    }
    @FXML
    private void buscarPrograma(ActionEvent event) {
        Programa programa = ModelFactoryController.getInstance().buscarPrograma(txtBuscarPrograma.getText());
        if(programa == null){
            JOptionPane.showMessageDialog(null,  "Porfavor, ingrese el codigo de un Programa registrado");
        }else{
            lblNombre.setText(programa.getNombre());
            lblCodigo.setText(programa.getCodigo());
            lblModalidad.setText(programa.getModalidad());
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        for(int i = 0; i < modalidades.size(); i++){
            opcionesChoiceBox.add(modalidades.get(i));
        }
        cbModalidad.setValue(opcionesChoiceBox.get(0));
        cbModalidad.setItems(opcionesChoiceBox);
    }
}
