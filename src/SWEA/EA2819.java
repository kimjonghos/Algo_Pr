package SWEA;

import java.util.Scanner;

public class EA2819 {
	static int [][]map;
	static int [] xl={0,1,0,-1};
	static int [] yl={1,0,-1,0};
	static int [] check;
	static int cnt;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		
		for(int i=0;i<N;i++){
			check=new int[10000001];
			map=new int[4][4];
			cnt=0;
			for(int k=0;k<4;k++){
				for(int j=0;j<4;j++){
					map[k][j]=sc.nextInt();
				}
			}
			for(int k=0;k<4;k++){
				for(int j=0;j<4;j++){
					solve(k,j,1,0);
				}
			}
			
			System.out.println("#"+(i+1)+" "+cnt);
		}
	}
	public static void solve(int x,int y,int depth,int number){
		if(x<0||y<0||x>3||y>3){
			return;
		}
		number=number*10+map[x][y];
		if(depth==7){
			if(check[number]==0){
				check[number]=1;
				cnt++;
			}
			return;
		}		
		
		for(int i=0;i<xl.length;i++){
			int nx=x+xl[i];
			int ny=y+yl[i];
			solve(nx,ny,depth+1,number);
		}
	}
	

}
