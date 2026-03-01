package co.edu.uniquindio.demo.viewController;

import co.edu.uniquindio.demo.App;
import co.edu.uniquindio.demo.controller.TallerController;
import co.edu.uniquindio.demo.model.Cliente;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class ClienteViewController {

    @FXML private Button btnAgregar;
    @FXML private Button btnBuscar;
    @FXML private Button btnEliminar;
    @FXML private Button btnVolver;
    @FXML private Label lblMensaje;
    @FXML private TextField txtDireccion;
    @FXML private TextField txtId;
    @FXML private TextField txtNombre;
    @FXML private TextField txtTelefono;
    @FXML private TableView<Cliente> tblClientes;
    @FXML private TableColumn<Cliente, String> colId;
    @FXML private TableColumn<Cliente, String> colNombre;
    @FXML private TableColumn<Cliente, String> colTelefono;
    @FXML private TableColumn<Cliente, String> colDireccion;

    private App app;
    private TallerController tallerController = TallerController.getInstancia();
    private ObservableList<Cliente> listaClientes = FXCollections.observableArrayList();
    @FXML
    void initialize() {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombreCompleto"));
        colTelefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        colDireccion.setCellValueFactory(new PropertyValueFactory<>("direccion"));
        tblClientes.setItems(listaClientes);
        actualizarTabla();
    }

    @FXML
    void onAgregar() {
        String id = txtId.getText();
        String nombre = txtNombre.getText();
        String telefono = txtTelefono.getText();
        String direccion = txtDireccion.getText();

        tallerController.agregarCliente(nombre,id, telefono, direccion);
        lblMensaje.setText("Cliente agregado correctamente");
        actualizarTabla();
    }

    @FXML
    void onBuscar() {
        String id = txtId.getText();
        Cliente cliente = tallerController.buscarCliente(id);

        if(cliente != null) {
            txtNombre.setText(cliente.getNombreCompleto());
            txtTelefono.setText(cliente.getTelefono());
            txtDireccion.setText(cliente.getDireccion());
            lblMensaje.setText("Cliente encontrado");
        } else {
            lblMensaje.setText("Cliente no encontrado");
        }
    }

    @FXML
    void onEliminar() {
        Cliente clienteSeleccionado = tblClientes.getSelectionModel().getSelectedItem();
        if(clienteSeleccionado != null) {
            boolean eliminado = tallerController.eliminarCliente(clienteSeleccionado.getId());
            if(eliminado) {
                lblMensaje.setText("Cliente eliminado correctamente");
                actualizarTabla();
            }
        } else {
            String id = txtId.getText();
            boolean eliminado = tallerController.eliminarCliente(id);
            lblMensaje.setText(eliminado ? "Cliente eliminado" : "Cliente no encontrado");
            actualizarTabla();
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
        listaClientes.clear();
        listaClientes.addAll(tallerController.getClientes());
    }
}