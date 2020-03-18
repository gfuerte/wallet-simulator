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

	public int monthToInt(String month) {
		switch(month) {
			case "January":
				return 1;
			case "February":
				return 2;
			case "March":
				return 3;
			case "April":
				return 4;
			case "May":
				return 5;
			case "June":
				return 6;
			case "July":
				return 7;
			case "August":
				return 8;
			case "September":
				return 9;
			case "October":
				return 10;
			case "November":
				return 11;
			case "December":
				return 12;										
		}
		return 0;
	}

	public Date(int day, int month, int year) {
		if (day == -1 || month == -1 || year == -1) {
			this.day = -1;
			this.month = "";
			this.year = -1;
		} else {
			this.day = day;
			this.month = monthToString(month);
			this.year = year;
		}
	}

	public int getDay() {
		return this.day;
	}

	public String getMonth() {
		return this.month;
	}

	public int getYear() {
		return this.year;
	}

	public int getValue() {
		if (this.day == -1 || this.month.equals("") || this.year == -1) {
			return -1;
		}
		String sum = Integer.toString(this.year);
		String monthString = Integer.toString(monthToInt(this.month));
		String dayString = Integer.toString(this.day);
		if (monthString.length() < 2) {
			monthString = "0" + monthString;
		}
		if (dayString.length() < 2) {
			dayString = "0" + dayString;
		}
		sum = sum + monthString + dayString;
		return Integer.parseInt(sum);
	}

	public String toString() {
		if (this.day == -1 || this.month.equals("") || this.year == -1) {
			return "Unassigned";
		}
		return this.month + " " + this.day + " " + this.year;
	}
}