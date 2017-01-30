package es.codigoandroid.pojos;

import java.util.Date;



public class LocacionAtractivo {
    private String _id;
    private String gps;
    private Atractivo atractivo;
    private Estado estado;
    private Date fechaInicioDisponibilidad;
    private Date fechaFinDisponibilidad;

    public LocacionAtractivo() {
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getGps() {
        return gps;
    }

    public void setGps(String gps) {
        this.gps = gps;
    }

    public Atractivo getAtractivo() {
        return atractivo;
    }

    public void setAtractivo(Atractivo atractivo) {
        this.atractivo = atractivo;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Date getFechaInicioDisponibilidad() {
        return fechaInicioDisponibilidad;
    }

    public void setFechaInicioDisponibilidad(Date fechaInicioDisponibilidad) {
        this.fechaInicioDisponibilidad = fechaInicioDisponibilidad;
    }

    public Date getFechaFinDisponibilidad() {
        return fechaFinDisponibilidad;
    }

    public void setFechaFinDisponibilidad(Date fechaFinDisponibilidad) {
        this.fechaFinDisponibilidad = fechaFinDisponibilidad;
    }
}
