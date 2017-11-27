
public class MethodDemo02 {

	public static void main(String[] args) {
		int a = 0;
		m1(a);
		System.out.println(a);
		a = m2(a);
		System.out.println(a);
		String s = "";
		m3(s);
		System.out.println(s);
		s = m4(s);
		System.out.println(s);
		
		
	}
	public static void m1(int i) {
		i=10;
	}
	public static int m2(int i) {
		return i = 10;
	}
	public static void m3(String str) {
		str = "Hello";
	}
	public static String m4(String str) {
		return str = "Hello";
	}

}
