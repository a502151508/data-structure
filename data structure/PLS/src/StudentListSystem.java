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
		            System.out.print("\n�����������˵���Ϣ�����������䣬ѧ�ţ�רҵ����");
		            Student s1 = new Student(sc.next(),sc.nextInt(),sc.nextInt(),sc.next());
					list1.insert(list1.length(),s1);
	                System.out.println(s1.getName() + "--  �ѱ��������Ա�");
				}else if (option.equals("d") || option.equals("D")) {
		            if (list1.isEmpty()) {
		            	System.out.println("\n���Ա�Ŀǰ�ǿձ����ܽ���ɾ��������");	            	
		            	continue;
		            }	
		            System.out.print("\n�����뱻ɾ���˵���Ϣ��ѧ�ţ���");
		            Student s1 = new Student("",0,sc.nextInt(),"");
		            int i = list1.indexOf(s1);		            
		            if (i == -1)
		            	System.out.print("\n��ɾ����" + s1.getName() + "������!");
		            else{
		            	Student s2=(Student) list1.get(i);
			            list1.remove(i);
			            
			            System.out.println( s2.getName()+ "--  �Ѵ����Ա����Ƴ���");
		            }
				}else if (option.equals("p") || option.equals("P")) {
		  				System.out.println("����\t����\tѧ��\tרҵ");
		  				System.out.println("----------------");
		                list1.display();
		        }
				else if (option.equals("s") || option.equals("S"))
				{
					System.out.println("\n������ѧ����ѧ���Բ�ѯ ��");
					Student s1 = new Student("",0,sc.nextInt(),"");
					int i= list1.indexOf(s1);
					 if (i == -1)
			            	{System.out.print("\n��ѯѧ�ţ�   " + s1.getNum() + "�����ڴ�ѧ��!");
					 continue;}				 
					 else
					 {
						 System.out.println("����\t����\tѧ��\tרҵ");
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
		   System.out.println("ллʹ�ñ�ϵͳ���ټ�������");
		}


		public static String menu() {
			boolean valid;
			String choice = "";
			System.out.print("\n---����---\n");
			System.out.print("\n");
			System.out.print("A: ��������\n");
			System.out.print("D: ɾ������\n");
			System.out.print("P: ��ʾ�б�\n");
			System.out.print("S: ��ѯ��Ϣ\n");
			System.out.print("Q: �˳�ϵͳ\n");
			System.out.print("\n");
			valid = false;
			while (valid == false)
			{
				System.out.print("���������ѡ��<A, D, P, Q>: ");
			    choice = new Scanner(System.in).next();
			    System.out.println();
			    if ("AaDdPpQqsS".indexOf(choice) != -1)
			    	valid = true;
			    else
			    	System.out.print("\n����ѡ�����");
			}
			return choice;
		}
	}

