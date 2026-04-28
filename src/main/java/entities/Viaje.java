package entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name="viajes")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Viaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "linea_transporte")
    private String lineaTransporte;

    private String origen;

    private String destino;

    @Column(name = "fecha_viaje", nullable = false)
    private LocalDate fechaViaje;

    @Column(name = "hora_viaje", nullable = false)
    private LocalTime horaViaje;

    @Column(name = "duracion_minutos", nullable = false)
    private int duracionMinutos;

    @Column(nullable = false)
    private double precio;

    @Column(nullable = false)
    private boolean incidencia;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "viajero_id", nullable = false)
    private Viajero viajero;


}
