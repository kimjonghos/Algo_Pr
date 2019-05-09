package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class EA6719 {
	static int [] w;
	public static void main(String [] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		for(int tc=0;tc<T;tc++){
			StringTokenizer st=new StringTokenizer(br.readLine()," ");
			int N=Integer.parseInt(st.nextToken());
			int K=Integer.parseInt(st.nextToken());
			w=new int[N];
			st=new StringTokenizer(br.readLine()," ");
			for(int i=0;i<N;i++){
				w[i]=Integer.parseInt(st.nextToken());
			}
			Arrays.sort(w);
			double sum=0;
			for(int i=N-K;i<N;i++){
				sum=(sum+w[i])/2;
			}
			System.out.println("#"+(tc+1)+" "+sum);
		}
	}
}
