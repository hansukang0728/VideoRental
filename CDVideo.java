import java.util.Date;

public class CDVideo extends Video{

    public final static int penalty = 2;
    private final static int videoType = Video.VHS;

    public CDVideo(String title, int videoType, Price.PriceCode priceCode, Date registeredDate) {
        super(title, videoType, priceCode, registeredDate);
    }

    @Override
    public int getLateReturnPointPenalty() {
        return penalty;
    }

    public final int getVideoType() {
        // TODO Auto-generated method stub
        return videoType;
    }
}
