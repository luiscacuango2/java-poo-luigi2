package platzi.play.plataforma;

import platzi.play.contenido.Pelicula;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Usuario {
    public String nombre;
    public String email;
    public LocalDateTime fechaRegistro;

    public void ver(Pelicula pelicula) {
        System.out.println(nombre + " está viendo...");
        pelicula.reproducir();
    }
}
