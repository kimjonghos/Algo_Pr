package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class EA5656 {
	static int [][]map;
	static int []he;
	static int [] xl={0,1,0,-1};
	static int [] yl={-1,0,1,0};
	static int N,W,H,max,res,sum;
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=T;tc++){
			StringTokenizer st=new StringTokenizer(br.readLine()," ");
			N=Integer.parseInt(st.nextToken());
			W=Integer.parseInt(st.nextToken());
			H=Integer.parseInt(st.nextToken());
			he=new int[W+1];
			max=0;
			res=0;
			sum=0;
			map=new int[H+1][W+1];
			for(int i=1;i<=H;i++){
				st=new StringTokenizer(br.readLine());
				for(int k=1;k<=W;k++){
					map[i][k]=Integer.parseInt(st.nextToken());
					if(map[i][k]!=0)
						sum++;
					if(he[k]==0&&map[i][k]!=0){
						he[k]=i;
					}
				}
			}
//			for(int i=1;i<=W;i++){
//				if(he[i]>H){
//					continue;
//				}
//				int [][]temp1=copy();
//				boom(he[i],i);
//				set();
//				for(int k=1;k<=W;k++){
//					if(he[k]>H){
//						continue;
//					}
//					int[][]temp2=copy();
//					boom(he[k],k);
//					set();
//					for(int j=1;j<=W;j++){
//						if(he[j]>H){
//							continue;
//						}
//						int[][]temp3=copy();
//						boom(he[j],j);
//						set();
////						System.out.println("i : "+k+", k : "+j+", "+"j : "+j+" res : "+res);
//						if(res>max){
//							max=res;
//						}
//						res=0;
//						map=temp3;
//					}
//					map=temp2;
//				}
//				map=temp1;
//			}
			solve(0);
			System.out.println("#"+tc+" "+(sum-max));
		}
	}
	public static void solve(int cnt){
		if(cnt>=N||sum<=res){
			if(res>max){
				max=res;
			}
			return;
		}
		for(int i=1;i<=W;i++){
			if(he[i]>H)
				continue;
			int [][]temp=copy();
			int rtem=res;
			boom(he[i],i);
			set();
			solve(cnt+1);
			res=rtem;
			map=temp;
			set();
		}
		
	}
	public static void boom(int x,int y){
		if(map[x][y]==0){
			return;
		}
		int lt=map[x][y]-1;
		map[x][y]=0;
		res++;
		for(int i=1;i<=lt;i++){
			for(int d=0;d<xl.length;d++){
				int newX=x+xl[d]*i;
				int newY=y+yl[d]*i;
				if(newX<=0||newX>H||newY<=0||newY>W) continue;
				boom(newX,newY);
			}
		}
	}
	public static void set(){
		for(int j=1;j<=W;j++){
			int lt=H;
			while(lt>0&&map[lt][j]!=0)lt--;
			for(int i=lt-1;i>=1;i--){
				if(map[i][j]!=0){
					map[lt][j]=map[i][j];
					map[i][j]=0;
					lt--;
				}
			}
			he[j]=lt+1;
		}
	}
	public static int[][] copy(){
		int[][] newary=new int[H+1][W+1];
		for(int i=1;i<=H;i++){
			for(int k=1;k<=W;k++){
				newary[i][k]=map[i][k];
			}
		}
		return newary;
	}
}
