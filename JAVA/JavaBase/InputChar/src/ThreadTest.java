
public class ThreadTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestA a = new TestA();
		TestB b = new TestB();
		Thread t1 = new Thread(a);
		t1.setPriority(Thread.MIN_PRIORITY);//1~10,普通优先级是5
		Thread t2 = new Thread(b);
		t2.setPriority(Thread.MAX_PRIORITY);
		t1.start();
		t2.start();
	}

}

class TestA implements Runnable
{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true)
		{
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				System.out.println("A");
		}
		
	}
	
}

class TestB implements Runnable
{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true)
		{
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				System.out.println("B");
		}
		
	}
	
}