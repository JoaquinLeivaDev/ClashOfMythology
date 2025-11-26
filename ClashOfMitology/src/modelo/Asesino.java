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
}