package co.edu.uniquindio.demo.model;

public class Mecanico extends Persona{

    private Especialidad especialidad;

    public Mecanico(String nombreCompleto, String id, String telefono , Especialidad especialidad) {
        super(nombreCompleto, id, telefono);
        this.especialidad = especialidad;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }


}