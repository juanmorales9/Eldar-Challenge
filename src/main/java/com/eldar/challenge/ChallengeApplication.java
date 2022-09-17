package com.eldar.challenge;

import com.eldar.challenge.creditCard.Tarjeta.NARA;
import com.eldar.challenge.creditCard.TarjetaCredito;
import com.eldar.challenge.creditCard.OperacionesTarjetaCredito;
import com.eldar.challenge.creditCard.Operacion;
import com.eldar.challenge.creditCard.Tarjeta.AMEX;
import com.eldar.challenge.creditCard.Tarjeta.VISA;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Date;
import java.time.LocalDate;

@SpringBootApplication
public class ChallengeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChallengeApplication.class, args);

		try {
			final OperacionesTarjetaCredito utils = new OperacionesTarjetaCredito();
			TarjetaCredito naraCard = new TarjetaCredito(NARA.getInstance(),1122336655L,"Juan Ignacio Morales",Date.valueOf(LocalDate.now().minusMonths(15)));
			naraCard.getMarca().setNombre("Nara");

			TarjetaCredito amexCard = new TarjetaCredito(AMEX.getInstance(), 2228884440L, "Yoli Martinez", Date.valueOf(LocalDate.now().minusMonths(10)));
			amexCard.getMarca().setNombre("Amex");
			TarjetaCredito visaCard = new TarjetaCredito(VISA.getInstance(), 1234567890L, "Rodolfo Morales", Date.valueOf(LocalDate.now().plusYears(3)));
			visaCard.getMarca().setNombre("Visa");

			Operacion naraOperacion = new Operacion(4000D,naraCard);
			 Operacion amexOperacion = new Operacion(5000d, amexCard);
			 Operacion visaOperacion = new Operacion(1000d, visaCard);


			System.out.println("Primera tarjeta");
			System.out.println("Info Tarjeta: " + utils.getInfoTarjeta(visaCard));
			System.out.println("Es una operacion Valida? " + utils.OperacionValida(visaOperacion));
			System.out.println("La tarjeta es Valida?) " + utils.isCreditCardValid(visaCard));
			System.out.println("Son las mismas tarjetas? " + utils.mismaTarjeta(visaCard, amexCard));
			System.out.println("Tasa de operacion: " + utils.getTasaOperacion(visaOperacion));

			System.out.println('\n');

			System.out.println('\n');
			System.out.println('\n');

			System.out.println("Segunda Tarjeta ");
			System.out.println("Info Tarjeta: " + utils.getInfoTarjeta(amexCard));
			System.out.println("Es una operacion Valida? " + utils.OperacionValida(amexOperacion));
			System.out.println("La tarjeta es Valida? " + utils.isCreditCardValid(amexCard));
			System.out.println("Son las mismas tarjetas? " + utils.mismaTarjeta(visaCard, amexCard));
			System.out.println("Tasa de operacion: " + utils.getTasaOperacion(amexOperacion));
			System.out.println('\n');

		} catch (final Exception e) {
			System.out.println(e.getMessage());
		}
	}



}
