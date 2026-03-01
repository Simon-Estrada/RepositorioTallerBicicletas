package co.edu.uniquindio.demo.viewController;

import co.edu.uniquindio.demo.App;
import co.edu.uniquindio.demo.controller.TallerController;
import co.edu.uniquindio.demo.model.Bicicleta;
import co.edu.uniquindio.demo.model.Tipo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class BicicletaViewController {

    @FXML private TextField txtSerial;
    @FXML private TextField txtMarca;
    @FXML private TextField txtColor;
    @FXML private TextField txtAno;
    @FXML private TextField txtIdPropietario;
    @FXML private ComboBox<Tipo> cmbTipo;
    @FXML private Label lblMensaje;
    @FXML private TableView<Bicicleta> tblBicicletas;
    @FXML private TableColumn<Bicicleta, String> colSerial;
    @FXML private TableColumn<Bicicleta, String> colMarca;
    @FXML private TableColumn<Bicicleta, String> colTipo;
    @FXML private TableColumn<Bicicleta, String> colColor;
    @FXML private TableColumn<Bicicleta, Integer> colAno;
    @FXML private TableColumn<Bicicleta, String> colPropietario;

    private App app;
    private TallerController tallerController = TallerController.getInstancia();
    private ObservableList<Bicicleta> listaBicicletas = FXCollections.observableArrayList();
    @FXML
    void initialize() {
        cmbTipo.getItems().addAll(Tipo.values());

        colSerial.setCellValueFactory(new PropertyValueFactory<>("numeroSerial"));
        colMarca.setCellValueFactory(new PropertyValueFactory<>("marca"));
        colTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        colColor.setCellValueFactory(new PropertyValueFactory<>("color"));
        colAno.setCellValueFactory(new PropertyValueFactory<>("ano"));
        colPropietario.setCellValueFactory(new PropertyValueFactory<>("propietario"));
        tblBicicletas.setItems(listaBicicletas);
    }

    @FXML
    void onAgregar() {
        String serial = txtSerial.getText();
        String marca = txtMarca.getText();
        String color = txtColor.getText();
        int ano = Integer.parseInt(txtAno.getText());
        String idPropietario = txtIdPropietario.getText();
        Tipo tipo = cmbTipo.getValue();

        tallerController.agregarBicicleta(marca, tipo, color, serial, ano, idPropietario);
        lblMensaje.setText("Bicicleta agregada correctamente");
        actualizarTabla();
    }

    @FXML
    void onEliminar() {
        String serial = txtSerial.getText();
        boolean eliminado = tallerController.eliminarBicicleta(serial);

        if(eliminado) {
            lblMensaje.setText("Bicicleta eliminada correctamente");
            actualizarTabla();
        } else {
            lblMensaje.setText("Bicicleta no encontrada");
        }
    }




    @FXML
    void onVolver() {
        app.openOpcionesPrograma();
    }

    public void setApp(App app) {
        this.app = app;
    }

    private void actualizarTabla() {
        listaBicicletas.clear();
        listaBicicletas.addAll(tallerController.getBicicletas());
    }

}