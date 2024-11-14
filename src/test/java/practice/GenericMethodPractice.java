package practice;

public class GenericMethodPractice {
	public static void main(String[] args) {//calling
		int sum=add(20,30);
		System.out.println(sum);
		System.out.println(add(sum,sum));
		int sum1=add(1,2,3);
		System.out.println(sum1);
		
	}
	//method to add
	public static int add(int a,int b) {//called-generic method
		int c=a+b;
		return c;
		
	}
	public static int add(int a,int b,int s) {
		int c=a+b+s;
		return c;
		
	}

}
