class test{
	public void insertSort() {
		RecordNode temp;
		int i,j;
		for (i = 1; j < this.curLen; i++) {
			temp = r[i];
			for (j = i-1; j >= 0 && temp.getKey().compareTo(r[j].getKey()) < 0; j--)
				r[j+1] = r[j];				
		}
		r[j+1] = temp;
	}
}