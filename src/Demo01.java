import java.util.Arrays;
import java.util.Scanner;

public class Demo01 {

	public static void main(String[] args) {
		int[]arr1 = {1,2,3,4,5};
		System.out.println("原始数组为:" + Arrays.toString(arr1));
		Scanner input = new Scanner(System.in);
		System.out.println("请输入要插入的数:");
		int num = input.nextInt();
		System.out.println("请输入要插入的位置(下标0到"+(arr1.length)+"):");
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
		System.out.println("现在数组为:" + Arrays.toString(arr2));
		System.out.println("请输入要删除的位置(下标0到"+(arr2.length-1)+"):");
		index = input.nextInt();
		int []arr3 = new int[arr2.length - 1];
		for(int i = 0; i < arr3.length; i++) {
			if(index > i) {
				arr3[i] = arr2[i];
			}else {
				arr3[i] = arr2[i+1];
			}
		}
		System.out.println("现在数组为:" + Arrays.toString(arr3));

	}

}