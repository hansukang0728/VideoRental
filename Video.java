import java.util.Date;

abstract class Video {
	private String title ;

	private Price.PriceCode priceCode ;

	private Price vedioPrice;
	private int videoType ;
	public static final int VHS = 1 ;
	public static final int CD = 2 ;
	public static final int DVD = 3 ;

	private Date registeredDate ;
	private boolean rented ;

	public Video(String title, int videoType, Price.PriceCode priceCode, Date registeredDate) {
		this.setTitle(title) ;
		//this.setVideoType(videoType) ;
		this.setVideoPrice(Price.PriceFactory(priceCode));
		this.setRegisteredDate(registeredDate);
	}


	public static Video VideoFactory(String title,  int videoType, Price.PriceCode priceCode, Date registeredDate)
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
	abstract int getVideoType();

	public Price.PriceCode getPriceCode()
	{
		return vedioPrice.getPriceCode();

	}
	public int getPoint(int dayRented, int LateReturnPointPenalty)
	{
		return vedioPrice.getPoint(dayRented, LateReturnPointPenalty);
	}

	public double getCharge(int dayRented)
	{
		return vedioPrice.getCharge(dayRented);
	}

	public void setPriceCode(Price.PriceCode priceCode) {
		this.priceCode = priceCode;
	}


	public void setVideoPrice(Price videoPrice) {
		this.vedioPrice = videoPrice;
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

}
