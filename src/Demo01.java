import java.util.Arrays;
import java.util.Scanner;

public class Demo01 {

	public static void main(String[] args) {
		int[]arr1 = {1,2,3,4,5};
		System.out.println("ԭʼ����Ϊ:" + Arrays.toString(arr1));
		Scanner input = new Scanner(System.in);
		System.out.println("������Ҫ�������:");
		int num = input.nextInt();
		System.out.println("������Ҫ�����λ��(�±�0��"+(arr1.length)+"):");
		int index = input.nextInt();
		int []arr2 = Arrays.copyOf(arr1,arr1.length+1);
		for (int i = 0; i < arr2.length; i++) {
			if(index == i) {
				arr2[i] = num;
			}else if(index < i){
				arr2[i] =arr1[i-1];
			}else {
				;
			}
		}
		System.out.println("��������Ϊ:" + Arrays.toString(arr2));
		System.out.println("������Ҫɾ����λ��(�±�0��"+(arr2.length-1)+"):");
		index = input.nextInt();
		int []arr3 = new int[arr2.length - 1];
		for(int i = 0; i < arr3.length; i++) {
			if(index > i) {
				arr3[i] = arr2[i];
			}else {
				arr3[i] = arr2[i+1];
			}
		}
		System.out.println("��������Ϊ:" + Arrays.toString(arr3));

	}

}