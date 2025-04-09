package online.jadg13.solicitud.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table(name = "coordinadores")
 @ToString
public class Coordinador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false, length = 50)
    @NotBlank(message = "El nombre no puede estar vacío")
    private String nombre;

    @Column(name = "apellido", nullable = false, length = 50)
    @NotBlank(message = "El apellido no puede estar vacío")
    private String apellido;

    @Column(name = "cif", nullable = false, unique = true, length = 20)
    @NotBlank(message = "El CIF no puede estar vacío")
    private String cif;

    @Column(name = "email", nullable = false, unique = true)
    @Email(message = "El email debe ser válido")
    private String email;

    @Column(name = "telefono", nullable = true, length = 50)
    @Size(max = 50, message = "El teléfono no puede exceder 50 caracteres")
    private String telefono;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "carrera_id", unique = true)
    private Carrera carrera;

    public Coordinador() {
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

    public @NotBlank(message = "El apellido no puede estar vacío") String getApellido() {
        return apellido;
    }

    public void setApellido(@NotBlank(message = "El apellido no puede estar vacío") String apellido) {
        this.apellido = apellido;
    }

    public @NotBlank(message = "El CIF no puede estar vacío") String getCif() {
        return cif;
    }

    public void setCif(@NotBlank(message = "El CIF no puede estar vacío") String cif) {
        this.cif = cif;
    }

    public @Email(message = "El email debe ser válido") String getEmail() {
        return email;
    }

    public void setEmail(@Email(message = "El email debe ser válido") String email) {
        this.email = email;
    }

    public @Size(max = 50, message = "El teléfono no puede exceder 50 caracteres") String getTelefono() {
        return telefono;
    }

    public void setTelefono(@Size(max = 50, message = "El teléfono no puede exceder 50 caracteres") String telefono) {
        this.telefono = telefono;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }
}
