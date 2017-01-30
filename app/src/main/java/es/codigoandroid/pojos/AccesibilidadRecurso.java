package es.codigoandroid.pojos;



public class AccesibilidadRecurso {
    private String _id;
    private TipoAccesibilidad tipoAccesibilidad;
    private String titulo;
    private String descripcion;

    //Constructor por defecto
    public AccesibilidadRecurso() {
    }

    //getter and setters
    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public TipoAccesibilidad getTipoAccesibilidad() {
        return tipoAccesibilidad;
    }

    public void setTipoAccesibilidad(TipoAccesibilidad tipoAccesibilidad) {
        this.tipoAccesibilidad = tipoAccesibilidad;
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
}
