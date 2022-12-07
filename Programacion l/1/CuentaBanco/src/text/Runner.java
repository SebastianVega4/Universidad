package text;

import java.time.LocalDate;
import java.time.Month;

import logic.Account;

public class Runner {

	public static void main(String[] args) {

		Account accOne = new Account("597-45636", "Alejandra Casas", LocalDate.of(2016, Month.AUGUST, 24), null);
		Account accTwo = new Account("300-84743", "Mario Rico", LocalDate.of(2020, Month.JUNE, 12), null);

		// Debe visualizar false porque no se puede retirar, no hay saldo
		System.out.println(accOne.withdraw(100_000.0));

		// Consignar - se espera un nuevo saldo de $100.000
		System.out.println(accOne.consign(100_000));

		// Consignar - se espera un nuevo saldo de $150.000
		System.out.println(accOne.consign(50_000));

		// Se espera false, no se puede retirar $101.000
		System.out.println(accOne.withdraw(101_000.0));

		// Se espera verdadero, se puede retirar $80.000 y el nuevo saldo es $70.000
		System.out.println(accOne.withdraw(80_000.0));
		System.out.println(accOne.getResidue());

		// Se espera verdadero, se puede transferir $50_000 a otra cuenta
		System.out.println(accOne.transfer(20_000, false, accTwo));

		// Los saldos son: cuenta uno ($50.000) y cuenta dos ($20.000)
		System.out.println(accOne.getResidue());
		System.out.println(accTwo.getResidue());

	}
}