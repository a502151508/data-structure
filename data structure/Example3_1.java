package dataStructure;
import dataStructure.linearList.LinkStack;
import java.util.Scanner;

public class Example3_1 {
	private final int LEFT = 0;// ��¼"��"�ָ���
	private final int RIGHT = 1;// ��¼"��"�ָ���
	private final int OTHER = 2;// ��¼�����ַ�
	
	public int verifyFlag(char ch) {
		if (ch == '(' || ch == '[' || ch == '{')  // ��ָ���
	    	return LEFT;
	    else if (ch == ')' || ch == ']' || ch == '}') // �ҷָ���
		    return RIGHT;
		else   // �������ַ�
		    return OTHER;
	}
	
	// ������ָ���str1���ҷָ���str2�Ƿ�ƥ��
	public boolean matches(char ch1, char ch2) {
		if ((ch1 == '(' && ch2 == ')')
			|| (ch1 == '[' && ch2 == ']')
			|| (ch1 == '{' && ch2 == '}'))
			return true;
	    else
		    return false;
	} 

	// �����������ʽ��Str�зָ����Ƿ�ƥ��
	private boolean isLegal(String str) throws Exception {  
		if ("".equals(str) || str == null)
			throw new Exception("�����������ʽ����Ϊ��");// �׳��쳣

		LinkStack<Character> S = new LinkStack(); 
		int length = str.length();
		for (int i = 0; i < length; i++) {
		 	char c = str.charAt(i); 
		
			if (verifyFlag(c) == LEFT)
				S.push(c);// ѹջ
			else if (verifyFlag(c) == RIGHT)
		    	if (S.isEmpty() || !matches(S.pop(), c))
		        	throw new Exception("�����������ʽ���Ϸ���");
		}
		
		if (!S.isEmpty())
			throw new Exception("�����������ʽ���Ϸ���");// �׳��쳣

		return true;
	}


	public static void main(String[] args) throws Exception {  
		Example3_1 e = new Example3_1();
		System.out.print("�������������ʽ��"); 
		Scanner sc = new Scanner(System.in);
		if (e.isLegal(sc.nextLine()))
			System.out.println("�������ʽ�Ϸ�!"); 
		else
		    System.out.println("�����������ʽ���Ϸ���"); 
	} 
}
