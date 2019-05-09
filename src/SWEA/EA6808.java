package SWEA;

import java.util.Scanner;

public class EA6808 {
	static int[] kyu;
	static int[] in;
	static boolean[] check;
	static long win,lose;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int i = 0; i < T; i++) {
			win = 0;
			lose=0;
			kyu = new int[9];
			in = new int[9];
			check = new boolean[19];
			for (int k = 0; k < 9; k++) {
				kyu[k] = sc.nextInt();
				check[kyu[k]] = true;
			}
			int c = 0;
			for (int k = 1; k < check.length; k++) {
				if (check[k] == false) {
					in[c] = k;
					c++;
				}
			}
			solve(0, 0, 0);
			System.out.println("#"+(i+1)+" "+win+" "+lose);
		}
	}

	public static void solve(int kindex, int kscore, int iscore) {
		if (kindex == kyu.length) {
			if (kscore > iscore)
				win++;
			else if(kscore<iscore)
				lose++;
			return;
		}
		int ks = kyu[kindex];

		for (int i = 0; i < in.length; i++) {
			if (in[i] != -1) {
				int ins = in[i];
				int tks=kscore;
				int tis=iscore;
				if (ks > ins) {
					tks+= ks + ins;
				} else {
					tis += ks + ins;
				}
				in[i]=-1;

				solve(kindex + 1, tks, tis);
				in[i]=ins;
			}
		}
	}
}
