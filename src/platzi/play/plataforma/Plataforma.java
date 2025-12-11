package platzi.play.plataforma;

import platzi.play.contenido.Contenido;
import platzi.play.contenido.Documental;
import platzi.play.contenido.Pelicula;
import platzi.play.contenido.ResumenContenido;
import platzi.play.excepcion.PeliculaExistenteException;
import platzi.play.util.FileUtils;

import java.util.*;

public class Plataforma {
    private String nombre;
    private List<Contenido> contenido; //Agregacion
    private Map<Contenido, Integer> visualizaciones;

    public Plataforma(String nombre) {
        this.nombre = nombre;
        this.contenido = new ArrayList<>();
        this.visualizaciones = new HashMap<>();
    }

    public void agregar(Contenido elemento) {
        Contenido contenido = this.buscarPorTitulo(elemento.getTitulo());
        if(contenido != null){
            throw new PeliculaExistenteException(elemento.getTitulo());
        }

        FileUtils.escribirContenido(elemento);
        this.contenido.add(elemento);
    }

    public List<Contenido> getContenido() {
        return contenido;
    }

    public void reproducir(Contenido contenido) {
        int conteoActual = visualizaciones.getOrDefault(contenido, 0);
        System.out.println(contenido.getTitulo() + " ha sido reproducido " +  conteoActual + " veces.");

       this.contarVisualizaciones(contenido);
        contenido.reproducir();
    }

    private void contarVisualizaciones(Contenido contenido) {
        int conteoActual = visualizaciones.getOrDefault(contenido, 0);
        visualizaciones.put(contenido, conteoActual + 1);
    }

    public List<String> getTitulos(){
        return contenido.stream()
                .map(Contenido::getTitulo)
                .toList();
    }

    public List<ResumenContenido> getResumenes(){
        return contenido.stream()
                .map(c -> new ResumenContenido(c.getTitulo(), c.getDuracion(), c.getGenero()))
                .toList();
    }

    public void eliminar(Contenido elemento){
        this.contenido.remove(elemento);
    }

    public Contenido buscarPorTitulo(String titulo){
         return contenido.stream()
                .filter(contenido -> contenido.getTitulo().equalsIgnoreCase(titulo))
                .findFirst()
                .orElse(null);
    }

    public List<Contenido> buscarPorGenero(Genero genero){
        return contenido.stream()
                .filter(contenido -> contenido.getGenero().equals(genero))
                .toList();
    }

    public List<Contenido> getPopulares(int cantidad) {
        return contenido.stream()
                .sorted(Comparator.comparingDouble(Contenido::getCalificacion).reversed())
                .limit(cantidad)
                .toList();
    }

    public List<Pelicula> getPeliculas(){
        return contenido.stream()
                .filter(contenido -> contenido instanceof Pelicula)
                .map(contenidoFiltrado -> (Pelicula) contenidoFiltrado)
                .toList();
    }

    public List<Pelicula> getPeliculasPopulares(int cantidad){
        return contenido.stream()
                .filter(contenido -> contenido instanceof Pelicula)
                .map(contenidoFiltrado -> (Pelicula) contenidoFiltrado)
                .sorted(Comparator.comparingDouble(Pelicula::getCalificacion).reversed())
                .limit(cantidad)
                .toList();
    }

    public List<Documental> getDocumentales(){
        return contenido.stream()
                .filter(contenido -> contenido instanceof Documental)
                .map(contenidoFiltrado -> (Documental) contenidoFiltrado)
                .toList();
    }

    public List<Documental> getDocumentalesPopulares(int cantidad){
        return contenido.stream()
                .filter(contenido -> contenido instanceof Documental)
                .map(contenidoFiltrado -> (Documental) contenidoFiltrado)
                .sorted(Comparator.comparingDouble(Documental::getCalificacion).reversed())
                .limit(cantidad)
                .toList();
    }

    public List<Contenido> getMuyPopulares(){
        return contenido.stream()
                .filter(pelicula -> pelicula.getCalificacion() > 4)
                .sorted(Comparator.comparingDouble(Contenido::getCalificacion).reversed())
                .toList();
    }

    public Contenido getMasLarga(){
        return contenido.stream()
                .max(Comparator.comparingInt(Contenido::getDuracion))
                .orElse(null);
    }

    public Contenido getMasCorta(){
        return contenido.stream()
                .min(Comparator.comparingInt(Contenido::getDuracion))
                .orElse(null);
    }

    public int getDuracionTotal() {
        return contenido.stream()
                .mapToInt(Contenido::getDuracion)
                .sum();
    }

    public String getNombre() {
        return nombre;
    }

    public List<Contenido> buscarPorIdioma(Idioma idioma) {
        return contenido.stream()
                .filter(contenido -> contenido.getIdioma().equals(idioma))
                .toList();
    }

    public List<Contenido> buscarPorCalidad(Calidad calidad) {
        return contenido.stream()
                .filter(contenido -> contenido.getCalidad().equals(calidad))
                .toList();
    }

}
