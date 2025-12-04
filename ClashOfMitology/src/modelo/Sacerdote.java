package modelo;

public class Sacerdote extends Personaje {    
    public Sacerdote(String nombre) {
        super(
            nombre,            
            "Sacerdote",
            85,                // salud
            140,               // mana
            10,                // ataque
            30,                // defensa
            15                 // agilidad
        ); 
    }
    
    public Sacerdote() {
        super(
            null, // Nombre inicializado a null
            "Sacerdote",
            0,
            0,
            0,
            0,
            0
        );
    }
}