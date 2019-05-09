package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Line5 {
	static int res=Integer.MAX_VALUE;
	static boolean [][]check=new boolean[200000][10];
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String []lo=br.readLine().split(" ");
		int co=Integer.parseInt(lo[0]);
		int bro=Integer.parseInt(lo[1]);
		solve(co,bro,1,0);
		System.out.println(res);
		System.out.println(Integer.MAX_VALUE);
		
		for(int i=1;co<=200000;i++){
			bro=
			co=co+i;
		}
		
	}
	public static void solve(int co,int brow,int count,int move){
		if(brow>200000||co>200000){
			return;
		}
		if(check[brow][move]){
			return;
		}
		if(co==brow){
			if(res>count){
				res=count;
			}
			return;
		}
		check[brow][move]=true;
		if(brow-1>=0){
			solve(co+count,brow-1,count+1,1);
		}
		solve(co+count,brow+1,count+1,2);
		solve(co+count,brow*2,count+1,3);
	}
}
