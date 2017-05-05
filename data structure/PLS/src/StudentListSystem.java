import java.util.Scanner;

import dataStructure.IList;
import dataStructure.LinkList;


public class StudentListSystem {
		public static void main (String[] args) throws Exception {
		   	IList list1 = new LinkList<Student>();
		   	//IList list1 = new SqList<Student>(20);
		
		   	String option = "";
	        Scanner sc = new Scanner(System.in);
		   	while (!option.equals("q") && !option.equals("Q"))
		    {
		        option = menu();
		        if (option.equals("a") || option.equals("A")) {
		            System.out.print("\n请输入新增人的信息（姓名，年龄，学号，专业）：");
		            Student s1 = new Student(sc.next(),sc.nextInt(),sc.nextInt(),sc.next());
					list1.insert(list1.length(),s1);
	                System.out.println(s1.getName() + "--  已被加入线性表！");
				}else if (option.equals("d") || option.equals("D")) {
		            if (list1.isEmpty()) {
		            	System.out.println("\n线性表目前是空表，不能进行删除操作！");	            	
		            	continue;
		            }	
		            System.out.print("\n请输入被删除人的信息（学号）：");
		            Student s1 = new Student("",0,sc.nextInt(),"");
		            int i = list1.indexOf(s1);		            
		            if (i == -1)
		            	System.out.print("\n被删除人" + s1.getName() + "不存在!");
		            else{
		            	Student s2=(Student) list1.get(i);
			            list1.remove(i);
			            
			            System.out.println( s2.getName()+ "--  已从线性表中移除！");
		            }
				}else if (option.equals("p") || option.equals("P")) {
		  				System.out.println("姓名\t年龄\t学号\t专业");
		  				System.out.println("----------------");
		                list1.display();
		        }
				else if (option.equals("s") || option.equals("S"))
				{
					System.out.println("\n请输入学生的学号以查询 ：");
					Student s1 = new Student("",0,sc.nextInt(),"");
					int i= list1.indexOf(s1);
					 if (i == -1)
			            	{System.out.print("\n查询学号：   " + s1.getNum() + "不存在此学号!");
					 continue;}				 
					 else
					 {
						 System.out.println("姓名\t年龄\t学号\t专业");
						 System.out.println("------------------------------------");
						 Student s2=(Student)list1.get(i);
						 System.out.print(s2.getName()+"\t");
						 System.out.print(s2.getAge()+"\t");
						 System.out.print(s2.getNum()+"\t");
						 System.out.print(s2.getSpe());
					 }
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
			System.out.print("S: 查询信息\n");
			System.out.print("Q: 退出系统\n");
			System.out.print("\n");
			valid = false;
			while (valid == false)
			{
				System.out.print("请输入你的选择<A, D, P, Q>: ");
			    choice = new Scanner(System.in).next();
			    System.out.println();
			    if ("AaDdPpQqsS".indexOf(choice) != -1)
			    	valid = true;
			    else
			    	System.out.print("\n操作选择错误！");
			}
			return choice;
		}
	}

