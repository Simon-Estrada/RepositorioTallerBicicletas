package co.edu.uniquindio.demo.model;

public enum Trabajo {
    COMPLETO(Especialidad.AjusteCompleto),
    FRENOS(Especialidad.FrenoTransmision),
    CAMBIOSSUSPENCION(Especialidad.Suspencion),
    ELECTRICA(Especialidad.BicicletasElectricas),
    RUEDAS(Especialidad.Ruedasllantas);

    private Especialidad especialidad;
    Trabajo(Especialidad especialidad){
        this.especialidad =especialidad;

    }
    public Especialidad getEspecialidad(){
        return especialidad;
    }
}
