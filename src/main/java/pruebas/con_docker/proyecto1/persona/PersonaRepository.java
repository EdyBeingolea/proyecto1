package pruebas.con_docker.proyecto1.persona;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona, Long> {
    boolean existsByEmail(String email);
}