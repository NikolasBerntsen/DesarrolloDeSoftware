package Infraestructura.Persistencia;

import Aplicacion.Controladores.ControladorUsuarios;
import Aplicacion.Interfaz.Persistencia;
import Dominio.Universidad.Carrera;
import Dominio.Universidad.Catedra;
import Dominio.Universidad.Facultad;
import Dominio.Universidad.Materia;
import Dominio.Usuarios.Docente;
import Dominio.Usuarios.Estudiante;
import Dominio.utils.Fecha;
import Aplicacion.Controladores.ControladorUniversidad;

import java.util.List;

public class CargadorDatosPrueba implements Persistencia {

    private static void cargarUniversidad() {

        ControladorUniversidad Uni = ControladorUniversidad.getInstancia();

        // Crear Facultad de Ciencias Sociales
        Uni.crearFacultad("Facultad de Ciencias Sociales", new Fecha(21, 3, 2025));

        // Carrera 1: Sociología
        Uni.crearCarrera("Facultad de Ciencias Sociales", "Sociología", 300);
        Uni.crearMateria("Sociología", "Introducción a la Sociología", 64, 101);
        Uni.crearCatedra(101, 201, 101, 50, "mañana", 800, 1000, "lunes");
        Uni.crearCatedra(101, 202, 102, 50, "tarde", 1400, 1600, "miercoles");

        Uni.crearMateria("Sociología", "Métodos de Investigación", 64, 102);
        Uni.crearCatedra(102, 203, 103, 30, "mañana", 900, 1100, "martes");

        Uni.crearMateria("Sociología", "Teorías Sociológicas", 64, 103);
        Uni.crearCatedra(103, 204, 104, 40, "tarde", 1300, 1500, "jueves");

        // Carrera 2: Psicología
        Uni.crearCarrera("Facultad de Ciencias Sociales", "Psicología", 320);
        Uni.crearMateria("Psicología", "Psicología General", 64, 104);
        Uni.crearCatedra(104, 205, 105, 60, "mañana", 800, 1000, "lunes");
        Uni.crearCatedra(104, 206, 106, 60, "tarde", 1400, 1600, "miercoles");

        Uni.crearMateria("Psicología", "Psicología del Desarrollo", 64, 105);
        Uni.crearCatedra(105, 207, 107, 40, "mañana", 900, 1100, "martes");

        // Carrera 3: Antropología
        Uni.crearCarrera("Facultad de Ciencias Sociales", "Antropología", 310);
        Uni.crearMateria("Antropología", "Antropología Cultural", 64, 106);
        Uni.crearCatedra(106, 208, 108, 50, "mañana", 800, 1000, "viernes");

        Uni.crearMateria("Antropología", "Arqueología", 64, 107);
        Uni.crearCatedra(107, 209, 109, 30, "tarde", 1400, 1600, "miercoles");

        // Crear Facultad de Ciencias Naturales
        Uni.crearFacultad("Facultad de Ciencias Naturales", new Fecha(22, 3, 2025));

        // Carrera 1: Biología
        Uni.crearCarrera("Facultad de Ciencias Naturales", "Biología", 340);
        Uni.crearMateria("Biología", "Biología General", 64, 108);
        Uni.crearCatedra(108, 210, 110, 50, "mañana", 800, 1000, "lunes");
        Uni.crearCatedra(108, 211, 111, 50, "tarde", 1400, 1600, "miercoles");

        Uni.crearMateria("Biología", "Genética", 64, 109);
        Uni.crearCatedra(109, 212, 112, 30, "mañana", 900, 1100, "martes");

        // Carrera 2: Física
        Uni.crearCarrera("Facultad de Ciencias Naturales", "Física", 350);
        Uni.crearMateria("Física", "Mecánica Clásica", 64, 110);
        Uni.crearCatedra(110, 213, 113, 60, "mañana", 800, 1000, "lunes");
        Uni.crearCatedra(110, 214, 114, 60, "tarde", 1400, 1600, "miércoles");

        Uni.crearMateria("Física", "Electromagnetismo", 64, 111);
        Uni.crearCatedra(111, 215, 115, 40, "mañana", 900, 1100, "martes");

        Uni.crearMateria("Física", "Termodinámica", 64, 112);
        Uni.crearCatedra(112, 216, 116, 50, "tarde", 1300, 1500, "jueves");

        // Carrera 3: Química
        Uni.crearCarrera("Facultad de Ciencias Naturales", "Química", 360);
        Uni.crearMateria("Química", "Química General", 64, 113);
        Uni.crearCatedra(113, 217, 117, 50, "mañana", 800, 1000, "viernes");

        Uni.crearMateria("Química", "Química Orgánica", 64, 114);
        Uni.crearCatedra(114, 218, 118, 30, "tarde", 1400, 1600, "miercoles");

        // Crear Facultad de Ciencias Humanas
        Uni.crearFacultad("Facultad de Ciencias Humanas", new Fecha(23, 3, 2025));

        // Carrera 1: Historia
        Uni.crearCarrera("Facultad de Ciencias Humanas", "Historia", 330);
        Uni.crearMateria("Historia", "Historia Antigua", 64, 115);
        Uni.crearCatedra(115, 219, 119, 50, "mañana", 800, 1000, "lunes");
        Uni.crearCatedra(115, 220, 120, 50, "tarde", 1400, 1600, "miercoles");

        Uni.crearMateria("Historia", "Historia Medieval", 64, 116);
        Uni.crearCatedra(116, 221, 121, 30, "mañana", 900, 1100, "martes");

        Uni.crearMateria("Historia", "Historia Moderna", 64, 117);
        Uni.crearCatedra(117, 222, 122, 40, "tarde", 1300, 1500, "jueves");

        // Carrera 2: Filosofía
        Uni.crearCarrera("Facultad de Ciencias Humanas", "Filosofía", 320);
        Uni.crearMateria("Filosofía", "Filosofía Antigua", 64, 118);
        Uni.crearCatedra(118, 223, 123, 60, "mañana", 800, 1000, "lunes");
        Uni.crearCatedra(118, 224, 124, 60, "tarde", 1400, 1600, "miercoles");

        Uni.crearMateria("Filosofía", "Filosofía Moderna", 64, 119);
        Uni.crearCatedra(119, 225, 125, 40, "mañana", 900, 1100, "martes");

        // Carrera 3: Letras
        Uni.crearCarrera("Facultad de Ciencias Humanas", "Letras", 310);
        Uni.crearMateria("Letras", "Literatura Antigua", 64, 120);
        Uni.crearCatedra(120, 226, 126, 50, "mañana", 800, 1000, "viernes");

        Uni.crearMateria("Letras", "Literatura Contemporánea", 64, 121);
        Uni.crearCatedra(121, 227, 127, 30, "tarde", 1400, 1600, "miercoles");
    }

    private static void cargarUsuarios() {
        ControladorUsuarios users = ControladorUsuarios.getInstancia();
        users.cargarEstudiante("Jose Perez", 1150439, 47203547, "Letras");
        users.cargarEstudiante("Ana Lopez", 1150440, 47203548, "Sociología");
        users.cargarEstudiante("Carlos Gomez", 1150441, 47203549, "Psicología");
        users.cargarEstudiante("Laura Martinez", 1150442, 47203550, "Antropología");
        users.cargarEstudiante("Miguel Diaz", 1150443, 47203551, "Biología");
        users.cargarEstudiante("Sofia Fernandez", 1150444, 47203552, "Física");
        users.cargarEstudiante("Jorge Sanchez", 1150445, 47203553, "Química");
        users.cargarEstudiante("Mariana Torres", 1150446, 47203554, "Historia");
        users.cargarEstudiante("Lucas Ramirez", 1150447, 47203555, "Filosofía");
        users.cargarEstudiante("Valentina Ruiz", 1150448, 47203556, "Letras");
        users.cargarEstudiante("David Herrera", 1150449, 47203557, "Sociología");
        users.cargarEstudiante("Camila Morales", 1150450, 47203558, "Psicología");
        users.cargarEstudiante("Martin Ortiz", 1150451, 47203559, "Antropología");
        users.cargarEstudiante("Lucia Mendoza", 1150452, 47203560, "Biología");
        users.cargarEstudiante("Juan Gonzalez", 1150453, 47203561, "Física");
        users.cargarEstudiante("Carla Rojas", 1150454, 47203562, "Química");
        users.cargarEstudiante("Andres Castro", 1150455, 47203563, "Historia");
        users.cargarEstudiante("Natalia Soto", 1150456, 47203564, "Filosofía");
        users.cargarEstudiante("Pablo Vargas", 1150457, 47203565, "Letras");
        users.cargarEstudiante("Gabriela Guzman", 1150458, 47203566, "Sociología");


        users.cargarDocente("Manuel Silva", 845339, 31457998);
        users.cargarDocente("Rosa Morales", 845340, 31457999);
        users.cargarDocente("Diego Fernandez", 845341, 31458000);
        users.cargarDocente("Elena Torres", 845342, 31458001);
        users.cargarDocente("Oscar Vargas", 845343, 31458002);
        users.cargarDocente("Laura Castro", 845344, 31458003);
        users.cargarDocente("Juan Rojas", 845345, 31458004);
        users.cargarDocente("Marta Ruiz", 845346, 31458005);
        users.cargarDocente("Luis Diaz", 845347, 31458006);
        users.cargarDocente("Patricia Herrera", 845348, 31458007);
        users.cargarDocente("Carlos Gutierrez", 845349, 31458008);
        users.cargarDocente("Sofia Garcia", 845350, 31458009);
        users.cargarDocente("Miguel Angel", 845351, 31458010);
        users.cargarDocente("Ana Martinez", 845352, 31458011);
        users.cargarDocente("Roberto Lopez", 845353, 31458012);
        users.cargarDocente("Laura Gonzalez", 845354, 31458013);
        users.cargarDocente("Francisco Perez", 845355, 31458014);
        users.cargarDocente("Valeria Sanchez", 845356, 31458015);
        users.cargarDocente("Hector Rivas", 845357, 31458016);
        users.cargarDocente("Beatriz Flores", 845358, 31458017);

        boolean[][] matriz1 = {
                {true, false, true},
                {false, true, false},
                {true, true, false},
                {true, false, true},
                {true, false, false}
        };
        boolean[][] matriz2 = {
                {false, true, false},
                {true, false, true},
                {false, true, true},
                {true, false, false},
                {false, false, true}
        };
        boolean[][] matriz3 = {
                {true, true, true},
                {true, false, false},
                {true, false, true},
                {false, true, false},
                {true, false, false}
        };
        boolean[][] matriz4 = {
                {false, true, false},
                {true, true, true},
                {false, true, false},
                {true, false, true},
                {false, true, true}
        };
        boolean[][] matriz5 = {
                {true, false, true},
                {false, true, true},
                {true, true, false},
                {false, false, true},
                {true, true, true}
        };

        users.getDocente(845339).setPreferencia(matriz1.clone());
        users.getDocente(845340).setPreferencia(matriz2.clone());
        users.getDocente(845341).setPreferencia(matriz3.clone());
        users.getDocente(845342).setPreferencia(matriz4.clone());
        users.getDocente(845343).setPreferencia(matriz5.clone());
        users.getDocente(845344).setPreferencia(matriz1.clone());
        users.getDocente(845345).setPreferencia(matriz2.clone());
        users.getDocente(845346).setPreferencia(matriz3.clone());
        users.getDocente(845347).setPreferencia(matriz4.clone());
        users.getDocente(845348).setPreferencia(matriz5.clone());
        users.getDocente(845349).setPreferencia(matriz1.clone());
        users.getDocente(845350).setPreferencia(matriz2.clone());
        users.getDocente(845351).setPreferencia(matriz3.clone());
        users.getDocente(845352).setPreferencia(matriz4.clone());
        users.getDocente(845353).setPreferencia(matriz5.clone());
        users.getDocente(845354).setPreferencia(matriz1.clone());
        users.getDocente(845355).setPreferencia(matriz2.clone());
        users.getDocente(845356).setPreferencia(matriz3.clone());
        users.getDocente(845357).setPreferencia(matriz4.clone());
        users.getDocente(845358).setPreferencia(matriz5.clone());

    }

    @Override
    public void descargarDatos() {
        cargarUniversidad();
        cargarUsuarios();
    }
}