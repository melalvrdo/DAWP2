package libcode.webapp.controladores;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import java.util.ArrayList;
import java.util.List;
import libcode.webapp.entidades.Alumno;
import libcode.webapp.negocio.DataService;

@Named
@RequestScoped
public class alumnoController {

    // Arreglo para la lista de alumnos
    private List<Alumno> alumnosList = new ArrayList<>();
    private Alumno alumno = new Alumno();

    @EJB
    private DataService servicio;

    @PostConstruct
    public void init() {
        cargarAlumnos();
    }

    public void cargarAlumnos() {
        alumnosList = servicio.getAlumnos();
    }

    // Función guardar alumno
    public void guardarAlumno() {
        if (alumno.getId() != null) {
            servicio.editAlumno(alumno);
        } else {
            servicio.saveAlumno(alumno);
        }

        alumno = new Alumno(); // Limpia los campos
        cargarAlumnos();
    }

    // Función editar
    public void llenarFormEditar(Alumno alumno) {
        this.alumno = alumno;
    }

    // Función eliminar alumno
    public void eliminarAlumno(Alumno alumno) {
        servicio.deleteAlumno(alumno);
        cargarAlumnos();
    }

    // Getters and Setters
    public List<Alumno> getAlumnosList() {
        return alumnosList;
    }

    public void setAlumnosList(List<Alumno> alumnosList) {
        this.alumnosList = alumnosList;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }
    
    // Método para completar Alumnos en el autoComplete
    public List<Alumno> completeAlumnos(String query) {
        List<Alumno> filteredAlumnos = new ArrayList<>();

        for (Alumno alumno : alumnosList) {
            if (alumno.getNombre().toLowerCase().contains(query.toLowerCase())) {
                filteredAlumnos.add(alumno);
            }
        }

        return filteredAlumnos;
    }
}
