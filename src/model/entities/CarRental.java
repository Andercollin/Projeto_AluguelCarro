package model.entities;

import java.util.Date;

public class CarRental {
	
	private Vehicle vehicle;
	private Invoice invoice;
	
	private Date start;
	private Date finish;
	
	public CarRental() {
	}

	public CarRental(Vehicle vehicle, Date start, Date finish) {
		this.vehicle = vehicle;
		this.start = start;
		this.finish = finish;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

	public Date getStart() {
		return start;
	}

	public void setStat(Date start) {
		this.start = start;
	}

	public Date getFinish() {
		return finish;
	}

	public void setFinish(Date finish) {
		this.finish = finish;
	}
}
