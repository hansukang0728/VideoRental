import java.util.Date;

public class VHSVideo extends Video{

    public final static int penalty = 1;
    private final static int videoType = Video.VHS;

    public VHSVideo(String title, int videoType,  Price.PriceCode priceCode, Date registeredDate) {
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
