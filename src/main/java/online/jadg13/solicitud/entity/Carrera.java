package online.jadg13.solicitud.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity @Table(name = "carreras")

public class Carrera {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false, length = 120)
    @NotBlank(message = "El nombre no puede estar vacío")
    private String nombre;

    @Column(name = "descripcion", nullable = false, length = 250)
    private String descripcion;

    public Carrera() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotBlank(message = "El nombre no puede estar vacío") String getNombre() {
        return nombre;
    }

    public void setNombre(@NotBlank(message = "El nombre no puede estar vacío") String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Carrera{");
        sb.append("id=").append(id);
        sb.append(", nombre='").append(nombre).append('\'');
        sb.append(", descripcion='").append(descripcion).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
