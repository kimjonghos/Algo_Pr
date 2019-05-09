package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class EA5213_2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		long[] ary = new long[1000001];
		for (int i = 1; i <= 1000000; i = i + 2) {
			for (int k = i; k <= 1000000; k += i) {
				ary[k] = ary[k] + i;
			}
		}
		for (int i = 1; i <= 1000000; i++) {
			ary[i] += ary[i - 1];
		}
		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int L=Integer.parseInt(st.nextToken());
			int R=Integer.parseInt(st.nextToken());
			System.out.println("#" + (tc + 1) + " " +(ary[R]-ary[L-1]));
		}
	}

}
