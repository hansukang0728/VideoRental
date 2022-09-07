import java.util.Date;

public class DVDVideo extends Video{

    public final static int penalty = 3;

    public DVDVideo(String title, int videoType, PriceCode priceCode, Date registeredDate) {
        super(title, videoType, priceCode, registeredDate);
    }

    @Override
    public int getLateReturnPointPenalty() {
        return penalty;
    }

    @Override
    public int getLimit() {
        return 2;
    }
}
