
public class RegularPrice extends Price{

	private static Price.PriceCode PriceCode = Price.PriceCode.REGULAR;
	private static int BasePoint = 1;
	@Override
	public final double getCharge(int daysRented) {
		// TODO Auto-generated method stub
		double charge = 2;
		
		if (daysRented > 2)
			charge += (daysRented - 2) * 1.5;
		
		return charge;
	}
	
	public final int getPoint(int daysRented, int LateReturnPointPenalty) {
		
		int point = BasePoint;
		if ( daysRented > LateReturnPointPenalty )
			point -= Math.min(point, LateReturnPointPenalty);
		return point;
	}

	public Price.PriceCode getPriceCode() {
		return PriceCode;
	}
}
