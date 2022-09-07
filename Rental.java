import java.util.Date;

public class Rental {
	private Video video ;
	private int status ; // 0 for Rented, 1 for Returned
	private Date rentDate ;
	private Date returnDate ;

	public Rental(Video video) {
		this.video = video ;
		status = 0 ;
		rentDate = new Date() ;
	}

	public int getPoint() {
		int eachPoint = 0 ;
		int daysRented = getDaysRented();

		eachPoint++;

		if ((getVideo().getPriceCode() == Video.PriceCode.New_Release) )
			eachPoint++;

		if ( daysRented > getDaysRentedLimit() )
			eachPoint -= Math.min(eachPoint, getVideo().getLateReturnPointPenalty()) ;
		return eachPoint;
	}

	public Video getVideo() {
		return video;
	}

	public void setVideo(Video video) {
		this.video = video;
	}

	public int getStatus() {
		return status;
	}

	public void returnVideo() {
		if ( status == 1 ) {
			this.status = 1;
			returnDate = new Date() ;
		}
	}
	public Date getRentDate() {
		return rentDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public int getDaysRentedLimit() {
		int limit = 0 ;
		int daysRented ;
		daysRented = getDaysRented();
		if ( daysRented <= 2) return limit ;

		return video.getLimit() ;
	}

	public int getDaysRented() {
		int daysRented;
		if (getStatus() == 1) { // returned Video
			long diff = returnDate.getTime() - rentDate.getTime();
			daysRented = (int) (diff / (1000 * 60 * 60 * 24)) + 1;
		} else { // not yet returned
			long diff = new Date().getTime() - rentDate.getTime();
			daysRented = (int) (diff / (1000 * 60 * 60 * 24)) + 1;
		}
		return daysRented;
	}

	private double getNewReleaseCharge(int daysRented) {
		return daysRented * 3;

	}

	private double getRegularVideoCharge(int daysRented) {
		double eachCharge = 2;
		if (daysRented > 2)
			eachCharge += (daysRented - 2) * 1.5;
		return eachCharge;
	}

	public double getCharge() {
		double eachCharge = 0;
		int eachPoint = 0;
		int daysRented = getDaysRented();

		switch (getVideo().getPriceCode()) {
			case Regular:
				eachCharge = getRegularVideoCharge(daysRented);
				break;
			case New_Release:
				eachCharge = getNewReleaseCharge(daysRented);
				break;
		}
		return eachCharge;
	}
}
