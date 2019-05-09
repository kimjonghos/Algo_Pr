package SWEA;

import java.util.Scanner;

public class EA6853 {
	static int [] square;
	static int [][] spotlocation;
	static int [] result;
	static int spotNum;
	public static void main(String [] args){
		
		Scanner sc=new Scanner(System.in);
		
		int T=sc.nextInt();
		
		for(int i=0;i<T;i++){
			square=new int[4];
			result=new int[3];
			for(int k=0;k<4;k++){
				square[k]=sc.nextInt();
			}
			spotNum=sc.nextInt();
			int spotcount=0;
			spotlocation=new int[spotNum][2];
			for(int k=0;k<spotNum;k++){
				spotlocation[spotcount][0]=sc.nextInt();
				spotlocation[spotcount][1]=sc.nextInt();
				spotcount++;
			}
			solve(0);
			System.out.println("#"+(i+1)+" "+result[0]+" "+result[1]+" "+result[2]);
		}
	}
	public static void solve(int nowSpotCount){
		if(nowSpotCount==spotNum){
			return;
		}
		int x=spotlocation[nowSpotCount][0];
		int y=spotlocation[nowSpotCount][1];
		
		if(x>=square[0]&&x<=square[2]&&y>=square[1]&&y<=square[3]){
			if(x==square[0]||x==square[2]||y==square[1]||y==square[3]){
				result[1]++;
			}else{
				result[0]++;
			}
		}
		else{
			result[2]++;
		}
		solve(nowSpotCount+1);
		
	}
}
