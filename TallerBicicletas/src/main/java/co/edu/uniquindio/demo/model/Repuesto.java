package co.edu.uniquindio.demo.model;

public class Repuesto {
    private String nombre;
    private int stock;
    private double precio;

    public Repuesto(double precio, int stock, String nombre) {
        this.precio = precio;
        this.stock = stock;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }
    public void actualizarStock(int stock) {
        this.stock = stock;
    }

    public void actualizarPrecio(double precio) {
        this.precio = precio;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
