package co.edu.uniquindio.demo.viewController;

import co.edu.uniquindio.demo.App;
import co.edu.uniquindio.demo.controller.TallerController;
import co.edu.uniquindio.demo.model.Especialidad;
import co.edu.uniquindio.demo.model.Mecanico;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class MecanicoViewController {
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

    @FXML private ComboBox<Especialidad> cmbEspecialidad;

    @FXML
    private TextField txtIdMecanico;

    @FXML
    private TextField txtNombreMecanico;

    @FXML
    private TextField txtTelefonoMecanico;

    @FXML
    private TableView<Mecanico> tblMecanico;

    @FXML
    private TableColumn<Mecanico, String> colNombreMecanico;

    @FXML
    private TableColumn<Mecanico, String> colIdMecanico;

    @FXML
    private TableColumn<Mecanico, String> colTelefonoMecanico;

    @FXML
    private TableColumn<Mecanico, String> colEspecialidad;

    private ObservableList<Mecanico> listaMecanicos = FXCollections.observableArrayList();
    private App app;
    private TallerController tallerController = TallerController.getInstancia();

    @FXML
    public void initialize() {
        colNombreMecanico.setCellValueFactory(new PropertyValueFactory<>("Nombre Mecanico"));
        colIdMecanico.setCellValueFactory(new PropertyValueFactory<>("ID"));
        colTelefonoMecanico.setCellValueFactory(new PropertyValueFactory<>("Telefono Mecanico"));
        colEspecialidad.setCellValueFactory(new PropertyValueFactory<>("Especialidad"));
        tblMecanico.setItems(listaMecanicos);
        cmbEspecialidad.getItems().addAll(Especialidad.values());
    }

    @FXML
    void onAgregar() {
        String id = txtIdMecanico.getText();
        String nombre = txtNombreMecanico.getText();
        String telefono = txtTelefonoMecanico.getText();
        Especialidad especialidad = cmbEspecialidad.getValue();

        tallerController.agregarMecanico(id, nombre, telefono, especialidad);
        lblMensaje.setText("Mecánico agregado correctamente");
        actualizarTabla();

    }

    @FXML
    void onBuscar() {
        String id = txtIdMecanico.getText();
        Mecanico mecanico = tallerController.buscarMecanico(id);

        if(mecanico != null) {
            txtNombreMecanico.setText(mecanico.getNombreCompleto());
            txtTelefonoMecanico.setText(mecanico.getTelefono());
            cmbEspecialidad.setValue(mecanico.getEspecialidad());
            lblMensaje.setText("Mecánico encontrado");
        } else {
            lblMensaje.setText("Mecánico no encontrado");
        }

    }

    @FXML
    void onEliminar() {
        String id = txtIdMecanico.getText();
        boolean eliminado = tallerController.eliminarMecanico(id);

        if(eliminado) {
            lblMensaje.setText("Mecánico eliminado correctamente");
            actualizarTabla();
        } else {
            lblMensaje.setText("Mecánico no encontrado");
        }

    }

    @FXML
    void onVolver() {
        app.openOpcionesPrograma();

    }

    public void setApp(App app) {
        this.app= app;
    }
    private void actualizarTabla() {
        listaMecanicos.clear();
        listaMecanicos.addAll(tallerController.getMecanicos());
    }
}
