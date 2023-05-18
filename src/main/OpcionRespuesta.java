package main;

import java.util.HashMap;
import java.util.Map;

public class OpcionRespuesta {
    private String dimension;
    private String texto;
    private Map<String, Integer> puntajes;

    public OpcionRespuesta(String texto) {
        this.texto = texto;
        this.puntajes = new HashMap<>();
    }
    
    public OpcionRespuesta(String texto, String personalidad, int puntaje) {
        this.texto = texto;
        this.puntajes = new HashMap<>();
        this.agregarPuntaje(personalidad, puntaje);
    }
    
    public void agregarPuntaje(String personalidad, int puntaje) {
        dimension = personalidad;
        puntajes.put(personalidad, puntaje);
    }

    public String getTexto() {
        return texto;
    }

    public Map<String, Integer> getPuntajes() {
        return puntajes;
    }
    
    public String getDimension() {
        return dimension;
    }
}