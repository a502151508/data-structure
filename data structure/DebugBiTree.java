package dataStructure;
import dataStructure.tree.BiTreeNode;
import dataStructure.tree.BiTree;

public class DebugBiTree {
	public static void main(String arg[]) throws Exception{
		BiTreeNode<Character> d = new BiTreeNode('D');
		BiTreeNode<Character> g = new BiTreeNode('G');
		BiTreeNode<Character> h = new BiTreeNode('H');
		BiTreeNode<Character> e = new BiTreeNode('E',g,null);
		BiTreeNode<Character> b = new BiTreeNode('B',d,e);
		BiTreeNode<Character> f = new BiTreeNode('F',null,h);
		BiTreeNode<Character> c = new BiTreeNode('C',f,null);
		BiTreeNode<Character> a = new BiTreeNode('A',b,c);

		BiTree<Character> bt1 = new BiTree(a);
		
		BiTreeNode<Character> root = bt1.getRoot();
		
		System.out.print("(递归)先根遍历序列为：");
		bt1.preRootTraverse(root);	System.out.println();
		System.out.print("(非递归)先根遍历序列为：");
		bt1.preRootTraverse();		System.out.println();
		
		
		System.out.print("(递归)中根遍历序列为：");
		bt1.inRootTraverse(root);	System.out.println();
		System.out.print("(非递归)中根遍历序列为：");
		bt1.inRootTraverse();	System.out.println();

		System.out.print("(递归)后根遍历序列为：");
		bt1.postRootTraverse(root);	System.out.println();
		System.out.print("(非递归)后根遍历序列为：");
		bt1.postRootTraverse();	System.out.println();

		System.out.println();
		System.out.print("层次遍历序列为：");
		bt1.levelTraverse();	System.out.println();
		
		System.out.println();
		System.out.print("查找--树中'F'的data为：" + bt1.searchNode(root,'F').getData());

		System.out.println();
		System.out.print("二叉树的结点个数为：" + bt1.countNode(root));

		System.out.println();
		System.out.print("二叉树的深度为：" + bt1.getDepth(root));

		System.out.println();
		System.out.print("二叉树的左子树与右子树相等为：" + bt1.isEqual(root.getLchild(),root.getRchild()));

		{
		System.out.println("\n\n");
		Character[] preOrder = {'A','B','D','E','G','C','F','H'};
		Character[] inOrder = {'D','B','G','E','A','F','H','C'};
		BiTree<Character> bt2 = new BiTree(preOrder,inOrder,0,0,preOrder.length);
		System.out.print("bt2树(递归)后根遍历序列为：");
		bt2.postRootTraverse(bt2.getRoot());
		}		

		{
		System.out.println("\n\n");
		Character[] preOrder = {'A','B',null,'D',null,null,'C',null,null};
		BiTree<Character> bt3 = new BiTree(preOrder);
		System.out.print("bt3树(递归)先根遍历序列为：");
		bt3.preRootTraverse(bt3.getRoot());	System.out.println();
		System.out.print("bt3树(递归)中根遍历序列为：");
		bt3.inRootTraverse(bt3.getRoot());	System.out.println();
		System.out.print("bt3树(递归)后根遍历序列为：");
		bt3.postRootTraverse(bt3.getRoot());
		}

		System.out.println();		
	}
}