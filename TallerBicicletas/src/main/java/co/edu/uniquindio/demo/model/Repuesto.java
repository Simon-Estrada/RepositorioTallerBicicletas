package co.edu.uniquindio.demo.model;

public class Repuesto {
    private String nombre;
    private int stock;
    private double precio;

    public Repuesto(String nombre, int stock, double precio) {
        this.nombre = nombre;
        this.stock = stock;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public int getStock() {
        return stock;
    }

    public double getPrecio() {
        return precio;
    }

    public void actualizarStock(int cantidad) {
        this.stock += cantidad;
    }

    public void actualizarPrecio(double precio) {
        this.precio = precio;
    }
}
