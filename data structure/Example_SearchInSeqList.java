package dataStructure;
import dataStructure.linearList.RecordNode;
import dataStructure.linearList.SortSqList;

public class Example_SearchInSeqList {
	public static void main(String arg[]) throws Exception {
		Student s1 = new Student("1023","张三",19,"信息",79);
		Student s2 = new Student("1026","李四",20,"信息",95);
		Student s3 = new Student("1011","王五",18,"统计",78);
		Student s4 = new Student("1013","赵六",21,"统计",82);
		Student s5 = new Student("1016","钱七",19,"统计",75);
		Student s6 = new Student("1002","孙九",19,"金融",88);
		Student s7 = new Student("1005","陈十",19,"金融",71);
		Student s8 = new Student("1006","周二",19,"金融",75);
		
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
		
		System.out.println("排序前的学生列表");
		ssL.display();
		
		int index = ssL.seqSearch("1016");
//		int index = ssL.seqSearchWithGuard("1016");
//		ssL.bubbleSort();
//		int index = ssL.binarySearch("1016");

		System.out.println("查找学号为1016的学生信息：");
		Student s = ssL.get(index).getElem();
		System.out.println(s);
		System.out.println();
	}
}