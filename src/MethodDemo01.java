import java.util.Scanner;

public class MethodDemo01 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("�������һ����:");
		int num1 = input.nextInt();
		System.out.println("������ڶ�����(����Ϊ0):");
		int num2 = input.nextInt();
		System.out.println("��ѡ��(1Ϊ���/2Ϊ���/3Ϊ���/4Ϊ���):");
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
		System.out.println("��Ӻ���Ϊ:"+(a + b));
	}
	public static void minus(int a,int b) {
		System.out.println("�������Ϊ:"+(a - b));
	}
	public static void multiply(int a,int b) {
		System.out.println("��˺���Ϊ:"+(a * b));
	}
	public static void divide(int a,int b) {
		System.out.println("�������Ϊ:"+(a / b));
	}

}
