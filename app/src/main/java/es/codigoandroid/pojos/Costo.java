package es.codigoandroid.pojos;



public class Costo {
    private String id;
    private Recursos recurso;
    private String descripcion;
    private float costo;
    private String nombre;

    public Costo() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Recursos getRecurso() {
        return recurso;
    }

    public void setRecurso(Recursos recurso) {
        this.recurso = recurso;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
