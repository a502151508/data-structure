package dataStructure;
import dataStructure.linearList.PriorityQData;
import dataStructure.linearList.PriorityQueue;

public class Example3_6{
	public static void main(String arg[]) throws Exception{
		PriorityQueue pm = new PriorityQueue();
		
		pm.offer(new PriorityQData(1,20));
		pm.offer(new PriorityQData(2,30));
		pm.offer(new PriorityQData(3,20));
		pm.offer(new PriorityQData(4,20));
		pm.offer(new PriorityQData(5,40));
		pm.offer(new PriorityQData(6,10));
		
		System.out.println("进程服务的顺序：");
		System.out.println("进程ID\t进程优先级");
		while(!pm.isEmpty()) {
			PriorityQData p = pm.poll();
			System.out.println(" " + p.getElem() + "\t" + p.getPriority());
		}
	}
}