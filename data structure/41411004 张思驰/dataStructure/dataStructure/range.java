package dataStructure;

import dataStructure.linearList.LinkQueue;

public class range extends LinkQueue{

	public static void main(String[] args) throws Exception {
	 
	int[] s={3,221,12,6,10,314,65,29,9,30,81,5,119,20,57,44,99};
	LinkQueue q1 = new LinkQueue();
	LinkQueue q2 = new LinkQueue();
	LinkQueue q3 = new LinkQueue();
	
	for(int i=0;i<16;i++){
		if(s[i]<10){
			q1.offer(s[i]);
		}else if(s[i]<100){
			q2.offer(s[i]);
		}else{
			q3.offer(s[i]); 
		}
		
		
	}
	//q1.display();
	//q2.display();
	//q3.display();
	 String h = "";
     while(q1.peek()!=null)
     {
  	   h=h+q1.poll()+" ";
     }
     while(q2.peek()!=null)
     {
  	   h=h+q2.poll()+" ";
     }
     while(q3.peek()!=null)
     {
  	   h=h+q3.poll()+" ";
     }
     
      System.out.println(h);
	
	}

}
