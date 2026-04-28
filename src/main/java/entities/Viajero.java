package entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="viajeros")
@NoArgsConstructor
@AllArgsConstructor
@Data

public class Viajero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String dni;
    private String nombre;
    private Integer edad;
    private String municipio;
    private TipoAbono tipoAbono;
    private Integer saldoPuntos;

}
