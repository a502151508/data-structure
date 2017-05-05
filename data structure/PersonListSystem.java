package dataStructure;
import dataStructure.linearList.IList;
import dataStructure.linearList.LinkList;
//import dataStructure.linearList.SqList;
import java.util.Scanner;

public class PersonListSystem {
	public static void main (String[] args) throws Exception {
	   	IList list1 = new LinkList<Person>();
	   	//IList list1 = new SqList<Person>(20);
	
	   	String option = "";
        Scanner sc = new Scanner(System.in);
	   	while (!option.equals("q") && !option.equals("q"))
	    {
	        option = menu();
	        if (option.equals("a") || option.equals("A")) {
	            System.out.print("\n请输入新增人的信息（姓名及年龄）：");
	            Person p1 = new Person(sc.next(),sc.nextInt());
				list1.insert(list1.length(),p1);
                System.out.println(p1.getName() + "--  已被加入线性表！");
			}else if (option.equals("d") || option.equals("D")) {
	            if (list1.isEmpty()) {
	            	System.out.println("\n线性表目前是空表，不能进行删除操作！");	            	
	            	continue;
	            }	
	            System.out.print("\n请输入被删除人的信息（姓名及年龄）：");
	            Person p1 = new Person(sc.next(),sc.nextInt());
	            int i = list1.indexOf(p1);
	            
	            if (i == -1)
	            	System.out.print("\n被删除人" + p1.getName() + "不存在!");
	            else{
		            list1.remove(i);
		            System.out.println(p1.getName() + "--  已从线性表中移除！");
	            }
			}else if (option.equals("p") || option.equals("P")) {
	  				System.out.println("姓名\t年龄");
	  				System.out.println("----------------");
	                list1.display();
	        }
	        System.out.println();
	   }
	   list1.clear();
	   System.out.println("谢谢使用本系统，再见。。。");
	}


	public static String menu() {
		boolean valid;
		String choice = "";
		System.out.print("\n---操作---\n");
		System.out.print("\n");
		System.out.print("A: 增加新人\n");
		System.out.print("D: 删除老人\n");
		System.out.print("P: 显示列表\n");
		System.out.print("Q: 退出系统\n");
		System.out.print("\n");
		valid = false;
		while (valid == false)
		        {
		        System.out.print("请输入你的选择<A, D, P, Q>: ");
		        choice = new Scanner(System.in).next();
		        System.out.println();
		        if ("AaDdPpQq".indexOf(choice) != -1)
		                valid = true;
		        else
		                System.out.print("\n操作选择错误！");
		        }
		return choice;
	}
}