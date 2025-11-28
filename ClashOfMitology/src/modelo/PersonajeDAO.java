package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PersonajeDAO {
    
    Connection cn = Conexion.getInstance().getConexion(); 
    PreparedStatement ps = null; 
    
    
    public boolean ingresarPersonaje(Personaje p) {
        
        String sql = "INSERT INTO personajes (nombre, tipo, salud, mana, ataque, defensa, agilidad) VALUES (?, ?, ?, ?, ?, ?, ?)";//aqui le tuve que quitar un '?'
               
        if (cn == null) {
            System.err.println("❌ Fallo: La conexión a la base de datos no está disponible.");
            return false;
        }

        try {
            ps = cn.prepareStatement(sql);
                        
            ps.setString(1, p.getNombre());
            ps.setString(2, p.getTipo());
            
            ps.setInt(3, p.getSalud());
            ps.setInt(4, p.getMana());
            ps.setInt(5, p.getAtaque());
            ps.setInt(6, p.getDefensa());
            ps.setInt(7, p.getAgilidad());
            
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
    
    public boolean editarPersonaje(Personaje p) {

        // Crear un personaje nuevo del tipo elegido, pero con el mismo nombre
        Personaje nuevo = FabricaPersonajes.crearPorTipo(p.getTipo(), p.getNombre());

        String sql = "UPDATE personajes SET nombre = ?, tipo = ?, salud = ?, mana = ?, ataque = ?, defensa = ?, agilidad = ? WHERE id = ?";

        if (cn == null) {
            System.err.println("❌ Fallo: La conexión a la base de datos no está disponible.");
            return false;
        }

        try {
            ps = cn.prepareStatement(sql);

            // Nuevo nombre y tipo
            ps.setString(1, nuevo.getNombre());
            ps.setString(2, nuevo.getTipo());

            // Nuevas estadísticas del tipo seleccionado
            ps.setInt(3, nuevo.getSalud());
            ps.setInt(4, nuevo.getMana());
            ps.setInt(5, nuevo.getAtaque());
            ps.setInt(6, nuevo.getDefensa());
            ps.setInt(7, nuevo.getAgilidad());

            ps.setInt(8, p.getId());

            int filas = ps.executeUpdate();

            if (filas > 0) {
                System.out.println("✅ Personaje actualizado a tipo '" + nuevo.getTipo() + "'");
                return true;
            } else {
                System.err.println("⚠️ No se encontró personaje con ID " + p.getId());
                return false;
            }

        } catch (SQLException e) {
            System.err.println("❌ Error al actualizar personaje.");
            e.printStackTrace();
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