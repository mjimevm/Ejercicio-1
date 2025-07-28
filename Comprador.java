import java.util.Random;
import java.util.Scanner;

public class Comprador {
    private String nombre;
    private String email;
    private int cantidadBoletos;
    private double presupuesto;
    private int numeroTicket;

    public void comprar() {
        Scanner teclado = new Scanner(System.in);
        System.out.print("Ingrese su nombre: ");
        nombre = teclado.nextLine();
        System.out.print("Ingrese su email: ");
        email = teclado.nextLine();
        System.out.print("Ingrese la cantidad de boletos que desea comprar: ");
        cantidadBoletos = teclado.nextInt();
        System.out.print("Ingrese su presupuesto máximo: ");
        presupuesto = teclado.nextDouble();
    }
    public String getNombre() {
        return nombre;
    }
    public String getEmail() {
        return email;
    }
    public int getCantidadBoletos() {
        return cantidadBoletos;
    }
    public double getPresupuesto() {
        return presupuesto;
    }
    public int getNumeroTicket() {
        return numeroTicket;
    }
    public void setNumeroTicket(int numeroTicket) {
        this.numeroTicket = numeroTicket;
    }
    public boolean validarTicket() {
        Random rand = new Random();
        int numeroTicket = rand.nextInt(15000);
        int a = rand.nextInt(15000);
        int b = rand.nextInt(15000);
        if (a > b) {
            int temp = a;
            a = b;
            b = temp;
        }
        boolean esValido = (numeroTicket >= a && numeroTicket <= b);

        setNumeroTicket(numeroTicket);
        return esValido;
    }
    
}