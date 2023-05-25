package main;

import java.util.List;

public class Quiz {

    private String nombre;
    private List<Pregunta> preguntas;
    private List<String> resultados;

    public Quiz() {
        this.nombre = null;
        this.preguntas = null;
        this.resultados = null;
    }

    public Quiz(String nombre, List<Pregunta> preguntas, List<String> resultados) {
        this.nombre = nombre;
        this.preguntas = preguntas;
        this.resultados = resultados;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Pregunta> getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(List<Pregunta> preguntas) {
        this.preguntas = preguntas;
    }

    public List<String> getResultados() {
        return resultados;
    }

    public void setResultados(List<String> resultados) {
        this.resultados = resultados;
    }

    public void imprimirDatos() {
        System.out.println("Quiz = " + nombre + "\n");
        
        for (int i = 0; i < resultados.size(); i++) {
            System.out.println("Respuesta " + i + ": " + resultados.get(i));
        }
        System.out.println("");
        
        for (int i = 0; i < preguntas.size(); i++) {
            System.out.println("Pregunta " + i + ": " + preguntas.get(i).getEnunciado());
            for (int k = 0; k < preguntas.get(i).getOpciones().size(); k++) {
                System.out.print("   Opcion " + i + ": " + preguntas.get(i).getOpciones().get(k).getTexto());
                System.out.print("  " + preguntas.get(i).getOpciones().get(k).getDimension());
                System.out.print("  " + preguntas.get(i).getOpciones().get(k).getPuntaje() + "\n");
            }
            System.out.println("");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Quiz{");
        sb.append("nombre=").append(nombre);
        sb.append(", preguntas=").append(preguntas);
        sb.append(", resultados=").append(resultados);
        sb.append('}');
        return sb.toString();
    }
}
