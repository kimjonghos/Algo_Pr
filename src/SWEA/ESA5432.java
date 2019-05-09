package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ESA5432 {

	public static void main(String [] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		for(int tc=0;tc<T;tc++){
			char [] str=br.readLine().toCharArray();
			int res=0,stick=0;
			for(int i=0;i<str.length;i++){
				if(i+1<str.length&&str[i]=='('&&str[i+1]==')'){
					res+=stick;
				}
				else if(str[i]=='('){
					stick++;
				}
				else if(str[i-1]!='('&&str[i]==')'){
					stick--;
					res++;
				}
			}
			System.out.println("#"+(tc+1)+" "+res);
		}
	}
}
