package platzi.play.util;

import platzi.play.contenido.Contenido;
import platzi.play.plataforma.Calidad;
import platzi.play.plataforma.Genero;
import platzi.play.plataforma.Idioma;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {

    public static final String NOMBRE_ARCHIVO = "contenido.txt";
    public static final String SEPARADOR = "|";

    public static void escribirContenido(Contenido contenido){
        String linea = String.join(SEPARADOR,
                contenido.getTitulo(),
                String.valueOf(contenido.getDuracion()),
                contenido.getGenero().name(),
                contenido.getIdioma().name(),
                contenido.getCalidad().name(),
                String.valueOf(contenido.getCalificacion()),
                contenido.getFechaEstreno().toString()
                );

        try {
            Files.writeString(Paths.get(NOMBRE_ARCHIVO),
                    linea + System.lineSeparator(),
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.out.println("Error escribiendo el archivo. " + e.getMessage());
        }
    }

    public static List<Contenido> leerContenido() {
        List<Contenido> contenidoDesdeArchivo = new ArrayList<>();

        try {
            List<String> lineas = Files.readAllLines(Paths.get(NOMBRE_ARCHIVO));

            lineas.forEach(linea -> {
                String[] datos = linea.split("\\" + SEPARADOR);

                if(datos.length == 7){
                    String titulo = datos[0];
                    int duracion = Integer.parseInt(datos[1]);
                    Genero genero = Genero.valueOf(datos[2]);
                    Idioma idioma = Idioma.valueOf(datos[3]);
                    Calidad calidad = Calidad.valueOf(datos[4]);
                    double calificacion = datos[5].isBlank() ? 0 : Double.parseDouble(datos[5]);
                    LocalDate fechaEstreno = LocalDate.parse(datos[6]);

                    Contenido contenido = new Contenido(titulo, duracion, genero, idioma, calidad, calificacion);
                    contenido.setFechaEstreno(fechaEstreno);

                    contenidoDesdeArchivo.add(contenido);

                }
            });
        } catch (IOException e) {
            System.out.println("Error al cargar contenido.txt" +  e.getMessage());
        }
        return contenidoDesdeArchivo;
    }
}
