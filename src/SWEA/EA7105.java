package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class EA7105 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		long bf=0;
		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[][] map = new int[N + 1][N + 1];
			int [] ch=new int[N];
			int idx=0;
			for (int m = 0; m < M; m++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				map[s][e]=v;
				if(e==1){
					ch[idx++]=s;
				}
			}
			bf=System.currentTimeMillis();
			int min=Integer.MAX_VALUE;
			int sum=0;
			boolean res=true;
			boolean [] desc=new boolean[N+1];
			for(int i=0;i<idx;i++){
				int des=ch[i];
				sum+=map[des][1];
				System.out.println(des);
				for(int j=0;j<N-1;j++){
					if(desc[des]==true){
						res=false;
						System.out.println("false");
						break;
					}
					int temp=Integer.MAX_VALUE,tdes=0;
					for(int k=1;k<=N;k++){
						if(map[k][des]!=0){
							if(temp>map[k][des]){
								temp=map[k][des];
								tdes=k;
							}
						}
						else{
							sum+=map[k][des];
						}
					}
					if(tdes==0){
						res=false;
						break;
					}else{
						sum+=map[tdes][des];
						des=tdes;
					}
				}
				if(res&&min>sum){
					min=sum;
					sum=0;
				}
			}
			System.out.println(min);
		}
		long ed=System.currentTimeMillis();
		System.out.println(ed-bf);
	}
}
