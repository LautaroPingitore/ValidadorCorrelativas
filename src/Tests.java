import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class Tests {
    Materia algoritmos = new Materia("Algoritmos");
    Materia logica = new Materia("Logica");
    Materia paradigmas = new Materia("Paradigmas", List.of(algoritmos, logica));

    Materia analisis = new Materia("Analisis");
    Materia fisicaI = new Materia("Fisica I");
    Materia fisicaII = new Materia("Fisica II", List.of(analisis, fisicaI));

    Inscipcion basicas = new Inscipcion(List.of(algoritmos, logica, analisis, fisicaI));
    Inscipcion inscPdp = new Inscipcion(List.of(paradigmas));
    Inscipcion inscFis = new Inscipcion(List.of(fisicaII));
    Inscipcion nivel2 = new Inscipcion(List.of(paradigmas, fisicaII));

    Alumno pepe = new Alumno("pepe");
    Alumno juan = new Alumno("juan", List.of(algoritmos, logica));
    Alumno lu = new Alumno("lu", List.of(algoritmos, logica, analisis, fisicaI));

    @Test
    void inscripcionBasicas() {
        assertTrue(basicas.aprobada(pepe));
    }

    @Test
    void inscripcionParadigmas() {
        assertFalse(inscPdp.aprobada(pepe));
        assertTrue(inscPdp.aprobada(juan));
    }

    @Test
    void inscripcionFisicaII() {
        assertFalse(inscFis.aprobada(pepe));
        assertTrue(inscFis.aprobada(lu));
    }

    @Test
    void inscripcion2doNivel() {
        assertFalse(nivel2.aprobada(pepe));
        assertTrue(nivel2.aprobada(lu));
    }

}
