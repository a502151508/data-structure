class MaxSubSequence{
	public static void main(String arg[]){
		//int seq[] = {-2,11,-4,13,-5,2,-5,-3,12,-9};
		int seq[] = {-8,-4,-3,-2,-11};
		
		System.out.println("the value of sub sequence is " + maxSub_1(seq));
		System.out.println("the value of sub sequence is " + maxSub_2(seq));
		System.out.println("the value of sub sequence is " + maxSub_3(seq));
		System.out.println("the value of sub sequence is " + maxSub_4(seq));
	}
	
	//方法一
	public static int maxSub_1(int[] sequence) {
	   int max = Integer.MIN_VALUE;
	   int n= sequence.length;
	   int sum = 0;
	    
	   //第一重循环执行一次则计算出长度为i的所有子序列和的最大值
	   for (int i = 1; i <= n; i++) {
	      for (int j = 0; j < n; j++) {
	         sum = 0;
	         for (int k = j; k < j + i && k < n; k++)
	         	sum += sequence[k];
	         	
	         if (sum > max) max = sum;
	      }
	   }
	   
	   return max;
	}

	//方法二
	public static int maxSub_2(int[] sequence) {
	   int max = Integer.MIN_VALUE;
	   int n= sequence.length;
	   int sum = 0;
	    
	   for  (int i = 0; i < n; i++) {
          sum = 0;
          for  (int j = i; j <n; j++) {
             sum += sequence[j];
             if (sum > max) max = sum;
          }
	   }
	   
	   return max;
	}	
	
	//方法三
	public static int maxSub_3(int[] sequence){
	   return maxSum(sequence,0, sequence.length-1);
	}

	public static int maxSum(int[] sequence,int left,int right) {
	   if (left==right)
           return sequence[left];
            
	   int mid=(left+right)/2;
	   int maxLeftSum=maxSum(sequence,left,mid);
	   int maxRightSum=maxSum(sequence,mid+1,right);
	   int maxLeftBorderSum=Integer.MIN_VALUE,leftBorderSum=0;
	
       for(int i=mid; i>=left; i--) {
	       leftBorderSum+= sequence [i];
	       if(leftBorderSum>maxLeftBorderSum)
	            maxLeftBorderSum=leftBorderSum;
       }
       
	   int maxRightBorderSum=Integer.MIN_VALUE,rightBorderSum=0;
       for(int i=mid+1; i<=right;i++) {
	       rightBorderSum+= sequence [i];
	       if(rightBorderSum>maxRightBorderSum)
	           maxRightBorderSum=rightBorderSum;
       }

	   return max3(maxLeftSum,maxRightSum,maxLeftBorderSum+maxRightBorderSum);        
    }

	public static int max3( int a,int b,int c){
	   int max=a>b?a:b;
	   max=max>c?max:c;
	   return max;
	}
	
	//方法四(书上方法的前提：整数序列中至少有一个正整数)
	public static int maxSub_4(int[] sequence){
	   int max = 0;		//这里max不能初始化为Integer.MIN_VALUE。why？
//	   int singleMax = sequence[0];
	   int n= sequence.length;
	   int sum = 0; 
	   for (int i = 0; i < n; i++) {
	       sum += sequence[i];
	       if (sum > max)
	           max = sum;
	       else if (sum <= 0)
	           sum = 0;

//	   	   if (sequence[i] > singleMax)
//	   	   	   singleMax = sequence[i];
	   }
	   
//	   if (sum == 0 && singleMax < 0)
//	   	   return max = singleMax;

	   return max;
	}
	
}