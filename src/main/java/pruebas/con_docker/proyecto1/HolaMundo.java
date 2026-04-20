package pruebas.con_docker.proyecto1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class HolaMundo {

    @GetMapping("/hola")
    public String hola() {
        return "Hola mundo";
    }
}
