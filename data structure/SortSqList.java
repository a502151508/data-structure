package dataStructure.linearList;
import java.util.Scanner;

public class SortSqList<E> extends SqList<RecordNode<E>> {

	//构造方法，构造一个数据元素为RecordNode类型、容量为maxSize的空顺序表      
    public SortSqList(int maxSize) { 
		curLen = 0;
		listElem = new RecordNode[maxSize];                   
	}

	//以下为顺序表的排序操作。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。
	public void insertSort() {	//直接插入排序
		RecordNode<E>  temp;
		for (int i = 1; i < curLen; i++) {	//i指向无序子表的第一个元素
			temp = listElem[i];
			int j;
			for (j = i - 1; j >= 0 && temp.getKey().compareTo(listElem[j].getKey()) < 0; j--) 	//j指向有序子表的最后一个元素
				listElem[j+1] = listElem[j];	//j指向的元素后移一个存储位置
			
			listElem[j+1] = temp;
		}
	}
	
	public void shellSort() {	//shell排序
		for (int incre = curLen/2; incre > 0; incre = incre/2) {	//incre为本趟shell排序的增量
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
	public void bubbleSort() {	//基本冒泡排序
		RecordNode<E>  temp;
		for (int i = 1; i < curLen; i++) {	//控制最多n-1趟排序
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
	public void bubbleSort() {	//冒泡排序
		RecordNode<E>  temp;
		boolean flag = true;
		for (int i = 1; i < curLen && flag; i++) {	//控制最多n-1趟排序
			flag = false;	//flag标记数据排序前是否为完全有序，先假定是有序的
			for (int j = 0; j < curLen - i; j++) {
				if (listElem[j].getKey().compareTo(listElem[j+1].getKey()) > 0) {
					temp = listElem[j];
					listElem[j] = listElem[j+1];
					listElem[j+1] = temp;
					flag = true;	//如果本趟排序进行了数据交换，则标记为非完全有序					
				}
			}	
		}
	}	

	//快速排序，包括下面的两个方法
	public void quickSort() {	
		qSort(0,curLen - 1);
	}
	
	private void qSort(int low, int high) {
		if (low >= high) return;
		
		RecordNode<E> pivot = listElem[low];
		int sortLeft = low + 1, sortRight = high;
		while (sortLeft < sortRight) {
			while (listElem[sortLeft].getKey().compareTo(pivot.getKey()) < 0)	//从左向右查找比支点大或相等的数据
				sortLeft ++;
			while (listElem[sortRight].getKey().compareTo(pivot.getKey()) >= 0)	//从右向左查找小于支点的数据
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
	
	public void selectSort() {	//选择排序
		RecordNode<E>  temp;
		for (int i = 0; i < curLen - 1; i++) {	//i指向无序子表的第一个元素
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
	

	//以下为顺序表的查找操作。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。
	public int seqSearch(Comparable key) {	//顺序查找
		int i = 0;
		
		while (i < curLen && listElem[i].getKey().compareTo(key) != 0)
			i++;
		
		if (i < curLen)
       		return  i;  
 		else
       		return -1; 
	}
	
	public int seqSearchWithGuard(Comparable key) {	//哨兵查找
		int i = 0;
		
		listElem[curLen] = new RecordNode(null,key);
		while (listElem[i].getKey().compareTo(key) != 0)
			i++;
		
		if (i < curLen)
       		return  i;  
 		else
       		return -1; 
	}
	
	public int binarySearch (Comparable key) {	//二分查找
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

