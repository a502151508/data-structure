package dataStructure;

public class Factorial {
	public static void main (String[] args) {
		int n = 16;
		System.out.println(n + "的阶乘为：" + iterativeFactorial(n));
		System.out.println(n + "的阶乘为：" + recursiveFactorial(n));
	}

	public static long iterativeFactorial(int n) {
		long factN = 1;
		for (int i = 1; i <= n; i++){
			factN = factN * i;
		}
		
		return factN;
	}

	public static long recursiveFactorial(int n) {
		if (n == 0)
			return 1;
		else
			return n * recursiveFactorial(n-1);
	}
}