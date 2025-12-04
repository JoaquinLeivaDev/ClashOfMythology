package modelo;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Personaje;
import modelo.Conexion;

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
    
    public List<Personaje> buscarPersonaje(String id, String tipo, String nombre) {
        
        // El 'id' se busca por igualdad (si se proporciona)
        // El 'nombre' y 'tipo' se buscan usando LIKE para búsquedas parciales (si se proporcionan)
        // La condición '1 = 1' es un truco para poder añadir clausulas AND sin preocuparse si es la primera.
        String sqlBase = "SELECT id, nombre, tipo, salud, mana, ataque, defensa, agilidad FROM personajes WHERE 1 = 1";
        
        List<Personaje> resultados = new ArrayList<>();
        PreparedStatement psBusqueda = null;
        ResultSet rs = null;
        
        // 1. Construir la consulta SQL dinámicamente
        if (id != null && !id.trim().isEmpty()) {
            sqlBase += " AND id = ?";
        }
        if (tipo != null && !tipo.trim().isEmpty() && !tipo.equalsIgnoreCase("TODOS")) {
            sqlBase += " AND tipo = ?";
        }
        if (nombre != null && !nombre.trim().isEmpty()) {
            sqlBase += " AND nombre LIKE ?";
        }
        
        System.out.println("DEBUG SQL: " + sqlBase);
        
        try (Connection conn = Conexion.getInstance().getConexion()) { // Usamos la conexión de la instancia
            
            if (conn == null) {
                System.err.println("❌ Fallo: La conexión a la base de datos no está disponible.");
                return resultados;
            }
            
            psBusqueda = conn.prepareStatement(sqlBase);
            int paramIndex = 1;
            
            // 2. Establecer los parámetros en el PreparedStatement
            if (id != null && !id.trim().isEmpty()) {
                // Se asume que el ID es un entero, por eso usamos Integer.parseInt
                psBusqueda.setInt(paramIndex++, Integer.parseInt(id.trim()));
            }
            if (tipo != null && !tipo.trim().isEmpty() && !tipo.equalsIgnoreCase("TODOS")) {
                psBusqueda.setString(paramIndex++, tipo);
            }
            if (nombre != null && !nombre.trim().isEmpty()) {
                // Para LIKE, añadimos comodines '%' al nombre para búsqueda parcial (ej: %Joa%)
                psBusqueda.setString(paramIndex++, "%" + nombre.trim() + "%");
            }
            
            // 3. Ejecutar la consulta
            rs = psBusqueda.executeQuery();
            
            // 4. Procesar los resultados
            while (rs.next()) {
                // Asume que tienes un constructor vacío o setters
                String tipoPersonaje = rs.getString("tipo");
                Personaje p = FabricaPersonajes.crearPorTipo(tipoPersonaje);
                
                p.setId(rs.getInt("id"));
                p.setNombre(rs.getString("nombre"));
                p.setTipo(tipoPersonaje); // Ya lo obtuvimos
                p.setSalud(rs.getInt("salud"));
                p.setMana(rs.getInt("mana"));
                p.setAtaque(rs.getInt("ataque"));
                p.setDefensa(rs.getInt("defensa"));
                p.setAgilidad(rs.getInt("agilidad"));

                resultados.add(p);
            }
            
            System.out.println("✅ Búsqueda completada. Encontrados " + resultados.size() + " personajes.");
            
        } catch (SQLException e) {
            System.err.println("❌ Error al ejecutar la búsqueda en la BD.");
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.err.println("❌ Error: El ID debe ser un número entero.");
        } finally {
             // 5. Cerrar recursos (ResultSet y PreparedStatement)
            try {
                if (rs != null) rs.close();
                if (psBusqueda != null) psBusqueda.close();
                // Nota: La conexión 'conn' no se cierra aquí porque se obtiene de la instancia (Singleton)
            } catch (SQLException e) {
                System.err.println("Error al cerrar recursos: " + e.getMessage());
            }
        }
        
        return resultados;
    }
}