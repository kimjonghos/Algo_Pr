package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class EA7272 {
	//ADOPQR는 같은 문자
	//CEFGHIJKLMNSTUVWXYZ는 같은문자
	public static void main(String [] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++){
			String [] str=br.readLine().split(" ");
			boolean res=false;
			if(str[0].length()==str[1].length()){
				res=solve(str[0].length(),0,str[0],str[1]);
			}
			else{
				res=false;
			}
			if(res)
				System.out.println("#"+tc+" SAME");
			else
				System.out.println("#"+tc+" DIFF");
			
		}
	}
	public static boolean solve(int len,int cnt,String str1,String str2){
		if(cnt==len){
			return true;
		}
		boolean res=false;
		char cstr1=str1.charAt(0);
		char cstr2=str2.charAt(0);
		if(cstr1=='A'||cstr1=='D'||(cstr1>=79&&cstr1<=82)){
			if(cstr2=='A'||cstr2=='D'||(cstr2>=79&&cstr2<=82)){
				res=true;
			}
		}
		else if(cstr1=='B'&&cstr2=='B'){
			res=true;
		}
		else if(cstr1!='B'&&cstr1!='A'&&cstr1!='D'&&(cstr1<79||cstr1>82)){
			if(cstr2!='B'&&cstr2!='A'&&cstr2!='D'&&(cstr2<79||cstr2>82)){
				res=true;
			}
		}
		if(res){
			return solve(len,cnt+1,str1.substring(1, str1.length()),str2.substring(1, str2.length()));
		}
		else{
			return false;
		}
		
		
	}
}
