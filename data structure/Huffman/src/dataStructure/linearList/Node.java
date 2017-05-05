package dataStructure.linearList;

public class Node<E> {
	private E data;    // 存放结点值
	private Node<E> next;     // 后继结点的引用	

	public Node( ) {  // 无参数时的构造函数
		this(null, null);
	}
	
	public Node(E data) { //带一个参数时的构造函数
		this(data, null);
	}
	
	public Node(E data, Node<E> next) { //带两个参数时的构造函数   
		this.data = data;
	    this.next = next;
	}
	
	public E getData( ) {
		return data;
	}
	
	public Node<E> getNext() {
	    return next;
	}
	
	public void setData(E data) {
		this.data = data;
	}
	
	public void setNext(Node<E> next) {
	    this.next = next;
	}	
}
