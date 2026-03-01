package co.edu.uniquindio.demo.model;

import java.util.ArrayList;
import java.util.List;

public class Proveedor {
    private static Proveedor instancia;
    private List<Repuesto> repuestos = new ArrayList<>();

    private Proveedor() {}

    public static Proveedor getInstancia() {
        if(instancia == null) {
            instancia = new Proveedor();
        }
        return instancia;
    }

    private String nombre;
    private String id;
    private String telefono;

    public void agregarRepuesto(Repuesto repuesto) {
        repuestos.add(repuesto);
    }
    public boolean eliminarRepuesto(String id) {
        Repuesto repuesto = buscarRepuesto(id);
        if(repuesto != null) {
            repuestos.remove(repuesto);
            return true;
        }
        return false;
    }
    public Repuesto buscarRepuesto(String id) {
        for(Repuesto repuesto : repuestos) {
            if(repuesto.getNombre().equals(id)) {
                return repuesto;
            }
        }
        return null;
    }



    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public List<Repuesto> getRepuestos() { return repuestos; }
    public void setRepuestos(List<Repuesto> repuestos) { this.repuestos = repuestos; }

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