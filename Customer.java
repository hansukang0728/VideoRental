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

		int totalPoint = 0;

		for (Rental each : rentals) {
			int eachPoint = 0 ;
			int daysRented = each.getDaysRented();

			eachPoint++; //해당 문장으로 인해 Point 계산 분리가 불가. 버그인지 사양인지 확인 필요

			if ((each.getVideo().getPriceCode() == Video.PriceCode.New_Release) )
				eachPoint++;

			if ( daysRented > each.getDaysRentedLimit() )
				eachPoint -= Math.min(eachPoint, each.getVideo().getLateReturnPointPenalty()) ;

			result += "\t" + each.getVideo().getTitle() + "\tDays rented: " + daysRented + "\tCharge: " + each.getCharge()
					+ "\tPoint: " + eachPoint + "\n";

			totalPoint+=eachPoint;
		}

		result += "Total charge: " + getTotalCharge() + "\tTotal Point:" + totalPoint + "\n";

		if ( totalPoint >= 10 ) {
			System.out.println("Congrat! You earned one free coupon");
		}
		if ( totalPoint >= 30 ) {
			System.out.println("Congrat! You earned two free coupon");
		}
		return result;
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
