public class Localidad {
    private String nombre;
    private double precio;
    private int capacidad;
    private int vendidos;

    public Localidad(String nombre, double precio, int capacidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.capacidad = capacidad;
        this.vendidos = 0;
    }
    public int venderBoletos(int cantidadDeseada) {
        int disponibles = this.capacidad - this.vendidos;
        int cantidadVendida = Math.min(disponibles, cantidadDeseada);
        this.vendidos += cantidadVendida;
        return cantidadVendida;
    }
    public String getNombre() {
        return nombre;
    }
    public double getPrecio() {
        return precio;
    }
    public int getCapacidad() {
        return capacidad;
    }
    public int getVendidos() {
        return vendidos;
    }
    public double getRecaudacion() {
        return precio*vendidos;
    }
    public int getDisponibilidad() {
        return capacidad-vendidos;
    }
}