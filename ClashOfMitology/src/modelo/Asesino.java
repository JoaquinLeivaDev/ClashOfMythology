package modelo;

public class Asesino extends Personaje {
    
    public Asesino(String nombre) {
        super(
            nombre,
            "Asesino",   
            60,// salud
            50,// mana
            60,// ataque
            20,// defensa
            70 // agilidad
        ); 
    }
    
    public Asesino() {
        super(
            null, // Nombre inicializado a null
            "Asesino",
            0,
            0,
            0,
            0,
            0
        );
    }
}