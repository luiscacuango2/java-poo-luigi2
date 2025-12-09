package platzi.play;

import platzi.play.contenido.Pelicula;
import platzi.play.plataforma.Genero;
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
    public static final int VER_POPULARES = 5;
    public static final int VER_MUY_POPULARES = 6;
    public static final int VER_MAS_LARGA = 7;
    public static final int VER_MAS_CORTA = 8;
    public static final int ELIMINAR = 9;
    public static final int SALIR = 10;

    public static void main(String[] args) {
        Plataforma plataforma = new Plataforma(NOMBRE_PLATAFORMA);
        System.out.println(NOMBRE_PLATAFORMA + " v" + VERSION);

        cargarPeliculas(plataforma);

        System.out.println("Más de " + plataforma.getDuracionTotal() + " minutos de contenido! \n");

        while(true){
            int opcionElegida = ScannerUtils.capturarNumero("""
                    Ingrese una de las siguientes opciones:
                    1. Agregar contenido
                    2. Mostrar todo
                    3. Buscar por titulo
                    4. Buscar por genero
                    5. Ver populares
                    6. Ver muy populares
                    7. Ver mas larga
                    8. Ver corta
                    9. Eliminar
                    10. Salir
                    """);

            switch (opcionElegida){
                case AGREGAR -> {
                    String nombre = ScannerUtils.capturarTexto("Nombre del contenido");
                    Genero genero = ScannerUtils.capturarGenero("Genero del contenido");
                    int duracion = ScannerUtils.capturarNumero("Duración del contenido");
                    double calificacion = ScannerUtils.capturarDecimal("Calificación del contenido");

                    plataforma.agregar(new Pelicula(nombre, duracion, genero, calificacion));
                }
                case MOSTRAR_TODO -> {
                    List<String> titulos = plataforma.getTitulos();
                    titulos.forEach(System.out::println);
                }
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
                    Genero generoBuscado = ScannerUtils.capturarGenero("Genero del contenido a buscar");

                    List<Pelicula> contenidoPorGenero = plataforma.buscarPorGenero(generoBuscado);
                    System.out.println("\n" + contenidoPorGenero.size() + " encontrados para el género " + generoBuscado);
                    contenidoPorGenero.forEach(contenido -> System.out.println(contenido.obtenerFichaTecnica()));
                }
                case VER_POPULARES -> {
                    int cantidad = ScannerUtils.capturarNumero("Cantidad de resultados a mostrar");

                    List<Pelicula> contenidosPopulares = plataforma.getPopulares(cantidad);
                    contenidosPopulares.forEach(contenido -> System.out.println(contenido.obtenerFichaTecnica()));
                }
                case VER_MUY_POPULARES -> {
                    System.out.println("Las películas muy populares 🌟 son:");
                    List<Pelicula> peliculasMuyPopulares = plataforma.getMuyPopulares();
                    peliculasMuyPopulares.forEach(contenido -> System.out.println(contenido.obtenerFichaTecnica()));
                }
                case VER_MAS_LARGA -> {
                    System.out.println("Las película mas larga es:\n");
                    Pelicula peliculaMasLarga = plataforma.getMasLarga();
                    System.out.println(peliculaMasLarga.obtenerFichaTecnica() + "⌛ Duración: " + peliculaMasLarga.getDuracion() + "\n");
                }
                case VER_MAS_CORTA -> {
                    System.out.println("Las película mas corta es:\n");
                    Pelicula peliculaMasCorta = plataforma.getMasCorta();
                    System.out.println(peliculaMasCorta.obtenerFichaTecnica() + "⌛ Duración: " + peliculaMasCorta.getDuracion() + "\n");
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
        plataforma.agregar(new Pelicula("Shrek", 90, Genero.ANIMADA));
        plataforma.agregar(new Pelicula("Inception", 148, Genero.CIENCIA_FICCION));
        plataforma.agregar(new Pelicula("Titanic", 195, Genero.DRAMA, 4.6));
        plataforma.agregar(new Pelicula("John Wick", 101, Genero.ACCION));
        plataforma.agregar(new Pelicula("El Conjuro", 112, Genero.TERROR, 3.0));
        plataforma.agregar(new Pelicula("Coco", 105, Genero.ANIMADA, 4.7));
        plataforma.agregar(new Pelicula("Interstellar", 169, Genero.CIENCIA_FICCION, 5));
        plataforma.agregar(new Pelicula("Joker", 122, Genero.DRAMA));
        plataforma.agregar(new Pelicula("Toy Story", 81, Genero.ANIMADA, 4.5));
        plataforma.agregar(new Pelicula("Avengers: Endgame", 181, Genero.ACCION, 3.9));
    }
}