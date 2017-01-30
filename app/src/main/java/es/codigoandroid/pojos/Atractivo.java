package es.codigoandroid.pojos;

import java.util.ArrayList;

public class Atractivo {
    private String _id;
    private String nombre;
    private String descripcion;
    private ArrayList<Imagen> imagen = new ArrayList<Imagen>();
    private TipoAtractivo tipoAtractivo;
    private Estado estado;
    private Imagen imagenPrincipal;

    //Contructor por defecto
    public Atractivo() {
    }

    //getters and setters


    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public ArrayList<Imagen> getImagen() {
        return imagen;
    }

    public void setImagen(ArrayList<Imagen> imagen) {
        this.imagen = imagen;
    }

    public TipoAtractivo getTipoAtractivo() {
        return tipoAtractivo;
    }

    public void setTipoAtractivo(TipoAtractivo tipoAtractivo) {
        this.tipoAtractivo = tipoAtractivo;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Imagen getImagenPrincipal() {
        return imagenPrincipal;
    }

    public void setImagenPrincipal(Imagen imagenPrincipal) {
        this.imagenPrincipal = imagenPrincipal;
    }
}
