package libcode.webapp.entidades;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;


@Entity
@Table(name = "inscripcion")
public class Inscripcion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "inscripcion_id_seq")
    @SequenceGenerator(name = "inscripcion_id_seq", sequenceName = "inscripcion_id_seq", allocationSize = 1)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "alumno_id")
    private Alumno alumno;

    @ManyToOne
    @JoinColumn(name = "materia_id")
    private Materia materia;

    @Column(name = "ciclo")
    private String ciclo;

    @Column(name = "anio")
    private Integer anio;

    @Column(name = "fecha_inscripcion")
    @Temporal(TemporalType.DATE)
    private Date fechaInscripcion;

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public String getCiclo() {
        return ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public Date getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(Date fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    // equals, hashCode, toString
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Inscripcion that = (Inscripcion) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Inscripcion{"
                + "id=" + id
                + ", alumno=" + alumno
                + ", materia=" + materia
                + ", ciclo='" + ciclo
                + ", anio=" + anio
                + ", fechaInscripcion=" + fechaInscripcion
                + '}';
    }

    // Constructors
    public Inscripcion() {
    }

    public Inscripcion(Integer id) {
        this.id = id;
    }

    public Inscripcion(Integer id, Alumno alumno, Materia materia, String ciclo, Integer anio, Date fechaInscripcion) {
        this.id = id;
        this.alumno = alumno;
        this.materia = materia;
        this.ciclo = ciclo;
        this.anio = anio;
        this.fechaInscripcion = fechaInscripcion;
    }

    public Inscripcion(Alumno alumno, Materia materia, String ciclo, Integer anio, Date fechaInscripcion) {
        this.alumno = alumno;
        this.materia = materia;
        this.ciclo = ciclo;
        this.anio = anio;
        this.fechaInscripcion = fechaInscripcion;
    }

}
