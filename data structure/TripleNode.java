package dataStructure.linearList;
 
public class TripleNode  {  
	private int row;              //行号
    private int column;           //列号  
    private int value;            //元素值

	public TripleNode(int row, int column, int value){
		this.row = row;
		this.column = column;
		this.value = value;
	}

	public TripleNode(){
		this(0,0,0);
	}
	
	public void setRow(int row){
		this.row = row;
	}

	public void setColumn(int column){
		this.column = column;
	}

	public void setValue(int value){
		this.value = value;
	}

	public int getRow(){
		return this.row;
	}

	public int getColumn(){
		return this.column;
	}
	
	public int getValue(){
		return this.value;
	}
}
