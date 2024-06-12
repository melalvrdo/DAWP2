package libcode.webapp.controladores;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import libcode.webapp.entidades.Inscripcion;
import libcode.webapp.negocio.DataService;

@Named
@RequestScoped
public class inscripcionController {

    // Arreglo para la lista de alumnos
    private List<Inscripcion> inscripcionesList = new ArrayList<>();
    private Inscripcion inscripcion = new Inscripcion();

    @EJB
    private DataService servicio;

    @PostConstruct
    public void init() {
        cargarInscripciones();
    }
    
    public void cargarInscripciones() {
        inscripcionesList = servicio.getInscripciones();
    }

    // Métodos para Inscripción
    public void guardarInscripcion() {
        if (inscripcion.getAlumno() != null && inscripcion.getMateria() != null) {
            System.out.println("Guardando Inscripción: " + inscripcion);
            inscripcion.setFechaInscripcion(new Date());
            servicio.saveInscripcion(inscripcion);
            inscripcion = new Inscripcion(); // Limpia los campos
            cargarInscripciones();
        } else {
            System.out.println("Alumno o Materia no pueden ser nulos");
        }
    }


    public void llenarFormEditar(Inscripcion inscripcion) {
        this.inscripcion = inscripcion;
    }

    public void eliminarInscripcion(Inscripcion inscripcion) {
        servicio.deleteInscripcion(inscripcion);
        cargarInscripciones();
    }

    public List<Inscripcion> getInscripcionesList() {
        return inscripcionesList;
    }

    public void setInscripcionesList(List<Inscripcion> inscripcionesList) {
        this.inscripcionesList = inscripcionesList;
    }

    public Inscripcion getInscripcion() {
        return inscripcion;
    }

    public void setInscripcion(Inscripcion inscripcion) {
        this.inscripcion = inscripcion;
    }
}
