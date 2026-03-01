package co.edu.uniquindio.demo.viewController;

import co.edu.uniquindio.demo.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class OpcionesProgramaViewController {

    @FXML
    private Button btnBicicletas;

    @FXML
    private Button btnClientes;

    @FXML
    private Button btnMecanicos;

    @FXML
    private Button btnRepuestos;

    @FXML
    private Button btnServicios;

    private App app;

    public void setApp(App app){
        this.app = app;
    }


    @FXML
    void onBicicletas() {
        app.openCRUDBicicletas();

    }

    @FXML
    void onClientes() {
        app.openCRUDClientes();

    }

    @FXML
    void onMecanicos() {
        app.openCRUDMecanicos();

    }

    @FXML
    void onRepuestos() {
        app.openCRUDRepuestos();

    }

    @FXML
    void onServicios() {
        app.openServiciosVista();

    }


}

