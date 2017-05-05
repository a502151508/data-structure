package dataStructure;
import dataStructure.linearList.LinkStack;
import dataStructure.linearList.LinkList;
import java.awt.*;
import javax.swing.*;

//��ʿ������������
public class KnightTravel_GUI{
	public static void main(String arg[]) throws Exception{
		Board bd1 = new Board();
		LinkStack<Item> ls1 = new LinkStack();

		for (int i=bd1.rN-1;i>=0;i--)		//������ȫ�����̸���Ϊ��һ����ʼ��ѡ·������ջ
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
			if (list.indexOf(item) == -1)	list.insert(0,item);	
		}
		
//		list.display();
 		System.out.println("���ο�ʼ������");     	
		KnightTravelShow(list);
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
		JFrame win = new JFrame("��ʿ����");
      	win.setLayout(new GridLayout(Board.rN,Board.cN));
      	JLabel label[][]=new JLabel[Board.rN][Board.cN];
      	for(int i=0;i<Board.rN;i++)
      	{  	for(int j=0;j<Board.cN;j++)
         	{  	label[i][j]=new JLabel();
         		label[i][j].setOpaque(true);//������͸������Ϊture
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
 		for (int i =0;i<ls.length();i++){
			if(item!=null) 
				label[item.getX()][item.getY()].setText("  ������");
 			item = ls.get(i);
//			System.out.println(item.getX()+","+item.getY());
      		label[item.getX()][item.getY()].setForeground(Color.red);
			label[item.getX()][item.getY()].setText("  ���");
			long sum = 0;
			for (int j=1;j<1000000000;j++){sum = sum +j;}
 		}
 		JOptionPane.showMessageDialog(win,"�������...","��ʿ����",JOptionPane.WARNING_MESSAGE);
 		System.exit(0);
 		//System.out.println("������ɡ�����");     	
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

