package modelo;

public class FabricaPersonajes {

    public static Personaje crearPorTipo(String tipo, String nombre) {

        switch (tipo.toLowerCase()) {
            case "guerrero":
                return new Guerrero(nombre);

            case "mago":
                return new Mago(nombre);

            case "arquero":
                return new Arquero(nombre);
            
            case "sacerdote":
                return new Sacerdote(nombre);
                
            case "asesino":
                return new Asesino(nombre);

            default:
                throw new IllegalArgumentException("Tipo de personaje inválido: " + tipo);
        }
    }
}
