import Models.Cliente;
import Models.Habitacion;
import Models.Reserva;
import Service.Hotel;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class HotelManager {

    private static Scanner scanner = new Scanner(System.in);
    private static Hotel hotel;
    public static int opcion;


    public static void main(String[] args) {



        HotelManager hotelManager = new HotelManager();
        hotelManager.ingresarNombre();
        hotelManager.iniciar();

        scanner.close();
    }
    public void iniciar(){

        saludo(hotel.nombre);
        opcion = 0;

        while (opcion != 5){

            mostrarMenu();

            try {
                //Se asegura que lo que se ingrese sea un numero entero
                opcion = Integer.parseInt(scanner.nextLine());
                switch (opcion){
                    case 1 -> hotel.mostrarHabitaciones();
                    case 2 -> agregarReserva();
                    case 3 -> quitarReserva();
                    case 4 ->mostrarReservas();
                    case 5 -> {
                        System.out.println("Hasta luego...");
                    }
                    default -> System.out.println("❌ Opción inválida. Por favor seleccione del 1 al 4.");
                }
            }catch (NumberFormatException e){
                System.out.println("❌ Por favor ingrese un número válido.");
            }
            if (opcion != 5){
                System.out.println("\nPresione ENTER para continuar...");
                scanner.nextLine();
            }

        }
    }
    private void saludo(String nombre){
        System.out.println("\n" + "=".repeat(50));
        System.out.println("    Bienvenido al Hotel " + nombre);
        System.out.println("=".repeat(50));

    }
    private void quitarReserva(){

        System.out.println("+".repeat(30));
        System.out.println("Quitar Reserva");
        System.out.println("+".repeat(30));

        System.out.print("Ingrese el numero de habitacion: ");
        String numHabitacion = scanner.nextLine();

        hotel.QuitarResera(numHabitacion);




    }

    private void mostrarReservas(){
        if (hotel.reservas.size() == 0){
            System.out.println("No hay Reservas activas");
        }else {
            hotel.mostrarReservas();
        }
    }

    private void mostrarMenu(){

        System.out.println("\n===== MENU PRINCIPAL =====");
        System.out.println("1. Ver habitaciones");
        System.out.println("2. Hacer reserva");
        System.out.println("3. Quitar reservas");
        System.out.println("4. Mostrar Reservas");
        System.out.println("5. Salir");
        System.out.println("=".repeat(60));
        System.out.print("Elija una opción: ");
    }
    public void ingresarNombre(){

        System.out.print("Hola, \nIngresa el Nombre del Hotel : ");
        String nombre = scanner.nextLine();
        hotel = new Hotel(nombre);
        System.out.println("Nombre actualizado con exito");

    }

    public void agregarReserva(){
        System.out.println("+".repeat(30));
        System.out.println("Agregar Reserva");
        System.out.println("+".repeat(30));

        System.out.print("Ingrese el nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el numero de DNI: ");
        String dni = scanner.nextLine();
        System.out.print("Ingrese el numero de telefono: ");
        String telefono = scanner.nextLine();
        System.out.print("Ingrese el numero de habitacion: ");
        String numHabitacion = scanner.nextLine();
        System.out.print("Cuantas noches desea hospedarse: ");
        int noches = Integer.parseInt(scanner.nextLine());

        Cliente cliente = new Cliente(nombre,dni,telefono);

        hotel.ReservarHabitacion(cliente,numHabitacion,noches);
    }
}