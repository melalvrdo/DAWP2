package libcode.webapp.resources;

import jakarta.ejb.EJB;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;
import libcode.webapp.entidades.Alumno;
import libcode.webapp.entidades.Materia;
import libcode.webapp.entidades.Inscripcion;
import libcode.webapp.negocio.DataService;

/**
 * Clase Recurso que expone servicios REST para Alumnos, Materias e Inscripciones.
 * 
 */
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/")
public class Recurso {

    @EJB
    DataService servicio;

    // Alumnos Endpoints
    
    // Obtener todos los alumnos
    @GET
    @Path("/alumno")
    public Response getAlumnos() {
        List<Alumno> alumnos = servicio.getAlumnos();
        return Response.ok(alumnos).build();
    }

    // Guardar alumno
    @POST
    @Path("/alumno")
    public Response saveAlumno(Alumno alumno) {
        servicio.saveAlumno(alumno);
        return Response.ok("Alumno creado exitosamente").build();
    }

    // Editar alumno
    @PUT
    @Path("/alumno")
    public Response editAlumno(Alumno alumno) {
        servicio.editAlumno(alumno);
        return Response.ok("Alumno actualizado exitosamente").build();
    }

    // Eliminar alumno
    @DELETE
    @Path("/alumno/{id}")
    public Response deleteAlumno(@PathParam("id") Integer id) {
        servicio.deleteAlumno(new Alumno(id));
        return Response.ok("Alumno eliminado exitosamente").build();
    }

    // Materias Endpoints

    // Obtener todas las materias
    @GET
    @Path("/materia")
    public Response getMaterias() {
        List<Materia> materias = servicio.getMaterias();
        return Response.ok(materias).build();
    }

    // Guardar materia
    @POST
    @Path("/materia")
    public Response saveMateria(Materia materia) {
        servicio.saveMateria(materia);
        return Response.ok("Materia creada exitosamente").build();
    }

    // Editar materia
    @PUT
    @Path("/materia")
    public Response editMateria(Materia materia) {
        servicio.editMateria(materia);
        return Response.ok("Materia editada exitosamente").build();
    }

    // Eliminar materia
    @DELETE
    @Path("/materia/{id}")
    public Response deleteMateria(@PathParam("id") Integer id) {
        servicio.deleteMateria(new Materia(id));
        return Response.ok("Materia eliminada exitosamente").build();
    }

    // Inscripciones Endpoints

    // Obtener todas las inscripciones
    @GET
    @Path("/inscripcion")
    public Response getInscripciones() {
        List<Inscripcion> inscripciones = servicio.getInscripciones();
        return Response.ok(inscripciones).build();
    }

    // Guardar inscripcion
    @POST
    @Path("/inscripcion")
    public Response saveInscripcion(Inscripcion inscripcion) {
        servicio.saveInscripcion(inscripcion);
        return Response.ok("Inscripción creada exitosamente").build();
    }

    // Eliminar inscripcion
    @DELETE
    @Path("/inscripcion/{id}")
    public Response deleteInscripcion(@PathParam("id") Integer id) {
        servicio.deleteInscripcion(new Inscripcion(id));
        return Response.ok("Inscripción eliminada exitosamente").build();
    }
}
