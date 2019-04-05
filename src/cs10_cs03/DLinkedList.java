package cs10_cs03;

public class DLinkedList implements ILinkedList {

	public Node first;
	public Node last;
	

	public DLinkedList() { //constructs an Empty list
	}
	/**
	* Inserts a specified element at the specified position in the list.
	* @param index
	* @param element
	*/
	public void add(int index, Object element) throws IndexOutOfBoundsException {
		
		Node newNode = new Node(element);
		Node temp = first;
		if (index < 0 || index > size()) {
			throw new IndexOutOfBoundsException();
		}else if (index == 0) {
			newNode.next = first;
			first.previous = newNode;
			first = newNode;
		}else if (index ==size()) {
			add(element);
		}else {
			for (int i=1; i<index; i++) {
				
				temp = temp.next;
				if (temp == null) {
					throw new IndexOutOfBoundsException();
				}
			}
			newNode.next = temp.next;
			newNode.previous=temp;
			temp.next.previous=newNode;
			temp.next = newNode;
		}
	}
	/**
	* Inserts the specified element at the end of the list.
	* @param element
	*/
	public void add(Object element) { // working
		Node newNode = new Node(element);
		if (first == null && last == null) {
			first = newNode;
			last = newNode;
		} else {
			last.next = newNode;
			newNode.previous = last;
			last = newNode;
		}
	}
	/**
	* @param index
	* @return the element at the specified position in this list.
	*/
	public Object get(int index) { //working
		
		if (first == null ) {
			throw new IndexOutOfBoundsException();
		}
		
		if (index > (size() - 1) || index < 0) {
			throw new IndexOutOfBoundsException();
		}
		
		Node temp;
		temp = first;
		
		for (int i=0; i<index; i++) {
			temp = temp.next;
		}
		
		return temp.data;
		
	}
	/**
	* Replaces the element at the specified position in this list with the
	* specified element.
	* @param index
	* @param element
	*/
	public void set(int index, Object element) { //working
		
		Node temp;
		temp = first;
		
		if (first == null ) {
			throw new IndexOutOfBoundsException();
		}
		
		if (index > (size() - 1)) {
			throw new IndexOutOfBoundsException();
		}
		
		for (int i=0; i<index; i++) {
			temp = temp.next;
		}
		temp.data = element;
	}
	/**
	* Removes all of the elements from this list.
	*/
	public void clear() {
		
		first = null;
		last = null;
	}
	/**
	* @return true if this list contains no elements.
	*/
	public boolean isEmpty() {
		
		return (first == null);
		
	}
	/**
	* Removes the element at the specified position in this list.
	* @param index
	*/
	public void remove(int index) { //working
		
		Node temp;
		temp = first;
		
			if (index > (size() - 1)) {
				throw new IndexOutOfBoundsException();
			}
		
		if (index == 0) {
			first = first.next;
			first.previous =  null;
		} else if(index < size() -1) {
			for (int i=1; i<index; i++) {
				temp=temp.next;
			}
			temp.next= temp.next.next;
			temp.next.next.previous = temp;
		}else if (index == size()-1) {
			for (int i=1; i<index; i++) {
				temp=temp.next;
			}
			last = temp;
			temp.next.previous=null;
			temp.next = null;
		}
	}
	/**
	* @return the number of elements in this list.
	*/
	public int size() { //working
		
		int count = 1;
		Node temp;
		temp = first;
		
		if (isEmpty()) {
			return 0;
		}else {
			while (temp.next != null) {
				count++;
				temp=temp.next;
			}
			return count;
		}
	}
	/**
	* @param fromIndex
	* @param toIndex
	* @return a view of the portion of this list between the specified
	* fromIndex and toIndex, inclusively.
	*/
	public ILinkedList sublist(int fromIndex, int toIndex) {
		
		
		DLinkedList subList = new DLinkedList();
		for (int i=fromIndex; i<=toIndex; i++) {
		
			subList.add(get(i));
	
		}
		return subList;
	
	}
	/**
	* @param o
	* @return true if this list contains an element with the same value as the
	* specified element.
	*/
	public boolean contains(Object o) {
		if(first==null) {
			return false;
		}
		Node temp = first;
		while(!o.equals(temp.data) && temp.next!=null) {
			temp=temp.next;
		}
		if(o.equals(temp.data)) {
		return true;}
		else {
			return false;
		}
	}
}