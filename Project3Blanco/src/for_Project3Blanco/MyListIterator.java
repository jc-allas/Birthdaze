package for_Project3Blanco;

import java.util.Iterator;

public class MyListIterator<E extends Comparable<E>> implements Iterator<E> {
	
	private MyLinkedList<E> ml;
	private Object element;
	private int index;
	private boolean removeGotCalled;
	
	public MyListIterator(MyLinkedList<E> thelist) {
		ml = thelist;
		element = ml.get(0);
		index = 0;
		removeGotCalled = false;
	}
	
	@Override
	public boolean hasNext() {
		return element != null;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public E next() {
		Object toReturn = element;
		index++;
		try {
			element = ml.get(index);
		}catch(IndexOutOfBoundsException e) {
			element = null;
		}
		removeGotCalled= false;
		return (E)toReturn;
	}
	
	@Override
	public void remove() {
		if(index == 0 || removeGotCalled) {
			throw new IllegalStateException();
		}
		ml.remove(index-1);
		index--;
		removeGotCalled = true;
	}
}
