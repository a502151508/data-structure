package dataStructure;
import dataStructure.linearList.SqList;
import java.util.Scanner;

public class Example2_2 {
	public static void main (String[] args) throws Exception {
      int n = 10;
      SqList<Integer> L = new SqList(80);
      for(int i = 0; i<n; i++)
      	 L.insert(i,i);
      
	  System.out.println("������ i ��ֵ��");
	  //ʹ��java.util�е�Scanner�����int��ֵ���ݵ�����
	  int i = new Scanner(System.in).nextInt();
	  
	  if(i>0 && i<=n){
	  	 Integer x = L.get(i - 1);
	  	 System.out.println("��" + i + "��Ԫ�ص�ֱ��ǰ���ǣ�" + x);
	  }
      else
		 System.out.println("��" + i + "��Ԫ�ص�ֱ��ǰ�������ڣ�");
	}
}
