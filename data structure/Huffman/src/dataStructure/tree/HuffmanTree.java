package dataStructure.tree;
import dataStructure.linearList.PriorityQData;
import dataStructure.linearList.PriorityQueue;

public class HuffmanTree extends BiTree
{
  public HuffmanTree(char[] paramArrayOfChar, int[] paramArrayOfInt)
    throws Exception
  {
    PriorityQueue PQ = new PriorityQueue();
    PriorityQData PQData2;
    for (int i = 0; i < paramArrayOfInt.length; i++) {
    	PQData2 = new PriorityQData(new BiTreeNode(Character.valueOf(paramArrayOfChar[i])), paramArrayOfInt[i]);
      PQ.offer(PQData2);
    }

    while (PQ.length() > 1) {
      PriorityQData PQData1 = PQ.poll();
      PQData2 = PQ.poll();
      BiTreeNode localBiTreeNode1 = (BiTreeNode)PQData1.getElem();
      BiTreeNode localBiTreeNode2 = (BiTreeNode)PQData2.getElem();
      BiTreeNode localBiTreeNode3 = new BiTreeNode();
      localBiTreeNode3.setLchild(localBiTreeNode1);
      localBiTreeNode3.setRchild(localBiTreeNode2);
      int j = PQData1.getPriority() + PQData2.getPriority();
      PQ.offer(new PriorityQData(localBiTreeNode3, j));
    }

    setRoot((BiTreeNode)PQ.poll().getElem());
  }

  public void getHuffmanCode(BiTreeNode paramBiTreeNode, String paramString)
  {
    if (paramBiTreeNode.getLchild() == null) {
      System.out.println(paramBiTreeNode.getData() + ": " + paramString);
    }
    else {
      getHuffmanCode(paramBiTreeNode.getLchild(), paramString.concat("0"));
      getHuffmanCode(paramBiTreeNode.getRchild(), paramString.concat("1"));
    }
  }
}

