package dataStructure.Graph;

public class ArcNode {
	private int adjVex;			// �û���ָ��Ķ���λ�����
	private int value;			// ��(��)��Ȩֵ
	private ArcNode nextArc;	// �������һ�������ıߣ��������

	public ArcNode() {
		this(-1, 0, null);
	}
	
	public ArcNode(int adjVex) {
		this(adjVex, 0, null);
	}
	
	public ArcNode(int adjVex, int value) {
		this(adjVex, value, null);
	}

	public ArcNode(int adjVex, ArcNode nextArc) {
		this(adjVex, 0, nextArc);
	}

	public ArcNode(int adjVex, int value, ArcNode nextArc) {
		this.value = value;
		this.adjVex = adjVex;
		this.nextArc = nextArc;
	}

	public int getAdjVex() {
		return this.adjVex;
	}
	
	public int getValue() {
		return this.value;
	}

	public ArcNode getNextArc() {
		return this.nextArc;
	}

	public void setAdjVex(int adjVex) {
		this.adjVex = adjVex;
	}

	public void setValue(int adjVex) {
		this.value = value;
	}

	public void setNextArc(ArcNode nextArc) {
		this.nextArc = nextArc;
	}
}
