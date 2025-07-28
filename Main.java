import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String [] args) {

        Localidad localidad1 = new Localidad("Localidad 1", 100, 20);
        Localidad localidad2 = new Localidad ("Localidad 5", 500, 20);
        Localidad localidad3 = new Localidad("Localidad 10", 1000, 20);

        Localidad[] localidades = {localidad1, localidad2, localidad3};
    
        Scanner teclado = new Scanner(System.in);

        Comprador comprador = null;

        int opcion = 0;
        while (opcion != 5) {
            System.out.println("THE ERAS TOUR // MENÚ //:");
            System.out.println("1. Nuevo comprador");
            System.out.println("2. Comprar boletos");
            System.out.println("3. Consultar disponibilidad");
            System.out.println("4. Reporte de ventas");
            System.out.println("5. Salir");
            System.out.print("Seleccionar: ");

            opcion = teclado.nextInt();

            switch (opcion) {
                case 1:
                    comprador = new Comprador();
                    comprador.comprar();
                    break;
                case 2:
                    if (comprador == null) {
                        System.out.println("Debe registrar un comprador primero");
                        break;
                    }
                    if (comprador.validarTicket() == true) {
                        Random rand = new Random();
                        Localidad localidadAsignada = localidades[rand.nextInt(3)];

                        if (comprador.getPresupuesto() < localidadAsignada.getPrecio()) {
                            System.out.println("No puede proceder a la compra debido a su presupuesto.");
                        }
                        else {
                        System.out.println("Localidad asignada: " + localidadAsignada.getNombre());
                        System.out.println("Precio unitario: $" + localidadAsignada.getPrecio());
                        
                        int cantidadDeseada = comprador.getCantidadBoletos();
                        int vendidos = localidadAsignada.venderBoletos(cantidadDeseada);
                        
                        if (vendidos > 0) {
                            System.out.println("Boletos comprados: " + vendidos);
                            System.out.println("Total: $" + (vendidos * localidadAsignada.getPrecio()));
                        }
                        else {
                            System.out.println("No hay suficientes boletos");
                        }   
                        }
                    }
                    else {
                        System.out.println("Su ticket no es válido para comprar"); 
                    }
                    break;
                case 3: 
                    System.out.println("Disponibilidad");
                    for (int i = 0; i < localidades.length; i++) {
                        System.out.printf("%s: %d disponibles\n", localidades[i].getNombre(), localidades[i].getDisponibilidad());
                    }
                    break;
                case 4:
                    System.out.println("Reporte de ventas:");
                    double total = 0;
                    for (Localidad localidadAsignada : localidades) {
                        double recaudado = localidadAsignada.getRecaudacion();
                        System.out.println(localidadAsignada.getNombre() + ": $" + recaudado);
                        total += recaudado;
                    }
                    System.out.println("Total: $" + total);
                    break;
                case 5:
                    System.out.println("¡Gracias por usar el sistema de Eras Tour!");
                    break;
            }
        }
    }
}