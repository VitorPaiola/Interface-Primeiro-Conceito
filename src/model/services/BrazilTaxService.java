package model.services;

public class BrazilTaxService implements TaxService { // serviço fiscal Brasil

	public double tax(double amount) { // amount - quantia
		if (amount <= 100.0) {
			return amount * 0.2;
		}
		else {
			return amount * 0.15;
		}
	}
}
