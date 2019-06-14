
public class PrintStarV2 {

	public static void main(String[] args) {
		int i = 9,
			num = 2,
			k = i;
		boolean isBreak = false;
		while(!isBreak){
			if(i>9){
				isBreak = true;
				continue;
			}
			for(int j=0; j<i; j++){
				System.out.print("*");
			}
			System.out.println();
			k-=num;
			if(-1 == k){
				k-=num;
			}
			i = Math.abs(k);
		}
	}
}
