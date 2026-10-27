
package Vistas;
import Modelo.Pase;
import Modelo.Socio;
import Persistencia.PaseData;
import java.math.BigDecimal;
import java.time.LocalDate;

public class PruebaPase {

    public static void main(String[] args) {
        Socio socio = new Socio();
        socio.setIdSocio(1); 

        LocalDate inicio = LocalDate.now();

        Pase pase = new Pase(
                socio,
                8,
                inicio,
                inicio.plusDays(30),
                new BigDecimal("15000.00"),
                true
        );

        PaseData paseData = new PaseData();
        paseData.guardarPase(pase);
    }
}