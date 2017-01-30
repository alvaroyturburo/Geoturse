package es.codigoandroid.pojos;


public class Facilidad {
    private String id;
    private String titulo;
    private String descripcion;
    private String gps;
    private TipoFacilidad tipo;

    public Facilidad() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getGps() {
        return gps;
    }

    public void setGps(String gps) {
        this.gps = gps;
    }

    public TipoFacilidad getTipo() {
        return tipo;
    }

    public void setTipo(TipoFacilidad tipo) {
        this.tipo = tipo;
    }
}
