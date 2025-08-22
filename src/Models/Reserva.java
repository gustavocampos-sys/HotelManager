package Models;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Reserva {

    private Cliente cliente;
    private Habitacion habitacion;
    private LocalDateTime fecha;
    private EstadoHabitacion estadoHabitacion;
    private int noches;
    private LocalDateTime fechaFin;

    double total;

    public Reserva( Cliente cliente, Habitacion habitacion, int noches) {
        this.cliente = cliente;
        this.habitacion = habitacion;
        this.fecha = LocalDateTime.now();
        this.estadoHabitacion = EstadoHabitacion.OCUPADO;
        this.noches = noches;
        this.total = habitacion.getPrecio() * noches;
        fechaFin = fecha.plusDays(noches);
    }

    //geters and seters


    public LocalDateTime getFechaFin() {
        return fechaFin;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public EstadoHabitacion getEstadoHabitacion() {
        return estadoHabitacion;
    }

    public void setEstadoHabitacion(EstadoHabitacion estadoHabitacion) {
        this.estadoHabitacion = estadoHabitacion;
    }

    public int getNoches() {
        return noches;
    }

    public void setNoches(int noches) {
        this.noches = noches;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "cliente=" + cliente +
                ", habitacion=" + habitacion +
                ", fecha=" + fecha +
                ", estadoHabitacion=" + estadoHabitacion +
                ", noches=" + noches +
                ", total=" + total +
                '}';
    }
}
