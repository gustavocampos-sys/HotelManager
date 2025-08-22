package Models;

public enum Tipo {

    SIMPLE("Simple",30.00),
    DOBLE("Doble",60.00),
    SUITE("Suite",100.00);
    private String descripcion;
    private Double precio;

    Tipo(String descripcion,Double precio){
        this.descripcion = descripcion;
        this.precio = precio;
    }
    public String getDescripcion(){
        return descripcion;
    }
    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
}
