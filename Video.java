import java.util.Date;

abstract class Video {
	private String title ;

	private PriceCode priceCode ;

	public enum PriceCode
	{
		None, Regular, New_Release;

		static PriceCode values(int number)
		{
			switch (number)
			{
				case 1 :
					return Regular;
				case 2:
					return New_Release;
				default:
					return None;

			}
		}
	}

	private int videoType ;
	public static final int VHS = 1 ;
	public static final int CD = 2 ;
	public static final int DVD = 3 ;

	private Date registeredDate ;
	private boolean rented ;

	public Video(String title, int videoType, PriceCode priceCode, Date registeredDate) {
		this.setTitle(title) ;
		this.setVideoType(videoType) ;
		this.setPriceCode(priceCode) ;
		this.setRegisteredDate(registeredDate);
	}


	public static Video VideoFactory(String title,  int videoType, PriceCode priceCode, Date registeredDate)
	{
		switch (videoType)
		{
			case VHS:
				return new VHSVideo(title, videoType, priceCode,  registeredDate);
			case CD:
				return new CDVideo(title, videoType, priceCode, registeredDate);
			case DVD:
				return new DVDVideo(title, videoType, priceCode, registeredDate);
			default:
				break;

		}
		return null;
	}

	abstract public int getLateReturnPointPenalty();

	public PriceCode getPriceCode() {
		return priceCode;
	}

	public void setPriceCode(PriceCode priceCode) {
		this.priceCode = priceCode;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isRented() {
		return rented;
	}

	public void setRented(boolean rented) {
		this.rented = rented;
	}

	// dead code 주석처리 삭제

	public void setRegisteredDate(Date registeredDate) {
		this.registeredDate = registeredDate;
	}

	public int getVideoType() {
		return videoType;
	}

	public void setVideoType(int videoType) {
		this.videoType = videoType;
	}
}
