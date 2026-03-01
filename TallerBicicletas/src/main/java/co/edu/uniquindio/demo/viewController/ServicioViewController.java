package co.edu.uniquindio.demo.viewController;

import co.edu.uniquindio.demo.App;
import co.edu.uniquindio.demo.controller.ProveedorController;
import co.edu.uniquindio.demo.controller.TallerController;
import co.edu.uniquindio.demo.model.Proveedor;
import co.edu.uniquindio.demo.model.Repuesto;
import co.edu.uniquindio.demo.model.Servicio;
import co.edu.uniquindio.demo.model.Trabajo;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;
import java.util.List;

public class ServicioViewController {

    @FXML private TextField txtId;
    @FXML private TextField txtIdBicicleta;
    @FXML private TextField txtIdMecanico;
    @FXML private TextField txtMotivo;
    @FXML private TextField txtDiagnostico;
    @FXML private ComboBox<Trabajo> cmbTrabajoRealizado;
    @FXML private DatePicker dpFechaIngreso;
    @FXML private ComboBox<Repuesto> cmbRepuestos;
    @FXML private Label lblCosto;
    @FXML private Label lblMensaje;
    @FXML private Label lblAlertaStock;
    @FXML private TableView<Servicio> tblServicios;
    @FXML private TableColumn<Servicio, String> colId;
    @FXML private TableColumn<Servicio, String> colFecha;
    @FXML private TableColumn<Servicio, String> colBicicleta;
    @FXML private TableColumn<Servicio, String> colMecanico;
    @FXML private TableColumn<Servicio, Double> colCosto;


    private App app;
    private TallerController tallerController = TallerController.getInstancia();
    private ProveedorController proveedorController = ProveedorController.getInstancia();
    private Servicio servicioActual;



    @FXML
    void initialize() {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colFecha.setCellValueFactory(new PropertyValueFactory<>("fechaIngreso"));
        colBicicleta.setCellValueFactory(new PropertyValueFactory<>("bicicletaAtendida"));
        colMecanico.setCellValueFactory(new PropertyValueFactory<>("mecanicoResponsable"));
        colCosto.setCellValueFactory(new PropertyValueFactory<>("costoTotal"));

        cmbRepuestos.getItems().addAll(proveedorController.getRepuestos());
        cmbTrabajoRealizado.getItems().addAll(Trabajo.values());
    }

    @FXML
    void onAgregarRepuesto() {
        Repuesto repuesto = cmbRepuestos.getValue();
        if(repuesto != null && servicioActual != null) {
            servicioActual.agregarRepuesto(repuesto);
            lblCosto.setText("Costo Total: $" + servicioActual.calcularCosto());


            List<Repuesto> stockBajo = proveedorController.alertaStockBajo();
            if(!stockBajo.isEmpty()) {
                lblAlertaStock.setText("Stock bajo en: " + stockBajo.get(0).getNombre());
            }
        } else {
            lblMensaje.setText("Primero crea el servicio");
        }
    }

    @FXML
    void onCrear() {
        String id = txtId.getText();
        LocalDate fecha = dpFechaIngreso.getValue();
        String idBicicleta = txtIdBicicleta.getText();
        String idMecanico = txtIdMecanico.getText();
        String motivo = txtMotivo.getText();
        String diagnostico = txtDiagnostico.getText();
        Trabajo trabajoRealizado = cmbTrabajoRealizado.getValue();

        servicioActual = tallerController.crearServicio(id, fecha, idBicicleta, idMecanico, motivo, diagnostico, trabajoRealizado);

        if(servicioActual != null) {
            lblMensaje.setText("Servicio creado, ahora agrega los repuestos usados");
            actualizarTabla();
        } else {
            lblMensaje.setText("Bicicleta o mecánico no encontrado");
        }
    }

    @FXML
    void onBuscar() {
        String id = txtId.getText();
        Servicio servicio = tallerController.buscarServicio(id);
        if(servicio != null) {
            txtMotivo.setText(servicio.getMotivo());
            txtDiagnostico.setText(servicio.getDiagnostico());
            cmbTrabajoRealizado.setValue(servicio.getTrabajoRealizado());
            dpFechaIngreso.setValue(servicio.getFechaIngreso());
            lblCosto.setText("Costo Total: $" + servicio.getCostoTotal());
            lblMensaje.setText("Servicio encontrado");
        } else {
            lblMensaje.setText("Servicio no encontrado");
        }
    }

    @FXML
    void onConsultarFecha() {
        LocalDate fecha = dpFechaIngreso.getValue();
        List<Servicio> servicios = tallerController.consultarServiciosPorFecha(fecha);
        tblServicios.getItems().clear();
        tblServicios.getItems().addAll(servicios);
    }

    @FXML
    void onVolver() {
        app.openOpcionesPrograma();
    }

    public void setApp(App app) {
        this.app = app;
    }

    private void actualizarTabla() {
        tblServicios.getItems().clear();
        tblServicios.getItems().addAll(tallerController.getServicios());
    }
}