package day7;

public class MemberInner {

	int a = 10;
	private int b = 20;
	static int c = 30;

	public void output() {
		class Inner {
			public void disp() {
				System.out.println(a);
				System.out.println(b);
				System.out.println(c);
			}
		}

		Inner in = new Inner();
		in.disp();
	}

	public static void main(String[] args) {
//		MemberInner mi = new MemberInner();
//		MemberInner.Inner in = mi.new Inner();
//		in.disp();

//		MemberInner.Inner mbIn = new MemberInner().new Inner();
//		mbIn.disp();

		MemberInner mi = new MemberInner();
		mi.output();

	}

}
