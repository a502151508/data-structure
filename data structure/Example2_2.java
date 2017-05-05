package dataStructure;
import dataStructure.linearList.SqList;
import java.util.Scanner;

public class Example2_2 {
	public static void main (String[] args) throws Exception {
      int n = 10;
      SqList<Integer> L = new SqList(80);
      for(int i = 0; i<n; i++)
      	 L.insert(i,i);
      
	  System.out.println("请输入 i 的值：");
	  //使用java.util中的Scanner类进行int数值数据的输入
	  int i = new Scanner(System.in).nextInt();
	  
	  if(i>0 && i<=n){
	  	 Integer x = L.get(i - 1);
	  	 System.out.println("第" + i + "个元素的直接前驱是：" + x);
	  }
      else
		 System.out.println("第" + i + "个元素的直接前驱不存在！");
	}
}
