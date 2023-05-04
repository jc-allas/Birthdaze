package for_Project3Blanco;

import java.io.*;
import java.util.Iterator;

public class PersonList {

    private MyLinkedList<Person> list = new MyLinkedList<>();

    public boolean add(Person p) {
        if (list.contains(p)) {
        	return false ;
        }
            list.add(p);
            return true;
    }

    public boolean addAlpha(Person p) {
        if (list.contains(p)) {
        	return false;
        }
            list.addAlpha(p);
            return true;
    }
  
    public Person search(Person p) {
        if (list.contains(p)) {
            return p;
        }
        return null;
    }

    public String saveToFile(String fileName) {
        String messageFromSave = "";
        try {
            ObjectOutputStream oOS = new ObjectOutputStream(new FileOutputStream(fileName));
            for (Person p : list) {
                oOS.writeObject(p);
            }
            oOS.flush();
            oOS.close();
        } catch (Exception e) {
            messageFromSave = e.toString();
        }
        return messageFromSave;
    }

    public String loadFromFile(String fileName) {
        String toReturn = "";
        try {
            ObjectInputStream oIS = new ObjectInputStream(new FileInputStream(fileName));
            while (oIS.available() > -1) {
                Person fromFile = (Person) (oIS.readObject());
                Person found = search(fromFile);
                if (found == null) {
                    if (add(fromFile)) {
                        toReturn += fromFile + "\n";
                    } else {
                        toReturn += fromFile + " not successfully added to DB.\n";
                    }
                } else {
                    toReturn += found + " already in the DB.\n";
                }
            }
            oIS.close();
        } catch (EOFException eOF) {
        } catch (Exception e) {
            toReturn += e;
        }
        return toReturn;
    }

    public boolean delete(Name n) {
        Iterator<Person> iter = list.iterator();
        while (iter.hasNext()) {
            Person p = iter.next();
            if (p.getName().equals(n)) {
                iter.remove();
                return true;
            }
        }
        return false;
    }

    public String hasBirthdayOn(Date date) {
        for (Person p : list) {
            if (p.getBirthday().equals(date)) {
                return p.toString();
            }
        }
        return "Nobody has a birthday on that date.";
    }

    public String printList() {
        String string = "";
        for (Person p : list) {
            string += p.toString() + "\n";
        }
        return string;
    }

    public String sortAlphab() {
        return printList();
    }

    public String sortChronol() {
        MyLinkedList<Person> sortedList = new MyLinkedList<Person>(new ChronoComparator());
        for (Person p : list) {
            sortedList.add(p);
        }
        sortedList.sort();
        String string = "";
        for (Person p : sortedList) {
            string += p.toString() + "\n";
        }
        return string;
    }

    public String findPersonByName(Name name) {
        for (Person p : list) {
            if (p.getName().equals(name)) {
                return p.toString();
            }
        }
        return "Person not found.";
    }
}

