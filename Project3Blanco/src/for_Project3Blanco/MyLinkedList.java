package for_Project3Blanco;

import java.util.Comparator;
import java.util.Iterator;

public class MyLinkedList<E extends Comparable<E>> implements Iterable<E> {
	
	private Node<E> head;
	private int size;
	private Comparator<E> myComparator;
	
	public MyLinkedList() {
		head = null;
		size = 0;
		myComparator = null;
	}
	
	public MyLinkedList(Comparator<E> theComparator) {
		head = null;
		size = 0;
		myComparator = theComparator;
	}
	
	private int myCompare(E first, E second) {
	      if(myComparator == null) {
	         return first.compareTo(second);
	      }
	      return myComparator.compare(first, second);
	   }

	public void add(E data) {
		Node<E> n = new Node<>(data);
		if(head == null) {
			head = n;
			size++;
			return;
		}
		Node<E> mover = head;
		while(mover.getLink() != null) {
			mover = mover.getLink();
		}
		mover.setLink(n);
		size++;
	}
	
	public void addFirst(E data) {
		Node<E> n = new Node<>(data);
		n.setLink(head);
		head = n;
		size++;
	}
	
	public String toString() {
		String toReturn = "";
		Node<E> mover = head;
		while(mover != null) {
			toReturn += mover.getData() + " - ";
			mover = mover.getLink();
		}
		if(size == 0) {
			toReturn = "Empty list";
		}
		return toReturn;
	}
	
	public E get(int index) {
		if(index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		Node<E> mover = head;
		for(int i = 0; i < index; i++) {
			mover = mover.getLink();
		}
		return mover.getData();
	}
	
	public void set(int index, E data) {
		if(index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		Node<E> mover = head;
		for(int i = 0; i < index; i++) {
			mover = mover.getLink();
		}
		mover.setData(data);
	}
	
	public boolean remove(E data) {
		if(head == null) {
			return false;
		}
		if(head.getData().equals(data)) {
			head = head.getLink();
			size--;
			return true;
		}
		
		Node<E> mover1 = head;
		Node<E> mover2 = head.getLink();
		
		while(mover2 != null) {
			if(mover2.getData().equals(data)) {
				mover1.setLink(mover2.getLink());
				size--;
				return true;
			}else {
				mover1 = mover1.getLink();
				mover2 = mover2.getLink();
			}
		}
		return false;
	}
	
	public void addAlpha(E data) {
		Node<E> n = new Node<>(data);
		if(head == null || myCompare(head.getData(), data) > 0) {
			addFirst(data);
			return;
		}
		Node<E> current = head;
		while(current.getLink() != null && myCompare(current.getLink().getData(), data) <= 0) {
			current = current.getLink();
		}
		n.setLink(current.getLink());
		current.setLink(n);
		size++;
	}
	
	public boolean contains(E data) {
		Node<E> current = head;
		while(current != null) {
			if(current.getData().equals(data)) {
				return true;
			}
			current = current.getLink();
		}
		return false;
	}
	
	public Node<E> getMiddle(Node<E> head){ 
		Node<E> slow = head;
		Node<E> fast = head;
		while(fast.getLink() != null && fast.getLink().getLink() != null) {
			slow = slow.getLink();
			fast = fast.getLink().getLink();
		}
		return slow; 
	}
	
	public Node<E> merge(Node<E> a, Node<E> b){ 
		Node<E> result = null;
		if(a == null) { 
			return b;
		}
		if(b == null) {
			return a;
		}
		if(myCompare(a.getData(), b.getData()) <= 0) { 
         result = a;
         result.setLink(merge(a.getLink(), b)); 
      } else {
         result = b;
         result.setLink(merge(a, b.getLink())); 
      }
		return result; 
	}
	
	public Node<E> mergeSort(Node<E> h) { 
		if(h == null || h.getLink() == null) {
			return h; 
		}
		Node<E> middle = getMiddle(h); 
		Node<E> nexttomiddle = middle.getLink(); 
		middle.setLink(null);
		Node<E> left = mergeSort(h);
		Node<E> right = mergeSort(nexttomiddle); 
		Node<E> sortedlist = merge(left, right); 
		return sortedlist;
	}
	
	public void sort() {
		head = this.mergeSort(head);
		}

	@Override
	public Iterator<E> iterator(){
	   return new MyListIterator<E>(this);
		}

	public void remove(int i) {
	    if (i < 0 || i >= size) {
	        throw new IndexOutOfBoundsException();
	    }
	    if (i == 0) {
	        head = head.getLink();
	    } else {
	        Node<E> prev = head;
	        for (int j = 0; j < i - 1; j++) {
	            prev = prev.getLink();
	        }
	        Node<E> current = prev.getLink();
	        prev.setLink(current.getLink());
	    }
	    size--;
	}		
}