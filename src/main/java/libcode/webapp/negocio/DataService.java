
package libcode.webapp.negocio;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import java.util.List;
import libcode.webapp.entidades.Alumno;
import libcode.webapp.entidades.Inscripcion;
import libcode.webapp.entidades.Materia;

/**
 *
 * @author melalvrdo
 */

@Stateless
public class DataService {
    
    @PersistenceContext(unitName = "pu")
    EntityManager entityManager;
    
    //Metodo o funcion para listar Alumnos
    public List<Alumno> getAlumnos(){
        
        Query query = entityManager.createQuery("SELECT e FROM Alumno e ORDER BY e.id DESC");
       
        List<Alumno> alumnos = query.getResultList();
        
        return alumnos;
    }
    
    //Funcion o metodo para guardar alumnos
    @Transactional
    public void saveAlumno(Alumno alumno){
        entityManager.persist(alumno);
    }
    
    public Alumno getAlumnobyId(Integer Id ){
        Alumno alumno = entityManager.find(Alumno.class,Id);
        return alumno;
    }
            
    //Funcion o metodo para editar alumnos
    @Transactional
    public void editAlumno(Alumno alumno){
        entityManager.merge(alumno);
    }
    
    //Funcion o metodo para eliminar alumnos
    @Transactional
    public void deleteAlumno(Alumno alumno){
        Alumno alumnoEliminar = entityManager.find(Alumno.class, alumno.getId());
        entityManager.remove(alumnoEliminar);
    }
    
    // Métodos para Materia
    public List<Materia> getMaterias() {
        Query query = entityManager.createQuery("SELECT m FROM Materia m ORDER BY m.id DESC");
        List<Materia> materias = query.getResultList();
        return materias;
    }
    
    public Materia getMateriabyId(Integer Id ){
        Materia materia = entityManager.find(Materia.class,Id);
        return materia;
    }

    @Transactional
    public void saveMateria(Materia materia) {
        entityManager.persist(materia);
    }

    @Transactional
    public void editMateria(Materia materia) {
        entityManager.merge(materia);
    }

    @Transactional
    public void deleteMateria(Materia materia) {
        Materia materiaEliminar = entityManager.find(Materia.class, materia.getId());
        entityManager.remove(materiaEliminar);
    }
    
    public List<Inscripcion> getInscripciones(){
        Query query = entityManager.createQuery("SELECT i FROM Inscripcion i ORDER BY i.id DESC");
        List<Inscripcion> inscripciones = query.getResultList();
        return inscripciones;
    }

    @Transactional
    public void saveInscripcion(Inscripcion inscripcion){
        entityManager.persist(inscripcion);
    }

    @Transactional
    public void deleteInscripcion(Inscripcion inscripcion){
        Inscripcion inscripcionEliminar = entityManager.find(Inscripcion.class, inscripcion.getId());
        entityManager.remove(inscripcionEliminar);
    }
    
}
