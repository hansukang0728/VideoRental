import java.util.ArrayList;
import java.util.List;

public class Customer {
	private String name;

	private List<Rental> rentals = new ArrayList<Rental>();

	public Customer(String name) {
		this.setName(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Rental> getRentals() {
		return rentals;
	}

	public void setRentals(List<Rental> rentals) {
		this.rentals = rentals;
	}

	public void addRental(Rental rental) {
		rentals.add(rental);

	}

	public String getReport() {
		String result = "Customer Report for " + getName() + "\n";

		List<Rental> rentals = getRentals();

		for (Rental each : rentals) {

			result += "\t" + each.getVideo().getTitle() + "\tDays rented: " + each.getDaysRented() + "\tCharge: " + each.getCharge()
					+ "\tPoint: " + each.getPoint() + "\n";

		}

		int totalPoint = getTotalPoint();
		result += "Total charge: " + getTotalCharge() + "\tTotal Point:" + totalPoint + "\n";

		if ( totalPoint >= 10 ) {
			System.out.println("Congrat! You earned one free coupon");
		}
		if ( totalPoint >= 30 ) {
			System.out.println("Congrat! You earned two free coupon");
		}
		return result;
	}

	private int getTotalPoint(){
		List<Rental> rentals = getRentals();

		int totalPoint = 0;

		for (Rental each : rentals) {
			int eachPoint = each.getPoint();

			totalPoint+=eachPoint;
		}
		return totalPoint;
	}


	private double getTotalCharge(){
		List<Rental> rentals = getRentals();

		double totalCharge = 0;

		for (Rental each : rentals) {
			totalCharge += each.getCharge();
		}
		return totalCharge;
	}
}
