package modelo;

public class Guerrero extends Personaje {    
    public Guerrero(String nombre) {
        
        super(
            nombre,
            "Guerrero",
            150,               // salud
            20,                // mana
            40,                // ataque
            60,                // defensa
            25                 // agilidad
        ); 
    }
    
    public Guerrero() {
        super(
            null, // Nombre inicializado a null
            "Guerrero",
            0,
            0,
            0,
            0,
            0
        );
    }
}