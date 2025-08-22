package Service;

import Models.*;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Hotel {

    public List<Habitacion> habitaciones = new ArrayList<>();
    public List<Reserva> reservas = new ArrayList<>();
    public Cliente cliente;
    public Reserva reserva;
    public String nombre;
    public Habitacion habitacion;

    public Hotel(String nombre) {
        this.nombre = nombre;
        CargarHabitaciones();
    }

    public void CargarHabitaciones(){
        habitaciones.add(new Habitacion("101",50, Tipo.SIMPLE));
        habitaciones.add(new Habitacion("102",50, Tipo.SIMPLE));
        habitaciones.add(new Habitacion("103",50, Tipo.SIMPLE));
        habitaciones.add(new Habitacion("104",100, Tipo.DOBLE));
        habitaciones.add(new Habitacion("105",100, Tipo.DOBLE));
        habitaciones.add(new Habitacion("106",150, Tipo.SUITE));
    }
    public void QuitarResera(String numHabitacion){

        int i = 0;
        habitacion = buscarHabitacion(numHabitacion);
        if (habitacion != null && habitacion.getEstado() == EstadoHabitacion.OCUPADO){

            for (Reserva reserv : reservas){

                if (Objects.equals(reserv.getHabitacion().getCodigodeHabitacion(), numHabitacion)){
                    habitacion.setEstado(EstadoHabitacion.LIBRE);
                    System.out.println("La habitacion ahora esta libre...");
                    reservas.remove(i);
                    break;
                }
                i++;
            }
        }
    }

    public void ReservarHabitacion(Cliente cliente, String numeroHabitacion, int noches){

        habitacion = buscarHabitacion(numeroHabitacion);
        if (habitacion != null && habitacion.getEstado() == EstadoHabitacion.LIBRE){
            reserva = new Reserva(cliente,habitacion,noches);
            reservas.add(reserva);
            habitacion.setEstado(EstadoHabitacion.OCUPADO);
            System.out.println("✅ Reserva registrada exitosamente : " + "S/ " + reserva.getTotal());
        }else {
            System.out.println("❌ Habitación no disponible.");
        }
    }

    public Habitacion buscarHabitacion(String numero){

        for (Habitacion hab : habitaciones){
            if (Objects.equals(hab.getCodigodeHabitacion(), numero)){
                return hab;
            }
        }
        return null;
    }

    public void mostrarReservas(){

        DateTimeFormatter formatoFecha= DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        for (Reserva reserva:reservas){

            System.out.println("+".repeat(30));
            System.out.printf("%-15s %s%n","Fecha: ", reserva.getFecha().format(formatoFecha));
            System.out.printf("%-15s %s%n","Habitacion : ", reserva.getHabitacion().getCodigodeHabitacion());
            System.out.printf("%-15s %s%n","Cliente : ", reserva.getCliente().getNombre());
            System.out.printf("%-15s %s%n","Fecha: ", reserva.getFechaFin().format(formatoFecha));
            System.out.println("+".repeat(30));

        }
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public String getnombre(){
        return this.nombre;
    }

    public void mostrarHabitaciones(){
        System.out.println("=".repeat(30));
        System.out.println("Mostrando Habitaciones");
        System.out.println("=".repeat(30));

        for(Habitacion habitacion : habitaciones ){

            System.out.println("+".repeat(30));
            System.out.printf("%-15s %s%n","Habitacion ",habitacion.getCodigodeHabitacion());
            System.out.printf("%-15s %s%n","Tipo : " , habitacion.getTipo());
            System.out.printf("%-15s %s%n","Estado : " , habitacion.getEstado());
            System.out.printf("%-15s %s%n","Precio : S/" , habitacion.getPrecio());
            System.out.println("+".repeat(30));
        }

    }

}

