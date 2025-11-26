package modelo;

public class Mago extends Personaje {
    public Mago(String nombre) {
        super(
            nombre,
            "Mago",           
            50,// salud
            100,// mana
            30,// ataque
            15,// defensa
            30// agilidad
        ); 
    }
}