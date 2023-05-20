package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class conexion {

    String bd = "motorinferencia";
    String url = "jdbc:mysql://localhost:3308/";

    String user = "prueba";
    String password = "";
    String driver = "com.mysql.cj.jdbc.Driver";
    Connection connect;

    public conexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("Error al cargar el driver");
            System.out.println(ex.getMessage());

        }
    }

    public Connection conectar() {
        try {
            Class.forName(driver);
            connect = DriverManager.getConnection(url + bd + "?serverTimezone=GMT-5", user, password);
            System.out.println("Se logró la conexion");

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(conexion.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("No se conecto a bd");
        }
        return connect;
    }

    public void desconectar() {
        try {
            connect.close();
            System.out.println("Se logró desconectar");
        } catch (SQLException ex) {
            Logger.getLogger(conexion.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("no se desconecto");
        }
    }

    public static void main(String[] args) {
        conexion conect = new conexion();
        conect.conectar();
    }
}
