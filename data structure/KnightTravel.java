package dataStructure;
import dataStructure.linearList.LinkStack;
import dataStructure.linearList.LinkList;

//��ʿ������������
public class KnightTravel{
	 
	public static void main(String arg[]) throws Exception{
		Board bd1 = new Board();
		LinkStack<Item> ls1 = new LinkStack();

		for (int i=bd1.rN-1;i>=0;i--)		//������ȫ�����̸���Ϊ��ʼʱ�ĳ�ʼ��ѡ·������ջ
			for (int j=bd1.cN-1;j>=0;j--)
				ls1.push(bd1.getItem(i,j));		

		System.out.println("���ڼ����� ...");
		int count = 0;
		while (count < Board.rN * Board.cN ) {
			Item item1;

			item1 = ls1.peek();
			if (item1.getValue() == 0) {		//��ǰջ�����̸�Ϊ��ѡ·��
				item1.setValue(1);	count++;	//������Ϊȷ��·��
				pushNextStep(bd1,ls1,item1);	//����ջ�м�����һ���ĺ�ѡ���̸�	
			}
			else{	//��ǰ���̸�Ϊȷ��·�����������û����һ���ĺ�ѡ·��
				item1 = ls1.pop();
				item1.setValue(0);	count--;
				if (ls1.isEmpty()) 
						throw new Exception("����ʵ����ʿ����");
			}
		}

		//���ls1�еı�ѡ���̸񣬽�ȷ������·�߰�˳����list��
		LinkList<Item> list = new LinkList();
		while (!ls1.isEmpty()) {
			Item item = ls1.pop();
			if (list.indexOf(item) == -1)	
				list.insert(0,item);	
		}
		
		list.display();
	}

	public static void pushNextStep(Board bd, LinkStack ls, Item xy) throws Exception{
		Item nextItem;

		nextItem = bd.getItem( xy.getX()+2, xy.getY()+1 );
		if ( nextItem!=null && nextItem.getValue()==0 ) 
			ls.push(nextItem);

		nextItem = bd.getItem( xy.getX()+2, xy.getY()-1 );
		if ( nextItem!=null && nextItem.getValue()==0 ) 
			ls.push(nextItem);

		nextItem = bd.getItem( xy.getX()+1, xy.getY()+2 );
		if ( nextItem!=null && nextItem.getValue()==0 ) 
			ls.push(nextItem);

		nextItem = bd.getItem( xy.getX()+1, xy.getY()-2 );
		if ( nextItem!=null && nextItem.getValue()==0 ) 
			ls.push(nextItem);

		nextItem = bd.getItem( xy.getX()-1, xy.getY()+2 );
		if ( nextItem!=null && nextItem.getValue()==0 ) 
			ls.push(nextItem);
		
		nextItem = bd.getItem( xy.getX()-1, xy.getY()-2 );
		if ( nextItem!=null && nextItem.getValue()==0 ) 
			ls.push(nextItem);

		nextItem = bd.getItem( xy.getX()-2, xy.getY()+1 );
		if ( nextItem!=null && nextItem.getValue()==0 ) 
			ls.push(nextItem);

		nextItem = bd.getItem( xy.getX()-2, xy.getY()-1 );
		if ( nextItem!=null && nextItem.getValue()==0 ) 
			ls.push(nextItem);
	}
}

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
		this.x = x;
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

