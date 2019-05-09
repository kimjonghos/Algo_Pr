package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class EA7396 {
	static int N,M;
	static int[] xl={0,1};
	static int[] yl={1,0};
	static char [][]map;
	static String [][]res;
	public static void main(String [] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++){
			String [] in=br.readLine().split(" ");
			N=Integer.parseInt(in[0]);
			M=Integer.parseInt(in[1]);
			if(N==0||M==0){
				System.out.println("#"+tc+" "+"");
			}
			map=new char[N][M];
			res=new String[N][M];
			for(int i=0;i<N;i++){
				char [] ca=br.readLine().toCharArray();
				for(int j=0;j<M;j++){
					map[i][j]=ca[j];
				}
				System.out.println(ca.length);
			}
//			int x=0,y=0;
//			String res=""+map[0][0];
//			while(x!=N-1||y!=M-1){
//				int dx=x+1,dy=y;
//				int rx=x,ry=y+1;
//				if(dx<N&&dy<M&&rx<N&&ry<M){
//					if(map[dx][dy]==map[rx][ry]){
//					}else if(map[dx][dy]>map[rx][ry]){
//						res+=map[rx][ry];
//						y=ry;
//					}else{
//						res+=map[dx][dy];
//						x=dx;
//					}
//				}else if(dx>=N){//오른쪽
//					res+=map[rx][ry];
//					y=ry;
//				}else if(ry>=M){//아래
//					res+=map[dx][dy];
//					x=dx;
//				}
//			}
//			System.out.println(res);
			
			for(int x=0;x<N;x++){
				for(int y=0;y<M;y++){
					if(x-1>=0&&y-1>=0){
						if(res[x-1][y].compareTo(res[x][y-1])<=0){
							res[x][y]=res[x-1][y]+map[x][y];
						}
						else{
							res[x][y]=res[x][y-1]+map[x][y];
						}
					}
					else if(x-1<0&&y-1<0){
						res[x][y]=""+map[x][y];
					}
					else if(x-1<0){
						res[x][y]=res[x][y-1]+map[x][y];
					}else if(y-1<0){
						res[x][y]=res[x-1][y]+map[x][y];
					}
				}
			}
			
			System.out.println("#"+tc+" "+res[N-1][M-1]);
		}
	}
	public static void solve(int x,int y){
		boolean c=false;
		if(x==N-1&&y==M-1){
			c=true;
		}
		if(res[x][y]!=null)
			return;
		if(x-1>=0&&y-1>=0){
			if(res[x-1][y].compareTo(res[x][y-1])<0){
				res[x][y]=res[x-1][y]+map[x][y];
			}
			else{
				res[x][y]=res[x][y-1]+map[x][y];
			}
		}
		else if(x-1<0&&y-1<0){
			res[x][y]=""+map[x][y];
		}
		else if(x-1<0){
			res[x][y]=res[x][y-1]+map[x][y];
		}else if(y-1<0){
			res[x][y]=res[x-1][y]+map[x][y];
		}
		if(c){
			return;
		}
		for(int i=0;i<2;i++){
			int nx=x+xl[i],ny=y+yl[i];
			if(nx<N&&ny<M){
				solve(nx,ny);
			}
		}
	}
}
