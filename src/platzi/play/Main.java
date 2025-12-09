package platzi.play;

import platzi.play.contenido.Pelicula;
import platzi.play.plataforma.Plataforma;
import platzi.play.plataforma.Usuario;
import platzi.play.util.ScannerUtils;

public class Main {
    public static final String NOMBRE_PLATAFORMA = "SISTEMA DE GESTIÓN DE PELÍCULAS";
    public static final String VERSION = "1.0.0";

    public static void main(String[] args) {
        Plataforma plataforma = new Plataforma(NOMBRE_PLATAFORMA);
        System.out.println(NOMBRE_PLATAFORMA + " v" + VERSION);

        // 1. Agregar contenido
        // 2. Mostrar todo
        // 3. Buscar por titulo
        // 4. Eliminar
        // 5. Salir

        while(true){
            int opcionElegida = ScannerUtils.capturarNumero("""
                    1. Agregar contenido
                    2. Mostrar todo
                    3. Buscar por titulo
                    4. Eliminar
                    5. Salir
                    """);

            System.out.println("Opción elegida: " + opcionElegida);

            if(opcionElegida == 5){
                System.exit(0);
            }
        }

//        String nombre = ScannerUtils.capturarTexto("Nombre del contenido");
//        String genero = ScannerUtils.capturarTexto("Genero del contenido");
//        int duracion = ScannerUtils.capturarNumero("Duracion del contenido");
//        double calificacion = ScannerUtils.capturarDecimal("Calificacion del contenido");
//
//        Pelicula pelicula = new Pelicula(nombre, duracion, genero, calificacion);
//        Pelicula pelicula2 = new Pelicula("F1 the Movie", 202, "Action");
//
//        plataforma.agregar(pelicula);
//        plataforma.agregar(pelicula2);
//        System.out.println("Numero de elementos en la plataform " + plataforma.getContenido().size());
//        plataforma.eliminar(pelicula2);
//
//        plataforma.mostrarTitulos();;
//
//        Usuario usuario = new Usuario("Pepito", "pepito@hotmail.com");
//        usuario.ver(pelicula);

    }
}
