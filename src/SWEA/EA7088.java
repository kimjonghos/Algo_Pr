package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class EA7088 {

	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		
		for(int tc=0;tc<T;tc++){
			StringTokenizer st=new StringTokenizer(br.readLine());
			StringBuilder sb=new StringBuilder("#"+(tc+1)+"\n");
			int N=Integer.parseInt(st.nextToken());
			int Q=Integer.parseInt(st.nextToken());
			int [][]map=new int[4][N+1];
			int idx1=0,idx2=0,idx3=0;
			for(int i=1;i<=N;i++){
				int tp=Integer.parseInt(br.readLine());
				if(tp==1){
					map[1][i]=map[1][idx1]+1;
					idx1=i;
				}
				else if(tp==2){
					map[2][i]=map[2][idx2]+1;
					idx2=i;
				}
				else{
					map[3][i]=map[3][idx3]+1;
					idx3=i;
				}
			}
			int res[][]=new int[Q][4];
			for(int q=0;q<Q;q++){
				st=new StringTokenizer(br.readLine());
				int s=Integer.parseInt(st.nextToken());
				int e=Integer.parseInt(st.nextToken());
				for(int a=1;a<=3;a++){
					int ri=e,le=s-1;
					while(s<=ri&&map[a][ri]==0)ri--;
					if(ri<s){
//						sb.append("0 ");
						res[q][a]=0;
					}
					else{
						while(0<le&&map[a][le]==0)le--;
//						sb.append((map[a][ri]-map[a][le])+" ");
						res[q][a]=map[a][ri]-map[a][le];
					}
				}
//				sb.append("\n");
			}
//			System.out.println(sb);
			System.out.println("#"+(tc+1));
			for(int i=0;i<Q;i++){
				System.out.println(res[i][1]+" "+res[i][2]+" "+res[i][3]);
			}
		}
	}

}
