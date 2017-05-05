package dataStructure.linearList;

public class SqStack<E> implements IStack<E> {
	private E[] stackElem; 
	private int top; 

    //构造一个容量为maxSize的空栈
    public SqStack (int maxSize) { 
		stackElem = (E[]) new Object[maxSize];
		top = 0;
    }

	// 栈置空
   	public void clear( ) {
		top= 0;
   	}

    // 栈判空
	public boolean isEmpty( ) {
		return  top== 0;
	}

	// 求栈数据元素个数函数
    public int length( ) {
		return top;
    }

  	// 取栈顶元素的函数
  	public E peek ( ) {
		if (!isEmpty())      // 栈非空
			return stackElem[top-1]; // 栈顶元素
		else
		return null;
  	}	

	//入栈
	public void push (E x) throws Exception {
		if (top == stackElem.length) 
			throw new Exception("栈已满");
		else
		    stackElem[top++] = x; 
	}  

	//出栈
	public E pop () {
		if (isEmpty() ) 
			return null;
		else
			return stackElem[--top];
	}  
	
	// 输出函数(从栈顶到栈底)
	public void display ()   {  
		for (int i = top - 1; i >= 0; i--)
			System.out.println(stackElem[i]);
	}
}
