package controller;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.Empresa;
import model.Producto;
import persistencia.Persistencia;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControladorProducto implements Initializable {

    @FXML
    private TextField txtNombreProducto;
    @FXML
    private TextField txtCodigoProducto;
    @FXML
    private TextField txtValorProducto;
    @FXML
    private Label lblConfirmarProducto;


    @FXML
    private void guardarProducto(ActionEvent event) throws IOException {
        try {
            Integer.parseInt(txtValorProducto.getText());
        }catch (NumberFormatException e){
            lblConfirmarProducto.setText("Ingrese numeros en el valor del producto");
        }
        String nombreProducto = txtNombreProducto.getText();
        String codigoProducto = txtCodigoProducto.getText();
        int valorProducto = Integer.parseInt(txtValorProducto.getText());
        Producto producto = new Producto(nombreProducto, codigoProducto, valorProducto);
        guardarProductoArchivo(producto);
        lblConfirmarProducto.setText("Se ha guardado el producto!");
    }

    private void guardarProductoArchivo(Producto producto) throws IOException {
        Persistencia.guardarProducto(producto);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

}