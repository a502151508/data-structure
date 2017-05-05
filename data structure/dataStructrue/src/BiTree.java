public class BiTree<E> {
	protected BiTreeNode<E> root; // 树的根结点 
	
	// 构造一棵空树
	public BiTree () {
		this.root=null;
	}
	
	// 构造一棵根结点为root的树
	public BiTree(BiTreeNode<E> root) {
		this.root=root;
	} 

	public BiTreeNode<E> getRoot() {
		return this.root;
	}

	public void setRoot(BiTreeNode<E> root) {
		this.root = root;
	}

/*		
	//由先根和中根遍历序列建二叉树
	public BiTree (E[] preOrder, E[] inOrder, int preIndex, int inIndex, int count) {
		int i;
		if (count >0){
			E r = preOrder[preIndex];
			for(i = 0; i < count; i++)
				if(r == inOrder[i+inIndex])
					break;
			this.root = new BiTreeNode(r);

			BiTree lSubtree = new BiTree(preOrder,inOrder,preIndex+1,inIndex,i);
			BiTree rSubtree = new BiTree(preOrder,inOrder,preIndex+i+1,inIndex+i+1,count-i-1);
			
			root.setLchild(lSubtree.root);
			root.setRchild(rSubtree.root);
		}
	}
*/
	//由先根和中根遍历序列建二叉树
	public BiTree (E[] preOrder, E[] inOrder) {
		int i,count=preOrder.length;
		if (count >0){
			//查找根结点在inOrder中的下标i
			E r = preOrder[0];
			for(i = 0; i < count; i++)
				if(r == inOrder[i])
					break;
			this.root = new BiTreeNode(r);
			
			//构造左子树的ProOrder及InOrder序列
			E[] lSubtreeProOrder =(E[]) new Object[i];
			E[] lSubtreeInOrder =(E[]) new Object[i];
			for(int j =0; j <= i-1; j++){
				lSubtreeProOrder[j] = preOrder[j+1];
			}
			for(int j =0; j <= i-1; j++){
				lSubtreeInOrder[j] = inOrder[j];
			}

			//构造右子树的ProOrder及InOrder序列
			E[] rSubtreeProOrder =(E[]) new Object[count-i-1];
			E[] rSubtreeInOrder =(E[]) new Object[count-i-1];
			for(int j =0; j <= count-i-2; j++){
				rSubtreeProOrder[j] = preOrder[j+i+1];
			}
			for(int j =0; j <= count-i-2; j++){
				rSubtreeInOrder[j] = inOrder[j+i+1];
			}

			//用该方法构造原树的左、右子树
			BiTree lSubtree = new BiTree(lSubtreeProOrder,lSubtreeInOrder);
			BiTree rSubtree = new BiTree(rSubtreeProOrder,rSubtreeInOrder);
			
			root.setLchild(lSubtree.root);
			root.setRchild(rSubtree.root);
		}else
			this.root = null;
	}
	
	//由标明空子树的先根遍历序列建立二叉树
	private static int index = 0;
	public BiTree (E[] preOrder) {
		E r = preOrder[index++];
		if (r != null){
			this.root = new BiTreeNode(r);
			root.setLchild(new BiTree(preOrder).root);
			root.setRchild(new BiTree(preOrder).root);
		}
		else
			this.root = null;
	}

	//深度优先遍历之先根遍历的递归算法
	public void preRootTraverse(BiTreeNode<E> T) { 
		if (T != null) {
			System.out.println(T.getData());	//访问根结点
			preRootTraverse(T.getLchild());	//先根遍历左子树
			preRootTraverse(T.getRchild());	//先根遍历右子树
		}
	}

	//深度优先遍历之中根遍历的递归算法
	public void inRootTraverse(BiTreeNode<E> T) { 
		if (T != null) {
			inRootTraverse(T.getLchild());
			System.out.println(T.getData());
			inRootTraverse(T.getRchild());
		}
	}

	//深度优先遍历之后根遍历的递归算法
	public void postRootTraverse(BiTreeNode<E> T) { 
		if (T != null) {
			postRootTraverse(T.getLchild());
			postRootTraverse(T.getRchild());
			System.out.println(T.getData());
		}
	}

	//深度优先遍历之先根遍历的非递归算法
	public void preRootTraverse() throws Exception { 
		BiTreeNode<E> T = this.root;
		if (T != null) {
			LinkStack<BiTreeNode<E>> S = new LinkStack();
			S.push(T);		//根结点入栈
			while(!S.isEmpty()) {
				T = S.pop();
				System.out.println(T.getData());	//访问当前栈顶结点
   				if (T.getRchild() != null)
   					S.push(T.getRchild());			//当前结点的右孩子结点入栈
   				if (T.getLchild() != null)
					S.push(T.getLchild());			//当前结点的左孩子结点入栈
			}
		}
	}

	//深度优先遍历之中根遍历的非递归算法
	public void inRootTraverse() throws Exception { 
		BiTreeNode<E> T = this.root;
		if (T != null) {
			LinkStack<BiTreeNode<E>> S = new LinkStack();
			S.push(T);		//根结点入栈
			while(!S.isEmpty()) {
				while (S.peek() != null) 	//当前栈顶结点的左孩子结点的...左孩子结点...依次进栈
					S.push(S.peek().getLchild());

				T = S.pop();	//最后进栈的一个null（左/右）孩子结点出栈
				if (!S.isEmpty()) {
					T = S.pop();
					System.out.print(T.getData());	//访问当前栈顶结点
					S.push(T.getRchild());			//当前结点的右孩子结点入栈
				}
			}
		}
	}

	//深度优先遍历之后根遍历的非递归算法
	public void postRootTraverse() throws Exception { 
		BiTreeNode<E> T = this.root;
		if (T != null) {
			LinkStack<BiTreeNode<E>> S = new LinkStack();
			S.push(T);				//根结点入栈
			BiTreeNode<E> p = null;
			while(!S.isEmpty()) {
				while (S.peek() != null) 	//当前栈顶结点的左孩子结点...左孩子结点...依次进栈
					S.push(S.peek().getLchild());

				T = S.pop();		//最后进栈的一个null左孩子结点出栈

				while (!S.isEmpty()) {
					T = S.peek();
					if (T.getRchild() == null || T.getRchild() == p) {
						T = S.pop();
						System.out.println(T.getData());	//访问当前栈顶结点
						p = T;
					}
					else {
						S.push(T.getRchild());
						break;
					}
				}
			}
		}
	}

	//广度优先遍算法
	public void levelTraverse() throws Exception {
		BiTreeNode<E> T=this.root;
		if (T !=null ) {
			LinkQueue<BiTreeNode<E>> L=new LinkQueue();
			L.offer(T);
			while(!L.isEmpty())  {
				T = L.poll();
				System.out.println(T.getData());
				if (T.getLchild() != null)
      				L.offer(T.getLchild());
				if (T.getRchild() != null)
      				L.offer(T.getRchild());
			}
		}
	}

	//查找递归算法
	public BiTreeNode<E> searchNode(BiTreeNode<E> T, E x) {
		BiTreeNode<E> result = null;

		if (T != null) {
			if (T.getData().equals(x))
				result = T;
			else {
				result = searchNode(T.getLchild(), x);
				if (result == null)
					result = searchNode(T.getRchild(), x);
			}
		}
		
		return result;
	}

	//统计二叉树结点个数
	public int countNode(BiTreeNode<E> T) {
		if (T == null)
			return 0;
		else 
			return 1 + countNode(T.getLchild()) + countNode(T.getRchild());
	}
	//统计二叉树中叶子结点的个数
	public int countLeaf(BiTreeNode<E> T)
	{
		int t=0;
		if(T==null)
			return 0;
		else 
		{
			if(T.getLchild()==null&&T.getRchild()==null)
			{
				t=1;
			}
			else 
			{
				t=countLeaf(T.getLchild())+countLeaf(T.getRchild());
			}
			return t;
		}
			
			
		
	}

	//求二叉树的深度
	public int getDepth(BiTreeNode<E> T) {
		if (T == null)
			return 0;
		else {
			int lDepth = getDepth(T.getLchild());
			int rDepth = getDepth(T.getRchild());
			return 1 + (lDepth > rDepth ? lDepth : rDepth);
		}
	}	

	//二叉树的相等
	public boolean isEqual(BiTreeNode<E> T1, BiTreeNode<E> T2) {
		if (T1 == null && T2 == null)
			return true;

		if (T1 != null && T2 != null) 
			if ( T1.getData().equals(T2.getData()) &&
				 isEqual(T1.getLchild(),T2.getLchild()) &&
				 isEqual(T1.getRchild(),T2.getRchild()) )
				return true;

		return false;
	}	
}
