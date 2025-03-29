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
        assertTrue(pepe.inscripcionAceptada(basicas));
    }

    @Test
    void inscripcionParadigmas() {
        assertFalse(pepe.inscripcionAceptada(inscPdp));
        assertTrue(juan.inscripcionAceptada(inscPdp));
    }

    @Test
    void inscripcionFisicaII() {
        assertFalse(pepe.inscripcionAceptada(inscFis));
        assertTrue(lu.inscripcionAceptada(inscFis));
    }

    @Test
    void inscripcion2doNivel() {
        assertFalse(pepe.inscripcionAceptada(nivel2));
        assertTrue(lu.inscripcionAceptada(nivel2));
    }

}
