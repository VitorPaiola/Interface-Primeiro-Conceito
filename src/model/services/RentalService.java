package model.services;

import java.time.Duration;

import model.entities.CarRental;
import model.entities.Invoice;

public class RentalService { // serviço de aluguel

	private Double pricePerHour; // preço por hora
	private Double pricePerDay; // preço por dia
	
	private TaxService taxService; // serviço de imposto

	/*Não usa o construtor vazio sem argumentos, porque eu quero obrigar a informar esses dados
	 * quando instanciar o RentalService.*/
	
	public RentalService(Double pricePerHour, Double pricePerDay,TaxService taxService) {
		this.pricePerHour = pricePerHour; // preço por dia
		this.pricePerDay = pricePerDay; // preço por hora
		this.taxService = taxService; // serviço de imposto
	}
	
	public void processInvoice(CarRental carRental) { // processInvoice - fatura do processo
		
		// Calcula a diferença em horas dos horários de início e fim no carRental convertidos para minutos.
		double minutes = Duration.between(carRental.getStart(), carRental.getFinish()).toMinutes();
		double hours = minutes / 60;
		
		double basicPayment; // pagamento básico
		if (hours <= 12.0) {
			basicPayment = pricePerHour * Math.ceil(hours); // ceil - arredonda para cima
		}
		else {
			basicPayment = pricePerDay * Math.ceil(hours / 24.0);
		}
		
		double tax = taxService.tax(basicPayment); // imposto = servicoImposto.imposto(pagamentoBasico);
		
		carRental.setInvoice(new Invoice(basicPayment, tax)); // aluguelCarros.setFatura(new fatura(bagamentoBasico, imposto))
		
	}
	
}
