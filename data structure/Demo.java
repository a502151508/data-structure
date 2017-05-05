import java.util.Scanner;

class Example6_1 {
	public static void main(String arg[]) {
		int a,b,c;
		Scanner sc = new Scanner(System.in);
		
		a = sc.nextInt();
		b = sc.nextInt();
//		c = div(a,b);

		try{
			c = div(a,b);
		}catch(ArithmeticException e){
			System.out.println("除数为零，结束程序！");
			return;
		}	

		System.out.println("c = "+c);
	}

/*	
	static int div(int x,int y) throws ArithmeticException{
		return x/y;
	}
*/


	static int div(int x,int y){
		try{
			return x/y;
		}catch(ArithmeticException e){
			throw e;
			//System.out.println("除数为零，结束程序！");
			//System.exit(0);	
			//return 0;		
		}
	}

}
