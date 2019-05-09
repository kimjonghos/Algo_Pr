package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class EA4672 {

	public static void main(String [] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		for(int tc=0;tc<T;tc++){
			char [] str=br.readLine().toCharArray();
			
			int res=str.length;
			int [] check=new int['z'-'a'+1];
			for(int i=0;i<str.length;i++){
				check[str[i]-'a']++;
			}
			for(int i=0;i<check.length;i++){
				if(check[i]>1){
					
					int t=check[i];
					for(int k=1;k<t;k++){
						for(int j=k;j<t;j++){
							res++;
						}
					}
				}
			}
			System.out.println("#"+(tc+1)+" "+res);
		}
	}
}
