package es.codigoandroid.pojos;

import java.util.ArrayList;
import java.util.Date;


public class Imagen {
    private String id;
    private String descripcion;
    private String titulo;
    private Date fecha;
    private String coordenadas;
    private int votosFavor;
    private int votosContra;
    private String url;
    private String base64;
    private String autor;
    private Usuario autorUsuario;
    private ArrayList<String> etiquetas = new ArrayList<String>();
    private boolean reportado;

    //constructor por defecto
    public Imagen() {
    }

    //getters and setters


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(String coordenadas) {
        this.coordenadas = coordenadas;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getBase64() {
        return base64;
    }

    public void setBase64(String base64) {
        this.base64 = base64;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Usuario getAutorUsuario() {
        return autorUsuario;
    }

    public void setAutorUsuario(Usuario autorUsuario) {
        this.autorUsuario = autorUsuario;
    }

    public ArrayList<String> getEtiquetas() {
        return etiquetas;
    }

    public void setEtiquetas(ArrayList<String> etiquetas) {
        this.etiquetas = etiquetas;
    }

    public boolean isReportado() {
        return reportado;
    }

    public void setReportado(boolean reportado) {
        this.reportado = reportado;
    }

    //metodos
    public void reportar(){

    }
    public void votarFavor(){

    }
    public void votarContra(){

    }
    public void etiquetar(){

    }
    public void convertirABase64(){

    }
    public void convertirDeBase64(){

    }
}
