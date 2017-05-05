public class BiTreeNode<E> {
	private E data; // 结点的数据域
	private BiTreeNode<E> lchild, rchild; // 左、右孩子域
	
	// 构造一个数据域和左、右孩子域都不为空的结点
	public BiTreeNode(E data, BiTreeNode<E> lchild, BiTreeNode<E> rchild) {
    	this.data = data;
	  	this.lchild = lchild;
	  	this.rchild = rchild;
	} 
	
	// 构造一个左、右孩子域为空的结点
	public BiTreeNode(E data) {
		this(data, null, null);
	} 
	
	// 构造一个空结点
	public BiTreeNode() {
		this(null);
	}

	public E getData(){
		return this.data;
	}	

	public BiTreeNode<E> getLchild(){
		return this.lchild;
	}	

	public BiTreeNode<E> getRchild(){
		return this.rchild;
	}	

	public void setData(E data){
		this.data = data;
	}	

	public void setLchild(BiTreeNode<E> lchild){
		this.lchild = lchild;
	}	

	public void setRchild(BiTreeNode<E> rchild){
		this.rchild = rchild;
	}
	
	public String toString() {
		return "" + data;
	}	
}
