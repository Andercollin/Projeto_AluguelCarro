package model.service;

import java.util.concurrent.TimeUnit;

import model.entities.CarRental;
import model.entities.Invoice;

public class RentalService {
	
	private Double pricePerHour;
	private Double pricePerDay;
	
	private TaxService taxService;

	public RentalService(Double pricePerHour, Double pricePerDay, TaxService taxService) {
		this.pricePerHour = pricePerHour;
		this.pricePerDay = pricePerDay;
		this.taxService = taxService;
	}

	public Double getPricePerHour() {
		return pricePerHour;
	}

	public void setPricePerHour(Double pricePerHour) {
		this.pricePerHour = pricePerHour;
	}

	public Double getPricePerDay() {
		return pricePerDay;
	}

	public void setPricePerDay(Double pricePerDay) {
		this.pricePerDay = pricePerDay;
	}

	public TaxService getTaxService() {
		return taxService;
	}
	
	public void processInvoice(CarRental carRental) {
		long ts = carRental.getStart().getTime();
		long tf = carRental.getFinish().getTime();
		double dif = tf-ts;   
		double hours = TimeUnit.HOURS.convert((long) dif, TimeUnit.MILLISECONDS);
		
		double valueParcial;
		if(hours<=12) {
			valueParcial = Math.ceil(hours) * pricePerHour;
		}
		else {
			valueParcial = Math.ceil(hours/24) * pricePerDay;
		}
		
		double tax = taxService.tax(valueParcial);
		
		carRental.setInvoice(new Invoice(valueParcial, tax)); 
	}
}
