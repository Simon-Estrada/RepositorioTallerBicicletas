package co.edu.uniquindio.demo.model;

public class Cliente extends Persona{

    private String direccion;

    public Cliente (String nombreCompleto, String id, String telefono, String direccion) {
        super(nombreCompleto, id, telefono);
        this.direccion = direccion;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }


    @Override
    public String toString() {
        return getNombreCompleto();
    }
}
