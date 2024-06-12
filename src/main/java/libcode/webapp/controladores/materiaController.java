package libcode.webapp.controladores;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import java.util.ArrayList;
import java.util.List;
import libcode.webapp.entidades.Materia;
import libcode.webapp.negocio.DataService;

@Named
@RequestScoped
public class materiaController {

    private List<Materia> materiasList = new ArrayList<>();
    private Materia materia = new Materia();

    @EJB
    private DataService servicio;

    @PostConstruct
    public void init() {
        cargarMaterias();
    }

    public void cargarMaterias() {
        materiasList = servicio.getMaterias();
    }

    public void guardarMateria() {
        if (materia.getId() != null) {
            servicio.editMateria(materia);
        } else {
            servicio.saveMateria(materia);
        }
        materia = new Materia();
        cargarMaterias();
    }

    public void llenarFormEditar(Materia materia) {
        this.materia = materia;
    }

    public void eliminarMateria(Materia materia) {
        servicio.deleteMateria(materia);
        cargarMaterias();
    }

    public List<Materia> getMateriasList() {
        return materiasList;
    }

    public void setMateriasList(List<Materia> materiasList) {
        this.materiasList = materiasList;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    // Método para completar Materias en el autoComplete
    public List<Materia> completeMaterias(String query) {
        List<Materia> filteredMaterias = new ArrayList<>();

        for (Materia materia : materiasList) {
            if (materia.getNombre().toLowerCase().contains(query.toLowerCase())) {
                filteredMaterias.add(materia);
            }
        }

        return filteredMaterias;
    }
}
