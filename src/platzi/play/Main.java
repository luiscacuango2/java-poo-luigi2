package platzi.play;

import platzi.play.contenido.Pelicula;
import platzi.play.plataforma.Usuario;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("SISTEMA DE GESTIÓN DE PELÍCULAS ");

        Pelicula pelicula = new Pelicula();
        pelicula.titulo = "El señor de los anillos";
        pelicula.fechaEstreno = LocalDate.of(2018, 10, 15);
        pelicula.genero = "Fantasía";
        pelicula.calificar(4.7);
        pelicula.duracion = 120;

//        System.out.println(pelicula.obtenerFichaTecnica());

        long duracionLong = pelicula.duracion;

        System.out.println("La duración Long es: " + duracionLong);

        Usuario usuario = new Usuario();
        usuario.nombre = "Juan";
        usuario.fechaRegistro = LocalDateTime.of(2025, 12, 11, 17,58, 45);

        System.out.println(usuario.fechaRegistro);

        usuario.ver(pelicula);

//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Cual es tu nombre?");
//        String nombre = scanner.nextLine();
//
//        System.out.println("Hola " + nombre + ", esto es Platzi Play!");
//
//        System.out.println(nombre + " cuantos años tienes?");
//        int edad = scanner.nextInt();
//
//        System.out.println(nombre + " puedes ver contenido +" + edad);
    }
}
