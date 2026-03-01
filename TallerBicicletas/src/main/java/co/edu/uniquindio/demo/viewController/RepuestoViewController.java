package co.edu.uniquindio.demo.viewController;

import co.edu.uniquindio.demo.App;
import co.edu.uniquindio.demo.controller.ProveedorController;
import co.edu.uniquindio.demo.model.Repuesto;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;

public class RepuestoViewController {

    @FXML private TextField txtNombre;
    @FXML private TextField txtStock;
    @FXML private TextField txtPrecio;
    @FXML private Label lblMensaje;
    @FXML private Label lblAlerta;
    @FXML private TableView<Repuesto> tblRepuestos;
    @FXML private TableColumn<Repuesto, String> colNombre;
    @FXML private TableColumn<Repuesto, Integer> colStock;
    @FXML private TableColumn<Repuesto, Double> colPrecio;

    private App app;
    private ProveedorController proveedorController = ProveedorController.getInstancia();

    @FXML
    void initialize() {
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colStock.setCellValueFactory(new PropertyValueFactory<>("stock"));
        colPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));
        actualizarTabla();
    }

    @FXML
    void onAgregar() {
        String nombre = txtNombre.getText();
        int stock = Integer.parseInt(txtStock.getText());
        double precio = Double.parseDouble(txtPrecio.getText());

        proveedorController.agregarRepuesto(nombre, stock, precio);
        lblMensaje.setText("Repuesto agregado correctamente");
        actualizarTabla();
    }

    @FXML
    void onEliminar() {
        String nombre = txtNombre.getText();
        boolean eliminado = proveedorController.eliminarRepuesto(nombre);

        if(eliminado) {
            lblMensaje.setText("Repuesto eliminado correctamente");
            actualizarTabla();
        } else {
            lblMensaje.setText("Repuesto no encontrado");
        }
    }

    @FXML
    void onBuscar() {
        String nombre = txtNombre.getText();
        Repuesto repuesto = proveedorController.buscarRepuesto(nombre);

        if(repuesto != null) {
            txtStock.setText(String.valueOf(repuesto.getStock()));
            txtPrecio.setText(String.valueOf(repuesto.getPrecio()));
            lblMensaje.setText("Repuesto encontrado");
        } else {
            lblMensaje.setText("Repuesto no encontrado");
        }
    }

    @FXML
    void onAlertaStock() {
        List<Repuesto> bajoStock = proveedorController.alertaStockBajo();
        if(!bajoStock.isEmpty()) {
            StringBuilder alerta = new StringBuilder("Stock bajo en: ");
            for(Repuesto r : bajoStock) {
                alerta.append(r.getNombre()).append(" (").append(r.getStock()).append(") ");
            }
            lblAlerta.setText(alerta.toString());
        } else {
            lblAlerta.setText("Todo el stock está bien");
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
        tblRepuestos.getItems().clear();
        tblRepuestos.getItems().addAll(proveedorController.getRepuestos());
    }
}