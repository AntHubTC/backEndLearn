package tc;

import java.util.Arrays;

public class test1 {
	public static void main(String[] args) {
		int a[] = {0,2,0,1,1};
		System.out.println(Arrays.toString(a));
		for (int i = 0; i < a.length; i++) {
			if(a[i] == 0){
				for (int j = i; j < a.length -1; j++) {
					a[j] = a[j+1];
					a[j+1] = 0;
				}
			}
		}
		System.out.println(Arrays.toString(a));
	}
}
