package pruebas.con_docker.proyecto1.persona;

public class PersonaNotFoundException extends RuntimeException {

    public PersonaNotFoundException(Long id) {
        super("No existe una persona con id " + id);
    }
}