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
    
    public static Personaje crearPorTipo(String tipo) {
        
        switch (tipo.toLowerCase()) {
            case "guerrero":
                return new Guerrero(); 

            case "mago":
                return new Mago();

            case "arquero":
                return new Arquero();
            
            case "sacerdote":
                return new Sacerdote();
                
            case "asesino":
                return new Asesino();

            default:
                // Si el tipo en la BD no coincide con ninguno, devolvemos null o lanzamos excepción.
                System.err.println("Advertencia: Tipo de personaje desconocido en la BD: " + tipo);
                return null;
        }
    }
}
    
