package dataStructure;
import dataStructure.Graph.ALGraph;
import dataStructure.Graph.VNode;
import dataStructure.Graph.ArcNode;
import dataStructure.Graph.GraphKind;

public class Examlpe_ALGraph {
	public static void main(String arg[]) throws Exception{
		{
		//图6.12中添加一个顶点G及一条弧CG，遍历测试
		VNode<Character> A,B,C,D,E,F,G;
		ArcNode ab,bc,be,cd,de,ef,fa,fb,cg;
		
		ab = new ArcNode(1);
		A = new VNode('A',ab);
		
		be = new ArcNode(4);
		bc = new ArcNode(2,be);
		B = new VNode('B',bc);
		
		cg = new ArcNode(6);
		cd = new ArcNode(3,cg);
		C = new VNode('C',cd);
		
		de = new ArcNode(4);
		D = new VNode('D',de);
				
		ef = new ArcNode(5);
		E = new VNode('E',ef);

		fb = new ArcNode(1);
		fa = new ArcNode(0,fb);
		F = new VNode('F',fa);

		G = new VNode('G');
		
		VNode[] vexs = {A,B,C,D,E,F,G};
		ALGraph<Character> alG1 = new ALGraph(GraphKind.DG, 7, 9, vexs);

		System.out.print("广度优先遍历顶点序列为："); 
		alG1.BFSTraverse();
		System.out.println();  

		System.out.print("深度优先遍历顶点序列为："); 
		alG1.DFSTraverse();
		System.out.println();  
		}
		
		{
		//图6.16(a) ，最小生成树测试
		VNode<String> v0,v1,v2,v3,v4,v5;
		ArcNode v0v1,v0v2,v0v3;
		ArcNode	v1v0,v1v2,v1v4;
		ArcNode v2v0,v2v1,v2v3,v2v4,v2v5;
		ArcNode v3v0,v3v2,v3v5;
		ArcNode v4v1,v4v2,v4v5;
		ArcNode v5v2,v5v3,v5v4;
		
		v0v3 = new ArcNode(3,5);
		v0v2 = new ArcNode(2,1,v0v3);
		v0v1 = new ArcNode(1,7,v0v2);
		v0 = new VNode("v0",v0v1);
		
		v1v4 = new ArcNode(4,3);
		v1v2 = new ArcNode(2,6,v1v4);
		v1v0 = new ArcNode(0,7,v1v2);
		v1 = new VNode("v1",v1v0);
		
		v2v5 = new ArcNode(5,4);
		v2v4 = new ArcNode(4,6,v2v5);
		v2v3 = new ArcNode(3,7,v2v4);
		v2v1 = new ArcNode(1,6,v2v3);
		v2v0 = new ArcNode(0,1,v2v1);
		v2 = new VNode("v2",v2v0);
		
		v3v5 = new ArcNode(5,2);
		v3v2 = new ArcNode(2,7,v3v5);
		v3v0 = new ArcNode(0,5,v3v2);
		v3 = new VNode("v3",v3v0);
				
		v4v5 = new ArcNode(5,7);
		v4v2 = new ArcNode(2,6,v4v5);
		v4v1 = new ArcNode(1,3,v4v2);
		v4 = new VNode("v4",v4v1);

		v5v4 = new ArcNode(4,7);
		v5v3 = new ArcNode(3,2,v5v4);
		v5v2 = new ArcNode(2,4,v5v3);
		v5 = new VNode("v5",v5v2);

		VNode[] vexs = {v0,v1,v2,v3,v4,v5};
		ALGraph<String> alG2 = new ALGraph(GraphKind.UDN, 6, 10, vexs);

		System.out.println("\n以顶点v0为根结点的最小生成树为："); 
		alG2.MinSpanTree_PRIM("v0");

		System.out.println("\n顶点v0至其他顶点的最短路径："); 
		alG2.ShortestPath_DIJ("v0");
		}
	}
}