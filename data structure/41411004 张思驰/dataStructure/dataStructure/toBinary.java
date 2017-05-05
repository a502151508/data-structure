package dataStructure;
import java.util.Scanner;
import dataStructure.linearList.LinkStack;
import dataStructure.linearList.Node;

public class toBinary extends LinkStack{

	public static void main(String[] args) {
		System.out.print("二进制 输入一个数: ");
        Scanner scanner = new Scanner(System.in);
        try {
            int num = scanner.nextInt();
            int numTemp = num;
             LinkStack stack = new LinkStack();
           while(numTemp != 0){
                int value = numTemp % 2;
                stack.push(value);
                numTemp /= 2;
            }
           String s = "";
           while(stack.peek()!=null)
           {
        	   s=s+stack.pop();
           }
            System.out.println(num + "的二进制数" + s);
            
        } catch (Exception e) {
            System.out.println("输入数不合法");
        }
 


	}

}
