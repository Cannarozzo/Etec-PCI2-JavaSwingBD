package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *Fernanda
 */
public class Conectar {
    final static String URL = "jdbc:mysql://localhost:3306/crud_java";
    final static String USER = "root";
    final static String PASS = "root";
    public static Connection Banco() throws SQLException
    {
        Connection Con = (Connection)DriverManager.getConnection(URL,USER,PASS);
        return Con;
        
    }
    
}
