package dataStructure.linearList;

public interface IList<E>{
	public void clear(); 
	public boolean isEmpty();
	public int length(); 
	public E get(int i) throws Exception; 
	public void insert(int i, E x) throws Exception; 
	public void remove(int i) throws Exception; 
	public int indexOf(E x);
	public void display();	
}
