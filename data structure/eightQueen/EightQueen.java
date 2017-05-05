package eightQueen;

import dataStructure.linearList.LinkList;
import dataStructure.linearList.LinkStack;
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
public class EightQueen {
public static void main(String arg[]) throws Exception{
		Board bd1 = new Board();
		LinkStack<Item> ls1 = new LinkStack();
		LinkList<Item> l1= new LinkList();
		for (int i=Board.rN-1;i>=0;i--)		//将棋盘全部棋盘格作为开始时的初始候选路径加入栈
			for (int j=Board.cN-1;j>=0;j--)
				ls1.push(bd1.getItem(i,j));	
       
		System.out.println("正在计算中 ...");
		int count = 0;
		while (count < Board.cN ) {
			Item item1;
		    item1 = ls1.peek();
			if (item1.getValue() == 0 &&isFine(item1,l1)) {		//当前栈顶棋盘格为候选路径
				item1.setValue(1);		//将其作为确定路径
				pushNextStep(bd1,ls1,item1);//并向栈中加入下一步的候选棋盘格	
			    l1.insert(l1.length(),item1);
			    count++;
			}
			else{	//当前棋盘格为确定路径，并且其后没有下一步的候选路径
				item1 = ls1.pop();
			    item1.setValue(0);
			   
			    if(l1.indexOf(item1)==-1)
			    {
			    	
			    }else{
			    	l1.remove(l1.indexOf(item1));
			    	count--;
			    }
				if (ls1.isEmpty()) 
						throw new Exception("不能实现八皇后");
			}
		}

		
		
		l1.display();
}
			
		







public static void pushNextStep(Board bd, LinkStack ls, Item xy) throws Exception{
		Item nextItem;
		
	 for (int j=0;j<bd.rN;j++){
			for(int i=0;i<bd.cN;i++){
		    nextItem = bd.getItem(i, j);
				if(nextItem!=null && nextItem.getValue()==0)
					ls.push(nextItem);
			}
			}
	}
static boolean isAttack(Item m, Item n){  //判断是否相互攻击
	      int x1 = m.getX();
	      int x2 = n.getX();
          int y1 = m.getY();
	      int y2 = n.getY();
	    if(x1==x2||y1==y2||y1-y2==x1-x2||y1-y2==x2-x1){
	
	            return true;
	
	        }
	
	        return false;
	
	    }
	
 static boolean isFine(Item item,LinkList<Item> l1 ) throws Exception{
	 
	 for(int i=0; i<l1.length();i++){
	  Item item2=l1.get(i);
	    if(isAttack(item,item2)){ //之前所有的数组元素和这时的数组元素之间判断是否攻击
	          return false;
	          
	   }
	}
	return true;   
	
	        }
}


