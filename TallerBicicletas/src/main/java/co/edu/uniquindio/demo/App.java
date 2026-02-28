package co.edu.uniquindio.demo;

import co.edu.uniquindio.demo.viewController.BicicletaViewController;
import co.edu.uniquindio.demo.viewController.ClienteViewController;
import co.edu.uniquindio.demo.viewController.InicioviewController;
import co.edu.uniquindio.demo.viewController.OpcionesProgramaViewController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application{
    private static Stage inicioStage;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        this.inicioStage = stage;
        this.inicioStage.setTitle("Taller de Bicicletas | UQ");
        openViewPrincipal();
    }
    private void openViewPrincipal(){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("co/edu/uniquindio/demo/inicioView.fxml"));
            javafx.scene.layout.VBox rootLayout = (javafx.scene.layout.VBox) loader.load();
            InicioviewController inicioviewController = loader.getController();
            inicioviewController.setApp(this);

            Scene scene = new Scene(rootLayout);
            inicioStage.setScene(scene);
            inicioStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void openOpcionesPrograma() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("opcionesProgramaView.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            OpcionesProgramaViewController opcionesProgramaViewController = loader.getController();
            opcionesProgramaViewController.setApp(this);

            Scene scene = new Scene(rootLayout);
            inicioStage.setScene(scene);
            inicioStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void openCRUDClientes(){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("crudCliente.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            ClienteViewController clienteViewController = loader.getController();
            clienteViewController.setApp(this);

            Scene scene = new Scene(rootLayout);
            inicioStage.setScene(scene);
            inicioStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void openCRUDBicicletas(){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("crudBicicleta.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            BicicletaViewController bicicletaViewController = loader.getController();
            bicicletaViewController.setApp(this);

            Scene scene = new Scene(rootLayout);
            inicioStage.setScene(scene);
            inicioStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


}

