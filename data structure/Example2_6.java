package dataStructure;
import dataStructure.linearList.Node;
import dataStructure.linearList.LinkList;
import java.util.Scanner;

//一元多项式的项类
class Polyn {
   	private double coef; // 系数
	private int expn; // 指数
               
	// 构造函数
	public Polyn(double coef, int expn) { 
	    this.coef = coef;
	    this.expn = expn;
	}

	public double getCoef(){
		return coef;
	}

	public int getExpn(){
		return expn;
	}
	
	public void setCoef(double coef){
		this.coef = coef;
	}

	public void setExpn(int expn){
		this.expn = expn;
	}

	public String toString(){
		return "系数为：" + coef +",指数为：" + expn;
	}

  	public int compareTo(Polyn pn){
		if (this.expn < pn.getExpn())
			return -1;
		else if (this.expn == pn.getExpn())
			return 0;
		else
			return 1;
	}	
}

class PolynList extends LinkList{
	public void addPolynList(PolynList pl) {
		Node<Polyn> pc = this.getHead(); 
		Node<Polyn> pa = this.getHead().getNext();
		Node<Polyn> pb = pl.getHead().getNext();
		while (pa != null && pb != null) {
			Polyn PnA =  pa.getData();
			Polyn PnB =  pb.getData();
			
			switch (PnA.compareTo(PnB)) {
				case -1: // 多项式LA中当前结点的指数值小
					pc.setNext(pa);
					pc = pa;
					pa = pa.getNext();
					break;
				case 0:  // 两者的指数值相等
				    double sum = PnA.getCoef() + PnB.getCoef();         
				    if (sum != 0.0) {
				    	PnA.setCoef(sum);
					    pc.setNext(pa);
					    pc = pa;
					    pa = pa.getNext();
					    pb = pb.getNext();
					} 
				    else { 
					   	pa = pa.getNext();
				        pb = pb.getNext();
					}
				    break; 
				case 1:     // 多项式LB当前结点的指数值小
					pc.setNext(pb);
					pc = pb;
					pb = pb.getNext();
					break;
		    }
		}
		pc.setNext(pa != null ? pa : pb); //插入剩余结点	
	}
}

public class Example2_6 {
	public static void main (String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PolynList listA = new PolynList();
		PolynList listB = new PolynList();
		
		System.out.print("\n请输入多项式A的项数:");
		int n = sc.nextInt();
		for(int i = 0; i<n; i++){
			System.out.print("多项式A第" + i + "项（系数 指数）:");
			Polyn pn = new Polyn(sc.nextDouble(),sc.nextInt());
			listA.insert(i,pn);
		}

		System.out.print("\n请输入多项式B的项数:");
		n = sc.nextInt();
		for(int i = 0; i<n; i++){
			System.out.print("多项式B第" + i + "项（系数 指数）:");
			Polyn pn = new Polyn(sc.nextDouble(),sc.nextInt());
			listB.insert(i,pn);
		}
		
		System.out.println("\n多项式A:");
		listA.display();
		System.out.println("\n多项式B:");
		listB.display();
		System.out.println("\n多项式A与多项式B相加后的多项式为：");
		listA.addPolynList(listB);
		listA.display();
	}
}
