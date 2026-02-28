package co.edu.uniquindio.demo.viewController;

import co.edu.uniquindio.demo.App;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class InicioviewController {

    @FXML
    private Button btnIniciar;
    private App app;

    @FXML
    void onEntrar() {
        app.openOpcionesPrograma();
    }
    public void setApp(App app){
        this.app = app;
    }
    @FXML
    void initialize(){

    }


}
