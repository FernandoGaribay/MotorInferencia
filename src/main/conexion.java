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
    private String url = "jdbc:mysql://localhost:3306/";
    private String user = "root";
    private String password = "";
    private String driver = "com.mysql.cj.jdbc.Driver";

    private Connection connect;

    private String nombre;
    private List<Pregunta> preguntas;
    private Map<String, String> resultados;
    private Map<String, Integer> resultadosIdMap;

    int idQuiz = -1;

    public conexion() {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            System.out.println("Error al cargar el driver");
            System.out.println(ex.getMessage());
        }
    }

    // <editor-fold desc="Metodos de conexion">
    private void conectar() {
        try {
            connect = DriverManager.getConnection(url + bd + "?serverTimezone=GMT-5", user, password);
//          System.out.println("Se logró la conexion");
        } catch (SQLException ex) {
            System.out.println("No se conecto a bd");
            System.out.println(ex.getMessage());
        }
    }

    private void desconectar() {
        try {
            connect.close();
//          System.out.println("Se logró desconectar");
        } catch (SQLException ex) {
            System.out.println("no se desconecto");
            System.out.println(ex.getMessage());
        }
    }
    // </editor-fold>

    //<editor-fold desc="Obtener Quiz de la BD">
    public Quiz obtenerQuiz(int id) {
        Quiz objQuiz = new Quiz();

        this.conectar();
        objQuiz.setResultados(obtenerResultados(id));
        objQuiz.setNombre(obtenerNombreQuiz(id));
        objQuiz.setPreguntas(obtenerPreguntas(id));
        this.desconectar();

        return objQuiz;
    }

    private String obtenerNombreQuiz(int id) {
        String query = "SELECT * FROM quizzes WHERE id = ?";
        PreparedStatement mostrarPregunta;
        String nombre = "";

        try {

            mostrarPregunta = connect.prepareStatement(query);
            mostrarPregunta.setInt(1, id);
            ResultSet resultSet = mostrarPregunta.executeQuery();

            if (resultSet.next()) {
                nombre = resultSet.getString("nombre");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nombre;
    }

    private List<Pregunta> obtenerPreguntas(int id) {
        String query = "SELECT * FROM preguntas WHERE idQuiz = ?";
        PreparedStatement mostrarPregunta;
        List<Pregunta> preguntas = new ArrayList<>();

        try {
            mostrarPregunta = connect.prepareStatement(query);
            mostrarPregunta.setInt(1, id);
            ResultSet resultSet = mostrarPregunta.executeQuery();

            while (resultSet.next()) {
                int idPregunta = resultSet.getInt("id");
                String enunciado = resultSet.getString("enunciado");
                List<OpcionRespuesta> listOpciones = obtenerOpciones(idPregunta);

                preguntas.add(new Pregunta(enunciado, obtenerOpciones(idPregunta)));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return preguntas;
    }

    private List<OpcionRespuesta> obtenerOpciones(int idPregunta) {
        String query = "SELECT * FROM opciones WHERE idPregunta = ?";
        PreparedStatement mostrarRespuesta;
        List<OpcionRespuesta> opciones = new ArrayList<>();

        try {

            mostrarRespuesta = connect.prepareStatement(query);
            mostrarRespuesta.setInt(1, idPregunta);
            ResultSet resultSet = mostrarRespuesta.executeQuery();

            while (resultSet.next()) {
                int idResultado = resultSet.getInt("idResultado");
                String texto = resultSet.getString("texto");
                String dimension = "";

                for (Map.Entry<String, Integer> tempDimension : resultadosIdMap.entrySet()) {
                    if (tempDimension.getValue().equals(idResultado)) {
                        dimension = tempDimension.getKey();
                        break;
                    }
                }

                int puntaje = resultSet.getInt("puntos");

                opciones.add(new OpcionRespuesta(texto, dimension, puntaje));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return opciones;
    }

    private Map<String, String> obtenerResultados(int id) {
        String query = "SELECT * FROM resultados WHERE idQuiz = ?";
        PreparedStatement mostrarResultados;
        Map<String, String> objRespuestas = new HashMap<>();
        resultadosIdMap = new HashMap<String, Integer>();

        try {
            mostrarResultados = connect.prepareStatement(query);
            mostrarResultados.setInt(1, id);
            ResultSet resultSet = mostrarResultados.executeQuery();

            while (resultSet.next()) {
                int value = resultSet.getInt("id");
                String resultado = resultSet.getString("nombre");
                String descripcion = resultSet.getString("descripcion");
                
                objRespuestas.put(resultado, descripcion);
                resultadosIdMap.put(resultado, value);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return objRespuestas;
    }
    //</editor-fold>

    // <editor-fold desc="Guardar Quiz en la BD">
    public void guardarQuiz(Quiz objQuiz) {

        this.conectar();
        nombre = objQuiz.getNombre();
        insertarQuiz();
        preguntas = objQuiz.getPreguntas();
        resultados = objQuiz.getResultados();
        resultadosIdMap = insertarResultados(resultados);
        insertarPreguntas();
        this.desconectar();

        System.out.println("El quiz fue guardado correctamente.");
    }

    private void insertarQuiz() {
        String sql = "INSERT INTO quizzes (nombre) VALUES (?)";
        PreparedStatement stInsertar;

        try {
            stInsertar = connect.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stInsertar.setString(1, nombre);
            stInsertar.executeUpdate();

            ResultSet rs = stInsertar.getGeneratedKeys();
            if (rs.next()) {
                idQuiz = rs.getInt(1);
            }
        } catch (SQLException ex) {
            System.out.println("El Quiz no pudo ser insertado");
            System.out.println(ex.getMessage());
        }
    }

    private void insertarPreguntas() {
        String sql = "INSERT INTO preguntas (enunciado, idQuiz) VALUES (?, ?)";
        PreparedStatement stInsertar;
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
                }
                insertarOpcion(preguntas.get(i).getOpciones(), idPregunta);
            }

        } catch (SQLException ex) {
            System.out.println("La pregunta no pudo ser insertada");
            System.out.println(ex.getMessage());
        }
    }

    private void insertarOpcion(List<OpcionRespuesta> opciones, int idPregunta) {
        String sql = "INSERT INTO opciones (texto, idPregunta, idResultado, puntos) VALUES (?, ?, ?, ?)";
        PreparedStatement stInsertar;

        try {
            for (OpcionRespuesta opcion : opciones) {
                String resultado = opcion.getDimension();
                Integer idResultado = resultadosIdMap.get(resultado); // se obtiene el valor a partir de una key

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

    private Map<String, Integer> insertarResultados(Map<String, String> resultados) {
        String sql = "INSERT INTO resultados (nombre, descripcion, idQuiz) VALUES (?, ?, ?)";
        PreparedStatement stInsertar;
        Map<String, Integer> resultadosIdMap = new HashMap<>();

        try {
            for (Map.Entry<String, String> entry : resultados.entrySet()) {
                stInsertar = connect.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                stInsertar.setString(1, entry.getKey());
                stInsertar.setString(2, entry.getValue());
                stInsertar.setString(3, String.valueOf(idQuiz));
                stInsertar.executeUpdate();

                ResultSet rs = stInsertar.getGeneratedKeys();
                if (rs.next()) {
                    resultadosIdMap.put(entry.getKey(), rs.getInt(1));
                }
            }

        } catch (SQLException ex) {
            System.out.println("El resultado no pudo ser insertado");
            System.out.println(ex.getMessage());
        }

        return resultadosIdMap;
    }
    // </editor-fold>

    // <editor-fold desc="Borrar Quiz de la BD">
    public void eliminarQuiz(int idQuiz) {
        this.conectar();
        try {
            eliminarOpciones(idQuiz);
            eliminarPreguntas(idQuiz);
            eliminarResultados(idQuiz);
            eliminarQuizById(idQuiz);

            System.out.println("Quiz eliminado");
        } catch (SQLException ex) {
            System.out.println("Error al eliminar el quiz");
            System.out.println(ex.getMessage());
        }
        this.desconectar();
    }

    private void eliminarPreguntas(int idQuiz) throws SQLException {
        String queryPreguntas = "DELETE FROM preguntas WHERE idQuiz = ?";
        PreparedStatement pstmtPreguntas = connect.prepareStatement(queryPreguntas);

        pstmtPreguntas.setInt(1, idQuiz);
        pstmtPreguntas.executeUpdate();
    }

    private void eliminarOpciones(int idQuiz) throws SQLException {
        String queryOpciones = "DELETE FROM opciones WHERE idPregunta IN (SELECT id FROM preguntas WHERE idQuiz = ?)";
        PreparedStatement pstmtOpciones = connect.prepareStatement(queryOpciones);

        pstmtOpciones.setInt(1, idQuiz);
        pstmtOpciones.executeUpdate();
    }

    private void eliminarResultados(int idQuiz) throws SQLException {
        String queryResultados = "DELETE FROM resultados WHERE idQuiz = ?";
        PreparedStatement pstmtResultados = connect.prepareStatement(queryResultados);

        pstmtResultados.setInt(1, idQuiz);
        pstmtResultados.executeUpdate();
    }

    private void eliminarQuizById(int idQuiz) throws SQLException {
        String queryQuiz = "DELETE FROM quizzes WHERE id = ?";
        PreparedStatement pstmtQuiz = connect.prepareStatement(queryQuiz);

        pstmtQuiz.setInt(1, idQuiz);
        pstmtQuiz.executeUpdate();
    }
    // </editor-fold>

    public Map<String, Integer> obtenerQuizzes() {
        Map<String, Integer> nombres = new HashMap<>();

        this.conectar();
        try {
            Statement statement = connect.createStatement();
            String sql = "SELECT * FROM quizzes";
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nombre = resultSet.getString("nombre");
                nombres.put(nombre, id);
            }

        } catch (SQLException ex) {
            System.out.println("Error al obtener los nombres");
            System.out.println(ex.getMessage());
        }
        this.desconectar();

        return nombres;
    }

    public static void main(String[] args) throws SQLException {
        conexion conect = new conexion();
        testQuiz().imprimirDatos();
        conect.guardarQuiz(testQuiz());
    }

    public static Quiz testQuiz() {
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

        Map<String, String> resultados = new HashMap<>();
        resultados.put("Introvertido", "Descripcion de Introvertido");
        resultados.put("Extrovertido", "Descripcion de Extrovertido");

        Quiz objQuiz = new Quiz("Test", preguntas, resultados);

        return objQuiz;
    }
}

// <editor-fold desc="Codigo Modificar">
/*
    private PreparedStatement stInsertar;
    private PreparedStatement stBorrarQA;

    private PreparedStatement stBorrarResutltado;
    private PreparedStatement stBorrarQuiz;

    private PreparedStatement stModificarQuiz;
    private PreparedStatement stModificarPregunta;
    private PreparedStatement stModificarOpciones;
    private PreparedStatement stModificarResultados;



    public void borrarQuiz(int id) {
        try {
            //borrarPreguntaRespuesta(id);
            String deletePreguntasQuery = "DELETE FROM preguntas WHERE idQuiz = ?";
            stBorrarQuiz = connect.prepareStatement(deletePreguntasQuery);
            stBorrarQuiz.setInt(1, id);
            stBorrarQuiz.executeUpdate();

            String deleteQuizQuery = "DELETE FROM quizzes WHERE id = ?";
            PreparedStatement deleteQuizStatement = connect.prepareStatement(deleteQuizQuery);
            deleteQuizStatement.setInt(1, id);
            int rowsAffected = deleteQuizStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Quiz borrado exitosamente.");
            } else {
                System.out.println("No se encontró el quiz especificado.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void borrarPreguntaRespuesta(int id) {
        try {
            // Eliminar las opciones asociadas a la pregunta
            String deleteOpcionesQuery = "DELETE FROM opciones WHERE idPregunta = ?";
            stBorrarQA = connect.prepareStatement(deleteOpcionesQuery);
            stBorrarQA.setInt(1, id);
            stBorrarQA.executeUpdate();

            // Eliminar la pregunta
            String deletePreguntaQuery = "DELETE FROM preguntas WHERE id = ?";
            PreparedStatement deletePreguntaStatement = connect.prepareStatement(deletePreguntaQuery);
            deletePreguntaStatement.setInt(1, id);
            int rowsAffected = deletePreguntaStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Pregunta y respuestas borradas exitosamente.");
            } else {
                System.out.println("No se encontró la pregunta especificada.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void borrarResultados(int id) {
        try {
            // Eliminar los resultados
            String deleteOpcionesQuery = "DELETE FROM resultados WHERE id = ?";
            stBorrarResutltado = connect.prepareStatement(deleteOpcionesQuery);
            stBorrarResutltado.setInt(1, id);
            stBorrarResutltado.executeUpdate();

            int rowsAffected = stBorrarResutltado.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Se borro la respuesta indicada.");
            } else {
                System.out.println("No se encontró la respuesta especificada.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void modificarQuiz(int id, String nuevoNombre) {
        try {
            String query = "UPDATE quizzes SET nombre = ? WHERE id = ?";
            stModificarQuiz = connect.prepareStatement(query);
            stModificarQuiz.setString(1, nuevoNombre);
            stModificarQuiz.setInt(2, id);

            int rowsAffected = stModificarQuiz.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Quiz modificado exitosamente.");
            } else {
                System.out.println("No se encontró el quiz especificado.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void modificarPregunta(int id, String nuevoEnunciado) {
        try {
            String query = "UPDATE preguntas SET enunciado = ? WHERE id = ?";
            stModificarPregunta = connect.prepareStatement(query);
            stModificarPregunta.setString(1, nuevoEnunciado);
            stModificarPregunta.setInt(2, id);

            int rowsAffected = stModificarPregunta.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Pregunta modificada exitosamente.");
            } else {
                System.out.println("No se encontró la pregunta especificada.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void modificarOpcion(int id, String nuevoTexto) {
        try {
            String query = "UPDATE opciones SET texto = ? WHERE id = ?";
            stModificarOpciones = connect.prepareStatement(query);
            stModificarOpciones.setString(1, nuevoTexto);
            stModificarOpciones.setInt(2, id);

            int rowsAffected = stModificarOpciones.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Opción modificada exitosamente.");
            } else {
                System.out.println("No se encontró la opción especificada.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void modificarResultados(int id, String nuevaRespuesta) {
        try {
            String query = "UPDATE resultados SET nombre = ? WHERE id = ?";
            stModificarResultados = connect.prepareStatement(query);
            stModificarResultados.setString(1, nuevaRespuesta);
            stModificarResultados.setInt(2, id);

            int rowsAffected = stModificarResultados.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Opción modificada exitosamente.");
            } else {
                System.out.println("No se encontró la opción especificada.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
 */
// </editor-fold>
