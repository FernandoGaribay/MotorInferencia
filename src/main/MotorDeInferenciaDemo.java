package main;

import java.util.ArrayList;
import java.util.List;

public class MotorDeInferenciaDemo {

    public static void main(String[] args) {
        // Crear preguntas y opciones de respuesta
        Pregunta pregunta1 = new Pregunta("¿Disfrutas de estar rodeado de mucha gente?");
        pregunta1.agregarOpcionRespuesta(new OpcionRespuesta("Si", "Extroversión", 1));
        pregunta1.agregarOpcionRespuesta(new OpcionRespuesta("No", "Introversión", 3));

        Pregunta pregunta2 = new Pregunta("¿Prefieres actividades tranquilas y solitarias?");
        
        pregunta2.agregarOpcionRespuesta(new OpcionRespuesta("Sí"));
        pregunta2.getOpciones().get(0).agregarPuntaje("Extroversión", 1);

        pregunta2.agregarOpcionRespuesta(new OpcionRespuesta("No"));
        pregunta2.getOpciones().get(1).agregarPuntaje("Introversión", 3);

        // Crear respuestas del test
        List<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(new Respuesta(pregunta1, pregunta1.getOpciones().get(0))); // Respuesta: No
        respuestas.add(new Respuesta(pregunta2, pregunta2.getOpciones().get(0))); // Respuesta: No

        // Crear el motor de inferencia y evaluar las respuestas
        MotorDeInferencia motor = new MotorDeInferencia();
        motor.evaluarRespuestas(respuestas);

        // Obtener el resultado final
        String resultado = motor.obtenerResultado();
        System.out.println("Resultado: " + resultado);
    }
}
