package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class EA5213 {

	public static void main(String [] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		
		for(int tc=0;tc<T;tc++){
			StringTokenizer st=new StringTokenizer(br.readLine());
			int L=Integer.parseInt(st.nextToken());
			int R=Integer.parseInt(st.nextToken());
			long sum=0;
			sum+=R-L+1;
			for(int i=L;i<=R;i++){
				if(i%2!=0)
					sum+=i;
				for(int k=2;k<=Math.sqrt(i);k++){
					int n=i%k;
					int m=i/k;
					if(n==0){
						if(k%2!=0)
							sum+=k;
						if(m%2!=0&&m!=k){
							sum+=m;
						}
					}
				}
			}
			System.out.println("#"+(tc+1)+" "+sum);
		}
	}
	
}
