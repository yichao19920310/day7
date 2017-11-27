

import java.util.Arrays;
import java.util.Scanner;

public class Homework01 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		boolean keep = true;
		int count = 0;
		int[] arr = arrayCreate();
		int numMax = arr.length * 2 ;
		while (keep) {
			System.out.println("请选择你想要的操作:");
			System.out.print("1.获取实际元素的个数 ");
			System.out.print("2.获取指定位置的元素 ");
			System.out.print("3.向指定位置添加元素 ");
			System.out.print("4.根据元素移除 ");
			System.out.print("5.冒泡排序 ");
			System.out.println("6.验证是否包含指定元素 ");
			int choose = input.nextInt();
			switch (choose) {
			case 1:
				count = countValid(arr);
				System.out.println("此数组中实际元素的个数为:" + count);
				break;
			case 2:
				select(arr);
				break;
			case 3:
				count = countValid(arr);
				arr = addElement(arr, count, numMax);
				break;
			case 4:
				arr = subElement(arr);
				break;
			case 5:
				arr = bubbleSort(arr);
				break;
			case 6:
				verify(arr);
				break;
			default:
				System.out.println("无效指令");
				break;
			}
			System.out.println("1:继续 2:重置 3:退出");
			int branch = input.nextInt();
			switch (branch) {
			case 1:
				break;
			case 2:
				arr = arrayCreate();
				numMax = arr.length * 2;
				break;
			case 3:
				System.out.println("再见!");
				return;
			default:
				System.out.println("无效指令,默认退出");
				return;
			}
		}
	}

	public static int[] arrayCreate() {
		int n = (int) (Math.random() * 10 + 1);
		System.out.println("原始数组的长度为:" + n);
		int[] arr = new int[n];
		int m = 0;
		while (true) {
			m = (int) (Math.random() * 10 + 1);
			if (m <= n) {
				break;
			} else {
				;
			}
		}
		System.out.println("初始填充的元素个数为:" + m);
		for (int i = 0; i < m; i++) {
			arr[i] = (int) (Math.random() * 2 * n + 1);
			for (int j = 0; j < i; j++) {
				if (arr[j] == arr[i]) {
					i--;
					break;
				} else {
					;
				}
			}
		}
		System.out.println("数组初始化完毕,为:" + Arrays.toString(arr));
		return arr;
	}

	public static int countValid(int[] arr) {
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0) {
				count++;
			} else {
				;
			}
		}

		return count;
	}

	public static void select(int[] arr) {
		Scanner input = new Scanner(System.in);
		System.out.println("请输入要获取的元素位置:");
		int index = input.nextInt();
		while (true) {
			if (index >= 0 && index < arr.length) {
				break;
			} else {
				System.out.println("超出范围,请重新输入:");
				index = input.nextInt();
			}
		}
		System.out.println("该元素的值为:" + arr[index]);
	}

	public static int[] addElement(int[] arr, int count, int numMax) {
		Scanner input = new Scanner(System.in);
		int num = 0;
		if (arr.length > count + 1 && arr[arr.length - 1] == 0) {

		} else {
			arr = Arrays.copyOf(arr, arr.length + 1);
		}
		System.out.println("请输入要插入的值:");
		boolean isSame = true;
		
		while (true) {
			num = input.nextInt();
			for (int i = 0; i < arr.length; i++) {
				if(num == arr[i] && num != 0) {
					System.out.println("不可以有相同元素,请重新输入:");
					isSame = true;
					break;
				} else {
					isSame = false;
				}
			}
			if(isSame) {
				continue;
			} else if (num < 1 || num > numMax) {
				System.out.println("超出元素取值范围(1~"+ numMax +"),请重新输入:");
			} else {
				break;
			}	
		}
		System.out.println("请输入要插入的位置:");
		int index = input.nextInt();
		while (true) {
			if (index >= 0 && index < arr.length) {
				break;
			} else {
				System.out.println("超出范围,请重新输入:");
				index = input.nextInt();
			}
		}
		int temp1 = arr[index], temp2 = 0;
		for (int i = index; i < arr.length; i++) {
			if (i == index) {
				arr[i] = num;
			} else {
				temp2 = arr[i];
				arr[i] = temp1;
				temp1 = temp2;
			}
		}
		System.out.println("插入后的数组为:" + Arrays.toString(arr));
		return arr;
	}

	public static int[] subElement(int[] arr) {
		Scanner input = new Scanner(System.in);
		if (arr.length == 0) {
			System.out.println("数组里已经没有数啦!");
			return arr;
		}
		while (true) {
			System.out.println("请输入要删除的数:");
			int num = input.nextInt();
			int match = 0;
			int[] temp = new int[arr.length];
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] == num) {
					System.out.println("找到第" + ++match + "个匹配的数,下标为" + i);
					temp[match - 1] = i;
				}
			}
			if (match == 0) {
				System.out.println("没有你要删除的数,请重新输入.");
				continue;
			} else {
				for (int i = 0; i < match; i++) {
					for (int j = temp[i] - i; j < arr.length - 1; j++) {
						arr[j] = arr[j + 1];
					}

					arr = Arrays.copyOf(arr, arr.length - 1);
				}
				System.out.println("删除后数组为:" + Arrays.toString(arr));
			}
			break;
		}
		return arr;
	}

	public static int[] bubbleSort(int[] arr) {
		int temp = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - 1 - i; j++) {
				if (arr[j] > arr[j + 1]) {
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				} else {
					;
				}
			}
		}
		System.out.println("排序后数组为:" + Arrays.toString(arr));
		return arr;
	}

	public static void verify(int[] arr) {
		Scanner input = new Scanner(System.in);
		System.out.println("请输入要查找的数:");
		int num = input.nextInt();
		int match = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == num) {
				System.out.println("找到了,该数在下标为" + i + "的位置");
				match++;
			} else {
				;
			}
		}
		if (match == 0) {
			System.out.println("此数组中没有找到该数.");
		} else {
			;
		}	
	}

				
}
