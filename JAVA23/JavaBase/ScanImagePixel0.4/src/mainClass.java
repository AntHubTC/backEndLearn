
public class mainClass {
	public static void main(String[] args) {
		BufferImageTest bIT = new BufferImageTest();
		Thread t = new Thread(bIT);
		t.start();
	}
}
