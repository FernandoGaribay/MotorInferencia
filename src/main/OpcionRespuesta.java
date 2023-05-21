package main;

public class OpcionRespuesta {
    private String dimension;
    private String texto;
    private int puntaje;

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
}