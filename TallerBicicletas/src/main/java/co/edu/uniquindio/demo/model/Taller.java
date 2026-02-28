package co.edu.uniquindio.demo.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Taller {

    private static Taller instancia;

    private String nombreCompleto;
    private String telefono;
    private String direccion;
    private List<Cliente> clientes ;
    private List<Mecanico> mecanicos ;
    private List<Bicicleta> bicicletas ;
    private List<Servicio> servicios ;
    private List<Repuesto> repuestos ;
    private List<Proveedor> proveedores ;

    public Taller() {
        this.nombreCompleto = "";
        this.telefono = "";
        this.direccion = "";
        this.clientes = new ArrayList<>();
        this.servicios = new ArrayList<>();
        this.bicicletas = new ArrayList<>();
        this.mecanicos = new ArrayList<>();
        this.proveedores = new ArrayList<>();
        this.repuestos = new ArrayList<>();

    }

    public static Taller getInstancia() {
        if (instancia == null) {
            instancia = new Taller();
        }
        return instancia;
    }



    public Taller(String nombreCompleto, String direccion, String telefono) {
        this.nombreCompleto = nombreCompleto;
        this.proveedores = new ArrayList<>();
        this.repuestos = new ArrayList<>();
        this.servicios = new ArrayList<>();
        this.bicicletas = new ArrayList<>();
        this.mecanicos = new ArrayList<>();
        this.clientes = new ArrayList<>();
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public List<Mecanico> getMecanicos() {
        return mecanicos;
    }

    public List<Servicio> getServicios() {
        return servicios;
    }

    public List<Bicicleta> getBicicletas() {
        return bicicletas;
    }

    public List<Repuesto> getRepuestos() {
        return repuestos;
    }

    public List<Proveedor> getProveedores() {
        return proveedores;
    }
    public void agregarBicicleta(Bicicleta bicicleta){
        bicicleta.add(bicicleta);
    }
    public boolean eliminarBicicleta(String numeroSerial) {
        for(Bicicleta b :bicicletas){
            if (b.getNumeroSerial().equals(numeroSerial)) {
                bicicletas.remove(b);
            }
        }
        return true;
    }

    public void agregarCliente(Cliente cliente){
        cliente.add(cliente);
    }
    public boolean eliminarCliente(Cliente cliente){
        cliente.remove(cliente);
        return true;
    }
    public Cliente buscarCliente(String id){
        for(Cliente cliente: clientes){
            if(cliente.getId().equals(id)){
                return cliente;
            }
        }
        return null;
    }
    public void agregarMecanico(Mecanico mecanico){
        mecanico.add(mecanico);
    }
    public boolean eliminarMecanico(Mecanico mecanico){
        mecanico.remove(mecanico);
        return true;
    }
    public Mecanico buscarMecanico(String id){
        for(Mecanico mecanico: mecanicos){
            if(mecanico.getId().equals(id)){
                return mecanico;
            }
        }
        return null;
    }
    public void crearServicio(Servicio servicio){
        servicio.add(servicio);
    }
    public Servicio buscarServicio(String id){
        for(Servicio servicio: servicios){
            if(servicio.getId().equals(id)){
                return servicio;
            }
        }
        return null;
    }
    public List<Servicio> historialBicicleta(String numeroSerial){
        List<Servicio> historial = new ArrayList<>();
        for(Servicio servicio : servicios){
            if(servicio.getBicicletaAtendida().getNumeroSerial().equals(numeroSerial)){
               historial.add(servicio);
            }
        }
        return historial;
    }
    public List<Servicio> consultarServiciosPorFecha(LocalDate fecha){
        List<Servicio> fechas = new ArrayList<>();
        for(Servicio servicio : servicios){
            if(servicio.getFechaIngreso().equals(fecha)){
                fechas.add(servicio);
            }
        }
        return fechas;
    }
    public List<Repuesto> alertaStockBajo(){
        List<Repuesto> bajostock = new ArrayList<>();
        for(Repuesto repuesto : repuestos){
            if(repuesto.getStock() <= 3){
                bajostock.add(repuesto);
            }
        }
        return bajostock;
    }

}
