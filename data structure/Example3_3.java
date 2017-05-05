package dataStructure;
import dataStructure.linearList.LinkStack;
import java.util.Scanner;

public class Example3_3 {

	public static void main(String[] args) throws Exception {  
		Example3_3 p = new Example3_3();

		Scanner sc = new Scanner(System.in);
		System.out.print("请输入中缀表达式："); 
		String inFix = sc.nextLine();
		System.out.println();
		
		String postFix = p.covertToPostFix(inFix);
		System.out.println("\n后缀表达式为：" + postFix); 
		
		System.out.println("\n表达式运算结果为：" + p.numberCalculate(postFix));
	} 

	public int priority(char operator)
	{
		switch(operator)
		{
			case '^': return 3;

		    case '%': 
	        case '*':
	        case '/': return 2;

		    case '+':
		    case '-': return 1;
		}
		return 0;
	}
	
	public String covertToPostFix(String inFix) throws Exception{
		if ("".equals(inFix) || inFix == null)
			throw new Exception("错误：算术表达式不能为空");// 抛出异常

		LinkStack<Character> stack = new LinkStack();
		String postFix = "";
		char token=' ',topToken=' ';
		
		for (int i = 0; inFix != null && i < inFix.length(); i++) {
			token = inFix.charAt(i);
		    if (token == '(') {
	       		stack.push(token);
		    } 
		    else if (token == ')') {
		        topToken = stack.pop();
		        while (topToken != '(') {
		        	postFix = postFix.concat(String.valueOf(topToken));
		            topToken = stack.pop();
		        }
		    } 
		    else if (isOperator(token)) {
		    	if(!stack.isEmpty())	topToken = stack.peek();
		        while (!stack.isEmpty() && (priority(token) <= priority(topToken))) {
                	topToken = stack.pop();
                    postFix = postFix.concat(String.valueOf(topToken));
                    if(!stack.isEmpty())	topToken = stack.peek();
	            }
	            stack.push(token);
		    } 
		    else{
                postFix = postFix.concat(String.valueOf(token));
		    }
		
		}
		
		while (!stack.isEmpty()) {
			token = stack.pop();
		    postFix = postFix.concat(String.valueOf(token));
	    }
		
		return(postFix);
	}

	public double numberCalculate(String postFix) throws Exception{
		if ("".equals(postFix) || postFix == null)
			throw new Exception("错误：后缀算术表达式不能为空");// 抛出异常
		
		LinkStack<Double> stack = new LinkStack();
		for (int i = 0; i < postFix.length(); i++){
			char token = postFix.charAt(i);
			if (isOperator(token)){
				Double d2 = stack.pop();
				Double d1 = stack.pop();
				double result = 0;
				
				if (token == '+')	result = d1 + d2;
				if (token == '-')	result = d1 - d2;
				if (token == '*')	result = d1 * d2;
				if (token == '^')	result = Math.pow(d1,d2);
				if (token == '/' && d2 != 0)	result = d1 / d2;
				if (token == '%' && d2 != 0)	result = d1 % d2;
				
				stack.push(result);
			}else {
					stack.push(Double.valueOf(String.valueOf(token)));
			}
		}
		
		return stack.pop();
	}

	public boolean isOperator(char c){
		return (c == '+' || c == '-' || c == '*' || c == '/' || c == '^' || c == '%' );
	}
}

