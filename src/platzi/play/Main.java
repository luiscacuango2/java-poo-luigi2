package platzi.play;

import platzi.play.contenido.Pelicula;
import platzi.play.contenido.ResumenContenido;
import platzi.play.excepcion.PeliculaExistenteException;
import platzi.play.plataforma.*;
import platzi.play.util.FileUtils;
import platzi.play.util.ScannerUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static final String NOMBRE_PLATAFORMA = "SISTEMA DE GESTIÓN DE PELÍCULAS";
    public static final String VERSION = "1.0.0";

    public static final int AGREGAR = 1;
    public static final int MOSTRAR_TODO = 2;
    public static final int BUSCAR_POR_TITULO = 3;
    public static final int BUSCAR_POR_GENERO = 4;
    public static final int BUSCAR_POR_IDIOMA = 5;
    public static final int BUSCAR_POR_CALIDAD = 6;
    public static final int VER_POPULARES = 7;
    public static final int VER_MAS_POPULARES = 8;
    public static final int VER_MAS_LARGA = 9;
    public static final int VER_MAS_CORTA = 10;
    public static final int REPRODUCIR = 11;
    public static final int ELIMINAR = 12;
    public static final int SALIR = 13;

    public static void main(String[] args) {
        Plataforma plataforma = new Plataforma(NOMBRE_PLATAFORMA);
        System.out.println(NOMBRE_PLATAFORMA + " v" + VERSION);

        cargarPeliculas(plataforma);

        System.out.println("Más de " + plataforma.getDuracionTotal() + " minutos de contenido!");

        while(true){
            int opcionElegida = ScannerUtils.capturarNumero("""
                    \nIngrese una de las siguientes opciones:
                    1. Agregar contenido
                    2. Mostrar todo
                    3. Buscar por titulo
                    4. Buscar por genero
                    5. Buscar por idioma
                    6. Buscar por calidad
                    7. Ver populares
                    8. Ver más populares
                    9. Ver más larga
                    10. Ver corta
                    11. Reproducir
                    12. Eliminar
                    13. Salir
                    """);

            switch (opcionElegida){
                case AGREGAR -> {
                    String nombre = ScannerUtils.capturarTexto("Nombre del contenido");
                    Genero genero = ScannerUtils.capturarGenero("Genero del contenido");
                    Idioma idioma =  ScannerUtils.capturarIdioma("Idioma del contenido");
                    Calidad calidad = ScannerUtils.capturarCalidad("Calidad del contenido");
                    int duracion = ScannerUtils.capturarNumero("Duración del contenido");
                    double calificacion = ScannerUtils.capturarDecimal("Calificación del contenido");

                    try {
                        plataforma.agregar(new Pelicula(nombre, duracion, genero, idioma, calidad, calificacion));
                    } catch (PeliculaExistenteException e) {
                        System.out.println(e.getMessage());
                    }

                }
                case MOSTRAR_TODO -> {
                    List<ResumenContenido> contenidosResumidos = plataforma.getResumenes();
                    contenidosResumidos.forEach(resumen -> System.out.println(resumen.toString()));
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
                    System.out.println("\n" + contenidoPorGenero.size() + " encontrados para el género " + generoBuscado + ":");
                    contenidoPorGenero.forEach(contenido -> System.out.println(contenido.obtenerFichaTecnica()));
                }
                case BUSCAR_POR_IDIOMA -> {
                    Idioma idiomaBuscado = ScannerUtils.capturarIdioma("Idioma del contenido a buscar");

                    List<Pelicula> contenidoPorIdioma = plataforma.buscarPorIdioma(idiomaBuscado);
                    System.out.println("\n" + contenidoPorIdioma.size() + " encontrados para el idioma " + idiomaBuscado + ":");
                    contenidoPorIdioma.forEach(contenido -> System.out.println(contenido.obtenerFichaTecnica()));
                }
                case BUSCAR_POR_CALIDAD -> {
                    Calidad calidadBuscada = ScannerUtils.capturarCalidad("Calidad del contenido a buscar");

                    List<Pelicula> contenidoPorCalidad = plataforma.buscarPorCalidad(calidadBuscada);
                    System.out.println("\n" + contenidoPorCalidad.size() + " encontrados para la calidad " + calidadBuscada + ":");
                    contenidoPorCalidad.forEach(contenido -> System.out.println(contenido.obtenerFichaTecnica()));
                }
                case VER_POPULARES -> {
                    int cantidad = ScannerUtils.capturarNumero("Cantidad de películas populares a mostrar");

                    List<Pelicula> contenidosPopulares = plataforma.getPopulares(cantidad);
                    contenidosPopulares.forEach(contenido -> System.out.println(contenido.obtenerFichaTecnica()));
                }
                case VER_MAS_POPULARES -> {
                    System.out.println("Las películas más populares (>4.0) 🌟 son:");
                    List<Pelicula> peliculasMuyPopulares = plataforma.getMuyPopulares();
                    peliculasMuyPopulares.forEach(contenido -> System.out.println(contenido.obtenerFichaTecnica()));
                }
                case VER_MAS_LARGA -> {
                    System.out.println("Las película más larga es:");
                    Pelicula peliculaMasLarga = plataforma.getMasLarga();
                    System.out.println(peliculaMasLarga.obtenerFichaTecnica() + "\n⌛ Duración: " + peliculaMasLarga.getDuracion());
                }
                case VER_MAS_CORTA -> {
                    System.out.println("Las película más corta es:");
                    Pelicula peliculaMasCorta = plataforma.getMasCorta();
                    System.out.println(peliculaMasCorta.obtenerFichaTecnica() + "\n⌛ Duración: " + peliculaMasCorta.getDuracion());
                }
                case REPRODUCIR -> {
                    String nombre = ScannerUtils.capturarTexto("Nombre del contenido a reproducir");
                    Pelicula contenido = plataforma.buscarPorTitulo(nombre);

                    if(contenido != null){
                        plataforma.reproducir(contenido);
                    } else {
                        System.out.println(nombre + " no existe.");
                    }
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
        plataforma.getContenido().addAll(FileUtils.leerContenido());
    }
}