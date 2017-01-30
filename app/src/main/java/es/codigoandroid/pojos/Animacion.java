package es.codigoandroid.pojos;



public class Animacion {
    private String _id;
    private TipoAnimacion tipoAnimacion;
    private String titulo;
    private String descripcion;
    private String base64;
    private String path;

    public Animacion() {
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public TipoAnimacion getTipoAnimacion() {
        return tipoAnimacion;
    }

    public void setTipoAnimacion(TipoAnimacion tipoAnimacion) {
        this.tipoAnimacion = tipoAnimacion;
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

    public String getBase64() {
        return base64;
    }

    public void setBase64(String base64) {
        this.base64 = base64;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
