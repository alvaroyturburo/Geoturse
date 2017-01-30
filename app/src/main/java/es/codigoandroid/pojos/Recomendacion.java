package es.codigoandroid.pojos;

import java.util.ArrayList;
import java.util.Date;


public class Recomendacion {
    private String id;
    private Usuario usuario;
    private Recursos recurso;
    private String titulo;
    private String descripcion;
    private int puntuacion;
    private int votosFavor;
    private int votosContra;
    private Imagen imagen;
    private Date fecha;
    private ArrayList<Comentario> idiomasInformac = new ArrayList<Comentario>();
    private boolean reportado;

    public Recomendacion() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Recursos getRecurso() {
        return recurso;
    }

    public void setRecurso(Recursos recurso) {
        this.recurso = recurso;
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

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public int getVotosFavor() {
        return votosFavor;
    }

    public void setVotosFavor(int votosFavor) {
        this.votosFavor = votosFavor;
    }

    public int getVotosContra() {
        return votosContra;
    }

    public void setVotosContra(int votosContra) {
        this.votosContra = votosContra;
    }

    public Imagen getImagen() {
        return imagen;
    }

    public void setImagen(Imagen imagen) {
        this.imagen = imagen;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public ArrayList<Comentario> getIdiomasInformac() {
        return idiomasInformac;
    }

    public void setIdiomasInformac(ArrayList<Comentario> idiomasInformac) {
        this.idiomasInformac = idiomasInformac;
    }

    public boolean isReportado() {
        return reportado;
    }

    public void setReportado(boolean reportado) {
        this.reportado = reportado;
    }

    public void responder(){
    }

    public void votarFavor(){
    }

    public void votarContra(){
    }

    public void subirImagen(){
    }

    public void reportar(){
    }
}
