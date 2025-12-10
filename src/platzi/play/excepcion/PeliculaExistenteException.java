package platzi.play.excepcion;

public class PeliculaExistenteException extends RuntimeException {
    public PeliculaExistenteException(String titulo){
        super("La película " + titulo + " ya existe.\n");
    }
}
