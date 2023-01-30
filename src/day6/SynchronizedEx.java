package day6;

class ATM implements Runnable {
	private long depositeMoney = 10000;

	public void run() {
		
		synchronized (this) {
			for (int i = 0; i < 10; i++) {
				try {
					
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if (getDepositeMoney() <= 0)
					break;
				withDraw(1000);
				notifyAll();
				try {
					wait();
					System.out.println("wait 다음");
					
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void withDraw(long howMuch) {
		if (getDepositeMoney() > 0) {
			depositeMoney -= howMuch;
			System.out.print(Thread.currentThread().getName() + " , ");
			System.out.printf("money: %,d %n", getDepositeMoney());
		} else {
			System.out.print(Thread.currentThread().getName() + " , ");
			System.out.println("out.");
		}
	}

	public long getDepositeMoney() {
		return depositeMoney;
	}
}

public class SynchronizedEx {

	public static void main(String[] args) {
		ATM atm = new ATM();

		Thread mother = new Thread(atm, "mother");
		Thread son = new Thread(atm, "son");
		Thread son1 = new Thread(atm, "son1");
		
		mother.start();
		son.start();
		son1.start();
	}

}
