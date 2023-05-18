package main;

public class Respuesta {
    private Pregunta pregunta;
    private OpcionRespuesta opcionSeleccionada;

    public Respuesta(Pregunta pregunta, OpcionRespuesta opcionSeleccionada) {
        this.pregunta = pregunta;
        this.opcionSeleccionada = opcionSeleccionada;
    }

    public Pregunta getPregunta() {
        return pregunta;
    }

    public OpcionRespuesta getOpcionSeleccionada() {
        return opcionSeleccionada;
    }
}
