package dataStructure.linearList;

public class LinkList<E> implements IList<E> {
	private Node<E> head; // 单链表的头指针
	private int curLen;
	
	//构造方法，构造一个只有头结点的空单链表     
	public LinkList( ) {  
		head = new Node<E>(); // 初始化头结点（哑结点）
	    curLen = 0;   
	}

	// 获取单链表的头指针
	public Node<E> getHead(){
		return head;
	}	 
	
	// 链表置空
	public void clear( ) {
		head.setNext(null);
		curLen = 0;
	}
	 
	//判空
	public boolean isEmpty() {   
		return head.getNext() == null; 
	}
	 
	//求单链表的长度
	public int length( )  {   
		return curLen;
	}
	 
	// 读取单链表中位置序号为i的元素的数据
	public E get (int i) throws Exception{
		if (i < 0 || i > curLen - 1)
			throw new Exception("位置序号为" + i + "个数据元素不存在");

		Node<E> p = head.getNext(); 
		int j = 0;
		while (p != null && j < i){
	         p = p.getNext();
	         ++j;
		}
		return p.getData();  
	}
	
	// 插入操作
	public void insert (int i, E x) throws Exception{
 		if (i < 0 || i > curLen)   // i不合法
            throw new Exception("插入位置不合法");
 
 		Node<E> s = new Node<E>(x);	//创建待插入的新结点s
 		if (s == null)	// 内存空间不够
 			throw new Exception("链表已满"); 
 			
 		Node<E> p = head; 
		int j = -1;
		while (p != null && j<i-1 ) {
			p = p.getNext(); 
			++j;    
		}
		
		s.setNext(p.getNext()); 
		p.setNext(s);
		curLen++; 
	}
	
	// 删除操作
	public void remove (int i) throws Exception{
		if (this.isEmpty())
		   throw new Exception("链表已空");	
		if (i < 0 || i > curLen - 1)
           throw new Exception("删除位置不合法");
   
   		Node<E> p = head; 
		int j = -1;
		while (p.getNext()!= null && j<i-1 ) {
			p = p.getNext(); 
			++j;    
		}
		p.setNext(p.getNext().getNext()); 
		curLen--;
	}
	
	// 查找操作
	public int indexOf (E x){
		Node<E> p = head.getNext(); 
		int j = 0;
		while (p != null && !p.getData().equals(x) ) {
			p = p.getNext(); 
			++j;    
		}

		if (p != null) 
		      return j;
		else 
		      return -1;

	}
	
	//输出单链表的数据元素
	public void display( ) {
		Node<E> node = head.getNext(); 
      	while (node != null) {
			System.out.println(node.getData( ));
			node = node.getNext();    // 取下一个结点
       }
		System.out.println();
	}
}