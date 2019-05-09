package SWEA;

import java.util.Scanner;

public class GetMaxMoney2 {
	static int maxMoney,benefit;
	static int [] value;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		for (int i = 0; i < N; i++) {

			int snum = sc.nextInt();
			value = new int[snum];
			for (int k = 0; k < snum; k++) {
				value[k] = sc.nextInt();
			}
			benefit=0;
			maxMoney=value[snum-1];
			for(int j=snum-2;j>=0;j--){
				if(maxMoney<value[j]){
					maxMoney=value[j];
				}
				else{
					benefit+=maxMoney-value[j];
				}
			}
			System.out.println("#"+(i+1)+" "+benefit);
		}
	}

}
