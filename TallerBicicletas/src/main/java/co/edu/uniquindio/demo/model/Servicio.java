package co.edu.uniquindio.demo.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Servicio {
    private String id;
    private LocalDate fechaIngreso;
    private LocalTime hora;
    private Bicicleta bicicletaAtendida;
    private Mecanico mecanicoResponsable;
    private String motivo;
    private String diagnostico;
    private Trabajo trabajoRealizado;
    private double costoTotal;
    private List<Repuesto> repuestos;

    public Servicio(String id, LocalDate fechaIngreso, LocalTime hora,
                    Bicicleta bicicletaAtendida, Mecanico mecanicoResponsable,
                    String motivo, String diagnostico, Trabajo trabajoRealizado) {

        this.id = id;
        this.fechaIngreso = fechaIngreso;
        this.hora = hora;
        this.bicicletaAtendida = bicicletaAtendida;
        this.mecanicoResponsable = mecanicoResponsable;
        this.motivo = motivo;
        this.diagnostico = diagnostico;
        this.trabajoRealizado = trabajoRealizado;
        this.repuestos = new ArrayList<>();
        this.costoTotal = 0;
    }

    public String getId() {
        return id;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public LocalTime getHora() {
        return hora;
    }

    public Bicicleta getBicicletaAtendida() {
        return bicicletaAtendida;
    }

    public Mecanico getMecanicoResponsable() {
        return mecanicoResponsable;
    }

    public String getMotivo() {
        return motivo;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public Trabajo getTrabajoRealizado() {
        return trabajoRealizado;
    }

    public double getCostoTotal() {
        return costoTotal;
    }

    public List<Repuesto> getRepuestos() {
        return repuestos;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public void setMecanicoResponsable(Mecanico mecanicoResponsable) {
        this.mecanicoResponsable = mecanicoResponsable;
    }

    public void setTrabajoRealizado(Trabajo trabajoRealizado) {
        this.trabajoRealizado = trabajoRealizado;
    }

    public void agregarRepuesto(Repuesto repuesto) {
        repuestos.add(repuesto);
        costoTotal += repuesto.getPrecio();
    }

    public double calcularCosto() {
        return costoTotal;
    }


}
