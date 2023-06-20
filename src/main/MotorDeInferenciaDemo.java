package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MotorDeInferenciaDemo {

    public static void main(String[] args) {
        // Crear preguntas y opciones de respuesta
        Pregunta pregunta1 = new Pregunta("¿Disfrutas de estar rodeado de mucha gente?");
        pregunta1.agregarOpcionRespuesta(new OpcionRespuesta("Si", "Extroversión", 3));
        pregunta1.agregarOpcionRespuesta(new OpcionRespuesta("No", "Introversión", 1));

        Pregunta pregunta2 = new Pregunta("¿Prefieres actividades tranquilas y solitarias?");
        pregunta2.agregarOpcionRespuesta(new OpcionRespuesta("Si", "Introversión", 3));
        pregunta2.agregarOpcionRespuesta(new OpcionRespuesta("No", "Extroversión", 1));

        // Crea la lista de pregutnas
        List<Pregunta> lista = new ArrayList<Pregunta>();
        lista.add(pregunta1);
        lista.add(pregunta2);

        // Crea el hashmap de resultados
        Map<String, String> resultados = new HashMap<>();
        resultados.put("Extroversión", "Descripcion de extroversion");
        resultados.put("Introversión", "Descripcion de introversion");

        // Crear respuestas del test
        List<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(new Respuesta(pregunta1, pregunta1.getOpciones().get(1))); // Respuesta: No
        respuestas.add(new Respuesta(pregunta2, pregunta2.getOpciones().get(0))); // Respuesta: No

        // Crear el objeto Quiz
        Quiz objQuiz = new Quiz("Test", lista, resultados);

        // Crear el motor de inferencia y evaluar las respuestas
        MotorDeInferencia motor = new MotorDeInferencia();
        motor.evaluarRespuestas(objQuiz, respuestas);

        // Obtener el resultado final
        String[] resultado = motor.obtenerResultado();
        System.out.println("Resultado: " + resultado[0]);
        System.out.println("Descripcion: " + resultado[1]);
    }
}
