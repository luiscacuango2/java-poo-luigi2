package platzi.play.contenido;

import platzi.play.plataforma.Genero;

public record ResumenContenido(
        String titulo,
        int duracion,
        Genero genero) {
}
