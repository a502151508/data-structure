package dataStructure;
import java.util.Scanner;

public class Towers {
	static int step = 0;

	public static void main (String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.print("请输入金盘子的个数：");
		int numDisks = sc.nextInt();
		
		towers(numDisks,'A','C','B');
		
		System.out.println("\n希望你没输入64，让我们的世界毁灭！");
		
	}
	
	public static void towers(int n, char source, char dest, char auxiliary){
		System.out.println("Towers (" + n +"," + source + "," + dest + "," + auxiliary + ")");
		if (n == 1)
			System.out.println("\t\t\t\t\t\tStep " + (++step) + ": Move from " + source + " to " + dest);
		else {
			towers(n-1,source,auxiliary,dest);
			System.out.println("\t\t\t\t\t\tStep " + (++step) + ": Move from " + source + " to " + dest);
			towers(n-1,auxiliary,dest,source);
		}
			
	}
}