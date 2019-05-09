package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test1_2{
	static int [] ary;
	static int [] sosu;
	static int res;
	static boolean []check;
	static boolean [] dp;
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		System.out.println(solution(n));
		for(int a:ary)
			System.out.print(a+" ");
		System.out.println();
		for(int a:sosu)
			System.out.print(a+" ");
		System.out.println("결과"+res);
		
	}
	public static int solution(int n){
		int answer=0;
		ary=new int[n+1];
		for(int i=2;i<=Math.sqrt(n);i++){
			if(ary[i]!=0)
				continue;
			for(int j=i+i;j<=n;j+=i){
				ary[j]=1;
			}
		}
		for(int i=2;i<=n;i++){
			if(ary[i]==0)
				answer++;
		}
		
		
		sosu=new int[answer];
		int count=0;
		for(int i=2;i<=n;i++){
			if(ary[i]==0){
				sosu[count]=i;
				count++;
			}
		}
		answer=0;
		for(int i=0;i<sosu.length-2;i++){
			for(int k=i+1;k<sosu.length-1;k++){
				for(int j=k+1;j<sosu.length;j++){
					if(sosu[i]+sosu[k]+sosu[j]==n){
						res++;
					}
				}
			}
		}
		return answer;
	}

}
