package test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ManejoEstudiantesTest {
    @Test
    public void testModificarEstudiante() {
        ManejoEstudiantes manejoEstudiantes = new ManejoEstudiantes();
        Estudiante estudiante = new Estudiante("Sebastián", "Gómez");
        manejoEstudiantes.agregarEstudiante(estudiante);

        // Modificar el estudiante
        Estudiante estudianteModificado = new Estudiante("Sebastián", "Pérez");
        manejoEstudiantes.modificarEstudiante(estudiante.getId(), estudianteModificado);

        Estudiante estudianteObtenido = manejoEstudiantes.obtenerEstudiante(estudiante.getId());
        assertEquals(estudianteModificado, estudianteObtenido);
    }
}
