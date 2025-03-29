import java.util.ArrayList;
import java.util.List;

class Materia {
    private String nombre;
    private List<Materia> correlativas;

    public Materia(String nombre) {
        this.nombre = nombre;
        this.correlativas = new ArrayList<>();
    }
    public Materia(String nombre, List<Materia> correlativas) {
        this.nombre = nombre;
        this.correlativas = correlativas;
    }

    public List<Materia> getCorrelativas() {
        return correlativas;
    }
}

class Alumno {
    private String nombre;
    private List<Materia> aprobadas;

    public Alumno(String nombre) {
        this.nombre = nombre;
        this.aprobadas = new ArrayList<>();
    }
    public Alumno(String nombre, List<Materia> aprobadas) {
        this.nombre = nombre;
        this.aprobadas = aprobadas;
    }

    public boolean puedeCursar(Materia materia) {
        return materia.getCorrelativas().isEmpty() ||
                aprobadas.containsAll(materia.getCorrelativas());
    }

    public boolean inscripcionAceptada(Inscipcion inscripcion) {
        return inscripcion.aprobada(this);
    }
}

class Inscipcion {
    private List<Materia> materias;

    public Inscipcion(List<Materia> materias) {
        this.materias = materias;
    }

    public boolean aprobada(Alumno alumno) {
        for (Materia materia: materias) {
            if(!alumno.puedeCursar(materia)) {
                return false;
            }
        }
        return true;
    }
}