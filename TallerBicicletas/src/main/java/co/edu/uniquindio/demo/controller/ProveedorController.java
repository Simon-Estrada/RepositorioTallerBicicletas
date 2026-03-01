package co.edu.uniquindio.demo.controller;

import co.edu.uniquindio.demo.model.Proveedor;
import co.edu.uniquindio.demo.model.Repuesto;

import java.util.List;

public class ProveedorController {
    private static ProveedorController instancia;
    private Proveedor proveedor = Proveedor.getInstancia();

    private ProveedorController() {}

    public static ProveedorController getInstancia() {
        if(instancia == null) {
            instancia = new ProveedorController();
        }
        return instancia;
    }

    public void agregarRepuesto(String nombre, int stock, double precio) {
        Repuesto repuesto = new Repuesto(precio, stock, nombre);
        proveedor.agregarRepuesto(repuesto);
    }
    public List<Repuesto> alertaStockBajo() {
        return proveedor.alertaStockBajo();
    }

    public boolean eliminarRepuesto(String nombre) {
        return proveedor.eliminarRepuesto(nombre);
    }

    public Repuesto buscarRepuesto(String nombre) {
        return proveedor.buscarRepuesto(nombre);
    }

    public List<Repuesto> getRepuestos() {
        return proveedor.getRepuestos();
    }
}