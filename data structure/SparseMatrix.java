package dataStructure.linearList;

public class SparseMatrix {  
	private TripleNode data[];   //三元组表
    private int rows;            //行数
    private int cols;            //列数
    private int nums;            //非零元素个数

	public SparseMatrix(int maxSize){		//创建一个空三元组表的SparseMatrix对象
		data = new TripleNode[maxSize];
		
		this.rows = 0;
		this.cols = 0;
		this.nums = 0;
	}

	public SparseMatrix(int[][] mat){		//按稀疏矩阵mat创建一个SparseMatrix对象
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
		System.out.println("系数矩阵的三元组存储结构：");
		System.out.println("行数：" + rows +"，列数：" + cols + "，非零元素个数：" + nums);
		System.out.println("行下标\t列下标\t元素值");
		for (int i = 0; i < nums; i++){
			System.out.println(data[i].getRow() + "\t" + data[i].getColumn() + "\t" + data[i].getValue());
		}
		
	}
	
	

}
