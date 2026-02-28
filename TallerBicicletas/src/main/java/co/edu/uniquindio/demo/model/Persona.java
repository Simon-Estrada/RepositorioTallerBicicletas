package co.edu.uniquindio.demo.model;

public class Persona {
    private String nombreCompleto ;
    private String id;
    private String telefono ;

    public Persona(String nombreCompleto, String id, String telefono) {
        this.nombreCompleto = nombreCompleto;
        this.id = id;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
