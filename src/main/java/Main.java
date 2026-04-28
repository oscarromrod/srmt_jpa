import entities.TipoAbono;
import entities.Viajero;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import repositories.ViajeroRepository;
import utils.JpaUtil;

import java.util.ArrayList;

public class Main {

    static void main() {

        IO.println("Arrancando app Servicio Municipal de Transporte");

        ViajeroRepository viajeroRepo = new ViajeroRepository();
        viajeroRepo.save(new Viajero(null, "12345678S", "Oscar Romera", 26, "Garrucha", TipoAbono.ANUAL, 150, null));
        viajeroRepo.save(new Viajero(null, "12345578F", "Esther Rodriguez", 22, "Valencia", TipoAbono.MENSUAL, 250, null));

    }
}
