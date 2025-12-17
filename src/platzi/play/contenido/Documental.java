package platzi.play.contenido;

import platzi.play.plataforma.Calidad;
import platzi.play.plataforma.Genero;
import platzi.play.plataforma.Idioma;

public class Documental extends Contenido implements Promocionable {
    private String narrador;

    public Documental(String titulo, int duracion, Genero genero, Idioma idioma, Calidad calidad) {
        super(titulo, duracion, genero, idioma, calidad);
    }

    @Override
    public void reproducir() {
        System.out.println("Reproduciendo documental " + getTitulo() + " narrado por " + getNarrador());
    }

    @Override
    public String obtenerFichaTecnica() {
        return "\n🎬 " + getTitulo() + " (" + getFechaEstreno().getYear() + ")\n" +
                "🎞 Género: " + getGenero() + "\n" +
                "🌎 Idioma: " + getIdioma() + "\n" +
                "✔ Calidad: " + getCalidad() + "\n" +
                "⭐ Calificación: " + getCalificacion() + "/5\n" +
                "🗣 Narrador por: " + getNarrador();
    }

    public Documental(String titulo, int duracion, Genero genero, Idioma idioma, Calidad calidad, double calificacion, String narrador) {
        super(titulo, duracion, genero, idioma, calidad, calificacion);
        this.narrador = narrador;
    }

    @Override
    public String promocionar() {
        return "✨ Descubre el documental " + this.getTitulo() + " narrado por " + this.getNarrador() + " ahora en LuigiPlay!";
    }

    public String getNarrador() {
        return narrador;
    }

}
