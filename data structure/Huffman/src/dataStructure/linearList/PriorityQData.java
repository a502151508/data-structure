package dataStructure.linearList;

public class PriorityQData<E> {
	private E elem;
	private int priority;	//值越小，优先级越高

	//构造函数
	public PriorityQData(E elem, int priority) {
		this.elem = elem;
		this.priority = priority;
	}

	public E getElem( ) {
		return elem;
	}

	public int getPriority( ) {
		return priority;
	}
	
	public void setElem(E elem) {
		this.elem = elem;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public String toString( ) {
		return elem.toString();
	}
}
