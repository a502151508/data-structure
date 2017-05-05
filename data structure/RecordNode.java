package dataStructure.linearList;

public class RecordNode<E> {
	private E elem;
	private Comparable key;
	
	public RecordNode(E elem, Comparable key) {
		this.elem = elem;
		this.key = key;
	}
	
	public E getElem() {
		return this.elem;
	}

	public Comparable getKey() {
		return this.key;
	}

	public void setElem(E elem) {
		this.elem = elem;
	}

	public void setKey(Comparable key) {
		this.key = key;
	}
	
	public String toString() {
		return elem.toString();
	}
}