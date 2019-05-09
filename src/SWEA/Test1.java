package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test1 {
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
		so(n,0,0);
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
		check=new boolean[answer];
		dp=new boolean[1000];
		int count=0;
		for(int i=2;i<=n;i++){
			if(ary[i]==0){
				sosu[count]=i;
				count++;
			}
		}
		return answer;
	}
	public static void so(int n,int sum,int count){
		int temp=0;
		for(int i=0;i<check.length;i++){
			if(check[i]){
				temp=temp*10+i;
			}
		}
		if(n<sum){
			return;
		}
		if(n==sum&&count==3&&!dp[temp]){
			dp[temp]=true;
			res++;
			return;
		}
		if(count>2){
			return;
		}
		
		for(int i=0;i<sosu.length;i++){
			if(!check[i]){
				check[i]=true;
				so(n,sum+sosu[i],count+1);
				check[i]=false;
			}
			
		}
	}

}
