package main;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MotorDeInferencia {

    private Map<String, String> mapResultados;
    private Map<String, Integer> puntajes;

    public MotorDeInferencia() {
        puntajes = new HashMap<>();
        mapResultados = null;
    }

    public void evaluarRespuestas(Quiz objQuiz, List<Respuesta> respuestas) {
        this.mapResultados = objQuiz.getResultados();

        for (Respuesta respuesta : respuestas) {
            String opcionSeleccionada = respuesta.getOpcionSeleccionada().getDimension();
            if (!puntajes.containsKey(opcionSeleccionada)) {
                puntajes.put(opcionSeleccionada, 0);
            }
        }

        for (Respuesta respuesta : respuestas) {
            String dimension = respuesta.getOpcionSeleccionada().getDimension();
            int puntaje = respuesta.getOpcionSeleccionada().getPuntaje();

            if (puntajes.containsKey(dimension)) {
                int puntajeExistente = puntajes.get(dimension);
                puntajes.put(dimension, puntajeExistente + puntaje);
            }
        }
    }

    public String[] obtenerResultado() {
        int puntajeMaximo = Integer.MIN_VALUE;
        String[] resultado = {"", ""};

        System.out.println("");
        for (Map.Entry<String, Integer> entry : puntajes.entrySet()) {
            String dimension = entry.getKey();
            int puntaje = entry.getValue();
            System.out.print("dimension = " + dimension);
            System.out.println("     puntaje = " + puntaje);

            if (puntaje > puntajeMaximo) {
                puntajeMaximo = puntaje;
                resultado[0] = dimension;
            } else if (puntaje == puntajeMaximo) {
//                resultado[0] = "Neutral";
            }
        }
        if (mapResultados.containsKey(resultado[0])){
            resultado[1] = mapResultados.get(resultado[0]);
        } else {
            resultado[1] = "Te encuentras en un estado neutral";
        }
        
        return resultado;
    }
}
