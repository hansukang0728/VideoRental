
public class NewReleasePrice extends Price{

	private static Price.PriceCode PriceCode = Price.PriceCode.NEW_RELEASE;
	private static int BasePoint = 2;
	@Override
	public final double getCharge(int daysRented) {
		
		return  daysRented * 3;
		
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

