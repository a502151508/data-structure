
public class builtTree {
	public static void main(String[] args) {
		Integer[] pOrder = {49,12,8,5,10,35,15,65,88,68};
	    Integer[] iOrder = {5,8,10,12,15,35,49,65,68,88};
		BiTree<Integer> T = new BiTree(pOrder,iOrder);
		

		System.out.println("�ö�������Ҷ�����"+T.countLeaf(T.getRoot())+"��");
		
		System.out.println("�ö��������������ݽ��Data������ֵ�ĺϼ�ֵΪ"+count(T.getRoot()));
		
	}
	//��dataֵ
	static int count(BiTreeNode<Integer> T){
		 if (T == null)
				return 0;
		 else 
			return T.getData() + count(T.getLchild()) + count(T.getRchild());
		 
			
		}
}
