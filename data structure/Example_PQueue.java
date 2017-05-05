package dataStructure;
import dataStructure.linearList.PriorityQData;
import dataStructure.linearList.PriorityQueue;

class Example_PQueue {
	public static void main(String arg[]) throws Exception{
		PriorityQueue pq = new PriorityQueue();
		
		Person ps1 = new Person("张三",22);		
		Person ps2 = new Person("李四",11);		
		Person ps3 = new Person("王五",33);	
		
		PriorityQData<Person> pqd1 = new PriorityQData(ps1,ps1.getAge());	
		PriorityQData<Person> pqd2 = new PriorityQData(ps2,ps2.getAge());	
		PriorityQData<Person> pqd3 = new PriorityQData(ps3,ps3.getAge());	

		pq.offer(pqd1);
		pq.offer(pqd2);
		pq.offer(pqd3);

		pq.display();
	}
}
