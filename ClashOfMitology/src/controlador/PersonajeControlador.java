package controlador;

import java.util.List;
import modelo.Personaje;
import modelo.Mago;
import modelo.Arquero;
import modelo.Guerrero;
import modelo.Asesino;
import modelo.Sacerdote;
import modelo.PersonajeDAO;

public class PersonajeControlador {
    
    private final PersonajeDAO dao;

    public PersonajeControlador() {
        this.dao = new PersonajeDAO();
    }
    
    public List<Personaje> buscarPersonajes(String id, String tipo, String nombre) {
        return dao.buscarPersonaje(id, tipo, nombre);
    }
    
    public List<Personaje> listarTodosLosPersonajes() {
        return dao.listarTodos(); 
    }
    
    public Personaje buscarPersonajePorId(int id) {
    return dao.buscarPorId(id);
}
    
    public boolean guardarPersonaje(String nombre, String tipo) {
        
        if (nombre == null || nombre.trim().isEmpty() || tipo == null || tipo.trim().isEmpty()) {
            System.err.println("Error: Nombre y Tipo no pueden estar vacíos.");
            return false;
        }
        
        Personaje nuevoPersonaje = null;
        
        switch (tipo) {
            case "Mago":
                nuevoPersonaje = new Mago(nombre);
                break;
            case "Guerrero":
                nuevoPersonaje = new Guerrero(nombre);
                break;
            case "Arquero":
                nuevoPersonaje = new Arquero(nombre);
                break;
            case "Asesino":
                nuevoPersonaje = new Asesino(nombre);
                break;
            case "Sacerdote":
                nuevoPersonaje = new Sacerdote(nombre);
                break;
            default:
                System.err.println("Error: Tipo de personaje no reconocido: " + tipo);
                return false;
        }
        
        if (nuevoPersonaje != null) {
            return dao.ingresarPersonaje(nuevoPersonaje);
        }
        
        return false;
    }
    
    public boolean editarPersonaje(Personaje p) {
        
        if (p == null || p.getId() <= 0) {
            System.err.println("Error de Control: El objeto Personaje o su ID son inválidos para la edición.");
            return false;
        }
        return dao.editarPersonaje(p);
    } 
    
    public boolean eliminarPersonajePorId(int id) {
    if (id <= 0) {
        System.err.println("Error: ID de personaje inválido para la eliminación.");
        return false;
    }
    return dao.eliminarPersonajePorID(id);
}

public boolean eliminarPersonajePorNombre(String nombre) {
    if (nombre == null || nombre.trim().isEmpty()) {
        System.err.println("Error: Nombre no puede estar vacío para la eliminación.");
        return false;
    }
    return dao.eliminarPersonajePorNombre(nombre);
}

public boolean eliminarPersonajePorTipo(String tipo) {
    if (tipo == null || tipo.trim().isEmpty()) {
        System.err.println("Error: Tipo no puede estar vacío para la eliminación.");
        return false;
    }
    return dao.eliminarPersonajePorTipo(tipo);
}

public void eliminarTodosLosPersonajes() throws java.sql.SQLException {
    dao.eliminarTodoPersonajes();
}
    
}