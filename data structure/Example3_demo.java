package dataStructure;
import dataStructure.linearList.LinkStack;
import java.util.Scanner;


public class Example3_demo {


public static void main(String[] args) throws Exception {  
Scanner sc = new Scanner(System.in);
Example3_3 p = new Example3_3();
System.out.print("请输入中缀表达式："); 
String inFix = sc.nextLine();
System.out.println();
String postFix = p.covertToPostFIx(inFix);
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
public String covertToPostFIx(String inFix) throws Exception{
LinkStack<Character> stack = new LinkStack();
String postFix = "";
char token=' ',topToken=' ',m=' ';
for (int i = 0; inFix != null && i < inFix.length(); i++) {
token = inFix.charAt(i);
m=inFix.charAt(i+1);
if(isOperators(token)&&isOperators(m)){
postFix=postFix+" "+String.valueOf(token)+String.valueOf(m)+" ";
i=i+1;
}
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
    if(!stack.isEmpty()) topToken = stack.peek();
       while (!stack.isEmpty() && (priority(token) <= priority(topToken))) {
                topToken = stack.pop();
                    postFix = postFix.concat(String.valueOf(topToken));
                    if(!stack.isEmpty()) topToken = stack.peek();
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
if (postFix == null) throw new Exception("后缀表达式为空");
LinkStack<Double> stack = new LinkStack();
for (int i = 0; i < postFix.length(); i++){
char token = postFix.charAt(i);
if (token==' '){
char m=postFix.charAt(i+1);
char n=postFix.charAt(i+2);
Double k=10*Double.valueOf(String.valueOf(m))+Double.valueOf(String.valueOf(n));
stack.push(k);
i=i+3;
}
if (isOperator(token)){
Double d2 = stack.pop();
Double d1 = stack.pop();
double result = 0;
if (token == '+') result = d1 + d2;
if (token == '-') result = d1 - d2;
if (token == '*') result = d1 * d2;
if (token == '^') result = Math.pow(d1,d2);
if (token == '/' && d2 != 0) result = d1 / d2;
if (token == '%' && d2 != 0) result = d1 % d2;
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
public boolean isOperators(char c){
return (c == '1' || c == '2' || c == '3' || c == '4' || c == '5' || c == '6'  || c == '7' || c == '8' || c == '9' || c == '0' );
}
}



