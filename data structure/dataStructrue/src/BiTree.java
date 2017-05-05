public class BiTree<E> {
	protected BiTreeNode<E> root; // ���ĸ���� 
	
	// ����һ�ÿ���
	public BiTree () {
		this.root=null;
	}
	
	// ����һ�ø����Ϊroot����
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
	//���ȸ����и��������н�������
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
	//���ȸ����и��������н�������
	public BiTree (E[] preOrder, E[] inOrder) {
		int i,count=preOrder.length;
		if (count >0){
			//���Ҹ������inOrder�е��±�i
			E r = preOrder[0];
			for(i = 0; i < count; i++)
				if(r == inOrder[i])
					break;
			this.root = new BiTreeNode(r);
			
			//������������ProOrder��InOrder����
			E[] lSubtreeProOrder =(E[]) new Object[i];
			E[] lSubtreeInOrder =(E[]) new Object[i];
			for(int j =0; j <= i-1; j++){
				lSubtreeProOrder[j] = preOrder[j+1];
			}
			for(int j =0; j <= i-1; j++){
				lSubtreeInOrder[j] = inOrder[j];
			}

			//������������ProOrder��InOrder����
			E[] rSubtreeProOrder =(E[]) new Object[count-i-1];
			E[] rSubtreeInOrder =(E[]) new Object[count-i-1];
			for(int j =0; j <= count-i-2; j++){
				rSubtreeProOrder[j] = preOrder[j+i+1];
			}
			for(int j =0; j <= count-i-2; j++){
				rSubtreeInOrder[j] = inOrder[j+i+1];
			}

			//�ø÷�������ԭ������������
			BiTree lSubtree = new BiTree(lSubtreeProOrder,lSubtreeInOrder);
			BiTree rSubtree = new BiTree(rSubtreeProOrder,rSubtreeInOrder);
			
			root.setLchild(lSubtree.root);
			root.setRchild(rSubtree.root);
		}else
			this.root = null;
	}
	
	//�ɱ������������ȸ��������н���������
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

	//������ȱ���֮�ȸ������ĵݹ��㷨
	public void preRootTraverse(BiTreeNode<E> T) { 
		if (T != null) {
			System.out.println(T.getData());	//���ʸ����
			preRootTraverse(T.getLchild());	//�ȸ�����������
			preRootTraverse(T.getRchild());	//�ȸ�����������
		}
	}

	//������ȱ���֮�и������ĵݹ��㷨
	public void inRootTraverse(BiTreeNode<E> T) { 
		if (T != null) {
			inRootTraverse(T.getLchild());
			System.out.println(T.getData());
			inRootTraverse(T.getRchild());
		}
	}

	//������ȱ���֮��������ĵݹ��㷨
	public void postRootTraverse(BiTreeNode<E> T) { 
		if (T != null) {
			postRootTraverse(T.getLchild());
			postRootTraverse(T.getRchild());
			System.out.println(T.getData());
		}
	}

	//������ȱ���֮�ȸ������ķǵݹ��㷨
	public void preRootTraverse() throws Exception { 
		BiTreeNode<E> T = this.root;
		if (T != null) {
			LinkStack<BiTreeNode<E>> S = new LinkStack();
			S.push(T);		//�������ջ
			while(!S.isEmpty()) {
				T = S.pop();
				System.out.println(T.getData());	//���ʵ�ǰջ�����
   				if (T.getRchild() != null)
   					S.push(T.getRchild());			//��ǰ�����Һ��ӽ����ջ
   				if (T.getLchild() != null)
					S.push(T.getLchild());			//��ǰ�������ӽ����ջ
			}
		}
	}

	//������ȱ���֮�и������ķǵݹ��㷨
	public void inRootTraverse() throws Exception { 
		BiTreeNode<E> T = this.root;
		if (T != null) {
			LinkStack<BiTreeNode<E>> S = new LinkStack();
			S.push(T);		//�������ջ
			while(!S.isEmpty()) {
				while (S.peek() != null) 	//��ǰջ���������ӽ���...���ӽ��...���ν�ջ
					S.push(S.peek().getLchild());

				T = S.pop();	//����ջ��һ��null����/�ң����ӽ���ջ
				if (!S.isEmpty()) {
					T = S.pop();
					System.out.print(T.getData());	//���ʵ�ǰջ�����
					S.push(T.getRchild());			//��ǰ�����Һ��ӽ����ջ
				}
			}
		}
	}

	//������ȱ���֮��������ķǵݹ��㷨
	public void postRootTraverse() throws Exception { 
		BiTreeNode<E> T = this.root;
		if (T != null) {
			LinkStack<BiTreeNode<E>> S = new LinkStack();
			S.push(T);				//�������ջ
			BiTreeNode<E> p = null;
			while(!S.isEmpty()) {
				while (S.peek() != null) 	//��ǰջ���������ӽ��...���ӽ��...���ν�ջ
					S.push(S.peek().getLchild());

				T = S.pop();		//����ջ��һ��null���ӽ���ջ

				while (!S.isEmpty()) {
					T = S.peek();
					if (T.getRchild() == null || T.getRchild() == p) {
						T = S.pop();
						System.out.println(T.getData());	//���ʵ�ǰջ�����
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

	//������ȱ��㷨
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

	//���ҵݹ��㷨
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

	//ͳ�ƶ�����������
	public int countNode(BiTreeNode<E> T) {
		if (T == null)
			return 0;
		else 
			return 1 + countNode(T.getLchild()) + countNode(T.getRchild());
	}
	//ͳ�ƶ�������Ҷ�ӽ��ĸ���
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

	//������������
	public int getDepth(BiTreeNode<E> T) {
		if (T == null)
			return 0;
		else {
			int lDepth = getDepth(T.getLchild());
			int rDepth = getDepth(T.getRchild());
			return 1 + (lDepth > rDepth ? lDepth : rDepth);
		}
	}	

	//�����������
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
