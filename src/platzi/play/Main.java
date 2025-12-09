package platzi.play;

import platzi.play.contenido.Pelicula;
import platzi.play.plataforma.Plataforma;
import platzi.play.plataforma.Usuario;
import platzi.play.util.ScannerUtils;

import java.util.List;

public class Main {
    public static final String NOMBRE_PLATAFORMA = "SISTEMA DE GESTIÓN DE PELÍCULAS";
    public static final String VERSION = "1.0.0";

    public static final int AGREGAR = 1;
    public static final int MOSTRAR_TODO = 2;
    public static final int BUSCAR_POR_TITULO = 3;
    public static final int BUSCAR_POR_GENERO = 4;
    public static final int ELIMINAR = 8;
    public static final int SALIR = 9;

    public static void main(String[] args) {
        Plataforma plataforma = new Plataforma(NOMBRE_PLATAFORMA);
        System.out.println(NOMBRE_PLATAFORMA + " v" + VERSION);

        cargarPeliculas(plataforma);

        while(true){
            int opcionElegida = ScannerUtils.capturarNumero("""
                    Ingrese una de las siguientes opciones:
                    1. Agregar contenido
                    2. Mostrar todo
                    3. Buscar por titulo                    
                    4. Buscar por genero
                    8. Eliminar
                    9. Salir
                    """);

            switch (opcionElegida){
                case AGREGAR -> {
                    String nombre = ScannerUtils.capturarTexto("Nombre del contenido");
                    String genero = ScannerUtils.capturarTexto("Genero del contenido");
                    int duracion = ScannerUtils.capturarNumero("Duración del contenido");
                    double calificacion = ScannerUtils.capturarDecimal("Calificación del contenido");

                    plataforma.agregar(new Pelicula(nombre, duracion, genero, calificacion));
                }
                case MOSTRAR_TODO -> plataforma.mostrarTitulos();
                case BUSCAR_POR_TITULO -> {
                    String nombreBuscado = ScannerUtils.capturarTexto("Nombre del contenido a buscar");
                    Pelicula pelicula = plataforma.buscarPorTitulo(nombreBuscado);

                    if(pelicula != null){
                        System.out.println(pelicula.obtenerFichaTecnica());
                    } else {
                        System.out.println(nombreBuscado + " no existe dentro de " + plataforma.getNombre());
                    }
                }
                case BUSCAR_POR_GENERO -> {
                    String generoBuscado = ScannerUtils.capturarTexto("Genero del contenido a buscar");

                    List<Pelicula> contenidoPorGenero = plataforma.buscarPorGenero(generoBuscado);
                    System.out.println(contenidoPorGenero.size() + " encontrados para el género " + generoBuscado);
                    contenidoPorGenero.forEach(contenido -> System.out.println(contenido.obtenerFichaTecnica() + "\n"));
                }
                case ELIMINAR -> {
                    String nombreAEliminar = ScannerUtils.capturarTexto("Nombre del contenido a eliminar");
                    Pelicula contenido = plataforma.buscarPorTitulo(nombreAEliminar);

                    if(contenido != null){
                        plataforma.eliminar(contenido);
                        System.out.println(nombreAEliminar + " eliminado! ❌");
                    } else {
                        System.out.println(nombreAEliminar +  " no existe dentro de " + plataforma.getNombre());
                    }
                }
                case SALIR -> System.exit(0);
            }
        }
    }

    private static void cargarPeliculas(Plataforma plataforma) {
        plataforma.agregar(new Pelicula("Shrek", 90, "Animada"));
        plataforma.agregar(new Pelicula("Inception", 148, "Ciencia Ficción"));
        plataforma.agregar(new Pelicula("Titanic", 195, "Drama", 4.6));
        plataforma.agregar(new Pelicula("John Wick", 101, "Acción"));
        plataforma.agregar(new Pelicula("El Conjuro", 112, "Terror", 3.0));
        plataforma.agregar(new Pelicula("Coco", 105, "Animada", 4.7));
        plataforma.agregar(new Pelicula("Interstellar", 169, "Ciencia Ficción", 5));
        plataforma.agregar(new Pelicula("Joker", 122, "Drama"));
        plataforma.agregar(new Pelicula("Toy Story", 81, "Animada", 4.5));
        plataforma.agregar(new Pelicula("Avengers: Endgame", 181, "Acción", 3.9));
    }
}