package dataStructure;

public class SqList<E> implements IList<E> {
	protected E[] listElem,listElemB; 
	protected int curLen; 

	//构造方法，构造一个容量为0顺序表      
    public SqList () { 
		curLen = 0;  
		listElem = null;                  
	}

	//构造方法，构造一个容量为maxSize的空顺序表      
    public SqList (int maxSize) { 
		curLen = 0; 
		listElem = (E[]) new Object[maxSize];                   
	}
    
	// 顺序表置空
   	public void clear( ) {
		curLen = 0; 
   	}

	// 判空
	public boolean isEmpty( ) {
		return curLen == 0;
	}

	// 求顺序表长度
    public int length( ) {
		return curLen; 
    }

	// 读取顺序表中位置序号为i的元素的数据
  	public E get (int i) throws Exception {
		if (i < 0 || i > curLen - 1)
        	throw new Exception("第" + i + "个元素不存在"); 
        return listElem[i]; 
  	}

	// 插入操作
	public void insert (int i, E x) throws Exception {
		if (curLen == listElem.length)
//       throw new Exception("顺序表已满"); 
		{
			listElemB = (E[]) new Object[curLen*2]; 
			for(int a =0;a<curLen;a++)
			{
				listElemB[a] = listElem[a];
			}
			System.out.println("线性表扩张"+curLen*2);
			for (int j = curLen; j > i; j--)     //后移
				listElemB[j] = listElemB[j - 1];  
		        listElemB[i] = x;    //插入 
				curLen++;    //表长加1  
			listElem=listElemB;
		}
		else{
		 if (i < 0 || i > curLen)   // i不合法
            throw new Exception("插入位置不合法");
		for (int j = curLen; j > i; j--)     //后移
           listElem[j] = listElem[j - 1];
           
        listElem[i] = x;    //插入 
		curLen++;    //表长加1  
	}}

	// 删除操作
	public void remove (int i) throws Exception {
		if (this.isEmpty())
			throw new Exception("顺序表已空");	
		if (i < 0 || i > curLen - 1)
           throw new Exception("删除位置不合法");

		for (int j = i; j < curLen - 1; j++)     //前移
          listElem[j] = listElem[j + 1];
		
		curLen--;     //表长减1
	}

	// 查找操作
	public int indexOf (E x) {
		int j = 0;
		
		while (j < curLen && !listElem[j].equals(x))
			j++;
		
		if (j < curLen)
       		return  j;  
 		else
       		return -1; 
	}

	//输出线性表的数据元素
	public void display() {
		for (int j = 0; j < curLen; j++)
			System.out.println(listElem[j]);
		System.out.println();
	}
}

