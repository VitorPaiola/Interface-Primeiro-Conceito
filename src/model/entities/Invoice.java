package model.entities;

public class Invoice { // fatura

	private Double basicPayment; // pagamento básico
	private Double tax; // imposto
	
	public Invoice() {
	}

	public Invoice(Double basicPayment, Double tax) {
		this.basicPayment = basicPayment;
		this.tax = tax;
	}

	public Double getBasicPayment() {
		return basicPayment;
	}

	public void setBasicPayment(Double basicPayment) {
		this.basicPayment = basicPayment;
	}

	public Double getTax() {
		return tax;
	}

	public void setTax(Double tax) {
		this.tax = tax;
	}
	
	public Double getTotalPayment() { // pagamento total
		return getBasicPayment() + getTax(); // motivo p/ usar get: caso mudar a lógica nos métodos.
	}
	
}
