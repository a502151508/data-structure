package dataStructure.Graph;

public class VNode<E> {
	private E data; 			// 顶点信息
	private ArcNode firstArc; 	// 第一条依附于该顶点的边（弧）结点
                                       
    public VNode() {
		this(null, null);
	}

	public VNode(E data) {
		this(data, null);
	}

	public VNode(E data, ArcNode firstArc) {
		this.data = data;
		this.firstArc = firstArc;
	}

	public E getData() {
		return this.data;
	}

	public ArcNode getFirstArc() {
		return this.firstArc;
	}

	public void setData(E data) {
		this.data = data;
	}

	public void setFirstArc(ArcNode firstArc) {
		this.firstArc = firstArc;
	}
}
