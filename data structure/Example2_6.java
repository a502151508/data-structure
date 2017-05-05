package dataStructure;
import dataStructure.linearList.Node;
import dataStructure.linearList.LinkList;
import java.util.Scanner;

//һԪ����ʽ������
class Polyn {
   	private double coef; // ϵ��
	private int expn; // ָ��
               
	// ���캯��
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
		return "ϵ��Ϊ��" + coef +",ָ��Ϊ��" + expn;
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
				case -1: // ����ʽLA�е�ǰ����ָ��ֵС
					pc.setNext(pa);
					pc = pa;
					pa = pa.getNext();
					break;
				case 0:  // ���ߵ�ָ��ֵ���
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
				case 1:     // ����ʽLB��ǰ����ָ��ֵС
					pc.setNext(pb);
					pc = pb;
					pb = pb.getNext();
					break;
		    }
		}
		pc.setNext(pa != null ? pa : pb); //����ʣ����	
	}
}

public class Example2_6 {
	public static void main (String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PolynList listA = new PolynList();
		PolynList listB = new PolynList();
		
		System.out.print("\n���������ʽA������:");
		int n = sc.nextInt();
		for(int i = 0; i<n; i++){
			System.out.print("����ʽA��" + i + "�ϵ�� ָ����:");
			Polyn pn = new Polyn(sc.nextDouble(),sc.nextInt());
			listA.insert(i,pn);
		}

		System.out.print("\n���������ʽB������:");
		n = sc.nextInt();
		for(int i = 0; i<n; i++){
			System.out.print("����ʽB��" + i + "�ϵ�� ָ����:");
			Polyn pn = new Polyn(sc.nextDouble(),sc.nextInt());
			listB.insert(i,pn);
		}
		
		System.out.println("\n����ʽA:");
		listA.display();
		System.out.println("\n����ʽB:");
		listB.display();
		System.out.println("\n����ʽA�����ʽB��Ӻ�Ķ���ʽΪ��");
		listA.addPolynList(listB);
		listA.display();
	}
}
