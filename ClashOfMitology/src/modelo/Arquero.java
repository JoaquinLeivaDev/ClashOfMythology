package modelo;

public class Arquero extends Personaje {
    
    public Arquero(String nombre) {
        super(
            nombre,
            "Arquero",
            65,  // salud
            40,  // mana
            55,  // ataque
            15,  // defensa
            60   // agilidad
        ); 
    }
}