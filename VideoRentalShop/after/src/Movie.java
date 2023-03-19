
public class Movie {
	public static final int CHILDRENS = 2;
	public static final int REGULAR = 0;
	public static final int NEW_RELEASE = 1;
	private String _title;
	private int _priceCode;

	public Movie(String title, int priceCode) {
		_title = title;
		_priceCode = priceCode;
	}

	public int getPriceCode() {
		return _priceCode;
	}

	public void setPriceCode(int arg) {
		_priceCode = arg;
	}

	public String getTitle() {
		return _title;
	}

	public double getCharge(int daysRented) {
		return _price.getCharge(daysRented);
	}

	public int getFrequentRenterPoints(int daysRented) {
		
		// add bonus for a two day new release rental
		if ((getPriceCode() == Movie.NEW_RELEASE) && daysRented > 1)
			return 2;
		return 1;
	};
}
//