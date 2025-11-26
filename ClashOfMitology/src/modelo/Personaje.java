package modelo;

public abstract class Personaje {
    
    private int id; // ID de la base de datos
    private String nombre; 
    private String tipo;
    private int salud;
    private int mana;
    private int ataque;
    private int defensa;
    private int agilidad;

    public Personaje(String nombre, String tipo, int salud, int mana, int ataque, int defensa, int agilidad) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.salud = salud;
        this.mana = mana;
        this.ataque = ataque;
        this.defensa = defensa;
        this.agilidad = agilidad;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getTipo() { return tipo; }
    public int getSalud() { return salud; }
    public int getMana() { return mana; }
    public int getAtaque() { return ataque; }
    public int getDefensa() { return defensa; }
    public int getAgilidad() { return agilidad; }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public void setSalud(int salud) {
        this.salud = salud;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    public void setAgilidad(int agilidad) {
        this.agilidad = agilidad;
    }    
}