package pruebas.con_docker.proyecto1.persona;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PersonaService {

    private final PersonaRepository personaRepository;

    public PersonaService(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    public Persona crear(Persona persona) {
        return personaRepository.save(persona);
    }

    @Transactional(readOnly = true)
    public List<Persona> listar() {
        return personaRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Persona buscarPorId(Long id) {
        return personaRepository.findById(id)
                .orElseThrow(() -> new PersonaNotFoundException(id));
    }

    public Persona actualizar(Long id, Persona datos) {
        Persona persona = buscarPorId(id);
        persona.setNombre(datos.getNombre());
        persona.setApellido(datos.getApellido());
        persona.setEmail(datos.getEmail());
        persona.setEdad(datos.getEdad());
        return personaRepository.save(persona);
    }

    public void eliminar(Long id) {
        Persona persona = buscarPorId(id);
        personaRepository.delete(persona);
    }
}