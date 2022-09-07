
public abstract class Price {

    public enum PriceCode
    {
        None, REGULAR, NEW_RELEASE;

        static PriceCode values(int number)
        {
            switch (number)
            {
                case 1 :
                    return REGULAR;
                case 2:
                    return NEW_RELEASE;
                default:
                    return None;

            }
        }
    }

    public static Price PriceFactory(Price.PriceCode priceCode)
    {
        switch (priceCode)
        {
            case REGULAR:
                return new RegularPrice();
            case NEW_RELEASE:
                return new NewReleasePrice();
		
        }
		return null;
    }
    
	abstract double getCharge(int daysRented);
	abstract int getPoint(int daysRented, int LateReturnPointPenalty);
	abstract Price.PriceCode getPriceCode();
	
}
