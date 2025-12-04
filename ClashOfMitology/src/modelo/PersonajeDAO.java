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

        String sqlBase = "SELECT id, nombre, tipo, salud, mana, ataque, defensa, agilidad FROM personajes WHERE 1 = 1";

        List<Personaje> resultados = new ArrayList<>();
        PreparedStatement psBusqueda = null;
        ResultSet rs = null;

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

        Connection conn = Conexion.getInstance().getConexion(); 
        if (conn == null) {
            System.err.println("❌ Fallo: La conexión está cerrada.");
            return resultados;
        }

        try {
            psBusqueda = conn.prepareStatement(sqlBase);
            int paramIndex = 1;

            if (id != null && !id.trim().isEmpty()) {
                psBusqueda.setInt(paramIndex++, Integer.parseInt(id.trim()));
            }
            if (tipo != null && !tipo.trim().isEmpty() && !tipo.equalsIgnoreCase("TODOS")) {
                psBusqueda.setString(paramIndex++, tipo);
            }
            if (nombre != null && !nombre.trim().isEmpty()) {
                psBusqueda.setString(paramIndex++, "%" + nombre.trim() + "%");
            }

            rs = psBusqueda.executeQuery();

            while (rs.next()) {
                String tipoPersonaje = rs.getString("tipo");
                Personaje p = FabricaPersonajes.crearPorTipo(tipoPersonaje);

                p.setId(rs.getInt("id"));
                p.setNombre(rs.getString("nombre"));
                p.setTipo(tipoPersonaje);
                p.setSalud(rs.getInt("salud"));
                p.setMana(rs.getInt("mana"));
                p.setAtaque(rs.getInt("ataque"));
                p.setDefensa(rs.getInt("defensa"));
                p.setAgilidad(rs.getInt("agilidad"));

                resultados.add(p);
            }

            System.out.println("✅ Búsqueda completada. Encontrados " + resultados.size() + " personajes.");

        } catch (SQLException e) {
            System.err.println("❌ Error al ejecutar la búsqueda.");
            e.printStackTrace();

        } finally {
            try {
                if (rs != null) rs.close();
                if (psBusqueda != null) psBusqueda.close();
            } catch (SQLException e) {
                System.err.println("Error al cerrar recursos: " + e.getMessage());
            }
        }

        return resultados;
    }
    
    public boolean eliminarPersonajePorID(int id) {
        String sql = "DELETE FROM personajes WHERE id = ?";

        if (cn == null) {
            System.err.println("❌ Fallo: No hay conexión disponible a la base de datos.");
            return false;
        }

        PreparedStatement ps = null;

        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(1, id);

            int filasAfectadas = ps.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("✅ Personaje con ID " + id + " eliminado con éxito.");
                return true;
            } else {
                System.out.println("⚠ No existe un personaje con ID " + id + ".");
                return false;
            }

        } catch (SQLException e) {
            System.err.println("❌ Error al intentar eliminar el personaje en la BD.");
            e.printStackTrace();
            return false;

        } finally {
            try {
                if (ps != null) ps.close();
            } catch (SQLException e) {
                System.err.println("Error al cerrar PreparedStatement: " + e.getMessage());
            }
        }
    }
    public boolean eliminarPersonajePorNombre(String nombre) {
        String sql = "DELETE FROM personajes WHERE nombre = ?";

        if (cn == null) {
            System.err.println("❌ Fallo: No hay conexión disponible a la base de datos.");
            return false;
        }

        PreparedStatement ps = null;

        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, nombre);

            int filasAfectadas = ps.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("✅ Personaje con Nombre: " + nombre + " eliminado con éxito.");
                return true;
            } else {
                System.out.println("⚠ No existe un personaje con Nombre: " + nombre + ".");
                return false;
            }

        } catch (SQLException e) {
            System.err.println("❌ Error al intentar eliminar el personaje en la BD.");
            e.printStackTrace();
            return false;

        } finally {
            try {
                if (ps != null) ps.close();
            } catch (SQLException e) {
                System.err.println("Error al cerrar PreparedStatement: " + e.getMessage());
            }
        }
    }
    public boolean eliminarPersonajePorTipo(String tipo) {
        String sql = "DELETE FROM personajes WHERE tipo = ?";

        if (cn == null) {
            System.err.println("❌ Fallo: No hay conexión disponible a la base de datos.");
            return false;
        }

        PreparedStatement ps = null;

        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, tipo);

            int filasAfectadas = ps.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("✅ Personaje(s) con Tipo: " + tipo + " eliminado(s) con éxito.");
                return true;
            } else {
                System.out.println("⚠ No existe un personaje con Tipo: " + tipo + ".");
                return false;
            }

        } catch (SQLException e) {
            System.err.println("❌ Error al intentar eliminar el personaje en la BD.");
            e.printStackTrace();
            return false;

        } finally {
            try {
                if (ps != null) ps.close();
            } catch (SQLException e) {
                System.err.println("Error al cerrar PreparedStatement: " + e.getMessage());
            }
        }
    }
    
    public void eliminarTodoPersonajes()throws SQLException{
        String sql = "DELETE FROM personajes";

        PreparedStatement ps = cn.prepareStatement(sql);
        ps.executeUpdate();
        ps.close();
    

        
    }
}