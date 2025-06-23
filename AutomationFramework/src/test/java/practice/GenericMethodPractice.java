package practice;

public class GenericMethodPractice {

	public static void main(String[] args) {//caller function
		
		/* hardcoding
		 * int a =10; int b= 20; int c = a + b; System.out.println(c);
		 */
		System.out.println("addition results");
		int sum = add(10, 20);
		System.out.println(sum);
		System.out.println(add(sum, 20));
		System.out.println(add(50, 20));
		System.out.println(add(30,sum));
		
		System.out.println("subtraction results");
		int subtraction = sub(20, 10);
		System.out.println(subtraction);
		System.out.println(sub(30, subtraction));
		
		System.out.println("product results");
		int product = product(20, 30);
		System.out.println(product);
		System.out.println(product(30, product));
		
		System.out.println("division results");
		int division  = division(20, 40);
		System.out.println(division);
		System.out.println(division(30, division));
	}

	public static int add(int a, int b) {//called function - generic
		int result = a + b;
		return result;
	}
	
	public static int sub(int a, int b) {
		int result = a - b;
		return result;
	}
	
	public static int product(int x, int y) {
		int result = x * y;
		return result;
	}
	
	public static int division(int x, int y) {
		int result = x % y;
		return result ;
	}
}
