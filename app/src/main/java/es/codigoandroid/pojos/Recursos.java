package es.codigoandroid.pojos;

import java.util.ArrayList;



public class Recursos {

    //Campos para couchdb
    //Campos para couchdb
    private String _id;


    private String _rev;
    private String nombre;
    private String descripcion;
    private String informacionGeneral;
    private String direccion;
    private ArrayList<Costo> costoRecursos = new ArrayList<Costo>();
    private ArrayList<AccesibilidadRecurso> opcionesAccesibilidad = new ArrayList<AccesibilidadRecurso>();
    private ArrayList<Facilidad> facilidadRecurso = new ArrayList<Facilidad>();
    private ArrayList<Recomendacion> recomendacion = new ArrayList<Recomendacion>();
    private Contacto infContacto;
    private float ranking;
    private ArrayList<Imagen> galeria = new ArrayList<Imagen>();
    private Imagen imagenPrinc;
    private ArrayList<Senderos> sendero = new ArrayList<Senderos>();
    private String posicion;
    private Estado estado;
    private ArrayList<Idiomas> idiomasInformac = new ArrayList<Idiomas>();
    private ArrayList<String> preguntasFrecuentes = new ArrayList<String>();
    private ArrayList<Comentario> comentarios = new ArrayList<Comentario>();


    //constructor por defecto
    public Recursos(){

    }

    //getters and setters


    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String get_rev() {
        return _rev;
    }

    public void set_rev(String _rev) {
        this._rev = _rev;
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

    public String getInformacionGeneral() {
        return informacionGeneral;
    }

    public void setInformacionGeneral(String informacionGeneral) {
        this.informacionGeneral = informacionGeneral;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public ArrayList<Costo> getCostoRecursos() {
        return costoRecursos;
    }

    public void setCostoRecursos(ArrayList<Costo> costoRecursos) {
        this.costoRecursos = costoRecursos;
    }

    public ArrayList<AccesibilidadRecurso> getOpcionesAccesibilidad() {
        return opcionesAccesibilidad;
    }

    public void setOpcionesAccesibilidad(ArrayList<AccesibilidadRecurso> opcionesAccesibilidad) {
        this.opcionesAccesibilidad = opcionesAccesibilidad;
    }

    public ArrayList<Facilidad> getFacilidadRecurso() {
        return facilidadRecurso;
    }

    public void setFacilidadRecurso(ArrayList<Facilidad> facilidadRecurso) {
        this.facilidadRecurso = facilidadRecurso;
    }

    public ArrayList<Recomendacion> getRecomendacion() {
        return recomendacion;
    }

    public void setRecomendacion(ArrayList<Recomendacion> recomendacion) {
        this.recomendacion = recomendacion;
    }

    public Contacto getInfContacto() {
        return infContacto;
    }

    public void setInfContacto(Contacto infContacto) {
        this.infContacto = infContacto;
    }

    public float getRanking() {
        return ranking;
    }

    public void setRanking(float ranking) {
        this.ranking = ranking;
    }

    public ArrayList<Imagen> getGaleria() {
        return galeria;
    }

    public void setGaleria(ArrayList<Imagen> galeria) {
        this.galeria = galeria;
    }

    public Imagen getImagenPrinc() {
        return imagenPrinc;
    }

    public void setImagenPrinc(Imagen imagenPrinc) {
        this.imagenPrinc = imagenPrinc;
    }

    public ArrayList<Senderos> getSendero() {
        return sendero;
    }

    public void setSendero(ArrayList<Senderos> sendero) {
        this.sendero = sendero;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public ArrayList<Idiomas> getIdiomasInformac() {
        return idiomasInformac;
    }

    public void setIdiomasInformac(ArrayList<Idiomas> idiomasInformac) {
        this.idiomasInformac = idiomasInformac;
    }

    public ArrayList<String> getPreguntasFrecuentes() {
        return preguntasFrecuentes;
    }

    public void setPreguntasFrecuentes(ArrayList<String> preguntasFrecuentes) {
        this.preguntasFrecuentes = preguntasFrecuentes;
    }

    public ArrayList<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(ArrayList<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    //otros metodos
    public void obtenerRuta( String posicion){

    }

    public void verReviews(){
    }

    public void llamarContacto(){
    }

    public void calcularRankingTotal(){

    }

    public void agregarImagen(){
    }

    public void reportarMalaUbicacion(){
    }

    public void agregarRecomendacion(){

    }
    public void verSenderos(){

    }
    public void verGaleria(){

    }
    public void comentar(){

    }
    public void sugerirCambio(){

    }
}
