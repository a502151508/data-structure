public class HuffmanTree extends BiTree
{
  public HuffmanTree(char[] cList, int[] wList)
    throws Exception
  {
	  	PriorityQueue PQueue = new PriorityQueue();
	  	PriorityQData PQData;
	  	for (int i = 0; i < wList.length; i++) 
	  	{
	  		PQData = new PriorityQData(new BiTreeNode(Character.valueOf(cList[i])), wList[i]);
	  		PQueue.offer(PQData);
	  	}

	  	while (PQueue.length() > 1) 
	  	{
	  		PriorityQData PQData1 = PQueue.poll();
	  		PQData = PQueue.poll();
	  		BiTreeNode localBiTreeNode1 = (BiTreeNode)PQData1.getElem();
	  		BiTreeNode localBiTreeNode2 = (BiTreeNode)PQData.getElem();
	  		BiTreeNode localBiTreeNode3 = new BiTreeNode();
	  		localBiTreeNode3.setLchild(localBiTreeNode1);
	  		localBiTreeNode3.setRchild(localBiTreeNode2);
	  		int j = PQData1.getPriority() + PQData.getPriority();
	  		PriorityQData pqd3=new PriorityQData(localBiTreeNode3, j);
	  		PQueue.offer(pqd3);
	  	}

	  	setRoot((BiTreeNode<?>)PQueue.poll().getElem());
  	}

  public void getHuffmanCode(BiTreeNode T, String code) {
 		if (T.getLchild() == null){
      	System.out.println(T.getData() + ": " + code);
 		}
 		else{
      	getHuffmanCode(T.getLchild(),code.concat("0"));
      	getHuffmanCode(T.getRchild(),code.concat("1"));
 		}
	}

}

