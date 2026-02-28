package co.edu.uniquindio.demo.model;

import java.util.ArrayList;
import java.util.List;

public class Proveedor {

    private String nombre;
    private String id;
    private String telefono;
    private List<Repuesto> repuestos;

    public Proveedor(String nombre, String id, String telefono) {
        this.nombre = nombre;
        this.id = id;
        this.telefono = telefono;
        this.repuestos = new ArrayList<>();
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public List<Repuesto> getRepuestos() { return repuestos; }
    public void setRepuestos(List<Repuesto> repuestos) { this.repuestos = repuestos; }
}