package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class conexion {

    private String bd = "motorinferencia";
    private String url = "jdbc:mysql://localhost:3306/";

    private String user = "root";
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

    public void insertarQuiz(String nombre) {
        String sql = "INSERT INTO quizzes (nombre) VALUES (?)";
        try {
            stInsertar = connect.prepareStatement(sql);
            stInsertar.setString(1, nombre);
            stInsertar.executeUpdate();
            System.out.println("Quiz insertado correctamente.");
        } catch (SQLException ex) {
            System.out.println("Error al insertar el quiz.");
            System.out.println(ex.getMessage());
        }
    }

    public static void main(String[] args) {
        conexion conect = new conexion();
        conect.conectar();
        conect.insertarQuiz("Peronalidad");
        conect.desconectar();
    }
}
