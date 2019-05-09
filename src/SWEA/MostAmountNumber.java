package SWEA;

import java.util.Scanner;

public class MostAmountNumber {
	static int[] scores ;
	static int[] count ;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for (int i = 0; i < N; i++) {
			int cn = sc.nextInt();
			scores= new int[1000];
			count= new int[101];
			for (int k = 0; k < scores.length; k++) {
				scores[k] = sc.nextInt();
			}
			for (int j : scores) {
//				System.out.println("scores value : " + j);
				count[j]++;
			}
			int mindex = 0;
			for (int k = 1; k < count.length; k++) {
				if (count[mindex] <= count[k]) {
					mindex = k;
				}
			}
			 System.out.println("#"+cn+" "+mindex);
		}

	}
}
