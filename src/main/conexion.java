package main;

import java.sql.ResultSet; // Requerida para crear un objeto ResultSet
import java.sql.Statement; // Requerida para el Statement.RETURN_GENERATED_KEYS
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class conexion {

    private String bd = "motorinferencia";
    private String url = "jdbc:mysql://localhost:3306/"; // CAMBIAR EL PUERTO SI ES NECESARIO

    private String user = "root"; // CAMBIAR EL USUARIO SI ES NECESARIO
    private String password = "";
    private String driver = "com.mysql.cj.jdbc.Driver";
    private Connection connect;

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

    public void insertarQuiz(String nombre, Pregunta[] preguntas) {
        String sql = "INSERT INTO quizzes (nombre) VALUES (?)";
        int idQuiz = -1;
        
        try {
            stInsertar = connect.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stInsertar.setString(1, nombre);
            stInsertar.executeUpdate();
            
            ResultSet rs = stInsertar.getGeneratedKeys();
            if(rs.next()){
                idQuiz = rs.getInt(1);
                System.out.println("Quiz insertado correctamente.");
            }

            insertarPreguntas(preguntas, idQuiz);
        } catch (SQLException ex) {
            System.out.println("El Quiz no pudo ser insertado");
            System.out.println(ex.getMessage());
        }

    }

    private void insertarPreguntas(Pregunta[] preguntas, int idQuiz) {
        String sql = "INSERT INTO preguntas (enunciado, idQuiz) VALUES (?, ?)";

        try {
            for (int i = 0; i < preguntas.length; i++) {
                stInsertar = connect.prepareStatement(sql);
                stInsertar.setString(1, preguntas[i].getEnunciado());
                stInsertar.setString(2, String.valueOf(idQuiz));
                stInsertar.executeUpdate();
            }
        } catch (SQLException ex) {
            System.out.println("La pregunta no pudo ser insertada");
            System.out.println(ex.getMessage());
        }
    }

    public static void main(String[] args) throws SQLException {
        conexion conect = new conexion();
        conect.conectar();
        Pregunta[] preguntas = {
            new Pregunta("Hola"),
            new Pregunta("que"),
            new Pregunta("hace")
        };
        conect.insertarQuiz("Personalidad", preguntas);
        conect.desconectar();
    }
}
