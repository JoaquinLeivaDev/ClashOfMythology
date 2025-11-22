package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PersonajeDAO {
    
    public boolean ingresarPersonaje(Personaje p) {
        
        String sql = "INSERT INTO personajes (nombre, tipo, caracteristicas, salud, mana, ataque, defensa, agilidad) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        
        Connection cn = Conexion.getInstance().getConexion(); 
        PreparedStatement ps = null; 
        
        if (cn == null) {
            System.err.println("❌ Fallo: La conexión a la base de datos no está disponible.");
            return false;
        }

        try {
            ps = cn.prepareStatement(sql);
                        
            ps.setString(1, p.getNombre());
            ps.setString(2, p.getTipo());
            
            ps.setInt(4, p.getSalud());
            ps.setInt(5, p.getMana());
            ps.setInt(6, p.getAtaque());
            ps.setInt(7, p.getDefensa());
            ps.setInt(8, p.getAgilidad());
            
            ps.executeUpdate();
            
            System.out.println("✅ Personaje '" + p.getNombre() + "' de tipo " + p.getTipo() + " ingresado con éxito.");
            return true;
            
        } catch (SQLException e) {
            System.err.println("❌ Error al intentar ingresar el personaje en la BD.");
            if (e.getErrorCode() == 1062) { 
                 System.err.println("El nombre de personaje '" + p.getNombre() + "' ya existe. Por favor, elige otro.");
            } else {
                 e.printStackTrace();
            }
            return false;
            
        } finally {
            try {
                if (ps != null) ps.close();
            } catch (SQLException e) {
                System.err.println("Error al cerrar recursos: " + e.getMessage());
            }
        }
    }
}