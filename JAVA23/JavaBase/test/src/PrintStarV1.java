
public class PrintStarV1 {
	
	public static void main(String[] args) {
		
		int i = 9,
			j = 0,
			num = -2;
		boolean isBreak = false;
		while(!isBreak){
			j = 0;
			if(i>9){
				isBreak = true;
				continue;
			}
			for(; j<i; j++){
				System.out.print("*");
			}
			System.out.println();
			if(i<=1) num = 2;
			i+=num;
		}	
	}
}
