package dataStructure.linearList;

public class SparseMatrix {  
	private TripleNode data[];   //��Ԫ���
    private int rows;            //����
    private int cols;            //����
    private int nums;            //����Ԫ�ظ���

	public SparseMatrix(int maxSize){		//����һ������Ԫ����SparseMatrix����
		data = new TripleNode[maxSize];
		
		this.rows = 0;
		this.cols = 0;
		this.nums = 0;
	}

	public SparseMatrix(int[][] mat){		//��ϡ�����mat����һ��SparseMatrix����
		int count = 0,k = 0;
		for (int i = 0; i < mat.length; i++)
			for (int j = 0; j < mat[i].length; j++)
				if (mat[i][j] != 0)  count++;
		
		this.rows = mat.length;
		this.cols = mat[0].length;
		this.nums = count;
		
		this.data = new TripleNode[nums];
		for (int i = 0; i < this.rows; i++)
			for (int j = 0; j < this.cols; j++)
				if (mat[i][j] != 0)  data[k++] = new TripleNode(i,j,mat[i][j]);		
	}

	public int getRows(){
		 return rows;
	}

	public int getCols(){
		 return cols;
	}

	public int length(){
		 return nums;
	}
	
	public SparseMatrix transport(){
		SparseMatrix tm = new SparseMatrix(nums);
		tm.cols = this.rows;
		tm.rows = this.cols;
		tm.nums = this.nums;
		
		int q = 0;
		for (int col = 0; col < this.cols; col++)
			for (int k = 0; k < this.nums; k++)
				if (this.data[k].getColumn() == col)
					tm.data[q++] = new TripleNode(this.data[k].getColumn(), this.data[k].getRow(), this.data[k].getValue());
		
		return tm;
	}
	
	public void display(){
		System.out.println("ϵ���������Ԫ��洢�ṹ��");
		System.out.println("������" + rows +"��������" + cols + "������Ԫ�ظ�����" + nums);
		System.out.println("���±�\t���±�\tԪ��ֵ");
		for (int i = 0; i < nums; i++){
			System.out.println(data[i].getRow() + "\t" + data[i].getColumn() + "\t" + data[i].getValue());
		}
		
	}
	
	

}
