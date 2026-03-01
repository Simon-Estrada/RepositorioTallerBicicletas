package co.edu.uniquindio.demo.viewController;

import co.edu.uniquindio.demo.App;
import co.edu.uniquindio.demo.controller.ProveedorController;
import co.edu.uniquindio.demo.model.Repuesto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
    private ObservableList<Repuesto> listaRepuestos = FXCollections.observableArrayList();
    @FXML
    void initialize() {
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colStock.setCellValueFactory(new PropertyValueFactory<>("stock"));
        colPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));
        tblRepuestos.setItems(listaRepuestos);
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
        Repuesto repuestoSeleccionado = tblRepuestos.getSelectionModel().getSelectedItem();
        if(repuestoSeleccionado != null){
            boolean eliminado = proveedorController.eliminarRepuesto(repuestoSeleccionado.getNombre());
            if(eliminado){
                lblMensaje.setText("Se elimino correctamente el repuesto :)");
                actualizarTabla();
            }
            else{
                String nombre = txtNombre.getText();
                boolean elminado = proveedorController.eliminarRepuesto(nombre);
                lblMensaje.setText(elminado ? "Repuesto eliminado": "Repuesto no existe");
                actualizarTabla();
            }
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
        listaRepuestos.clear();
        listaRepuestos.addAll(proveedorController.getRepuestos());
    }
}