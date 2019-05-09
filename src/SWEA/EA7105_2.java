package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class EA7105_2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		long bf=0;
		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[][] map = new int[M + 1][3];// 0 왼 1 오 2 값
			int start=0;
			int []ch=new int[M+1];
			for (int m = 1; m <= M; m++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				map[m][0] = s;
				map[m][1] = e;
				map[m][2] = v;
				ch[s]=e;
				if(s==1) start=m;
			}
			bf=System.currentTimeMillis();
			int []go=new int[M+1];
			int []back=new int[M+1];
			for(int i=1;i<=M;i++){
				for(int k=1;k<=M;k++){
					go[i]+=map[k][2];
					if(map[k][1]==i){
						break;
					}
				}
			}
			for(int i=2;i<=M;i++){
				back[i]=go[1]-go[i];
			}
//			for(int d:go)
//				System.out.print(d+" ");
//			System.out.println();
//			for(int d:back)
//				System.out.print(d+" ");
//			System.out.println();
//			for(int d:ch)
//				System.out.print(d+" ");
//			System.out.println();
			int res=0;
			for(int i=2;i<=M;i++){
				if(ch[i-1]==i){
					if(i-1==1){
						res+=go[i];
					}
					else{
						res+=go[i]-go[i-1];
					}
				}
				else{
					res+=go[i]+back[i-1];
				}
			}
			res+=back[M];
			System.out.println(res);
//			int min = Integer.MAX_VALUE;
//			int sum = 0;
//			boolean res = false;
//			int des = 2;
//			int j = start, tem = 0;
//			while (true) {
//				if (j > M)
//					j = 1;
//				if (j == tem) {
//					break;
//				}
//				sum += map[j][2];
//
//				if (map[j][1] == des) {
//					if (des == 1) {
//						res = true;
//						break;
//					}
//					else{
//					des++;
//					tem = j;
//					}
//				}
//				if (des == N + 1) {
//					des = 1;
//				}
//				j++;
//			}
//			if (res) {
//				if (sum < min) {
//					min = sum;
//					sum = 0;
//				}
//			} else {
//				min = -1;
//			}
//			System.out.println("#" + (tc + 1) + " " + min);
		}
		long ed=System.currentTimeMillis();
		System.out.println(ed+" "+bf);
	}
}
