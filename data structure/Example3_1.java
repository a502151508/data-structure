package dataStructure;
import dataStructure.linearList.LinkStack;
import java.util.Scanner;

public class Example3_1 {
	private final int LEFT = 0;// 记录"左"分隔符
	private final int RIGHT = 1;// 记录"右"分隔符
	private final int OTHER = 2;// 记录其他字符
	
	public int verifyFlag(char ch) {
		if (ch == '(' || ch == '[' || ch == '{')  // 左分隔符
	    	return LEFT;
	    else if (ch == ')' || ch == ']' || ch == '}') // 右分隔符
		    return RIGHT;
		else   // 其它的字符
		    return OTHER;
	}
	
	// 检验左分隔符str1和右分隔符str2是否匹配
	public boolean matches(char ch1, char ch2) {
		if ((ch1 == '(' && ch2 == ')')
			|| (ch1 == '[' && ch2 == ']')
			|| (ch1 == '{' && ch2 == '}'))
			return true;
	    else
		    return false;
	} 

	// 检验算术表达式串Str中分隔符是否匹配
	private boolean isLegal(String str) throws Exception {  
		if ("".equals(str) || str == null)
			throw new Exception("错误：算术表达式不能为空");// 抛出异常

		LinkStack<Character> S = new LinkStack(); 
		int length = str.length();
		for (int i = 0; i < length; i++) {
		 	char c = str.charAt(i); 
		
			if (verifyFlag(c) == LEFT)
				S.push(c);// 压栈
			else if (verifyFlag(c) == RIGHT)
		    	if (S.isEmpty() || !matches(S.pop(), c))
		        	throw new Exception("错误：算术表达式不合法！");
		}
		
		if (!S.isEmpty())
			throw new Exception("错误：算术表达式不合法！");// 抛出异常

		return true;
	}


	public static void main(String[] args) throws Exception {  
		Example3_1 e = new Example3_1();
		System.out.print("请输入算术表达式："); 
		Scanner sc = new Scanner(System.in);
		if (e.isLegal(sc.nextLine()))
			System.out.println("算术表达式合法!"); 
		else
		    System.out.println("错误：算术表达式不合法！"); 
	} 
}
