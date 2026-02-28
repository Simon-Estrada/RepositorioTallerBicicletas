package co.edu.uniquindio.demo.model;

public class Mecanico extends Persona{

    private String especialidad;

    public Mecanico(String nombreCompleto, String id, String telefono , String especialidad) {
        super(nombreCompleto, id, telefono);
        this.especialidad = especialidad;
    }

    public String getEspecialidad() {
        return especialidad;
    }
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

}