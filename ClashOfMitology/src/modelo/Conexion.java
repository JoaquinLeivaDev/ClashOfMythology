package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    
    private static final String URL = "jdbc:mysql://localhost:3306/clashofmythology";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    
    private Connection conexion = null;
    
    private Conexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            
            conexion = DriverManager.getConnection(URL, USER, PASSWORD);
            
            System.out.println("✅ Conexión exitosa a la base de datos.");
            
        } catch (ClassNotFoundException e) {
            System.err.println("❌ Error: No se encontró el driver JDBC de MySQL. " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("❌ Error al conectar con la BD 'clashofmythology'. Revisa XAMPP.");
            System.err.println("Mensaje de error: " + e.getMessage());
        }
    }
    
    public static Conexion getInstance() {
        return SingletonHolder.INSTANCE;
    }
    
    
    private static class SingletonHolder {
        private static final Conexion INSTANCE = new Conexion();
    }

    public Connection getConexion() {
        return conexion;
    }

    public void cerrarConexion() {
        if (conexion != null) {
            try {
                conexion.close();
                System.out.println("Cerrando conexión.");
            } catch (SQLException e) {
                System.err.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }
}