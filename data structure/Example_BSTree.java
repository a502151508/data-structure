package dataStructure;
import dataStructure.linearList.RecordNode;
import dataStructure.tree.*;

public class Example_BSTree {
	public static void main(String arg[]) {
		Student s1 = new Student("1023","张三",19,"信息",79);
		Student s2 = new Student("1026","李四",20,"信息",95);
		Student s3 = new Student("1011","王五",18,"统计",78);
		Student s4 = new Student("1013","赵六",21,"统计",82);
		Student s5 = new Student("1016","钱七",19,"统计",75);
		Student s6 = new Student("1002","孙九",19,"金融",88);
		Student s7 = new Student("1005","陈十",19,"金融",71);
		Student s8 = new Student("1006","周二",19,"金融",75);

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

		System.out.println("二叉排序树中根遍历结点序列为：");
		bst.inRootTraverse(bst.getRoot());
		System.out.println();

		System.out.println("二叉排序树最大Key值结点的数据为：");
		System.out.println(bst.getLargest(bst.getRoot()));
		System.out.println();
		
		System.out.println("二叉排序树Key值等于82的结点的数据为：");
		System.out.println(bst.searchBST(bst.getRoot(), 82f));
		System.out.println();

		RecordNode<Student> del = bst.removeBST(75f);
		System.out.println("被删结点为：");
		System.out.println(del);
		System.out.println("删除Key值等于" + del.getKey() + "，二叉排序树中根遍历结点序列为：");
		bst.inRootTraverse(bst.getRoot());
		System.out.println();

		
	}
}