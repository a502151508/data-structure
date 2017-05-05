package dataStructure;
import java.util.Scanner;

public class Fibonacci {
	public static void main (String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.print("请输入斐波拉切数列长度：");
		int seriesSize = sc.nextInt();
		
		for (int i = 0; i < seriesSize; i++)
			System.out.print(fib(i) + "  ");
		System.out.println();
	}
	
	public static int fib(int num){
		if (num ==0 || num == 1)
			return num;
		else
			return fib(num-1) + fib(num-2); 
	}
}