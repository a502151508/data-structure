package dataStructure;
import dataStructure.tree.BiTreeNode;
import dataStructure.tree.BiTree;

class Example_BiTree {
	public static void main(String arg[]) throws Exception {
/*		
		//生成p170 图5.16的树
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
		

 		//由先根和中根遍历序列生成p170 图5.16的树
		Character[] preOrder = {'A','B','D','E','G','C','F','H'};
		Character[] inOrder = {'D','B','G','E','A','F','H','C'};
		//BiTree<Character> T = new BiTree(preOrder,inOrder,0,0,preOrder.length);
		BiTree<Character> T = new BiTree(preOrder,inOrder);

/*		
 		//由标明空子树的先根遍历序列生成p170 图5.16的树
		Character[] preOrder = {'A','B','D',null,null,'E','G',null,null,null,'C','F',null,'H',null,null,null};
		BiTree<Character> T = new BiTree(preOrder);
*/		

		System.out.println("层次遍历：");
		T.levelTraverse();
		System.out.println();
		
		System.out.println("先根遍历：");
		T.preRootTraverse(T.getRoot());
		System.out.println();

		System.out.println("中根遍历：");
		T.inRootTraverse(T.getRoot());
		System.out.println();

		System.out.println("后根遍历：");
		T.postRootTraverse(T.getRoot());
		System.out.println();

	}
}