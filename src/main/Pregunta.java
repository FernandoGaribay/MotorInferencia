package main;

import java.util.ArrayList;
import java.util.List;

public class Pregunta {
    private String enunciado;
    private List<OpcionRespuesta> opciones;

    public Pregunta(String enunciado) {
        this.enunciado = enunciado;
        this.opciones = new ArrayList<>();
    }

    public void agregarOpcionRespuesta(OpcionRespuesta opcion) {
        opciones.add(opcion);
    }

    public String getEnunciado() {
        return enunciado;
    }

    public List<OpcionRespuesta> getOpciones() {
        return opciones;
    }
}