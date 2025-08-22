package Models;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Habitacion {


    private String codigodeHabitacion;
    private double precio;
    private Tipo tipo;

    private Cliente usuario;

    private EstadoHabitacion estado; // Disponible, Ocupado, Reservada, No Disponible

    public Habitacion(String codigodeHabitacion, double precio, Tipo tipo) {
        this.codigodeHabitacion = codigodeHabitacion;
        this.precio = precio;
        this.tipo = tipo;
        this.usuario = null;
        this.estado = EstadoHabitacion.LIBRE;
    }


    //Geters and Seters


    public String getCodigodeHabitacion() {
        return codigodeHabitacion;
    }

    public void setCodigodeHabitacion(String codigodeHabitacion) {
        this.codigodeHabitacion = codigodeHabitacion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public Cliente getUsuario() {
        return usuario;
    }

    public void setUsuario(Cliente usuario) {
        this.usuario = usuario;
    }

    public EstadoHabitacion getEstado() {
        return estado;
    }

    public void setEstado(EstadoHabitacion estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Habitacion{" +
                "codigodeHabitacion='" + codigodeHabitacion + '\'' +
                ", precio=" + precio +
                ", tipo=" + tipo +
                ", usuario=" + usuario +
                ", estado=" + estado +
                '}';
    }
}
