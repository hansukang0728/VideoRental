import java.util.Date;

public class CDVideo extends Video{

    public final static int penalty = 2;

    public CDVideo(String title, int videoType, PriceCode priceCode, Date registeredDate) {
        super(title, videoType, priceCode, registeredDate);
    }

    @Override
    public int getLateReturnPointPenalty() {
        return penalty;
    }
}
