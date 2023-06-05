package main;

public class OpcionRespuesta {
    
    private String texto;
    private String dimension;
    private int puntaje;

    public OpcionRespuesta() {
        this.texto = null;
    }
    
    public OpcionRespuesta(String texto) {
        this.texto = texto;
    }
    
    public OpcionRespuesta(String texto, String dimension, int puntaje) {
        this.texto = texto;
        this.puntaje = puntaje;
        this.dimension = dimension;
    }
    
    public void agregarPuntaje(String dimension, int puntaje) {
        this.puntaje = puntaje;
        this.dimension = dimension;
    }

    public String getTexto() {
        return texto;
    }

    public int getPuntaje() {
        return puntaje;
    }
    
    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }
}