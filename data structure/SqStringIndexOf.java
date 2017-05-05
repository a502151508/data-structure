public class SqStringIndexOf {
	public static void main (String args[]) {
		String s = "bcadabcaabcad";
		String t = "bcad";
		
		System.out.println("�Ӵ�T������S�е�λ�����Ϊ��" + indexOf_BF(s,t,0));
		System.out.println("�Ӵ�T������S�е�λ�����Ϊ��" + indexOf_KMP(s,t,0));
		System.out.println("�Ӵ�T������S�е�λ�����Ϊ��" + s.indexOf(t,0) + "\n");

		System.out.println("�Ӵ�T������S�е�λ�����Ϊ��" + indexOf_BF(s,t,4));
		System.out.println("�Ӵ�T������S�е�λ�����Ϊ��" + indexOf_KMP(s,t,4));
		System.out.println("�Ӵ�T������S�е�λ�����Ϊ��" + s.indexOf(t,4) + "\n");

		System.out.println("�Ӵ�T������S�е�λ�����Ϊ��" + indexOf_BF(s,t,10));
		System.out.println("�Ӵ�T������S�е�λ�����Ϊ��" + indexOf_KMP(s,t,10));
		System.out.println("�Ӵ�T������S�е�λ�����Ϊ��" + s.indexOf(t,10) + "\n");
	}
	
	/* �����Ӵ�t������s����ǰ�����е�start���ַ�֮���λ�á�
	 *�������ڣ� ����ֵΪ-1�����У�t�ǿա�
	 *     0��start��S.Length()-1 	*/
	public static int indexOf_BF(String s, String t, int start) {
		int i = start, j = 0;	//iΪ�����е�ǰ�Ƚ��ַ���ţ�jΪ�Ӵ��е�ǰ�Ƚ��ַ����
		int sLen=s.length(),tLen=t.length();  

		if (s == null || t == null || tLen ==0 || sLen < tLen)
			return -1;
		
		while  (i < sLen && j < tLen) {
			if (s.charAt(i) == t.charAt(j)) {	// �������еĵ�ǰ�Ƚ��ַ���ͬ�������ȽϺ���ַ�
		    	i++;
		    	j++;  
			} else {	// �������еĵ�ǰ�Ƚ��ַ�����ͬ��i��jָ��������¿�ʼƥ��
				i = i-j+1; 	
				j = 0;
			}  
		}
		
		if (j == tLen)  	//���ȷ���Ƿ�ɹ�ƥ��
			return i-tLen;
		else  
			return -1;
	}

	public static int indexOf_KMP(String s, String t, int start) {
		int i = start, j = 0;	//iΪ�����е�ǰ�Ƚ��ַ���ţ�jΪ�Ӵ��е�ǰ�Ƚ��ַ����
		int sLen=s.length(),tLen=t.length();  

		int[] next = getNext(t);
		while  (i < sLen && j < tLen) {
			if (j == -1 || s.charAt(i) == t.charAt(j)) {	// j==-1��ʾs[i]!=t[0]
		    	i++;
		    	j++;  
			} else {	// �������еĵ�ǰ�Ƚ��ַ�����ͬ��jָ��������¿�ʼƥ��
				j = next[j];
			}  
		}
		
		if (j == tLen)  	//���ȷ���Ƿ�ɹ�ƥ��
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