package co.edu.uniquindio.demo.controller;
import co.edu.uniquindio.demo.model.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
//En este controllador vamos a guardar toda la logica del programa que se encuentra en taller

public class TallerController {
    private Taller taller = Taller.getInstancia();
    private static TallerController instancia;

    private TallerController() {
        this.taller = Taller.getInstancia();
    }

    public static TallerController getInstancia() {
        if(instancia == null) {
            instancia = new TallerController();
        }
        return instancia;
    }

    //Aqui voy a hacer la logica de clientes
    public void agregarCliente(String nombreCompleto, String id, String telefono, String direccion) {
        Cliente cliente = new Cliente(nombreCompleto, id, telefono, direccion);
        taller.agregarCliente(cliente);
    }

    public boolean eliminarCliente(String id) {
        return taller.eliminarCliente(id);
    }

    public Cliente buscarCliente(String id) {
        return taller.buscarCliente(id);
    }

    //Logica para mecanico
    public void agregarMecanico(String nombreCompleto, String id, String telefono, Especialidad especialidad) {
        Mecanico mecanico = new Mecanico(nombreCompleto, id, telefono, especialidad);
        taller.agregarMecanico(mecanico);
    }

    public boolean eliminarMecanico(String id) {
        taller.eliminarMecanico(id);
        return false;
    }

    public Mecanico buscarMecanico(String id) {
        return taller.buscarMecanico(id);
    }

    //Logica para bicicleta
    public void agregarBicicleta(String marca, Tipo tipo, String color,
                                 String serial, int ano, String idPropietario) {
        Cliente propietario = taller.buscarCliente(idPropietario);
        if(propietario != null) {
            Bicicleta bicicleta = new Bicicleta(marca, tipo, color, serial, ano, propietario);
            taller.agregarBicicleta(bicicleta);
        }
    }

    public boolean eliminarBicicleta(String numeroSerial) {
        taller.eliminarBicicleta(numeroSerial);
        return false;
    }

    //Logica de Servicios
    public Servicio crearServicio(String id, LocalDate fecha, String idBicicleta,
                                  String idMecanico, String motivo, String diagnostico, Trabajo trabajoRealizado) {
        Bicicleta bicicleta = taller.buscarBicicleta(idBicicleta);
        Mecanico mecanico = taller.buscarMecanico(idMecanico);

        if(bicicleta != null && mecanico != null) {
            Servicio servicio = new Servicio(id, fecha, LocalTime.now(),
                    bicicleta, mecanico, motivo, diagnostico, trabajoRealizado);
            taller.crearServicio(servicio);
            return servicio;
        }
        return null;
    }
    public void agregarRepuestoAServicio(String idServicio, Repuesto repuesto) {
        Servicio servicio = taller.buscarServicio(idServicio);
        if(servicio != null) {
            servicio.agregarRepuesto(repuesto);
        }
    }

    public double calcularCostoServicio(String idServicio) {
        Servicio servicio = taller.buscarServicio(idServicio);
        if(servicio != null) {
            return servicio.calcularCosto();
        }
        return 0.0;
    }

    public Servicio buscarServicio(String id) {
        return taller.buscarServicio(id);
    }

    public List<Servicio> historialBicicleta(String numeroSerial) {
        return taller.historialBicicleta(numeroSerial);
    }

    public List<Servicio> consultarServiciosPorFecha(LocalDate fecha) {
        return taller.consultarServiciosPorFecha(fecha);
    }

    public List<Repuesto> alertaStockBajo() {
        return taller.alertaStockBajo();
    }

    public List<Cliente> getClientes() {
        return taller.getClientes();
    }
    public List<Servicio> getServicios() {
        return taller.getServicios();
    }


    public List<Bicicleta> getBicicletas() {
        return taller.getBicicletas();
    }

    public List<Mecanico> getMecanicos() {
        return taller.getMecanicos();
    }
}


