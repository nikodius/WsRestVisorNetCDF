package com.visorNetCDF.logica;

/**
 * Clase generica con estructura de respuesta con error, mensaje
 * y datos mediante el objeto de la calse generica
 * @param <T> Objeto generico
 */
public class Respuesta<T> {

    private boolean error;
    private String mensaje;
    private T datos;

    public Respuesta() {
    }

    public Respuesta(boolean error, String mensaje, T datos) {
        this.error = error;
        this.mensaje = mensaje;
        this.datos = datos;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public T getDatos() {
        return datos;
    }

    public void setDatos(T datos) {
        this.datos = datos;
    }

}
