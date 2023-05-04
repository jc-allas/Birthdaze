package for_Project3Blanco;

import java.io.Serializable;
import java.util.Objects;

public class Date implements Serializable {
    
	private static final long serialVersionUID = 1L;  
    private Month month;
    private int day;
    private int year;
    
    public Date(Month month, int day, int year) {
        if (Month.isValidDay(month, day) == false || year < 0) {
            throw new IllegalArgumentException("Invalid date");
        }
        this.month = month;
        this.day = day;
        this.year = year;
    }
    
    public Month getMonth() {
        return month;
    }
    
    public void setMonth(Month month) {
        if (Month.isValidDay(month, day)) {
        	this.month = month;
        } else {
            throw new IllegalArgumentException("Invalid date");
        }
    }
    
    public int getDay() {
        return day;
    }
    
    public void setDay(int day) {
        if (Month.isValidDay(month, day)) {
            this.day = day;
        } else {
            throw new IllegalArgumentException("Invalid date");
        }
    }
    
    public int getYear() {
        return year;
    }
    
    public void setYear(int year) {
        if (year < 0) {
            throw new IllegalArgumentException("Invalid date");
        }
        this.year = year;
    }
    
    @Override
    public String toString() {
        return month.toString() + " " + day + ", " + year;
    }

	@Override
	public int hashCode() {
		return Objects.hash(day, month, year);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Date other = (Date) obj;
		return day == other.day && month == other.month && year == other.year;

    }

	public int compareTo(Date other) {
	    if (this.year != other.year) {
	        return Integer.compare(this.year, other.year);
	    } else if (this.month != other.month) {
	        return this.month.compareTo(other.month);
	    } else {
	        return Integer.compare(this.day, other.day);
	    }
	}


}
