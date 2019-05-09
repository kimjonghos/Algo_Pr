package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class EA5550 {

	public static void main(String [] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		for(int tc=0;tc<T;tc++){
			char [] str=br.readLine().toCharArray();
			char [] croak={'c','r','o','a','k'};
			boolean [] check=new boolean[str.length];
			int minidx=2501;
			boolean res=true;
			int count=0;
			int []checkk=new int[str.length];
			for(int i=0;i<str.length;i++){
				
				if(str[i]!='c')
					continue;
				res=false;
				check[i]=true;
				if(i<minidx){
					boolean ck=false;
					for(int c=0;c<i;c++){
						if(checkk[c]>0){
							ck=true;
							checkk[c]--;
						}
					}
					if(!ck)
						count++;
				}
				int index=1;
				for(int k=i+1;k<str.length;k++){
					if(!check[k]&&str[k]==croak[index]){
						check[k]=true;
						index++;
					}
					if(index==5){
						res=true;
						if(minidx==2501)
							minidx=k;
						else if(i>minidx){
							minidx=k;
						}
						checkk[k]++;
						break;
					}
				}
				if(!res){
					break;
				}
			}
			System.out.print("#"+(tc+1)+" ");
			if(!res)
				System.out.println("-1");
			else
				System.out.println(count);
		}
	}
}
