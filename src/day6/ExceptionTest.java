package day6;

public class ExceptionTest {

	public static void main(String[] args) throws ArrayIndexOutOfBoundsException {
		// TODO Auto-generated method stub
		int [] arr = {1,2,3,4};
		
			for(int i = 0; i < 5; i++) {
				try{
				System.out.println(arr[i]);
				
				} catch (ArrayIndexOutOfBoundsException e) { // 예외처리기.
					System.out.println(e);
					
				} catch (Exception e) {
					System.out.println(e);
				}
				finally {
					System.out.println("Test" + i);
				}
			}
		System.out.println("End...");
	}

}
