

public interface IQueue<E>{
	public  void  clear();
	public  boolean  isEmpty();
	public  int  length();
	public  E  peek();
	public  void  offer(E x) throws Exception;
	public  E  poll();
}
