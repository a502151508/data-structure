package dataStructure;
import dataStructure.linearList.LinkStack;
import dataStructure.linearList.LinkList;
import java.awt.*;
import javax.swing.*;

//骑士周游主程序类
public class KnightTravel_GUI_2{
	public static void main(String arg[]) throws Exception{
		Board bd1 = new Board();
		LinkStack<Item> ls1 = new LinkStack();

		for (int i=bd1.rN-1;i>=0;i--)		//将棋盘全部棋盘格作为第一步初始候选路径加入栈
			for (int j=bd1.cN-1;j>=0;j--)
				ls1.push(bd1.getItem(i,j));		

		System.out.println("正在计算中 ...");
		int count = 0;
		Item fstItem = null;
Item it=null;	
		while (count < Board.rN * Board.cN ) {
			Item item1,item2;
			if (count == 0) fstItem = ls1.peek();
			
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
		
			if (count == Board.rN * Board.cN) {
//System.out.println("1111111111111");  
if (fstItem != it)
{	System.out.println(fstItem.toString());it = fstItem;
}
				if (fstItemIsNext(bd1,fstItem,item1))
				{
//System.out.println("22222222222222");  
					ls1.push(fstItem);
				}	
				else{
//System.out.println("33333333333333");  
					item1 = ls1.pop();
					item1.setValue(0);	count--;
				}
			}
			
		}

		//清除ls1中的备选棋盘格，将确定周游路线按顺序倒入list中
		LinkList<Item> list = new LinkList();
		while (!ls1.isEmpty()) {
			Item item = ls1.pop();
			if (list.indexOf(item) == -1 || item == fstItem)	list.insert(0,item);	
		}
		
//		list.display();
 		System.out.println("周游开始。。。");     	
		KnightTravelShow(list);
	}
	
	public static boolean fstItemIsNext(Board bd,Item fstItem,Item item){
		if (fstItem == bd.getItem(item.getX()+2, item.getY()+1) ||
		    fstItem == bd.getItem(item.getX()+2, item.getY()-1) ||
		    fstItem == bd.getItem(item.getX()+1, item.getY()+2) ||
		    fstItem == bd.getItem(item.getX()+1, item.getY()-2) ||
		    fstItem == bd.getItem(item.getX()-1, item.getY()+2) ||
		    fstItem == bd.getItem(item.getX()-1, item.getY()-2) ||
		    fstItem == bd.getItem(item.getX()-2, item.getY()+1) ||
		    fstItem == bd.getItem(item.getX()-2, item.getY()-1) )
		    return true;
		else
			return false;
	}

	public static int pushNextStep(Board bd, LinkStack ls, Item xy) throws Exception{
		int i = 0;
		Item nextItem;


		nextItem = bd.getItem( xy.getX()+2, xy.getY()+1 );
		if ( nextItem!=null && nextItem.getValue()==0 ) {
			i++;
			ls.push(nextItem);
		}

		nextItem = bd.getItem( xy.getX()+2, xy.getY()-1 );
		if ( nextItem!=null && nextItem.getValue()==0 ) {
			i++;
			ls.push(nextItem);
		}

		nextItem = bd.getItem( xy.getX()+1, xy.getY()+2 );
		if ( nextItem!=null && nextItem.getValue()==0 ) {
			i++;
			ls.push(nextItem);
		}

		nextItem = bd.getItem( xy.getX()+1, xy.getY()-2 );
		if ( nextItem!=null && nextItem.getValue()==0 ) {
			i++;
			ls.push(nextItem);
		}

		nextItem = bd.getItem( xy.getX()-1, xy.getY()+2 );
		if ( nextItem!=null && nextItem.getValue()==0 ) {
			i++;
			ls.push(nextItem);
		}
		
		nextItem = bd.getItem( xy.getX()-1, xy.getY()-2 );
		if ( nextItem!=null && nextItem.getValue()==0 ) {
			i++;
			ls.push(nextItem);
		}

		nextItem = bd.getItem( xy.getX()-2, xy.getY()+1 );
		if ( nextItem!=null && nextItem.getValue()==0 ) {
			i++;
			ls.push(nextItem);
		}

		nextItem = bd.getItem( xy.getX()-2, xy.getY()-1 );
		if ( nextItem!=null && nextItem.getValue()==0 ) {
			i++;
			ls.push(nextItem);
		}

		return i;
	}

	public static void KnightTravelShow(LinkList<Item> ls) throws Exception{
		JFrame win = new JFrame("骑士周游");
      	win.setLayout(new GridLayout(Board.rN,Board.cN));
      	JLabel label[][]=new JLabel[Board.rN][Board.cN];
      	for(int i=0;i<Board.rN;i++)
      	{  	for(int j=0;j<Board.cN;j++)
         	{  	label[i][j]=new JLabel();
         		label[i][j].setOpaque(true);//背景不透明设置为ture
            	if((i+j)%2==0)
               		label[i][j].setBackground(Color.black);
            	else
               		label[i][j].setBackground(Color.white);
            	win.add(label[i][j]); 
         	}
      	}
      	win.setBounds(200,180,360,360);
      	win.setVisible(true);
 
		Item item = null;
		Item fstItem = ls.get(0);
 		for (int i =0;i<ls.length();i++){
			if(item!=null) 
				if(item == fstItem)
					label[item.getX()][item.getY()].setText("  Start...");
				else
					label[item.getX()][item.getY()].setText("  。。。");
 			item = ls.get(i);
//			System.out.println(item.getX()+","+item.getY());
      		label[item.getX()][item.getY()].setForeground(Color.red);
			label[item.getX()][item.getY()].setText("  ☆☆");
			long sum = 0;
			for (int j=1;j<1000000000;j++){sum = sum +j;}
 		}
 		JOptionPane.showMessageDialog(win,"周游完成...","骑士周游",JOptionPane.WARNING_MESSAGE);
 		System.exit(0);
 		//System.out.println("周游完成。。。");     	
	}
}

//棋盘类
class Board{
	public static final int rN = 7;
	public static final int cN = 4;
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

