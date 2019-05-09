package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class EA7510 {

	public static void main(String [] args) throws Exception{
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		int []dp=new int[100000];
		for(int i=1;i<dp.length;i++){
			dp[i]++;
			for(int j=1;j<=(i/2)+1;j++){
				int sum=j;
				for(int k=j+1;k<=(i/2)+1;k++){
					sum+=k;
					if(sum>i)
						break;
					if(sum==i){
						dp[i]++;
						break;
					}
					
				}
			}
		}
		for(int tc=1;tc<=T;tc++){
			int n=Integer.parseInt(br.readLine());
			System.out.println(dp[n]);
		}
	}
}
