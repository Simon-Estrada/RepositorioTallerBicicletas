package co.edu.uniquindio.demo.model;

public class Bicicleta {
    private String marca;
    private Tipo tipo;
    private String color;        ;
    private String numeroSerial;
    private int año;
    private Cliente propietario;

    public Bicicleta(String marca, Tipo tipo, String color, String numeroSerial, int año, Cliente propietario) {
        this.marca = marca;
        this.tipo = tipo;
        this.color = color;
        this.numeroSerial = numeroSerial;
        this.año = año;
        this.propietario = propietario;
    }

    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }

    public Tipo getTipo() { return tipo; }


    public String getColor() {return color; }
    public void setColor(String color) {this.color = color; }

    public String getNumeroSerial() {return numeroSerial; }
    public void setNumeroSerial(String numeroSerial) { this.numeroSerial = numeroSerial; }

    public int getAno() { return año; }
    public void setAno(int ano) { this.año = ano; }

    public Cliente getPropietario() { return propietario; }
    public void setPropietario(Cliente propietario) { this.propietario = propietario; }

    public void add(Bicicleta bicicleta) {
    }
}

