package es.codigoandroid.pojos;

import android.graphics.Bitmap;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Alvaro on 22/12/2016.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Recurso {


    @JsonProperty(value = "_id")
    private String nombre;
    private int visitas;
    private int imagen;

    public Recurso(){
    }

    public Recurso(int imagen, String nombre, int visitas) {
        this.imagen = imagen;
        this.nombre = nombre;
        this.visitas = visitas;
    }


    public String getNombre() {
        return nombre;
    }

    public int getVisitas() {
        return visitas;
    }

    public int getImagen() {
        return imagen;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setVisitas(int visitas) {
        this.visitas = visitas;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
}