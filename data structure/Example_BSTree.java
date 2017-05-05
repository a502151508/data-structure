package dataStructure;
import dataStructure.linearList.RecordNode;
import dataStructure.tree.*;

public class Example_BSTree {
	public static void main(String arg[]) {
		Student s1 = new Student("1023","����",19,"��Ϣ",79);
		Student s2 = new Student("1026","����",20,"��Ϣ",95);
		Student s3 = new Student("1011","����",18,"ͳ��",78);
		Student s4 = new Student("1013","����",21,"ͳ��",82);
		Student s5 = new Student("1016","Ǯ��",19,"ͳ��",75);
		Student s6 = new Student("1002","���",19,"����",88);
		Student s7 = new Student("1005","��ʮ",19,"����",71);
		Student s8 = new Student("1006","�ܶ�",19,"����",75);

		RecordNode<Student>	r1 = new RecordNode(s1, s1.getScore());	
		RecordNode<Student>	r2 = new RecordNode(s2, s2.getScore());	
		RecordNode<Student>	r3 = new RecordNode(s3, s3.getScore());	
		RecordNode<Student>	r4 = new RecordNode(s4, s4.getScore());	
		RecordNode<Student>	r5 = new RecordNode(s5, s5.getScore());	
		RecordNode<Student>	r6 = new RecordNode(s6, s6.getScore());	
		RecordNode<Student>	r7 = new RecordNode(s7, s7.getScore());	
		RecordNode<Student>	r8 = new RecordNode(s8, s8.getScore());	

		BSTree<Student> bst = new BSTree();
		
		bst.insertBST(s1.getScore(), s1);
		bst.insertBST(s2.getScore(), s2);
		bst.insertBST(s3.getScore(), s3);
		bst.insertBST(s4.getScore(), s4);
		bst.insertBST(s5.getScore(), s5);
		bst.insertBST(s6.getScore(), s6);
		bst.insertBST(s7.getScore(), s7);
		bst.insertBST(s8.getScore(), s8);

		System.out.println("�����������и������������Ϊ��");
		bst.inRootTraverse(bst.getRoot());
		System.out.println();

		System.out.println("�������������Keyֵ��������Ϊ��");
		System.out.println(bst.getLargest(bst.getRoot()));
		System.out.println();
		
		System.out.println("����������Keyֵ����82�Ľ�������Ϊ��");
		System.out.println(bst.searchBST(bst.getRoot(), 82f));
		System.out.println();

		RecordNode<Student> del = bst.removeBST(75f);
		System.out.println("��ɾ���Ϊ��");
		System.out.println(del);
		System.out.println("ɾ��Keyֵ����" + del.getKey() + "�������������и������������Ϊ��");
		bst.inRootTraverse(bst.getRoot());
		System.out.println();

		
	}
}