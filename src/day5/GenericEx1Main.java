package day5;

public class GenericEx1Main {
	public static void main(String[] args) {
		GenericEx1<String> t = new GenericEx1<String>();

		String[] ss = { "애", "아", "서" };
		t.set(ss);
		t.print();
	}
}
