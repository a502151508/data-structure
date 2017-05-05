package eightQueen;
import java.awt.*;
import javax.swing.*;


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
public class EightQueen_GUI {
public static void main(String arg[]) throws Exception{
		Board bd1 = new Board();
		LinkStack<Item> ls1 = new LinkStack();
		LinkList<Item> l1= new LinkList();
		for (int i=Board.rN-1;i>=0;i--)		//������ȫ�����̸���Ϊ��ʼʱ�ĳ�ʼ��ѡ·������ջ
			for (int j=Board.cN-1;j>=0;j--)
				ls1.push(bd1.getItem(i,j));	
       
		System.out.println("���ڼ����� ...");
		int count = 0;
		while (count < Board.cN ) {
			Item item1;
		    item1 = ls1.peek();
			if (item1.getValue() == 0 &&isFine(item1,l1)) {		//��ǰջ�����̸�Ϊ��ѡ·��
				item1.setValue(1);		//������Ϊȷ��·��
				pushNextStep(bd1,ls1,item1);//����ջ�м�����һ���ĺ�ѡ���̸�	
			    l1.insert(l1.length(),item1);
			    count++;
			}
			else{	//��ǰ���̸�Ϊȷ��·�����������û����һ���ĺ�ѡ·��
				item1 = ls1.pop();
			    item1.setValue(0);
			   
			    if(l1.indexOf(item1)==-1)
			    {
			    	
			    }else{
			    	l1.remove(l1.indexOf(item1));
			    	count--;
			    }
				if (ls1.isEmpty()) 
						throw new Exception("����ʵ�ְ˻ʺ�");
			}
		}

		
		
		l1.display();
		System.out.println("�˻ʺ�ʼ������");     	
		EightQueenShow(l1);
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
static boolean isAttack(Item m, Item n){  //�ж��Ƿ��໥����
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
	    if(isAttack(item,item2)){ //֮ǰ���е�����Ԫ�غ���ʱ������Ԫ��֮���ж��Ƿ񹥻�
	          return false;
	          
	   }
	}
	return true;   
	
	        }
 public static void EightQueenShow(LinkList<Item> ls) throws Exception{
	JFrame win = new JFrame("�˻ʺ�����");
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
		JOptionPane.showMessageDialog(win,"�˻ʺ����...","�˻ʺ�����",JOptionPane.WARNING_MESSAGE);
		System.exit(0);
		//System.out.println("������ɡ�����");     	
	}
}



