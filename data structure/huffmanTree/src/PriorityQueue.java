
public class PriorityQueue implements IQueue<PriorityQData> {
	private Node<PriorityQData> front;     
	private Node<PriorityQData> rear;     
	private int curLen;

	public PriorityQueue(){
		front=null;
		rear= null; 
		curLen = 0;
	}

	// 队列置空函数
   	public void clear( ) {
		front=rear= null; 
		curLen = 0;
	}

	// 判空函数
	public boolean isEmpty( ) {
		return front== null;
	}

	// 求队列长度函数
	public int length( ) { 
		/*  如果没有curLen成员
		Node p = front;
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
  	public PriorityQData peek ( ) {
  		if (isEmpty())      // 队列非空
  			return null;

		return front.getData( ); // 返回队首元素
  	}
	
	//入队操作
	public void offer (PriorityQData x) throws Exception{
		Node s = new Node(x);
 		if (s == null)	// 内存空间不够，满队异常
 			throw new Exception("链表已满"); 

      	if (!isEmpty( )) {         // 队列非空
			Node<PriorityQData> p = front, q = null;
			while (p != null && x.getPriority() >= p.getData().getPriority()) {
				q = p;
				p = p.getNext();
			}

			if (p == null) {	//p已指向链队尾之外，q指向队尾结点
				rear.setNext(s);
				rear = s;
			}
			else if (p == front) {	//在队首插入新结点
				s.setNext(front);
				front = s;
			}
			else{
				q.setNext(s);
				s.setNext(p);
			}
        } 
      	else  {		//空队时入队操作,需调整front及rear
	   		front = rear = s;
       	}
       	
       	curLen++;
	}

	//出队操作
	public PriorityQData poll( ) {
		if (isEmpty())	//空队异常
		    return  null;

        if (length( )==1) 	//如果出队时队只有一个结点，需调整rear 
           	rear=null;
		PriorityQData dataOut = front.getData();
	   	front=front.getNext();
		curLen--;

        return dataOut;              
	}
	
	// 输出函数(从队首到队尾)
	public void display ( ) {  
		Node p=front;
		while( p!=null ) {
			System.out.println(p.getData( ));
			p=p.getNext();
		}
	}
 }
