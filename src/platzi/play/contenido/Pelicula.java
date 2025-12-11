package platzi.play.contenido;

import platzi.play.plataforma.Calidad;
import platzi.play.plataforma.Genero;
import platzi.play.plataforma.Idioma;

public class Pelicula extends Contenido {
    public Pelicula(String titulo, int duracion, Genero genero, Idioma idioma, Calidad calidad, double calificacion) {
        super(titulo, duracion, genero, idioma, calidad, calificacion);
    }

    @Override
    public void reproducir() {
        System.out.println("Reproduciendo pelicula " + getTitulo());
    }

    @Override
    public String obtenerFichaTecnica() {
        return "\n🎬 " + getTitulo() + " (" + getFechaEstreno().getYear() + ")\n" +
                "🎞 Género: " + getGenero() + "\n" +
                "🌎 Idioma: " + getIdioma() + "\n" +
                "✔ Calidad: " + getCalidad() + "\n" +
                "⭐ Calificación: " + getCalificacion() + "/5";
    }
}
