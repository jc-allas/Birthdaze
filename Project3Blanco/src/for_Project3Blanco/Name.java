package for_Project3Blanco;

import java.io.Serializable;
import java.util.Objects;

public class Name implements Serializable {
    private static final long serialVersionUID = 1L;
    
    String first;
    private String middle;
    private String last;
    
    public Name(String first, String middle, String last) {
        this.first = first;
        this.middle = middle;
        this.last = last;
    }
    
    public Name(String first, String last) {
        this(first, "", last);
    }
    
    public String getFirst() {
        return first;
    }
    
    public void setFirst(String first) {
        this.first = first;
    }
    
    public String getMiddle() {
        return middle;
    }
    
    public void setMiddle(String middle) {
        this.middle = middle;
    }
    
    public String getLast() {
        return last;
    }
    
    public void setLast(String last) {
        this.last = last;
    }
    
    @Override
    public String toString() {
        if (middle.isEmpty()) {
            return first + " " + last;
        } else {
            return first + " " + middle + " " + last;
        }
    }

	@Override
	public int hashCode() {
		return Objects.hash(first, last, middle);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Name other = (Name) obj;
		return Objects.equals(first, other.first) && Objects.equals(last, other.last)
				&& Objects.equals(middle, other.middle);

	}

	public int compareTo(Name other) {
	    int compare = last.compareTo(other.last);
	    if (compare == 0) {
	        compare = first.compareTo(other.first);
	        if (compare == 0) {
	            compare = middle.compareTo(other.middle);
	        }
	    }
	    return compare;
	}
}
