package co.edu.uniquindio.demo.controller;
import co.edu.uniquindio.demo.model.Taller;
import co.edu.uniquindio.demo.model.Cliente;

import java.time.LocalDate;
import java.time.LocalTime;
//En este controllador vamos a guardar toda la logica del programa que se encuentra en taller

public class TallerController {
    private Taller taller = Taller.getInstancia();

    //Aqui voy a hacer la logica de clientes
    public void agregarCliente(String nombreCompleto, String id, String telefono, String direccion) {
        Cliente cliente = new Cliente(nombreCompleto, id, telefono, direccion);
        taller.agregarCliente(cliente);
    }

    public void eliminarCliente(String id) {
        taller.eliminarCliente(id);
    }

    public Cliente buscarCliente(String id) {
        return taller.buscarCliente(id);
    }

    //Logica para mecanico
    public void agregarMecanico(String nombreCompleto, String id, String telefono, Especialidad especialidad) {
        Mecanico mecanico = new Mecanico(nombreCompleto, id, telefono, especialidad);
        taller.agregarMecanico(mecanico);
    }

    public void eliminarMecanico(String id) {
        taller.eliminarMecanico(id);
    }

    public Mecanico buscarMecanico(String id) {
        return taller.buscarMecanico(id);
    }

    //Logica para bicicleta
    public void agregarBicicleta(String marca, Tipo tipo, String color, String numeroSerial, int ano, Cliente propietario) {
        Bicicleta bicicleta = new Bicicleta(marca, tipo, color, numeroSerial, ano, propietario);
        taller.agregarBicicleta(bicicleta);
    }

    public void eliminarBicicleta(String numeroSerial) {
        taller.eliminarBicicleta(numeroSerial);
    }

    //Logica de Servicios
    public void crearServicio(String id, LocalDate fechaIngreso, LocalTime hora, bicicletaAtendida Bicicleta, mecanicoResponsable Mecanico
            , String motivo, String diagnostico, String trabajoRealizado, double costoTotal) {
        Servicio servicio = new Servicio(id, fechaIngreso, hora, Bicicleta, Mecanico, motivo, diagnostico, trabajoRealizado, costoTotal);
        taller.crearServicio(servicio);
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

}


