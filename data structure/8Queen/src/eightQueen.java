import dataStructure.linearList.LinkList;
import dataStructure.linearList.LinkStack;
//������
class Board{
	public static final int rN = 8;
	public static final int cN = 8;
	private Item[][] itemElem;
	
	Board(){
		itemElem = new Item[rN][cN];
		for (int i=0;i<rN;i++)
			for (int j=0;j<cN;j++)
				itemElem[i][j] = new Item(i,j,0);
	}

	public Item getItem(int x,int y){
		if ( x<0 || x>=Board.rN || y<0 || y>=Board.cN )
			return null;
		return itemElem[x][y];
	}
	
	public void display(){
		for (int i=0;i<rN;i++){
			for (int j=0;j<cN;j++)
				System.out.print(" " + itemElem[i][j].getValue());
			System.out.println();
		}
	} 
}

//���̸���
class Item{
	private int x;	//x����
	private int y;	//y����
	private int value;	//0--��ǰ���̸�Ϊδ������1--��ǰ���̸�Ϊ�Ѿ���
	
	Item(int x,int y,int value){
			this.x = x;
			this.y = y;
			this.value = value;
	}
	
	public void setX(int x){
		this.x = x;
	}
	public void setY(int y){
		this.y = y;
	}
	public void setValue(int value){
		this.value = value;
	}
	public int getX(){
		return this.x;
	}
	public int getY(){
		return this.y;
	}
	public int getValue(){
		return this.value;
	}
	
	public String toString(){
		return "(" + x + "," + y +") ";
	}
}
public class eightQueen 
{
	public static void main(String arg[]) throws Exception
	{
		Board bd1 = new Board();
		LinkStack<Item> linkStack= new LinkStack<Item>();
		LinkList<Item> linkList= new LinkList<Item>();
		for (int i=Board.rN-1;i>=0;i--)		//������ȫ�����̸���Ϊ��ʼʱ�ĳ�ʼ��ѡ·������ջ
			for (int j=Board.cN-1;j>=0;j--)
				linkStack.push(bd1.getItem(i,j));	
		System.out.println("���ڼ����� ...");
		int count = 0;
		while (count < Board.cN ) 
		{
			Item item1;
		    item1 = linkStack.peek();
			if (item1.getValue() == 0 &&allRight(item1,linkList)) 
			{		//��ǰջ�����̸�Ϊ��ѡ·��
				item1.setValue(1);		//������Ϊȷ��·��
				pushNextStep(bd1,linkStack,item1);//����ջ�м�����һ���ĺ�ѡ���̸�	
			    linkList.insert(linkList.length(),item1);
			    count++;
			}
			else
			{	//��ǰ���̸�Ϊȷ��·�����������û����һ���ĺ�ѡ·��
				item1 = linkStack.pop();
			    item1.setValue(0);
			   
			    if(linkList.indexOf(item1)==-1)
			    {
			    	
			    }else
			    {
			    	linkList.remove(linkList.indexOf(item1));
			    	count--;
			    }
				if (linkStack.isEmpty()) 
						throw new Exception("����ʵ�ְ˻ʺ�");
			}
		}
		linkList.display();
	}
	public static void pushNextStep(Board bd, LinkStack<Item> ls, Item xy) throws Exception
	{
		Item nextItem;
		for (int j=0;j<Board.rN;j++)
		{
			for(int i=0;i<Board.cN;i++)
			{
				nextItem = bd.getItem(i, j);
				if(nextItem!=null && nextItem.getValue()==0)
					ls.push(nextItem);
			}
		}
	}
	static boolean setRight(Item m, Item n)
	{  //�ж��Ƿ��໥����
	    if(m.getX()==n.getX()||m.getY()==n.getY()||m.getY()-n.getY()==m.getX()-n.getX()||
	    m.getY()-n.getY()==n.getX()-m.getX())
	    {
	    	return true;
	    }
	
	    return false;
	
	 }
	
	static boolean allRight(Item item,LinkList<Item> linkList ) throws Exception
	{ 
		for(int i=0; i<linkList.length();i++)
		{
			Item item2=linkList.get(i);
			if(setRight(item,item2))
			{ 
				return false;
	        }
		}
		return true;   
	
	 }
}


