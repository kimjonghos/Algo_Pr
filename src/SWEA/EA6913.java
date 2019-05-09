package SWEA;

import java.util.Scanner;

public class EA6913 {
	static int [][]map;
	static int pnum;
	public static void main(String [] args){
		Scanner sc=new Scanner(System.in);
		
		int T=sc.nextInt();
		for(int i=0;i<T;i++){
			
			pnum=0;
			int r=sc.nextInt();
			int c=sc.nextInt();
			map=new int[r][c];
			for(int k=0;k<r;k++){
				for(int j=0;j<c;j++){
					map[k][j]=sc.nextInt();
				}
			}
			int max=solve();
			System.out.println("#"+(i+1)+" "+pnum+" "+max);
			
		}
	}
	public static int solve(){
		int max=0;
		
		for(int i=0;i<map.length;i++){
			int count=0;
			for(int k=0;k<map[0].length;k++){
				if(map[i][k]==1)
					count++;
			}
			if(count>max){
				max=count;
				pnum=1;
			}
			else if(count==max){
				pnum++;
			}
		}
		return max;
	}
	
}
