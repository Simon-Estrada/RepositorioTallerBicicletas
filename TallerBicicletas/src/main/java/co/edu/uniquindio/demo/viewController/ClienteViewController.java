package co.edu.uniquindio.demo.viewController;

import co.edu.uniquindio.demo.App;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;



public class ClienteViewController {
    @FXML
    private Button btnAgregar;

    @FXML
    private Button btnBuscar;

    @FXML
    private Button btnEliminar;

    @FXML
    private Button btnVolver;

    @FXML
    private Label lblMensaje;

    @FXML
    private TextField txtDireccion;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtTelefono;

    @FXML
    void onAgregar() {
        String nombreCompleto = txtNombre.getText();
        String id = txtId.getText();
        String telefono = txtTelefono.getText();
        String direccion = txtDireccion.getText();

        tallerController

    }

    @FXML
    void onBuscar() {

    }

    @FXML
    void onEliminar() {

    }

    @FXML
    void onVolver() {

    }
    public void setApp(App app) {
    }
}
