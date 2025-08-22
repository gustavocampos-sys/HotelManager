package Models;

public enum EstadoHabitacion {

    LIBRE("Habitación Libre"),
    OCUPADO("Habitación Ocupada"),
    ENLIMPIEZA("Habitación en Limpieza"),
    NODISPONIBLE("Habitación no Disponible");

    private final String descripcion;

    EstadoHabitacion(String descripcion){
        this.descripcion = descripcion;
    }

    public String getDescripcion(){
        return descripcion;
    }
}
