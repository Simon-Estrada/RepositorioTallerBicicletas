package co.edu.uniquindio.demo.viewController;

import co.edu.uniquindio.demo.App;
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

    @FXML
    private TextField txtEspecialidad;

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

    private ObservableList<Mecanico> mecanicos;
    private App app;


    @FXML
    public void initialize() {
        colNombreMecanico.setCellValueFactory(new PropertyValueFactory<>("Nombre Mecanico"));
        colIdMecanico.setCellValueFactory(new PropertyValueFactory<>("ID"));
        colTelefonoMecanico.setCellValueFactory(new PropertyValueFactory<>("Telefono Mecanico"));
        colEspecialidad.setCellValueFactory(new PropertyValueFactory<>("Especialidad"));

        mecanicos = FXCollections.observableArrayList(
                new Mecanico("Fabian Henao Sanchez" , "111456837230" , "30015104735" , Especialidad.FrenoTransmision)
        );

        tblMecanico.setItems(mecanicos);
    }

    @FXML
    void onAgregar() {
        String nombreCompleto = txtNombreMecanico.getText();
        String id = txtIdMecanico.getText();
        String telefono = txtTelefonoMecanico.getText();
        String especialidad = txtEspecialidad.getText();

    }

    @FXML
    void onBuscar() {

    }

    @FXML
    void onEliminar() {

    }

    @FXML
    void onVolver() {
        app.openOpcionesPrograma();

    }

    public void setApp(App app) {
    }
}
