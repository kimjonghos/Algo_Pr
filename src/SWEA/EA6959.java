package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class EA6959 {

	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		
		
		for(int tc=0;tc<T;tc++){
			StringBuilder N=new StringBuilder(br.readLine());
			int res=0;
			while(true){
				int len=N.length();
				if(len==1){
					break;
				}
				else{
					int a=(N.charAt(len-2)-'0')+(N.charAt(len-1)-'0');
					N.delete(len-2,len);
					N.append(a);
					res++;
				}
			}
			System.out.print("#"+(tc+1)+" ");
			if(res%2==0){
				System.out.println("B");
			}
			else{
				System.out.println("A");
			}
		}
		
	}

}
