package dataStructure;

public class Example2_1 {
	public static void main (String[] args) throws Exception {
      SqList<Character> L = new SqList(10); 
      L.insert(0, 'a'); 
      L.insert(1, 'z');
      L.insert(2, 'd');
      L.insert(3, 'm');
      L.insert(4, 'z');
      L.insert(5, 'b');
      L.insert(6, 'x');
      L.insert(7, 't');
      L.insert(8, 'y');
      L.insert(9, 'z');
      L.insert(10, 'w');
      L.insert(11, 'z');
      L.insert(12, 'z');
      L.insert(13, 'z');
      L.insert(14, 'm');
      L.insert(15, 'z');
      L.insert(16, 'b');
      L.insert(17, 'x');
      L.insert(18, 't');
      L.insert(19, 'y');
      L.insert(20, 'z');
      L.insert(21, 'w');
      L.insert(22, 'z');
      L.insert(23, 'z');
      L.insert(24, 'z');
      L.insert(25, 'm');
      L.insert(26, 'z');
      L.insert(27, 'b');
      L.insert(28, 'x');
      L.insert(29, 't');
      L.insert(30, 'y');
      L.insert(31, 'z');
      L.insert(32, 'w');
      L.insert(33, 'z');
      L.insert(34, 'z');
      L.insert(35, 'z');
      System.out.println("���Ա���Ϊ:"+L.length());
      int order = L.indexOf('b');
      if (order != -1)
	  	 System.out.println("˳����е�һ�γ��ֵ�ֵΪ'b'������Ԫ�ص�λ��Ϊ��" + order);
      else
		 System.out.println("��˳����в�����ֵΪ'b'������Ԫ�أ�");
	}
}
