package dataStructure.linearList;
import java.util.Scanner;

public class SortSqList<E> extends SqList<RecordNode<E>> {

	//���췽��������һ������Ԫ��ΪRecordNode���͡�����ΪmaxSize�Ŀ�˳���      
    public SortSqList(int maxSize) { 
		curLen = 0;
		listElem = new RecordNode[maxSize];                   
	}

	//����Ϊ˳�����������������������������������������������������������������������������������������������������������������������������������
	public void insertSort() {	//ֱ�Ӳ�������
		RecordNode<E>  temp;
		for (int i = 1; i < curLen; i++) {	//iָ�������ӱ�ĵ�һ��Ԫ��
			temp = listElem[i];
			int j;
			for (j = i - 1; j >= 0 && temp.getKey().compareTo(listElem[j].getKey()) < 0; j--) 	//jָ�������ӱ�����һ��Ԫ��
				listElem[j+1] = listElem[j];	//jָ���Ԫ�غ���һ���洢λ��
			
			listElem[j+1] = temp;
		}
	}
	
	public void shellSort() {	//shell����
		for (int incre = curLen/2; incre > 0; incre = incre/2) {	//increΪ����shell���������
			RecordNode<E>  temp;
			for (int i = incre; i < curLen; i = i+incre) {
				temp = listElem[i];
				int j;
				for (j = i - incre; j >= 0 && temp.getKey().compareTo(listElem[j].getKey()) < 0; j = j-incre) 	
					listElem[j+incre] = listElem[j];
				
				listElem[j+incre] = temp;
			}
		}
	}

/*
	public void bubbleSort() {	//����ð������
		RecordNode<E>  temp;
		for (int i = 1; i < curLen; i++) {	//�������n-1������
			for (int j = 0; j < curLen - i; j++) {
				if (listElem[j].getKey().compareTo(listElem[j+1].getKey()) > 0) {
					temp = listElem[j];
					listElem[j] = listElem[j+1];
					listElem[j+1] = temp;
				}
			}	
		}
	}	
*/	
	public void bubbleSort() {	//ð������
		RecordNode<E>  temp;
		boolean flag = true;
		for (int i = 1; i < curLen && flag; i++) {	//�������n-1������
			flag = false;	//flag�����������ǰ�Ƿ�Ϊ��ȫ�����ȼٶ��������
			for (int j = 0; j < curLen - i; j++) {
				if (listElem[j].getKey().compareTo(listElem[j+1].getKey()) > 0) {
					temp = listElem[j];
					listElem[j] = listElem[j+1];
					listElem[j+1] = temp;
					flag = true;	//�������������������ݽ���������Ϊ����ȫ����					
				}
			}	
		}
	}	

	//�������򣬰����������������
	public void quickSort() {	
		qSort(0,curLen - 1);
	}
	
	private void qSort(int low, int high) {
		if (low >= high) return;
		
		RecordNode<E> pivot = listElem[low];
		int sortLeft = low + 1, sortRight = high;
		while (sortLeft < sortRight) {
			while (listElem[sortLeft].getKey().compareTo(pivot.getKey()) < 0)	//�������Ҳ��ұ�֧������ȵ�����
				sortLeft ++;
			while (listElem[sortRight].getKey().compareTo(pivot.getKey()) >= 0)	//�����������С��֧�������
				sortRight --;

			if (sortLeft <= sortRight) {
				RecordNode<E> temp;
				temp = listElem[sortRight];
				listElem[sortRight] = listElem[sortLeft];
				listElem[sortLeft] = temp;
				sortLeft ++;	sortRight --;

			}

		}
		
		listElem[low] = listElem[sortLeft-1];
		listElem[sortLeft-1] = pivot;
		qSort(low,sortRight - 1);
		qSort(sortLeft,high);
	}
	
	public void selectSort() {	//ѡ������
		RecordNode<E>  temp;
		for (int i = 0; i < curLen - 1; i++) {	//iָ�������ӱ�ĵ�һ��Ԫ��
			int min = i;
			for (int j = i + 1; j < curLen; j++)
				if (listElem[j].getKey().compareTo(listElem[min].getKey()) < 0)
					min = j;

			if (min != i) {
				temp = listElem[i];
				listElem[i] = listElem[min];
				listElem[min] = temp;
			}
		}
	}	
	

	//����Ϊ˳���Ĳ��Ҳ���������������������������������������������������������������������������������������������������������������������������
	public int seqSearch(Comparable key) {	//˳�����
		int i = 0;
		
		while (i < curLen && listElem[i].getKey().compareTo(key) != 0)
			i++;
		
		if (i < curLen)
       		return  i;  
 		else
       		return -1; 
	}
	
	public int seqSearchWithGuard(Comparable key) {	//�ڱ�����
		int i = 0;
		
		listElem[curLen] = new RecordNode(null,key);
		while (listElem[i].getKey().compareTo(key) != 0)
			i++;
		
		if (i < curLen)
       		return  i;  
 		else
       		return -1; 
	}
	
	public int binarySearch (Comparable key) {	//���ֲ���
   		if (curLen > 0) {
       		int low = 0; 
       		int high =  curLen-1;
       		while(low <= high) {
           		int mid = (low + high) / 2;
          		if (listElem[mid].getKey().compareTo(key) == 0)
                	return mid;
         		else if (listElem[mid].getKey().compareTo(key) > 0)
                    high = mid - 1;
          		else    
          			low = mid + 1;
        	}  
        }
        return -1 ;  
	}
	

}

