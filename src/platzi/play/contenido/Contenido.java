package platzi.play.contenido;

import platzi.play.plataforma.Calidad;
import platzi.play.plataforma.Genero;
import platzi.play.plataforma.Idioma;

import java.time.LocalDate;

public abstract class Contenido {
    private String tipo;
    private String titulo;
    private String descripcion;
    private int duracion;
    private Genero genero;
    private LocalDate fechaEstreno;
    private double calificacion;
    private boolean disponible;
    private Idioma idioma;
    private Calidad calidad;

    public Contenido(String titulo, int duracion, Genero genero, Idioma idioma, Calidad calidad) {
        this.titulo = titulo;
        this.duracion = duracion;
        this.genero = genero;
        this.idioma = idioma;
        this.calidad = calidad;
        this.fechaEstreno = LocalDate.now();
        this.disponible = true;
    }

    public Contenido(String titulo, int duracion, Genero genero, Idioma idioma, Calidad calidad, double calificacion) {
        this(titulo, duracion, genero, idioma, calidad);
        this.calificar(calificacion);
    }

    public abstract void reproducir();

    public abstract String obtenerFichaTecnica();

    public void calificar(double calificacion) {
        if (calificacion >= 0 && calificacion <= 5) {
            this.calificacion = calificacion;
        }
    }

    public boolean esPopular() {
        return calificacion >= 4;
    }

    public String getTipo() {
        return tipo;
    }

    public String getTitulo() {
        return titulo;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public LocalDate getFechaEstreno() {
        return fechaEstreno;
    }

    public Genero getGenero() {
        return genero;
    }

    public int getDuracion() {
        return duracion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Idioma getIdioma() {
        return idioma;
    }

    public Calidad getCalidad() {
        return calidad;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public void setFechaEstreno(LocalDate fechaEstreno) {
        this.fechaEstreno = fechaEstreno;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }

    public void setIdioma(Idioma idioma) {
        this.idioma = idioma;
    }

    public void setCalidad(Calidad calidad) {
        this.calidad = calidad;
    }
}
