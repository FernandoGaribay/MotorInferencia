package main;

import java.sql.ResultSet; // Requerida para crear un objeto ResultSet
import java.sql.Statement; // Requerida para el Statement.RETURN_GENERATED_KEYS
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class conexion {

    private String bd = "motorinferencia";
    private String url = "jdbc:mysql://localhost:3306/"; // CAMBIAR EL PUERTO SI ES NECESARIO

    private String user = "root"; // CAMBIAR EL USUARIO SI ES NECESARIO
    private String password = "";
    private String driver = "com.mysql.cj.jdbc.Driver";
    private Connection connect;

    private String nombre;
    private List<Pregunta> preguntas;
    private List<String> resultados;
    Map<String, Integer> resultadosIdMap;

    int idQuiz = -1;

    private PreparedStatement stInsertar;

    public conexion() {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            System.out.println("Error al cargar el driver");
            System.out.println(ex.getMessage());
        }
    }

    public void conectar() {
        try {
            connect = DriverManager.getConnection(url + bd + "?serverTimezone=GMT-5", user, password);
            System.out.println("Se logró la conexion");
        } catch (SQLException ex) {
            System.out.println("No se conecto a bd");
            System.out.println(ex.getMessage());
        }
    }

    public void desconectar() {
        try {
            connect.close();
            System.out.println("Se logró desconectar");
        } catch (SQLException ex) {
            System.out.println("no se desconecto");
            System.out.println(ex.getMessage());
        }
    }

    public void guardarQuiz(String nombre, List<Pregunta> preguntas, List<String> resultados) {
        this.nombre = nombre;
        this.preguntas = preguntas;
        this.resultados = resultados;
        this.resultadosIdMap = insertarResultados(resultados);
        
        insertarQuiz();
        insertarPreguntas();
    }

    public void insertarQuiz() {
        String sql = "INSERT INTO quizzes (nombre) VALUES (?)";

        try {
            stInsertar = connect.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stInsertar.setString(1, nombre);
            stInsertar.executeUpdate();

            ResultSet rs = stInsertar.getGeneratedKeys();
            if (rs.next()) {
                idQuiz = rs.getInt(1);
                System.out.println("Quiz insertado correctamente.");
            }
        } catch (SQLException ex) {
            System.out.println("El Quiz no pudo ser insertado");
            System.out.println(ex.getMessage());
        }
    }

    private void insertarPreguntas() {
        String sql = "INSERT INTO preguntas (enunciado, idQuiz) VALUES (?, ?)";
        int idPregunta = -1;

        try {
            for (int i = 0; i < preguntas.size(); i++) {
                stInsertar = connect.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                stInsertar.setString(1, preguntas.get(i).getEnunciado());
                stInsertar.setString(2, String.valueOf(idQuiz));
                stInsertar.executeUpdate();

                ResultSet rs = stInsertar.getGeneratedKeys();
                if (rs.next()) {
                    idPregunta = rs.getInt(1);
                    System.out.println("Pregunta insertada correctamente.");
                }
                insertarOpcion(preguntas.get(i).getOpciones(), idPregunta);
            }

        } catch (SQLException ex) {
            System.out.println("La pregunta no pudo ser insertada");
            System.out.println(ex.getMessage());
        }
    }

    public void insertarOpcion(List<OpcionRespuesta> opciones, int idPregunta) {
        String sql = "INSERT INTO opciones (texto, idPregunta, idResultado, puntos) VALUES (?, ?, ?, ?)";

        try {
            for (OpcionRespuesta opcion : opciones) {
                String resultado = opcion.getDimension();
                int idResultado = resultadosIdMap.get(resultado);

                stInsertar = connect.prepareStatement(sql);
                stInsertar.setString(1, opcion.getTexto());
                stInsertar.setInt(2, idPregunta);
                stInsertar.setInt(3, idResultado);
                stInsertar.setInt(4, opcion.getPuntaje());
                stInsertar.executeUpdate();
            }
        } catch (SQLException ex) {
            System.out.println("La opción no pudo ser insertada");
            System.out.println(ex.getMessage());
        }
    }

    public Map<String, Integer> insertarResultados(List<String> resultados) {
        String sql = "INSERT INTO resultados (nombre) VALUES (?)";
        Map<String, Integer> resultadosIdMap = new HashMap<>();

        try {
            for (String resultado : resultados) {
                stInsertar = connect.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                stInsertar.setString(1, resultado);
                stInsertar.executeUpdate();

                ResultSet rs = stInsertar.getGeneratedKeys();
                if (rs.next()) {
                    resultadosIdMap.put(resultado, rs.getInt(1));
                    System.out.println("Resultado insertado correctamente.");
                }
            }

        } catch (SQLException ex) {
            System.out.println("El resultado no pudo ser insertado");
            System.out.println(ex.getMessage());
        }

        return resultadosIdMap;
    }

    public static void main(String[] args) throws SQLException {
        conexion conect = new conexion();
        conect.conectar();

        List<Pregunta> preguntas = new ArrayList<>();
        Pregunta pregunta1 = new Pregunta("¿Disfrutas de estar rodeado de mucha gente?");
        pregunta1.agregarOpcionRespuesta(new OpcionRespuesta("Completamente de acuerdo", "Extrovertido", 3));
        pregunta1.agregarOpcionRespuesta(new OpcionRespuesta("De acuerdo", "Extrovertido", 2));
        pregunta1.agregarOpcionRespuesta(new OpcionRespuesta("A veces", "Extrovertido", 1));
        pregunta1.agregarOpcionRespuesta(new OpcionRespuesta("A veces", "Introvertido", 1));
        pregunta1.agregarOpcionRespuesta(new OpcionRespuesta("En Desacuerdo", "Introvertido", 2));
        pregunta1.agregarOpcionRespuesta(new OpcionRespuesta("Completamente en desacuerdo", "Introvertido", 3));

        Pregunta pregunta2 = new Pregunta("¿Prefieres actividades tranquilas y solitarias?");
        pregunta2.agregarOpcionRespuesta(new OpcionRespuesta("Completamente de acuerdo", "Introvertido", 3));
        pregunta2.agregarOpcionRespuesta(new OpcionRespuesta("De acuerdo", "Introvertido", 2));
        pregunta2.agregarOpcionRespuesta(new OpcionRespuesta("A veces", "Extrovertido", 1));
        pregunta2.agregarOpcionRespuesta(new OpcionRespuesta("A veces", "Introvertido", 1));
        pregunta2.agregarOpcionRespuesta(new OpcionRespuesta("En Desacuerdo", "Extrovertido", 2));
        pregunta2.agregarOpcionRespuesta(new OpcionRespuesta("Completamente en desacuerdo", "Extrovertido", 3));

        preguntas.add(pregunta1);
        preguntas.add(pregunta2);

        List<String> resultados = new ArrayList<>();
        resultados.add("Introvertido");
        resultados.add("Extrovertido");

        conect.guardarQuiz("Personalidad", preguntas, resultados);
        conect.desconectar();
    }
}
