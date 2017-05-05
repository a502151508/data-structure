
public class LinkStack<E> implements IStack<E> {
	private Node<E> top;
	private int curLen; 

	public LinkStack(){
		top = null;
		curLen = 0;
	}
	
	// 栈置空
   	public void clear( ) {
		top = null;
		curLen = 0;
   	}

    // 栈判空
	public boolean isEmpty( ) {
		return  top== null;
	}

	// 求栈数据元素个数函数
    public int length( ) {
		return curLen;
    }

  	// 取栈顶元素的函数
  	public E peek ( ) {
		if (!isEmpty())      // 栈非空
		      return top.getData( ); // 栈顶元素
		else
		      return null;	 //栈空
  	}	

	//入栈
	public void push (E x) throws Exception {
		Node<E> p = new Node<E>(x); 
 		if (p == null)	// 内存空间不够
 			throw new Exception("链栈已满"); 

 		p.setNext(top); 
		top = p;
		curLen++; 
	}  

	//出栈
	public E pop () {
		if (isEmpty())
		    return  null;
		
		Node<E> p = top; 
		top=top.getNext( );
		curLen--; 
		return p.getData( ); 
	}  
	
	// 输出函数(从栈顶到栈底)
	public void display () {  
		Node<E> p = top; 
      	while (p != null) {
			System.out.println(p.getData( ));
			p = p.getNext();    // 取下一个结点
       	}
		System.out.println();
	}


 }
