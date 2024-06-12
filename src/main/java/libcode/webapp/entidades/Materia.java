package libcode.webapp.entidades;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author luispolanco
 */
@Entity
@Table(name = "Materia")
public class Materia implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "materia_id_seq")
    @SequenceGenerator(name = "materia_id_seq", sequenceName = "materia_id_seq", allocationSize = 1)
    private Integer id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "codigo")
    private String codigo;

    // Getters and Setters, equals, hashCode, toString, constructors...
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    // equals, hashCode, toString
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null){
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Materia other = (Materia) obj;
        return Objects.equals(id, other.id);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public String toString() {
        return "Materia{"
                + "id=" + id
                + ", nombre='" + nombre
                + ", descripcion='" + descripcion
                + ", codigo='" + codigo
                + '}';
    }

    // Constructors
    public Materia() {
    }

    public Materia(Integer id) {
        this.id = id;
    }

    public Materia(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Materia(Integer id, String nombre, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Materia(Integer id, String nombre, String descripcion, String codigo) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.codigo = codigo;
    }

}
