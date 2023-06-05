package main;

import java.util.ArrayList;
import java.util.List;

public class Pregunta {

    private String enunciado;
    private List<OpcionRespuesta> opciones;

    public Pregunta() {
        this.enunciado = null;
        this.opciones = new ArrayList<>();
    }

    public Pregunta(String enunciado) {
        this.enunciado = enunciado;
        this.opciones = new ArrayList<>();
    }
    
    public Pregunta(String enunciado, List<OpcionRespuesta> opcionesRespuesta) {
        this.enunciado = enunciado;
        this.opciones = opcionesRespuesta;
    }

    public void agregarOpcionRespuesta(OpcionRespuesta opcion) {
        opciones.add(opcion);
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public List<OpcionRespuesta> getOpciones() {
        return opciones;
    }

    public void setOpciones(List<OpcionRespuesta> opciones) {
        this.opciones = opciones;
    }

}
