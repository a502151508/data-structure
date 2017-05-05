package dataStructure.Graph;
import dataStructure.linearList.LinkQueue;

public class ALGraph<E> implements IGraph<E> {
	private GraphKind kind;		//ͼ������
	private int vexNum, arcNum;	//ͼ�ж��������ߣ�������
	private VNode<E>[] vexs;	//ͼ�Ķ�������
	
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

	//��ȡ����λ�����Ϊv�Ķ��������
	public E getVex(int v) throws Exception {
		if (v < 0 || v >= vexNum)
		      throw new Exception("��" + v + "�����㲻����!");
		return vexs[v].getData();
	}
	
	//��ȡ����ֵΪvex�Ķ����λ���
	public int locateVex(E vex) {
		for (int i = 0; i < vexNum; i++)
			if (vexs[i].getData().equals(vex))
				return i;  

		return -1;  
	}	
	
	//��ȡλ�����Ϊv�Ķ���ĵ�һ���ڽӵ��λ���
	public int firstAdjVex(int v) throws Exception {
      	if (v < 0 || v >= vexNum)
			throw new Exception("��" + v + "�����㲻����!");

		if (vexs[v].getFirstArc() != null)
			return vexs[v].getFirstArc().getAdjVex();

		return -1;
	}

	//��ȡλ�����Ϊv�Ķ����λ���Ϊw���ڽӵ����һ���ڽӵ�
	public int nextAdjVex(int v, int w) throws Exception {
      	if (v < 0 || v >= vexNum)
			throw new Exception("��" + v + "�����㲻����!");
		
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
	
	//��ȡ��ʼ����λ�����ΪinitVex����ֹ����λ�����ΪtermVex�ı�
	public ArcNode getArc (int initVex, int termVex) throws Exception {
		if (initVex < 0 || initVex >= vexNum)
		      throw new Exception("��" + initVex + "�����㲻����!");

		if (termVex < 0 || termVex >= vexNum)
		      throw new Exception("��" + termVex + "�����㲻����!");

		ArcNode arc = vexs[initVex].getFirstArc();	//arcָ����ʼ����ĵ�һ����
		while (arc != null && arc.getAdjVex() != termVex) {
			arc = arc.getNextArc();		//arcָ����ʼ�������һ����
		}
		
		return arc;
	}

	//������ȱ���
	public void BFSTraverse() throws Exception {
		boolean[] visited = new boolean[vexNum];	//��ʼ����������visited
		for (int i = 0; i < vexNum; i++) {
			visited[i] = false;
		}

		LinkQueue<Integer> lq = new LinkQueue();	//�����������У�����Ԫ��Ϊ�����λ�����
		
		for (int v = 0; v < vexNum; v++) {			//���η���ͼ�е�������ͨ��������ǿ��ͨ������
			if (!visited[v]) {
				lq.offer(v);						//ָ������v���
				while (!lq.isEmpty()) {
					int u = lq.poll();				//�������ж��׶������
					System.out.print(vexs[u].getData() + " ");	//���ʸö���
					visited[u] = true;				//��Ǹö���Ϊtrue

					//���ճ��ӵĶ��������δ�����ʵ��ڽӵ���븨��������
					for (int w = firstAdjVex(u); w>=0; w = nextAdjVex(u,w)) 	
						if (!visited[w])	
							lq.offer(w);	
				}
			}
		}

	}
	
	//������ȱ���
	private boolean[] visited  ;
	public void DFSTraverse() throws Exception {
		visited = new boolean[vexNum];	//��ʼ��visited����
		for (int i = 0; i < vexNum; i++) {
			visited[i] = false;
		}

		for (int v = 0; v < vexNum; v++)			//���η���ͼ�е�������ͨ��������ǿ��ͨ������
			if (!visited[v]) 
				DFS(v);
	}

	private void DFS (int v) throws Exception {
		visited[v] = true;							//��Ǹö���Ϊtrue
		System.out.print(vexs[v].getData() + " ");	//���ʸö���
		
		//ʹ��DFS(),���α��������ö����δ�����ʵ��ڽӵ����ͼ
		for (int w = firstAdjVex(v); w>=0; w = nextAdjVex(v,w)) 
			if (!visited[w])
				DFS(w);	
	}
	
	//�ж�����ͼ�������Ƿ�Ϊ����ͨ��
	public boolean isConnected() {
		//...��ҵ��
		return true; 
	}

	
	//����ķ�㷨������С������
	private class CloseEdge<E> {	//�ڲ��࣬��������Ԫ�ض����ࡣ��¼����V-U�Ķ��㵽����U�ı�
		E startVex;		//����U�еĶ���
		E endVex;		//����V-U�еĶ���
		int lowCost;	//�ñߵ�Ȩ
		boolean isOK;	//��ǣ��ñ��Ƿ�������С��������
		
		public CloseEdge (E startVex,E endVex,int lowCost,boolean isOK) {
			this.startVex = startVex;
			this.endVex = endVex;
			this.lowCost = lowCost;
			this.isOK = isOK;
		}

//		public void display(){	//������
//			System.out.println(startVex + "-" + endVex +"\t" + lowCost + "\t" + isOK);
//		}
	}

	public void MinSpanTree_PRIM (E u) throws Exception {
		if (kind != GraphKind.UDN || !isConnected())
			throw new Exception("��������ͨ��������������С��������");
		
		//������������closeEdge����¼��С�����������ɹ����м���V-U�����ж��㵽����U�ľ�����С�ı�
		CloseEdge<E>[] closeEdge = new CloseEdge[vexNum];	

		int s = locateVex(u);	//��С�������ĸ�����λ�����
		
		for (int i = 0; i < vexNum; i++) {	//��ʼ����������closeEdge
			if (i != s) {
				if (getArc(s,i) != null)
					closeEdge[i] = new CloseEdge(u,getVex(i),getArc(s,i).getValue(),false);
				else
					closeEdge[i] = new CloseEdge(u,getVex(i),Integer.MAX_VALUE,false);
			} else
					closeEdge[i] = new CloseEdge(u,u,0,true);
		}
		
		for (int i = 1; i < vexNum; i++){				//ѭ��n-1�Σ�������С�������ı�
			//������㼯��U�붥�㼯��V-U�ľ���ı�,dΪ�ñ�������closeEdge���±��Լ��ñߵ�endVex�������
			int d = getMinMum(closeEdge);				
			closeEdge[d].isOK = true;			//�ñ߻򻡼�����С��������,����λ�����Ϊd�Ķ������U����			
			
			//���Ϊd�Ķ�����뼯��U�󣬵�����������
			for (int j = 0; j < vexNum; j++){	
				ArcNode arcDJ = getArc(d,j);			//arcDJΪ����d��j�Ĺ����߻�
				if (arcDJ != null && closeEdge[j].isOK == false)
					if (arcDJ.getValue() < closeEdge[j].lowCost) {
						closeEdge[j].startVex = getVex(d);
						closeEdge[j].lowCost = arcDJ.getValue();
					}
			}
		}

		//������
		for (int i = 0; i < vexNum; i++){
			if (closeEdge[i].startVex == closeEdge[i].endVex) continue;	//�����������ı�
			System.out.print(closeEdge[i].startVex + " - " + closeEdge[i].endVex + "\t");
			System.out.print("\t" + closeEdge[i].lowCost);
			System.out.println();
		}		
	}
	
	//�󼯺�U�뼯��V-U ������̵ıߣ��������ڸ��������е��±�
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
	
	//�Ͻ�˹�����㷨�������·��
	private class ShortestPathNode<E> {	//�ڲ��࣬���·����������Ԫ�ض����࣬��¼Դ�㵽���յ��·��
		E endVex;				//�յ�
		int pathLength;			//·������
		LinkQueue<E> pathVexs;	//·����������
		boolean isOK;			//��ǣ����յ��Ƿ���������·��
		
		public ShortestPathNode(E endVex, int pathLength, LinkQueue pathVexs, boolean isOK) {
			this.endVex = endVex;
			this.pathLength = pathLength;
			this.pathVexs = pathVexs;
			this.isOK = isOK;
		}
		
//		public void display(){	//������
//			pathVexs.display();
//			System.out.println("\t" + pathLength + "\t" + isOK);
//		}
	}
	
	public void ShortestPath_DIJ(E u) throws Exception {
		if (kind == GraphKind.UDG || kind == GraphKind.DG)
			throw new Exception("�����������������·����");

		//������������spNode����¼ָ��Դ���㵽�������յ��·��
		ShortestPathNode[] spNode = new ShortestPathNode[vexNum];

		int s = locateVex(u);	//sΪԴ����λ�ñ��
		
		//��ʼ����������spNode
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
		
		for (int i = 1; i < vexNum; i++){	//ѭ��n-1��
			int d = getMinMum(spNode);		//��������spNode��pathLength��̵�Ԫ��
			spNode[d].isOK = true;			//ȷ�����Ϊd�Ķ�������·��
			spNode[d].pathVexs.offer(getVex(d));	//�����Ϊd���յ����·���Ķ���������
			//�����µ����·�����㣬������������
			for (int j = 0; j < vexNum; j++){
				ArcNode arcDJ = getArc(d,j);
				if (arcDJ != null && spNode[j].isOK == false)
					if (spNode[d].pathLength + arcDJ.getValue() < spNode[j].pathLength) {
						spNode[j].pathLength = spNode[d].pathLength + arcDJ.getValue();
						spNode[j].pathVexs.offer(getVex(d));
					}
			}
		}
		
		//������
		for (int i = 0; i < vexNum; i++){
			if (u == spNode[i].endVex) continue;
			System.out.print(u + " ~ " + spNode[i].endVex + "\t");
			spNode[i].pathVexs.display();
			System.out.print("\t" + spNode[i].pathLength);
			System.out.println();
		}		
	}

	//�Ӹ�������spNode��ѡ��pathLength��̵�Ԫ�أ��������ڸ��������е��±�
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