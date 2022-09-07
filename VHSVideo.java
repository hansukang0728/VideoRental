import java.util.Date;

public class VHSVideo extends Video{

    public final static int penalty = 1;

    public VHSVideo(String title, int videoType,  PriceCode priceCode, Date registeredDate) {
        super(title, videoType, priceCode, registeredDate);
    }

    @Override
    public int getLateReturnPointPenalty() {
        return penalty;
    }

    @Override
    public int getLimit() {
        return 5;
    }
}
