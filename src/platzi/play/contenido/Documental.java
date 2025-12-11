package platzi.play.contenido;

import platzi.play.plataforma.Calidad;
import platzi.play.plataforma.Genero;
import platzi.play.plataforma.Idioma;

public class Documental extends Contenido {
    private String narrador;

    public Documental(String titulo, int duracion, Genero genero, Idioma idioma, Calidad calidad) {
        super(titulo, duracion, genero, idioma, calidad);
    }

    public Documental(String titulo, int duracion, Genero genero, Idioma idioma, Calidad calidad, double calificacion, String narrador) {
        super(titulo, duracion, genero, idioma, calidad, calificacion);
        this.narrador = narrador;
    }

    public String getNarrador() {
        return narrador;
    }
}
