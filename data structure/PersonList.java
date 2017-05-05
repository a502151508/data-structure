package dataStructure;
import dataStructure.linearList.SqList;
//import dataStructure.linearList.Node;
//import dataStructure.linearList.LinkList;
import java.util.Scanner;

public class PersonList {
	public static void main (String[] args) throws Exception {
      SqList list1 = new SqList<Person>(80);
	  //LinkList list1 = new LinkList<Person>();
      Person p1,p2,p3;
      
	  p1 = new Person("张三",19);
	  list1.insert(0,p1);
	  p1 = new Person("李四",20);
	  list1.insert(1,p1);
	  p1 = new Person("王五",21);
	  list1.insert(2,p1);
	  p1 = new Person("赵六",22);
	  list1.insert(2,p1);

	  System.out.println("姓名\t年龄");
	  list1.display();

  	  System.out.println("请输入被查询人的信息（姓名及年龄）：");
  	  Scanner sc = new Scanner(System.in);

	  p2 = new Person(sc.next(),sc.nextInt());
	  int loc = list1.indexOf(p2);
	  if (loc>=0){
	  	p3 = (Person)list1.get(loc);
	  	System.out.println("\n线性表中被查询人位置序号为：" + loc + "  " + p3.getName() + "  " + p3.getAge());
	  }
	  else
	  	System.out.println("线性表中没有被查询人");
	}
}
