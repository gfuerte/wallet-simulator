//Self-made Date class because apprently java.util.Date is Deprecated
public class Date {
	private int day;
	private String month;
	private int year;

	public Date() {
		this.day = -1;
		this.month = "";
		this.year = -1;
	}

	public String monthToString(int month) {
		if(month <= 0 || month >= 13) {
			return null;
		}
		switch(month) {
			case 1:
				return "January";
			case 2:
				return "February";
			case 3:
				return "March";
			case 4:
				return "April";
			case 5:
				return "May";
			case 6:
				return "June";
			case 7:
				return "July";
			case 8:
				return "August";
			case 9:
				return "September";
			case 10:
				return "October";
			case 11:
				return "November";
			case 12:
				return "December";										
		}
		return null;
	}

	public Date(int day, String month, int year) {
		this.day = day;
		this.month = month.substring(0, 1).toUpperCase() + month.substring(1).toLowerCase();
		this.year = year;
	}

	public Date(int day, int month, int year) {
		this.day = day;
		this.month = monthToString(month);
		this.year = year;
	}

	public String toString() {
		return this.month + " " + this.day + " " + this.year;
	}
}