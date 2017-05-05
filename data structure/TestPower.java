package dataStructure;

public class TestPower {
	public static void main (String[] args) {
		int base = 5;
		int exp = 2;
		System.out.println(base + "µÄ" + exp + "·½Îª£º" + power(base,exp));
	}

/*	public static int power(int base, int exp) {
		int num = 1;
		for (int i = 1; i <= exp; i++){
			num = num * base;
		}
		
		return num;
	}
*/
	public static int power(int base, int exp) {
		if (exp == 0)	
			return 1;
		else
		 	return base * power(base,exp-1);
	}
}