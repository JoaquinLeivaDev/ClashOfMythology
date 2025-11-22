package controlador;

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
}