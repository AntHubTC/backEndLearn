import java.math.BigInteger;
public class rand {
	
	public static int GetEventNum(double num1,double num2)
	{
		int s = (int)num1 + (int)(Math.random()*(num2-num1));
		if(s%2==0)
			return s;
		else
			return s + 1;
	}
	
	public static void main(String[] args)
	{
		System.out.println(GetEventNum(2,33));
		System.out.println((new BigInteger("2")).divide(new BigInteger("2")));
		System.out.println((new BigInteger("2")).remainder(new BigInteger("2")));
		System.out.println((new BigInteger("2")).equals(new BigInteger("2")));
		System.out.println((new BigInteger("2")).pow(2));
		System.out.println((new BigInteger("2")).negate());
		System.out.println((new BigInteger("2")).shiftLeft(2));
		System.out.println((new BigInteger("2")).shiftRight(2));
		System.out.println((new BigInteger("2")).compareTo(new BigInteger("2")));
		System.out.println((new BigInteger("3")).min(new BigInteger("2")));
		System.out.println((new BigInteger("3")).max(new BigInteger("2")));
	}

}
