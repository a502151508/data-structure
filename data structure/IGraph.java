package dataStructure.Graph;

public interface IGraph<E>{
	int getVexNum(); 
	int getArcNum(); 
	E getVex(int v) throws Exception;
	int locateVex(E vex);
	int firstAdjVex(int v) throws Exception;
	int nextAdjVex(int v, int w) throws Exception;
	void BFSTraverse() throws Exception;
	void DFSTraverse() throws Exception;
}
