package Clases;

import java.sql.*;

public class ConexionBD {

    Connection cn = null;

    public Connection conexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            cn = DriverManager.getConnection("jdbc:mysql://localhost:8889/sistema?user=root&password=root");
            System.out.println("Coneccion exitosa");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return cn;
    }

    Statement creStatement() {
        throw new UnsupportedOperationException("No soportable");
    }
}
