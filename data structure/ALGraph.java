package dataStructure.Graph;
import dataStructure.linearList.LinkQueue;

public class ALGraph<E> implements IGraph<E> {
	private GraphKind kind;		//图的类型
	private int vexNum, arcNum;	//图中顶点数、边（弧）数
	private VNode<E>[] vexs;	//图的顶点数组
	
	public ALGraph() {
		this(null,0,0,null);
	}

	public ALGraph(GraphKind kind, int vexNum, int arcNum, VNode<E>[] vexs) {
		this.kind = kind;
		this.vexNum = vexNum;
		this.arcNum = arcNum;
		this.vexs = vexs;
	}
	
	public GraphKind getKind() {
		return kind;
	}

	public int getVexNum() {
		return vexNum;
	}

	public int getArcNum() {
		return arcNum;
	}

	public VNode<E>[] getVexs() {
		return vexs;
	}

	//获取顶点位置序号为v的顶点的数据
	public E getVex(int v) throws Exception {
		if (v < 0 || v >= vexNum)
		      throw new Exception("第" + v + "个顶点不存在!");
		return vexs[v].getData();
	}
	
	//获取顶点值为vex的顶点的位序号
	public int locateVex(E vex) {
		for (int i = 0; i < vexNum; i++)
			if (vexs[i].getData().equals(vex))
				return i;  

		return -1;  
	}	
	
	//获取位置序号为v的顶点的第一个邻接点的位序号
	public int firstAdjVex(int v) throws Exception {
      	if (v < 0 || v >= vexNum)
			throw new Exception("第" + v + "个顶点不存在!");

		if (vexs[v].getFirstArc() != null)
			return vexs[v].getFirstArc().getAdjVex();

		return -1;
	}

	//获取位置序号为v的顶点的位序号为w的邻接点的下一个邻接点
	public int nextAdjVex(int v, int w) throws Exception {
      	if (v < 0 || v >= vexNum)
			throw new Exception("第" + v + "个顶点不存在!");
		
		ArcNode arcVW = null;
		ArcNode arc = vexs[v].getFirstArc();
		while (arc != null)	{
			if (arc.getAdjVex() == w) {
				arcVW = arc;
				break;
			}else
				arc = arc.getNextArc();
		}
		
		if (arcVW != null && arcVW.getNextArc() != null)
			return arcVW.getNextArc().getAdjVex();
		else
			return -1;	
	}
	
	//获取起始顶点位置序号为initVex，终止顶点位置序号为termVex的边
	public ArcNode getArc (int initVex, int termVex) throws Exception {
		if (initVex < 0 || initVex >= vexNum)
		      throw new Exception("第" + initVex + "个顶点不存在!");

		if (termVex < 0 || termVex >= vexNum)
		      throw new Exception("第" + termVex + "个顶点不存在!");

		ArcNode arc = vexs[initVex].getFirstArc();	//arc指向起始顶点的第一条边
		while (arc != null && arc.getAdjVex() != termVex) {
			arc = arc.getNextArc();		//arc指向起始顶点的下一条边
		}
		
		return arc;
	}

	//广度优先遍历
	public void BFSTraverse() throws Exception {
		boolean[] visited = new boolean[vexNum];	//初始化辅助数组visited
		for (int i = 0; i < vexNum; i++) {
			visited[i] = false;
		}

		LinkQueue<Integer> lq = new LinkQueue();	//创建辅助队列，数据元素为顶点的位置序号
		
		for (int v = 0; v < vexNum; v++) {			//依次访问图中的所有连通分量（或强连通分量）
			if (!visited[v]) {
				lq.offer(v);						//指定顶点v入队
				while (!lq.isEmpty()) {
					int u = lq.poll();				//辅助队列队首顶点出队
					System.out.print(vexs[u].getData() + " ");	//访问该顶点
					visited[u] = true;				//标记该顶点为true

					//将刚出队的顶点的所有未被访问的邻接点加入辅助队列中
					for (int w = firstAdjVex(u); w>=0; w = nextAdjVex(u,w)) 	
						if (!visited[w])	
							lq.offer(w);	
				}
			}
		}

	}
	
	//深度优先遍历
	private boolean[] visited  ;
	public void DFSTraverse() throws Exception {
		visited = new boolean[vexNum];	//初始化visited数组
		for (int i = 0; i < vexNum; i++) {
			visited[i] = false;
		}

		for (int v = 0; v < vexNum; v++)			//依次访问图中的所有连通分量（或强连通分量）
			if (!visited[v]) 
				DFS(v);
	}

	private void DFS (int v) throws Exception {
		visited[v] = true;							//标记该顶点为true
		System.out.print(vexs[v].getData() + " ");	//访问该顶点
		
		//使用DFS(),依次遍历包含该顶点的未被访问的邻接点的子图
		for (int w = firstAdjVex(v); w>=0; w = nextAdjVex(v,w)) 
			if (!visited[w])
				DFS(w);	
	}
	
	//判断无向图（网）是否为是连通的
	public boolean isConnected() {
		//...作业哈
		return true; 
	}

	
	//普里姆算法构造最小生成树
	private class CloseEdge<E> {	//内部类，辅助数组元素对象类。记录集合V-U的顶点到集合U的边
		E startVex;		//集合U中的顶点
		E endVex;		//集合V-U中的顶点
		int lowCost;	//该边的权
		boolean isOK;	//标记，该边是否已在最小生成树中
		
		public CloseEdge (E startVex,E endVex,int lowCost,boolean isOK) {
			this.startVex = startVex;
			this.endVex = endVex;
			this.lowCost = lowCost;
			this.isOK = isOK;
		}

//		public void display(){	//测试用
//			System.out.println(startVex + "-" + endVex +"\t" + lowCost + "\t" + isOK);
//		}
	}

	public void MinSpanTree_PRIM (E u) throws Exception {
		if (kind != GraphKind.UDN || !isConnected())
			throw new Exception("非无向连通网，不能生成最小生成树！");
		
		//创建辅助数组closeEdge，记录最小生成树的生成过程中集合V-U的所有顶点到集合U的距离最小的边
		CloseEdge<E>[] closeEdge = new CloseEdge[vexNum];	

		int s = locateVex(u);	//最小生成树的根顶点位置序号
		
		for (int i = 0; i < vexNum; i++) {	//初始化辅助数组closeEdge
			if (i != s) {
				if (getArc(s,i) != null)
					closeEdge[i] = new CloseEdge(u,getVex(i),getArc(s,i).getValue(),false);
				else
					closeEdge[i] = new CloseEdge(u,getVex(i),Integer.MAX_VALUE,false);
			} else
					closeEdge[i] = new CloseEdge(u,u,0,true);
		}
		
		for (int i = 1; i < vexNum; i++){				//循环n-1次，产生最小生成树的边
			//求代表顶点集合U与顶点集合V-U的距离的边,d为该边在数组closeEdge的下标以及该边的endVex顶点序号
			int d = getMinMum(closeEdge);				
			closeEdge[d].isOK = true;			//该边或弧加入最小生成树中,并且位置序号为d的顶点加入U集中			
			
			//序号为d的顶点加入集合U后，调整辅助数组
			for (int j = 0; j < vexNum; j++){	
				ArcNode arcDJ = getArc(d,j);			//arcDJ为顶点d与j的关联边或弧
				if (arcDJ != null && closeEdge[j].isOK == false)
					if (arcDJ.getValue() < closeEdge[j].lowCost) {
						closeEdge[j].startVex = getVex(d);
						closeEdge[j].lowCost = arcDJ.getValue();
					}
			}
		}

		//输出结果
		for (int i = 0; i < vexNum; i++){
			if (closeEdge[i].startVex == closeEdge[i].endVex) continue;	//根结点与根结点的边
			System.out.print(closeEdge[i].startVex + " - " + closeEdge[i].endVex + "\t");
			System.out.print("\t" + closeEdge[i].lowCost);
			System.out.println();
		}		
	}
	
	//求集合U与集合V-U 距离最短的边，返回其在辅助数组中的下标
	private int getMinMum(CloseEdge<E>[] closeEdge) {
		int min = Integer.MAX_VALUE;
		int minIndex = -1;
		for (int i = 0; i < closeEdge.length; i++)
			if (closeEdge[i].isOK == false && closeEdge[i].lowCost < min) {
				min = closeEdge[i].lowCost;
				minIndex = i;
			}
				
		return minIndex;
	}
	
	//迪杰斯特拉算法构造最短路径
	private class ShortestPathNode<E> {	//内部类，最短路径辅助数组元素对象类，记录源点到该终点的路径
		E endVex;				//终点
		int pathLength;			//路径长度
		LinkQueue<E> pathVexs;	//路径顶点序列
		boolean isOK;			//标记，该终点是否已求出最短路径
		
		public ShortestPathNode(E endVex, int pathLength, LinkQueue pathVexs, boolean isOK) {
			this.endVex = endVex;
			this.pathLength = pathLength;
			this.pathVexs = pathVexs;
			this.isOK = isOK;
		}
		
//		public void display(){	//测试用
//			pathVexs.display();
//			System.out.println("\t" + pathLength + "\t" + isOK);
//		}
	}
	
	public void ShortestPath_DIJ(E u) throws Exception {
		if (kind == GraphKind.UDG || kind == GraphKind.DG)
			throw new Exception("非网，不能生成最短路径！");

		//创建辅助数组spNode，记录指定源顶点到其他各终点的路径
		ShortestPathNode[] spNode = new ShortestPathNode[vexNum];

		int s = locateVex(u);	//s为源顶点位置编号
		
		//初始化辅助数组spNode
		for (int i = 0; i < vexNum; i++){	
			int pathLength;
			LinkQueue<E> pathVexs = null;
			boolean isOK;
			if (i != s){
				pathVexs = new LinkQueue(); 
				ArcNode arcSI = getArc(s,i);
				if (arcSI == null)
					pathLength = Integer.MAX_VALUE;
				else 
					pathLength = arcSI.getValue();
				pathVexs.offer(u);
				isOK = false;
			} else {
				pathLength = 0;
				isOK = true;
			}
			
			spNode[i] = new ShortestPathNode(getVex(i),pathLength,pathVexs,isOK);
		}
		
		for (int i = 1; i < vexNum; i++){	//循环n-1次
			int d = getMinMum(spNode);		//求辅助数组spNode中pathLength最短的元素
			spNode[d].isOK = true;			//确定序号为d的顶点的最短路径
			spNode[d].pathVexs.offer(getVex(d));	//将序号为d的终点加入路径的顶点序列中
			//根据新的最短路径顶点，调整辅助数组
			for (int j = 0; j < vexNum; j++){
				ArcNode arcDJ = getArc(d,j);
				if (arcDJ != null && spNode[j].isOK == false)
					if (spNode[d].pathLength + arcDJ.getValue() < spNode[j].pathLength) {
						spNode[j].pathLength = spNode[d].pathLength + arcDJ.getValue();
						spNode[j].pathVexs.offer(getVex(d));
					}
			}
		}
		
		//输出结果
		for (int i = 0; i < vexNum; i++){
			if (u == spNode[i].endVex) continue;
			System.out.print(u + " ~ " + spNode[i].endVex + "\t");
			spNode[i].pathVexs.display();
			System.out.print("\t" + spNode[i].pathLength);
			System.out.println();
		}		
	}

	//从辅助数组spNode中选出pathLength最短的元素，返回其在辅助数组中的下标
	private int getMinMum(ShortestPathNode<E>[] spNode) {
		int min = Integer.MAX_VALUE;
		int minIndex = -1;

		for (int i = 0; i < spNode.length; i++)
			if (spNode[i].isOK == false && spNode[i].pathLength < min) {
				min = spNode[i].pathLength;
				minIndex = i;
			}
				
		return minIndex;
	}
	
}