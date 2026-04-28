import entities.TipoAbono;
import entities.Viaje;
import entities.Viajero;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import repositories.ViajeRepository;
import repositories.ViajeroRepository;
import utils.JpaUtil;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Main {

    static void main() {

        IO.println("Arrancando app Servicio Municipal de Transporte");

        ViajeroRepository viajeroRepo = new ViajeroRepository();
        ViajeRepository viajeRepo = new ViajeRepository();
//        viajeroRepo.save(new Viajero(null, "12345678S", "Oscar Romera", 26, "Garrucha", TipoAbono.ANUAL, 150, null));
//        viajeroRepo.save(new Viajero(null, "12345578F", "Esther Rodriguez", 22, "Valencia", TipoAbono.MENSUAL, 250, null));

//        Viajero v1 = viajeroRepo.findById(1L).orElse(null);
//        v1.setSaldoPuntos(300);
//        viajeroRepo.update(v1);

//        Viajero v1 = viajeroRepo.findById(1L).orElse(null);
//        Viajero v2 = viajeroRepo.findById(2L).orElse(null);
//
//
//        viajeRepo.save(new Viaje(null, "Linea 1", "Antas", "Vera", LocalDate.now(), LocalTime.now(), 45, 2.5, false, v1));
//        viajeRepo.save(new Viaje(null, "Linea 1", "Vera", "Antas", LocalDate.now(), LocalTime.now(), 47, 2.5, false, v1));
//
//        viajeRepo.save(new Viaje(null, "Linea 2", "Mojacar", "Vera", LocalDate.now(), LocalTime.now(), 10, 1.5, false, v2));
//        viajeRepo.save(new Viaje(null, "Linea 2", "Garrucha", "Antas", LocalDate.now(), LocalTime.now(), 13, 1.5, false, v2));

        viajeRepo.findAll().stream()
                .collect(Collectors.groupingBy(Viaje::getLineaTransporte, Collectors.counting()))
                .forEach((k, v) -> IO.println(k + " " + v));

        viajeRepo.findWithIncidencia().forEach(System.out::println);

        viajeroRepo.findViajesByViajeroIdAndPrecioGreaterThan(1L, 1.5).forEach(System.out::println);

        viajeroRepo.findTotalViajero().forEach(System.out::println);
    }
}
