package pruebas.con_docker.proyecto1.persona;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(PersonaController.class)
class PersonaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PersonaService personaService;

    @Test
    void crearPersonaConDatosValidos() throws Exception {
        given(personaService.crear(any(Persona.class)))
                .willAnswer(invocation -> {
                    Persona persona = invocation.getArgument(0);
                    persona.setId(1L);
                    return persona;
                });

        mockMvc.perform(post("/api/personas")
                .contentType(MediaType.APPLICATION_JSON)
                .content("""
                        {
                          "nombre": "Ana",
                          "apellido": "Perez",
                          "email": "ana@example.com",
                          "edad": 25
                        }
                        """))
                .andExpect(status().isCreated());
    }
}