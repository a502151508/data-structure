package dataStructure;
import dataStructure.linearList.IList;
import dataStructure.linearList.Node;
import dataStructure.linearList.LinkList;

public class Example2_5 {
	public static void main (String[] args) throws Exception {
	    double a1[] = {0,2.1,4,6,8,10,12,14,16.5};
	    double a2[] = {1,3.1,5,7,9,10,11,13,15,17.6,19};
	      
	    LinkList<Double> listA = new LinkList();
	    for (int i=0;i<a1.length;i++){
	      	 listA.insert(i,a1[i]); 
	    }
	 	LinkList listB = new LinkList<Double>();
	    for (int i=0;i<a2.length;i++){
	      	 listB.insert(i,a2[i]); 
	    }
		
		System.out.println("有序单链表lista数据元素为：");
		listA.display();
		System.out.println("有序单链表listb数据元素为：");
		listB.display();
		System.out.println("将有序单链表lista和listb合并后，新的有序单链表的各个数据元素为：");	
		mergeLinkList(listA,listB).display();
	}


	public static LinkList mergeLinkList(LinkList LA, LinkList LB) {
		Node<Double> pa = LA.getHead().getNext();
		Node<Double> pb = LB.getHead().getNext();
		Node<Double> pc = LA.getHead();
		Double da, db;     // 结点值所对应的浮点数

		while (pa != null && pb != null) {
	    	da = pa.getData();
	    	db = pb.getData();
	    	if (da <= db) {
	    		pc.setNext(pa);
				pc = pa;
				pa = pa.getNext();
            } 
	    	else {
	    		pc.setNext(pb);
				pc = pb;
				pb = pb.getNext();
	    	}
	 	}
		pc.setNext(pa != null ? pa : pb); // 插入剩余结点

		return LA;
	} 
}

