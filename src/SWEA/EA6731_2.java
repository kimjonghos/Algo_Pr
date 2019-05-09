package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class EA6731_2 {
	static int[] c;
	static int[] r;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {

			int N = Integer.parseInt(br.readLine());
			c = new int[N];
			r = new int[N];
			String[] str = new String[N];
			for (int k = 0; k < N; k++) {
				str[k] = br.readLine();
				for (int j = 0; j < N; j++) {
					if (str[k].charAt(j) == 'B') {
						r[k]++;
						c[j]++;
					}

				}
			}

			int res = 0;
			for (int j = 0; j < N; j++) {
				for (int a = 0; a < N; a++) {
					if (str[j].charAt(a) == 'B') {
						if((r[j] + c[a]-1) % 2 != 0)
							res++;
					}
					else{
						if((r[j]+c[a])%2!=0)
							res++;
					}
				}
			}
			System.out.println("#" + (i + 1) + " " + res);

		}

	}

}
