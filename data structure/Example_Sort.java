package dataStructure;
import dataStructure.linearList.RecordNode;
import dataStructure.linearList.SortSqList;

public class Example_Sort {
	public static void main(String arg[]) throws Exception {
		Student s1 = new Student("1023","����",19,"��Ϣ",79);
		Student s2 = new Student("1026","����",20,"��Ϣ",95);
		Student s3 = new Student("1011","����",18,"ͳ��",78);
		Student s4 = new Student("1013","����",21,"ͳ��",82);
		Student s5 = new Student("1016","Ǯ��",19,"ͳ��",75);
		Student s6 = new Student("1002","���",19,"����",88);
		Student s7 = new Student("1005","��ʮ",19,"����",71);
		Student s8 = new Student("1006","�ܶ�",19,"����",75);
		
		{
		RecordNode<Student>	r1 = new RecordNode(s1, s1.getID());	
		RecordNode<Student>	r2 = new RecordNode(s2, s2.getID());	
		RecordNode<Student>	r3 = new RecordNode(s3, s3.getID());	
		RecordNode<Student>	r4 = new RecordNode(s4, s4.getID());	
		RecordNode<Student>	r5 = new RecordNode(s5, s5.getID());	
		RecordNode<Student>	r6 = new RecordNode(s6, s6.getID());	
		RecordNode<Student>	r7 = new RecordNode(s7, s7.getID());	
		RecordNode<Student>	r8 = new RecordNode(s8, s8.getID());	

		SortSqList<Student> ssL = new SortSqList(18);
		ssL.insert(ssL.length(),r1);
		ssL.insert(ssL.length(),r2);
		ssL.insert(ssL.length(),r3);
		ssL.insert(ssL.length(),r4);
		ssL.insert(ssL.length(),r5);
		ssL.insert(ssL.length(),r6);
		ssL.insert(ssL.length(),r7);
		ssL.insert(ssL.length(),r8);
		
		System.out.println("����ǰ��ѧ���б�");
		ssL.display();
		
//		ssL.insertSort();
//		ssL.shellSort();
//		ssL.bubbleSort();
		ssL.quickSort();
//		ssL.selectSort();
		
		System.out.println("��ѧ��������ѧ���б�(��ѧ������)");
		ssL.display();

		}


		{
		RecordNode<Student>	r1 = new RecordNode(s1, s1.getScore());	
		RecordNode<Student>	r2 = new RecordNode(s2, s2.getScore());	
		RecordNode<Student>	r3 = new RecordNode(s3, s3.getScore());	
		RecordNode<Student>	r4 = new RecordNode(s4, s4.getScore());	
		RecordNode<Student>	r5 = new RecordNode(s5, s5.getScore());	
		RecordNode<Student>	r6 = new RecordNode(s6, s6.getScore());	
		RecordNode<Student>	r7 = new RecordNode(s7, s7.getScore());	
		RecordNode<Student>	r8 = new RecordNode(s8, s8.getScore());	

		SortSqList<Student> ssL = new SortSqList(18);
		ssL.insert(ssL.length(),r1);
		ssL.insert(ssL.length(),r2);
		ssL.insert(ssL.length(),r3);
		ssL.insert(ssL.length(),r4);
		ssL.insert(ssL.length(),r5);
		ssL.insert(ssL.length(),r6);
		ssL.insert(ssL.length(),r7);
		ssL.insert(ssL.length(),r8);
		
//		ssL.insertSort();
//		ssL.shellSort();
//		ssL.bubbleSort();
		ssL.quickSort();
//		ssL.selectSort();
		
		System.out.println("���ɼ�������ѧ���б�(���ɼ�����)");
		ssL.display();
		}
		
	}
}