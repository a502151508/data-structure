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
		
		System.out.print("(�ݹ�)�ȸ���������Ϊ��");
		bt1.preRootTraverse(root);	System.out.println();
		System.out.print("(�ǵݹ�)�ȸ���������Ϊ��");
		bt1.preRootTraverse();		System.out.println();
		
		
		System.out.print("(�ݹ�)�и���������Ϊ��");
		bt1.inRootTraverse(root);	System.out.println();
		System.out.print("(�ǵݹ�)�и���������Ϊ��");
		bt1.inRootTraverse();	System.out.println();

		System.out.print("(�ݹ�)�����������Ϊ��");
		bt1.postRootTraverse(root);	System.out.println();
		System.out.print("(�ǵݹ�)�����������Ϊ��");
		bt1.postRootTraverse();	System.out.println();

		System.out.println();
		System.out.print("��α�������Ϊ��");
		bt1.levelTraverse();	System.out.println();
		
		System.out.println();
		System.out.print("����--����'F'��dataΪ��" + bt1.searchNode(root,'F').getData());

		System.out.println();
		System.out.print("�������Ľ�����Ϊ��" + bt1.countNode(root));

		System.out.println();
		System.out.print("�����������Ϊ��" + bt1.getDepth(root));

		System.out.println();
		System.out.print("�������������������������Ϊ��" + bt1.isEqual(root.getLchild(),root.getRchild()));

		{
		System.out.println("\n\n");
		Character[] preOrder = {'A','B','D','E','G','C','F','H'};
		Character[] inOrder = {'D','B','G','E','A','F','H','C'};
		BiTree<Character> bt2 = new BiTree(preOrder,inOrder,0,0,preOrder.length);
		System.out.print("bt2��(�ݹ�)�����������Ϊ��");
		bt2.postRootTraverse(bt2.getRoot());
		}		

		{
		System.out.println("\n\n");
		Character[] preOrder = {'A','B',null,'D',null,null,'C',null,null};
		BiTree<Character> bt3 = new BiTree(preOrder);
		System.out.print("bt3��(�ݹ�)�ȸ���������Ϊ��");
		bt3.preRootTraverse(bt3.getRoot());	System.out.println();
		System.out.print("bt3��(�ݹ�)�и���������Ϊ��");
		bt3.inRootTraverse(bt3.getRoot());	System.out.println();
		System.out.print("bt3��(�ݹ�)�����������Ϊ��");
		bt3.postRootTraverse(bt3.getRoot());
		}

		System.out.println();		
	}
}