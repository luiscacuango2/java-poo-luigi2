package platzi.play;

import platzi.play.contenido.Contenido;
import platzi.play.contenido.Documental;
import platzi.play.contenido.Pelicula;
import platzi.play.contenido.ResumenContenido;
import platzi.play.excepcion.PeliculaExistenteException;
import platzi.play.plataforma.*;
import platzi.play.util.FileUtils;
import platzi.play.util.ScannerUtils;

import java.util.List;

public class Main {
    public static final String NOMBRE_PLATAFORMA = "SISTEMA DE GESTIÓN DE CONTENIDOS";
    public static final String VERSION = "1.0.0";

    public static final int AGREGAR = 1;
    public static final int MOSTRAR_TODO = 2;
    public static final int BUSCAR_POR_TITULO = 3;
    public static final int BUSCAR_POR_GENERO = 4;
    public static final int BUSCAR_POR_IDIOMA = 5;
    public static final int BUSCAR_POR_CALIDAD = 6;
    public  static final int BUSCAR_POR_TIPO = 7;
    public static final int VER_POPULARES = 8;
    public static final int VER_MAS_POPULARES = 9;
    public static final int VER_MAS_LARGA = 10;
    public static final int VER_MAS_CORTA = 11;
    public static final int REPRODUCIR = 12;
    public static final int ELIMINAR = 13;
    public static final int SALIR = 14;

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
                    7. Buscar por tipo
                    8. Ver populares
                    9. Ver más populares
                    10. Ver más larga
                    11. Ver corta
                    12. Reproducir
                    13. Eliminar
                    14. Salir
                    """);

            switch (opcionElegida){
                case AGREGAR -> {
                    int tipoDeContenido = ScannerUtils.capturarNumero("Que tipo de contenido quieres agregar?\n1. Película\n2. Documental");
                    String nombre = ScannerUtils.capturarTexto("Nombre del contenido");
                    Genero genero = ScannerUtils.capturarGenero("Genero del contenido");
                    Idioma idioma =  ScannerUtils.capturarIdioma("Idioma del contenido");
                    Calidad calidad = ScannerUtils.capturarCalidad("Calidad del contenido");
                    int duracion = ScannerUtils.capturarNumero("Duración del contenido");
                    double calificacion = ScannerUtils.capturarDecimal("Calificación del contenido");

                    try {
                        if (tipoDeContenido == 1) {
                            plataforma.agregar(new Pelicula(nombre, duracion, genero, idioma, calidad, calificacion));
                        } else {
                            String narrador = ScannerUtils.capturarTexto("Narrador del documental");
                            plataforma.agregar(new Documental(nombre, duracion, genero, idioma, calidad, calificacion, narrador));
                        }

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
                    Contenido contenido = plataforma.buscarPorTitulo(nombreBuscado);

                    if(contenido != null){
                        System.out.println(contenido.obtenerFichaTecnica());
                    } else {
                        System.out.println(nombreBuscado + " no existe dentro de " + plataforma.getNombre());
                    }
                }
                case BUSCAR_POR_GENERO -> {
                    Genero generoBuscado = ScannerUtils.capturarGenero("Genero del contenido a buscar");

                    List<Contenido> contenidoPorGenero = plataforma.buscarPorGenero(generoBuscado);
                    System.out.println("\n" + contenidoPorGenero.size() + " encontrados para el género " + generoBuscado + ":");
                    contenidoPorGenero.forEach(contenido -> System.out.println(contenido.obtenerFichaTecnica()));
                }
                case BUSCAR_POR_IDIOMA -> {
                    Idioma idiomaBuscado = ScannerUtils.capturarIdioma("Idioma del contenido a buscar");

                    List<Contenido> contenidoPorIdioma = plataforma.buscarPorIdioma(idiomaBuscado);
                    System.out.println("\n" + contenidoPorIdioma.size() + " encontrados para el idioma " + idiomaBuscado + ":");
                    contenidoPorIdioma.forEach(contenido -> System.out.println(contenido.obtenerFichaTecnica()));
                }
                case BUSCAR_POR_CALIDAD -> {
                    Calidad calidadBuscada = ScannerUtils.capturarCalidad("Calidad del contenido a buscar");

                    List<Contenido> contenidoPorCalidad = plataforma.buscarPorCalidad(calidadBuscada);
                    System.out.println("\n" + contenidoPorCalidad.size() + " encontrados para la calidad " + calidadBuscada + ":");
                    contenidoPorCalidad.forEach(contenido -> System.out.println(contenido.obtenerFichaTecnica()));
                }
                case BUSCAR_POR_TIPO -> {
                    int tipoDeContenido = ScannerUtils.capturarNumero("Que tipo de contenido quieres reproducir?\n1. Película\n2. Documental");

                    if(tipoDeContenido == 1) {
                        List<Pelicula> peliculas = plataforma.getPeliculas();
                        peliculas.forEach(pelicula -> System.out.println(pelicula.obtenerFichaTecnica()));
                    } else {
                        List<Documental> documentales = plataforma.getDocumentales();
                        documentales.forEach(documental -> System.out.println(documental.obtenerFichaTecnica()));
                    }
                }
                case VER_POPULARES -> {
                    int tipoDeContenido = ScannerUtils.capturarNumero("Que tipo de contenido popular quieres ver?\n1. Película\n2. Documental\n");

                    if(tipoDeContenido == 1) {
                        int cantidad = ScannerUtils.capturarNumero("Cantidad de películas populares a mostrar");
                        List<Pelicula> peliculasPopulares = plataforma.getPeliculasPopulares(cantidad);
                        peliculasPopulares.forEach(pelicula -> System.out.println(pelicula.obtenerFichaTecnica()));
                    } else {
                        int cantidad = ScannerUtils.capturarNumero("Cantidad de documentales populares a mostrar");
                        List<Documental> documentalesPopulares = plataforma.getDocumentalesPopulares(cantidad);
                        documentalesPopulares.forEach(documental -> System.out.println(documental.obtenerFichaTecnica()));
                    }
                }
                case VER_MAS_POPULARES -> {
                    System.out.println("Los contenidos más populares (>4.0) 🌟 son:");
                    List<Contenido> peliculasMuyPopulares = plataforma.getMuyPopulares();
                    peliculasMuyPopulares.forEach(contenido -> System.out.println(contenido.obtenerFichaTecnica()));
                }
                case VER_MAS_LARGA -> {
                    System.out.println("El contenido más largo es:");
                    Contenido contenidoMasLarga = plataforma.getMasLarga();
                    System.out.println(contenidoMasLarga.obtenerFichaTecnica() + "\n⌛ Duración: " + contenidoMasLarga.getDuracion());
                }
                case VER_MAS_CORTA -> {
                    System.out.println("El contenido más corto es:");
                    Contenido contenidoMasCorta = plataforma.getMasCorta();
                    System.out.println(contenidoMasCorta.obtenerFichaTecnica() + "\n⌛ Duración: " + contenidoMasCorta.getDuracion());
                }
                case REPRODUCIR -> {
                    String nombre = ScannerUtils.capturarTexto("Nombre del contenido a reproducir");
                    Contenido contenido = plataforma.buscarPorTitulo(nombre);

                    if(contenido != null){
                        plataforma.reproducir(contenido);
                    } else {
                        System.out.println(nombre + " no existe.");
                    }
                }
                case ELIMINAR -> {
                    String nombreAEliminar = ScannerUtils.capturarTexto("Nombre del contenido a eliminar");
                    Contenido contenido = plataforma.buscarPorTitulo(nombreAEliminar);

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