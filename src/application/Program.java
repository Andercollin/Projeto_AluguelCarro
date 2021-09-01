package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.CarRental;
import model.entities.Vehicle;
import model.service.BrazilTaxService;
import model.service.RentalService;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat ("dd/MM/yyyy hh:mm");
		
		System.out.println("Digite os dados da locação: ");
		System.out.print("Modelo do carro: ");
		String model = sc.nextLine();
		System.out.print("Digite a data e hora de retirada - dd/mm/yyyy hh:mm: ");
		Date start = sdf.parse(sc.nextLine());
		System.out.print("Digite a data e hora de devolução - dd/mm/yyyy hh:mm: ");
		Date finish = sdf.parse(sc.nextLine());
		
		CarRental carRental = new CarRental(new Vehicle(model), start, finish);
		
		System.out.print("Digite o valor por hora: ");
		double pricePerHour = sc.nextDouble();
		System.out.print("Digite o valor por dia: ");
		double pricePerDay = sc.nextDouble();
		
		RentalService rentalService = new RentalService(pricePerHour, pricePerDay, new BrazilTaxService());
		
		rentalService.processInvoice(carRental);
		
		System.out.println();
		System.out.println("INVOICE");
		System.out.println("Basic payment: $" + carRental.getInvoice().getBasicPayment());
		System.out.println("Tax: $" + carRental.getInvoice().getTax());
		System.out.println("Total payment: $" + carRental.getInvoice().totalPayment());
				
		sc.close();
	}
}
