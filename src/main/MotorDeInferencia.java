package main;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MotorDeInferencia {

    private Map<String, Integer> puntajes;

    public MotorDeInferencia() {
        puntajes = new HashMap<>();
        puntajes.put("Extroversión", 0);
        puntajes.put("Introversión", 0);
    }

    public void evaluarRespuestas(List<Respuesta> respuestas) {
        for (Respuesta respuesta : respuestas) {
            String dimension = respuesta.getOpcionSeleccionada().getDimension();
            int puntaje = respuesta.getOpcionSeleccionada().getPuntaje();

            if (puntajes.containsKey(dimension)) {
                int puntajeExistente = puntajes.get(dimension);
                puntajes.put(dimension, puntajeExistente + puntaje);
            }
        }
    }

    public String obtenerResultado() {
        int puntajeMaximo = Integer.MIN_VALUE;
        String resultado = "Neutral";

        System.out.println("");
        for (Map.Entry<String, Integer> entry : puntajes.entrySet()) {
            String dimension = entry.getKey();
            int puntaje = entry.getValue();
            System.out.print("dimension = " + dimension);
            System.out.println("     puntaje = " + puntaje);

            if (puntaje > puntajeMaximo) {
                puntajeMaximo = puntaje;
                resultado = dimension;
            } else if (puntaje == puntajeMaximo) {
                resultado = "Neutral";
            }
        }

        return resultado;
    }

}
