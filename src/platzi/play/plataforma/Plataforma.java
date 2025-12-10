package platzi.play.plataforma;

import platzi.play.contenido.Pelicula;
import platzi.play.excepcion.PeliculaExistenteException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Plataforma {
    private String nombre;
    private List<Pelicula> contenido; //Agregacion
    private static final int MUY_POPULAR = 4;

    public Plataforma(String nombre) {
        this.nombre = nombre;
        this.contenido = new ArrayList<>();
    }

    public void agregar(Pelicula elemento) {
        Pelicula contenido = this.buscarPorTitulo(elemento.getTitulo());
        if(contenido != null){
            throw new PeliculaExistenteException(elemento.getTitulo());
        }

        this.contenido.add(elemento);
    }

    public List<Pelicula> getContenido() {
        return contenido;
    }

    public List<String> getTitulos(){
        return contenido.stream()
                .map(Pelicula::getTitulo)
                .toList();
    }

    public void eliminar(Pelicula elemento){
        this.contenido.remove(elemento);
    }

    public Pelicula buscarPorTitulo(String titulo){
         return contenido.stream()
                .filter(contenido -> contenido.getTitulo().equalsIgnoreCase(titulo))
                .findFirst()
                .orElse(null);
    }

    public List<Pelicula> buscarPorGenero(Genero genero){
        return contenido.stream()
                .filter(contenido -> contenido.getGenero().equals(genero))
                .toList();
    }

    public List<Pelicula> getPopulares(int cantidad){
        return contenido.stream()
                .sorted(Comparator.comparingDouble(Pelicula::getCalificacion).reversed())
                .limit(cantidad)
                .toList();
    }

    public List<Pelicula> getMuyPopulares(){
        return contenido.stream()
                .filter(pelicula -> pelicula.getCalificacion() > MUY_POPULAR)
                .sorted(Comparator.comparingDouble(Pelicula::getCalificacion).reversed())
                .toList();
    }

    public Pelicula getMasLarga(){
        return contenido.stream()
                .max(Comparator.comparingInt(Pelicula::getDuracion))
                .orElse(null);
    }

    public Pelicula getMasCorta(){
        return contenido.stream()
                .min(Comparator.comparingInt(Pelicula::getDuracion))
                .orElse(null);
    }

    public int getDuracionTotal() {
        return contenido.stream()
                .mapToInt(Pelicula::getDuracion)
                .sum();
    }

    public String getNombre() {
        return nombre;
    }

    public List<Pelicula> buscarPorIdioma(Idioma idioma) {
        return contenido.stream()
                .filter(contenido -> contenido.getIdioma().equals(idioma))
                .toList();
    }

    public List<Pelicula> buscarPorCalidad(Calidad calidad) {
        return contenido.stream()
                .filter(contenido -> contenido.getCalidad().equals(calidad))
                .toList();
    }

}
