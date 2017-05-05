public class SqStringIndexOf {
	public static void main (String args[]) {
		String s = "bcadabcaabcad";
		String t = "bcad";
		
		System.out.println("子串T在主串S中的位置序号为：" + indexOf_BF(s,t,0));
		System.out.println("子串T在主串S中的位置序号为：" + indexOf_KMP(s,t,0));
		System.out.println("子串T在主串S中的位置序号为：" + s.indexOf(t,0) + "\n");

		System.out.println("子串T在主串S中的位置序号为：" + indexOf_BF(s,t,4));
		System.out.println("子串T在主串S中的位置序号为：" + indexOf_KMP(s,t,4));
		System.out.println("子串T在主串S中的位置序号为：" + s.indexOf(t,4) + "\n");

		System.out.println("子串T在主串S中的位置序号为：" + indexOf_BF(s,t,10));
		System.out.println("子串T在主串S中的位置序号为：" + indexOf_KMP(s,t,10));
		System.out.println("子串T在主串S中的位置序号为：" + s.indexOf(t,10) + "\n");
	}
	
	/* 返回子串t在主串s（当前串）中第start个字符之后的位置。
	 *若不存在， 则函数值为-1。其中，t非空。
	 *     0≤start≤S.Length()-1 	*/
	public static int indexOf_BF(String s, String t, int start) {
		int i = start, j = 0;	//i为主串中当前比较字符序号，j为子串中当前比较字符序号
		int sLen=s.length(),tLen=t.length();  

		if (s == null || t == null || tLen ==0 || sLen < tLen)
			return -1;
		
		while  (i < sLen && j < tLen) {
			if (s.charAt(i) == t.charAt(j)) {	// 两个串中的当前比较字符相同，继续比较后继字符
		    	i++;
		    	j++;  
			} else {	// 两个串中的当前比较字符不相同，i、j指针后退重新开始匹配
				i = i-j+1; 	
				j = 0;
			}  
		}
		
		if (j == tLen)  	//最后确认是否成功匹配
			return i-tLen;
		else  
			return -1;
	}

	public static int indexOf_KMP(String s, String t, int start) {
		int i = start, j = 0;	//i为主串中当前比较字符序号，j为子串中当前比较字符序号
		int sLen=s.length(),tLen=t.length();  

		int[] next = getNext(t);
		while  (i < sLen && j < tLen) {
			if (j == -1 || s.charAt(i) == t.charAt(j)) {	// j==-1表示s[i]!=t[0]
		    	i++;
		    	j++;  
			} else {	// 两个串中的当前比较字符不相同，j指针后退重新开始匹配
				j = next[j];
			}  
		}
		
		if (j == tLen)  	//最后确认是否成功匹配
			return i-tLen;
		else  
			return -1;
	}

	public static int[] getNext(String t) {
		int[] next = new int[t.length()];
		int j = 1, k = 0;
		next[0] = -1; next[1] = 0;
		
		while (j<t.length() - 1) {
			if (t.charAt(j) == t.charAt(k)) {
				next[j+1] = k + 1;
				j++; k++;
			}
			else{
				if (k == 0) {
					next[j+1] = 0;
					j++;
				}
				else k = next[k];
			}
		}
		
		return next;
	}
}