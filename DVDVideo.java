import java.util.Date;

public class DVDVideo extends Video{

    public final static int penalty = 3;
    private final static int videoType = Video.DVD;
    public DVDVideo(String title, int videoType, Price.PriceCode priceCode, Date registeredDate) {
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
