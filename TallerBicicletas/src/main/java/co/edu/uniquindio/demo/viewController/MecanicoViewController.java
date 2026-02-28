package co.edu.uniquindio.demo.viewController;

import co.edu.uniquindio.demo.App;
import co.edu.uniquindio.demo.model.Especialidad;
import co.edu.uniquindio.demo.model.Mecanico;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import static co.edu.uniquindio.demo.model.Especialidad.Ruedasllantas;

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

    @FXML
    private ComboBox<Especialidad> cmbEspecialidad;

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
    private TableColumn<Mecanico, Especialidad> colEspecialidad;

    private ObservableList<Mecanico> mecanicos;



    //Inicializamos la tabla con un mecanico
    @FXML
    public void initialize() {
        colNombreMecanico.setCellValueFactory(new PropertyValueFactory<>("Nombre Mecanico"));
        colIdMecanico.setCellValueFactory(new PropertyValueFactory<>("ID"));
        colTelefonoMecanico.setCellValueFactory(new PropertyValueFactory<>("Telefono Mecanico"));
        colEspecialidad.setCellValueFactory(new PropertyValueFactory<>("Especialidad"));

        mecanicos = FXCollections.observableArrayList(
                new Mecanico("Fabian Henao Sanchez" , "111456837230" , "30015104735" , Ruedasllantas)
        );

        tblMecanico.setItems(mecanicos);
    }

    //Metodo para agregar los mecanicos al relenar los campos
    @FXML
    void onAgregar() {

            String nombreCompleto = txtNombreMecanico.getText();
            String id = txtIdMecanico.getText();
            String telefono = txtTelefonoMecanico.getText();
            String especialidad = cmbEspecialidad.getValue().toString();

            if (nombreCompleto.isEmpty() || id.isEmpty() || telefono.isEmpty()) {
                showAlert("Campos vacíos", "Por favor, complete todos los campos");
                return;
            }

            Mecanico mecanico = new Mecanico(nombreCompleto, id, telefono, Especialidad);
            mecanicos.add(mecanico);

            txtNombreMecanico.clear();
            txtIdMecanico.clear();
            txtTelefonoMecanico.clear();

    }

    private void showAlert(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    @FXML
    void onBuscar() {

    }

    @FXML
    void onEliminar() {
        String id = txtIdMecanico.getText();
        boolean eliminado = tallerController.eliminarCliente(id);

        if (eliminado) {
            lblMensaje.setText("Mecanico eliminado");
            actualizarTabla();
        } else {
            lblMensaje.setText("Mecanico no encontrado");
        }

    }

    @FXML
    void onVolver() {

    }
    public void setApp(App app) {
    }
}
