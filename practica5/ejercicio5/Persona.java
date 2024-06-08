package practica5.ejercicio5;

public class Persona {
    private String tipo;
    private String nombre;
    private String domicilio;
    private boolean cobro;

    public Persona(String tipo, String nombre, String domicilio, boolean cobro) {
        this.tipo = tipo;
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.cobro = cobro;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public boolean equals(Persona other) {
        return this.tipo.equals(other.tipo) && this.nombre.equals(other.nombre)
                && this.domicilio.equals(other.domicilio);
    }

    public boolean esJubilado() {
        return this.tipo.equals("Jubilado");
    }

    public boolean haCobrado() {
        return this.cobro;
    }

}
