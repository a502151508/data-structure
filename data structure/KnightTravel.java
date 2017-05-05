package dataStructure;
import dataStructure.linearList.LinkStack;
import dataStructure.linearList.LinkList;

//骑士周游主程序类
public class KnightTravel{
	 
	public static void main(String arg[]) throws Exception{
		Board bd1 = new Board();
		LinkStack<Item> ls1 = new LinkStack();

		for (int i=bd1.rN-1;i>=0;i--)		//将棋盘全部棋盘格作为开始时的初始候选路径加入栈
			for (int j=bd1.cN-1;j>=0;j--)
				ls1.push(bd1.getItem(i,j));		

		System.out.println("正在计算中 ...");
		int count = 0;
		while (count < Board.rN * Board.cN ) {
			Item item1;

			item1 = ls1.peek();
			if (item1.getValue() == 0) {		//当前栈顶棋盘格为候选路径
				item1.setValue(1);	count++;	//将其作为确定路径
				pushNextStep(bd1,ls1,item1);	//并向栈中加入下一步的候选棋盘格	
			}
			else{	//当前棋盘格为确定路径，并且其后没有下一步的候选路径
				item1 = ls1.pop();
				item1.setValue(0);	count--;
				if (ls1.isEmpty()) 
						throw new Exception("不能实现骑士周游");
			}
		}

		//清除ls1中的备选棋盘格，将确定周游路线按顺序倒入list中
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

//棋盘类
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

//棋盘格类
class Item{
	private int x;	//x坐标
	private int y;	//y坐标
	private int value;	//0--当前棋盘格为未经过；1--当前棋盘格为已经过
	
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

