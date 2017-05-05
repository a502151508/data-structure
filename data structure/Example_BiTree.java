package dataStructure;
import dataStructure.tree.BiTreeNode;
import dataStructure.tree.BiTree;

class Example_BiTree {
	public static void main(String arg[]) throws Exception {
/*		
		//����p170 ͼ5.16����
		BiTreeNode<Character> nodeA = new BiTreeNode('A');
		BiTreeNode<Character> nodeB = new BiTreeNode('B');
		BiTreeNode<Character> nodeC = new BiTreeNode('C');
		BiTreeNode<Character> nodeD = new BiTreeNode('D');
		BiTreeNode<Character> nodeE = new BiTreeNode('E');
		BiTreeNode<Character> nodeF = new BiTreeNode('F');
		BiTreeNode<Character> nodeG = new BiTreeNode('G');
		BiTreeNode<Character> nodeH = new BiTreeNode('H');

		BiTree<Character> T = new BiTree(nodeA);
		nodeA.setLchild(nodeB);
		nodeA.setRchild(nodeC);
		nodeB.setLchild(nodeD);
		nodeB.setRchild(nodeE);
		nodeC.setLchild(nodeF);
		nodeE.setLchild(nodeG);
		nodeF.setRchild(nodeH);
*/		
		

 		//���ȸ����и�������������p170 ͼ5.16����
		Character[] preOrder = {'A','B','D','E','G','C','F','H'};
		Character[] inOrder = {'D','B','G','E','A','F','H','C'};
		//BiTree<Character> T = new BiTree(preOrder,inOrder,0,0,preOrder.length);
		BiTree<Character> T = new BiTree(preOrder,inOrder);

/*		
 		//�ɱ������������ȸ�������������p170 ͼ5.16����
		Character[] preOrder = {'A','B','D',null,null,'E','G',null,null,null,'C','F',null,'H',null,null,null};
		BiTree<Character> T = new BiTree(preOrder);
*/		

		System.out.println("��α�����");
		T.levelTraverse();
		System.out.println();
		
		System.out.println("�ȸ�������");
		T.preRootTraverse(T.getRoot());
		System.out.println();

		System.out.println("�и�������");
		T.inRootTraverse(T.getRoot());
		System.out.println();

		System.out.println("���������");
		T.postRootTraverse(T.getRoot());
		System.out.println();

	}
}