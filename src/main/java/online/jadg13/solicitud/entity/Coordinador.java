package online.jadg13.solicitud.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "coordinadores")
@Getter @Setter @ToString
public class Coordinador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

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
    private String telefono;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "carrera_id", unique = true)
    private Carrera carrera;
}
