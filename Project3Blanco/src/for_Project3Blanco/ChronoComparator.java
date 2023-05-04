package for_Project3Blanco;

import java.util.Comparator;

public class ChronoComparator implements Comparator<Person> {
    
	@Override
    public int compare(Person person1, Person person2) {
        Date date1 = person1.getBirthday();
        Date date2 = person2.getBirthday();

        if (date1.getYear() < date2.getYear()) {
            return -1;
        } else if (date1.getYear() > date2.getYear()) {
            return 1;
        } else {
            if (date1.getMonth().getNum() < date2.getMonth().getNum()) {
                return -1;
            } else if (date1.getMonth().getNum() > date2.getMonth().getNum()) {
                return 1;
            } else {
                return Integer.compare(date1.getDay(), date2.getDay());
            }
        }
    }
}




