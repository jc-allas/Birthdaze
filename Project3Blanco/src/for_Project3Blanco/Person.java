package for_Project3Blanco;

import java.io.Serializable;
import java.util.Objects;

public class Person implements Comparable<Person>, Serializable {

    private static final long serialVersionUID = 1L;
	private Name name;
    private Date birthday;
    private static int numPeople = 0;
    
    public Person(String fName, String lName, Month month, int day, int year) {
        this.name = new Name(fName, lName);
        this.birthday = new Date(month, day, year);
        numPeople++;
    }

	public Name getName() {
        return name;
    }
    
    public Date getBirthday() {
        return birthday;
    }

    public static int getNumPpl() {
        return numPeople;
    }

	@Override
	public int hashCode() {
		return Objects.hash(birthday, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return Objects.equals(birthday, other.birthday) && Objects.equals(name, other.name);
	}
	
    @Override
    public String toString() {
        return name.toString() + ", " + birthday.toString();
    }
    
    public int compareTo(Person other) {
        return this.name.compareTo(other.getName());
    }
    
}
