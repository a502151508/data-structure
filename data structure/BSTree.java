package dataStructure.tree;
import dataStructure.linearList.RecordNode;
//import java.util.Scanner;

public class BSTree<E> extends BiTree<RecordNode<E>> {
	
	//在二叉排序树中查找关键字值为key的结点，若查找成功，则返回其值；否则返回null
	public RecordNode<E> searchBST(BiTreeNode<RecordNode<E>> T, Comparable key)	{
  		if (T != null) {
       		if (key.compareTo(T.getData().getKey()) == 0) //查找成功
              	return T.getData();
        	else if (key.compareTo(T.getData().getKey()) < 0)
              	return searchBST(T.getLchild(), key);     
     		else 
        		return searchBST(T.getRchild(), key);    
      	}
      	
      	return null;
	}
	
    //在二叉排序树中查找Key值最大的结点，若查找成功，则返回其值；否则返回null
    public RecordNode<E> getLargest(BiTreeNode<RecordNode<E>> T) {
    	if (T == null) return null;
    	
    	if (T.getRchild() == null) 
    		return T.getData();
    	else
    		return getLargest(T.getRchild());
    }

	//在二叉排序树中添加关键字值为key，数据为theElement的新结点
	public boolean insertBST(Comparable key,E theElement) {
    	if (key == null || theElement == null)  return false;

        if (root == null)
        	root = new BiTreeNode(new RecordNode(theElement, key)); //建立根结点
        else
        	insertBST(root,key,theElement);

        return true;
    }
	private void insertBST(BiTreeNode<RecordNode<E>> p, Comparable key,E theElement) {
       	if (key.compareTo(p.getData().getKey()) < 0)
			if (p.getLchild() == null)
				p.setLchild(new BiTreeNode(new RecordNode(theElement, key)));
			else
        		insertBST(p.getLchild(), key, theElement);
       	else
			if (p.getRchild() == null)
				p.setRchild(new BiTreeNode(new RecordNode(theElement, key)));
			else
        		insertBST(p.getRchild(), key, theElement);
    }
    
	//在二叉排序树中删除关键字值为key的结点，返回被删结点的值
	public RecordNode<E> removeBST(Comparable key) {
    	if (key == null || root == null)  return null;

		return removeBST(root, key, null);
    }
	private RecordNode<E> removeBST(BiTreeNode<RecordNode<E>> p, Comparable key, BiTreeNode<RecordNode<E>> parent) {
       	if (key.compareTo(p.getData().getKey()) < 0)
       		return removeBST(p.getLchild(), key, p);
       	else if (key.compareTo(p.getData().getKey()) > 0)
       		return removeBST(p.getRchild(), key, p);
       	else {	//key == p.getData().getKey()
			RecordNode<E> del = p.getData();
       		if (p.getLchild() != null && p.getRchild() != null){	//删除左右子树都不为空的结点
       			RecordNode<E> leftLargest = getLargest(p.getLchild());
       			p.setData(leftLargest);
       			removeBST(p.getLchild(), leftLargest.getKey(), p);
       		}
			else {
	 			if (parent == null)  //删除原树的度为0或1的根
	 				if (p.getLchild() != null)
	 					root = p.getLchild();
	 				else
	 					root = p.getRchild();
	       		else if (p == parent.getLchild())	//删除度为1或0，并且是双亲结点的左孩子的结点
		       		if (p.getLchild() != null) 
		       			parent.setLchild(p.getLchild());
		       		else
		       			parent.setLchild(p.getRchild());
		       	else if (p == parent.getRchild())	//删除度为1或0，并且是双亲结点的右孩子的结点
		       		if (p.getLchild() != null) 
		       			parent.setRchild(p.getLchild());
		       		else
		       			parent.setRchild(p.getRchild());
 			} 
			return del;
       	}
    }
	
}
