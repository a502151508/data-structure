package huffmanTree;

import dataStructure.linearList.PriorityQData;
import dataStructure.linearList.PriorityQueue;
import dataStructure.tree.HuffmanTree;

public class DebugHuffmanTree {
	public static void main(String[] args) throws Exception {  
		int[] wList = {7,2,2,3,11,2,2,6,6,1,1,4,3,7,9,2,1,6,6,8,4,1,2,1,2,1};
		char[] cList = {'A','B','C','D','E','F','G','H','I','J','K','L','M',
						'N','O','P','K','R','S','T','V','U','W','X','Y','Z'};

		
	 	HuffmanTree	hfmT = new HuffmanTree(cList,wList);
			
		hfmT.getHuffmanCode(hfmT.getRoot(),"");
		System.out.println();
		
	}
}


/*
public class HuffmanTree extends BiTree {
	public HuffmanTree(char[] cList, int[] wList) throws Exception {
		.......
	}
	
	//利用深度优先遍历求出huffman树的huffman编码
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


*/
