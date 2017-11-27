import java.util.Scanner;

public class MethodDemo01 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("请输入第一个数:");
		int num1 = input.nextInt();
		System.out.println("请输入第二个数(不能为0):");
		int num2 = input.nextInt();
		System.out.println("请选择(1为相加/2为相减/3为相乘/4为相除):");
		int i = input.nextInt();
		switch(i) {
		case 1 :
			plus(num1,num2);
			break;
		case 2 :
			minus(num1,num2);
			break;
		case 3 :
			multiply(num1,num2);
			break;
		case 4 :
			divide(num1,num2);
			break;
		default:
			break;
		}

	}
	public static void plus(int a,int b) {
		System.out.println("相加后结果为:"+(a + b));
	}
	public static void minus(int a,int b) {
		System.out.println("相减后结果为:"+(a - b));
	}
	public static void multiply(int a,int b) {
		System.out.println("相乘后结果为:"+(a * b));
	}
	public static void divide(int a,int b) {
		System.out.println("相除后结果为:"+(a / b));
	}

}
