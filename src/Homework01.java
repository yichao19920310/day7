

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
			System.out.println("��ѡ������Ҫ�Ĳ���:");
			System.out.print("1.��ȡʵ��Ԫ�صĸ��� ");
			System.out.print("2.��ȡָ��λ�õ�Ԫ�� ");
			System.out.print("3.��ָ��λ�����Ԫ�� ");
			System.out.print("4.����Ԫ���Ƴ� ");
			System.out.print("5.ð������ ");
			System.out.println("6.��֤�Ƿ����ָ��Ԫ�� ");
			int choose = input.nextInt();
			switch (choose) {
			case 1:
				count = countValid(arr);
				System.out.println("��������ʵ��Ԫ�صĸ���Ϊ:" + count);
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
				System.out.println("��Чָ��");
				break;
			}
			System.out.println("1:���� 2:���� 3:�˳�");
			int branch = input.nextInt();
			switch (branch) {
			case 1:
				break;
			case 2:
				arr = arrayCreate();
				numMax = arr.length * 2;
				break;
			case 3:
				System.out.println("�ټ�!");
				return;
			default:
				System.out.println("��Чָ��,Ĭ���˳�");
				return;
			}
		}
	}

	public static int[] arrayCreate() {
		int n = (int) (Math.random() * 10 + 1);
		System.out.println("ԭʼ����ĳ���Ϊ:" + n);
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
		System.out.println("��ʼ����Ԫ�ظ���Ϊ:" + m);
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
		System.out.println("�����ʼ�����,Ϊ:" + Arrays.toString(arr));
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
		System.out.println("������Ҫ��ȡ��Ԫ��λ��:");
		int index = input.nextInt();
		while (true) {
			if (index >= 0 && index < arr.length) {
				break;
			} else {
				System.out.println("������Χ,����������:");
				index = input.nextInt();
			}
		}
		System.out.println("��Ԫ�ص�ֵΪ:" + arr[index]);
	}

	public static int[] addElement(int[] arr, int count, int numMax) {
		Scanner input = new Scanner(System.in);
		int num = 0;
		if (arr.length > count + 1 && arr[arr.length - 1] == 0) {

		} else {
			arr = Arrays.copyOf(arr, arr.length + 1);
		}
		System.out.println("������Ҫ�����ֵ:");
		boolean isSame = true;
		
		while (true) {
			num = input.nextInt();
			for (int i = 0; i < arr.length; i++) {
				if(num == arr[i] && num != 0) {
					System.out.println("����������ͬԪ��,����������:");
					isSame = true;
					break;
				} else {
					isSame = false;
				}
			}
			if(isSame) {
				continue;
			} else if (num < 1 || num > numMax) {
				System.out.println("����Ԫ��ȡֵ��Χ(1~"+ numMax +"),����������:");
			} else {
				break;
			}	
		}
		System.out.println("������Ҫ�����λ��:");
		int index = input.nextInt();
		while (true) {
			if (index >= 0 && index < arr.length) {
				break;
			} else {
				System.out.println("������Χ,����������:");
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
		System.out.println("����������Ϊ:" + Arrays.toString(arr));
		return arr;
	}

	public static int[] subElement(int[] arr) {
		Scanner input = new Scanner(System.in);
		if (arr.length == 0) {
			System.out.println("�������Ѿ�û������!");
			return arr;
		}
		while (true) {
			System.out.println("������Ҫɾ������:");
			int num = input.nextInt();
			int match = 0;
			int[] temp = new int[arr.length];
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] == num) {
					System.out.println("�ҵ���" + ++match + "��ƥ�����,�±�Ϊ" + i);
					temp[match - 1] = i;
				}
			}
			if (match == 0) {
				System.out.println("û����Ҫɾ������,����������.");
				continue;
			} else {
				for (int i = 0; i < match; i++) {
					for (int j = temp[i] - i; j < arr.length - 1; j++) {
						arr[j] = arr[j + 1];
					}

					arr = Arrays.copyOf(arr, arr.length - 1);
				}
				System.out.println("ɾ��������Ϊ:" + Arrays.toString(arr));
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
		System.out.println("���������Ϊ:" + Arrays.toString(arr));
		return arr;
	}

	public static void verify(int[] arr) {
		Scanner input = new Scanner(System.in);
		System.out.println("������Ҫ���ҵ���:");
		int num = input.nextInt();
		int match = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == num) {
				System.out.println("�ҵ���,�������±�Ϊ" + i + "��λ��");
				match++;
			} else {
				;
			}
		}
		if (match == 0) {
			System.out.println("��������û���ҵ�����.");
		} else {
			;
		}	
	}

				
}
