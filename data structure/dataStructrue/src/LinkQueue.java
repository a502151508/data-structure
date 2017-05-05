public class LinkQueue<E> implements IQueue<E> {
	private Node<E> front;     
	private Node<E> rear;     
	private int curLen;

	public LinkQueue(){
		front=null;
		rear= null; 
		curLen = 0;
	}

	// 队列置空函数
   	public void clear( ) {
		front = rear = null; 
		curLen = 0;
	}

	// 判空函数
	public boolean isEmpty( ) {
		return front== null;
	}

	// 求队列长度函数
	public int length( ) { 
		/*  如果没有curLen成员
		Node<E> p = front;
		int length = 0;
	          
		while (p !=null) { 
       		p = p.getNext();    //指针下移
      		++length;      //计数器加1
		}  
		return length;      
		*/

		return curLen;
	}

	// 取队首元素的函数
  	public E peek ( ) {
  		if (isEmpty())      // 队列非空
  			return null;

		return front.getData( ); // 返回队首元素
  	}
	
	//入队操作
	public void offer (E x) throws Exception{
		Node<E> p = new Node<E>(x);
 		if (p == null)	// 内存空间不够，满队异常
 			throw new Exception("链队列已满"); 

      	if (!isEmpty( )) {         // 队列非空
	   		rear.setNext(p);
	   		rear = p;              
        } 
      	else  {		//空队时入队操作,需调整front及rear
	   		front = rear = p;
       	}
       	curLen++;
	}

	//出队操作
	public E poll( ) {
		if (isEmpty())	//空队异常
		    return  null;

        if (length( )==1) 	//如果出队时队只有一个结点，需调整rear 
           	rear=null;
		
		E dataOut = front.getData();
	   	front=front.getNext();
		curLen--;

        return dataOut;              
	}
	
	// 输出函数(从队首到队尾)
	public void display ( ) {  
		Node<E> p=front;
		while( p!=null ) {
			System.out.print(p.getData( ));
			p=p.getNext();
		}
	}
 }
