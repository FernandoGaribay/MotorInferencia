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
