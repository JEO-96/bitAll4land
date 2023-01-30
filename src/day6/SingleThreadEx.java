package day6;

public class SingleThreadEx implements Runnable {
	private int[] temp;
	
	public SingleThreadEx() {
		temp = new int[10];
		for (int start = 0; start < temp.length; start++) {
			temp[start] = start;
		}
	}

	public void run() {
		for (int start : temp) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
			System.out.printf("쓰레드이름 : %s ,", Thread.currentThread().getName());
			System.out.printf("temp value : %d %n", start);
		}
	}

	public static void main(String[] args) {
		SingleThreadEx st = new SingleThreadEx();
		Thread th = new Thread(st, "Superman");
		th.start();
	}

}
