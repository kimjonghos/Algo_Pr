package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class EA5644 {
	static int []xl={0,-1,0,1,0};
	static int []yl={0,0,1,0,-1};
	static int []A;
	static int []B;
	static int [][]BC; //0: x, 1:y,2:C,3:P
	static int M,Bnum,ares,bres;
	public static void main(String [] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++){
			StringTokenizer st=new StringTokenizer(br.readLine());
			M=Integer.parseInt(st.nextToken());
			Bnum=Integer.parseInt(st.nextToken());
			A=new int[M];
			B=new int[M];
			BC=new int[Bnum][4];
			ares=0;bres=0;
			st=new StringTokenizer(br.readLine());
			for(int i=0;i<M;i++){
				A[i]=Integer.parseInt(st.nextToken());
			}
			st=new StringTokenizer(br.readLine());
			for(int i=0;i<M;i++){
				B[i]=Integer.parseInt(st.nextToken());
			}
			
			for(int i=0;i<BC.length;i++){
				st=new StringTokenizer(br.readLine());
				for(int j=0;j<4;j++){
					BC[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			solve(1,1,10,10,0,0,0);
			System.out.println("#"+tc+" "+(ares+bres));
		}
	}
	public static void solve(int Ax,int Ay,int Bx,int By,int m,int asum,int bsum){
		
		boolean []ach=new boolean[Bnum];
		boolean []bch=new boolean[Bnum];
		int an=0,bn=0;
		for(int i=0;i<BC.length;i++){
			if(Math.abs(Ax-BC[i][1])+Math.abs(Ay-BC[i][0])<=BC[i][2]){
				ach[i]=true;
				an++;
			}
		}
		for(int i=0;i<BC.length;i++){
			if(Math.abs(Bx-BC[i][1])+Math.abs(By-BC[i][0])<=BC[i][2]){
				bch[i]=true;
				bn++;
			}
		}
		int av=0,bv=0;
		for(int i=0;i<ach.length;i++){
			int v=BC[i][3];
			if(ach[i]&&bch[i]){
				if(an>1&&bn>1){
					int ai=i,bi=i;
					for(int j=0;j<ach.length;j++){
						if(j==i)continue;
						if(ach[j]&&BC[ai][3]<BC[j][3]){
							ai=j;
						}
					}
					for(int j=0;j<ach.length;j++){
						if(j==i||j==ai)continue;
						if(bch[j]&&BC[bi][3]<BC[j][3]){
							bi=j;
						}
					}
					av=BC[ai][3];
					bv=BC[bi][3];
//					if(ai!=bi){
//						av=BC[ai][3];
//						bv=BC[bi][3];
//					}
//					else{
//						int ait=-1,bit=-1;
//						while(ait==bit){
//							for(int j=0;j<ach.length;j++){
//								if(j==ai||j==ait)continue;
//								if(ach[j]&&ait==-1){ait=j;continue;}
//								if(ach[j]&&BC[ait][3]<BC[j][3])ait=j;
//							}
//							for(int j=0;j<ach.length;j++){
//								if(j==bi||j==bit)continue;
//								if(bch[j]&&bit==-1){bit=j;continue;}
//								if(bch[j]&&BC[bit][3]<BC[j][3])bit=j;
//							}
//						}
//					}
//					if(av+bv<v){
//						av=v/2;
//						bv=v/2;
//					}
//					int at=0,bt=0;
//					while(!ach[at]||at==i)at++;
//					while(!ach[bt]||bt==i)bt++;
//					if(av+bv<BC[at][3]+v){
//						av=BC[at][3];
//						bv=v;
//					}
//					if(av+bv<BC[bt][3]+v){
//						av=v;
//						bv=BC[bt][3];
//					}
				}
				else{
					if(an>1&&bn==1){
						int at=0;
						while(!ach[at]||at==i)at++;
						if(av+bv<BC[at][3]+v){
							av=BC[at][3];
							bv=v;
						}
					}
					else if(an==1&&bn>1){
						int bt=0;
						while(!bch[bt]||bt==i)bt++;
						if(av+bv<BC[bt][3]+v){
							bv=BC[bt][3];
							av=v;
						}
					}else if(an==1&&bn==1){
						if(av+bv<v){
							av=v/2;
							bv=v/2;
						}
					}
				}
			}
			else{
				if(ach[i]&&av<v){
					av=v;
				}
				if(bch[i]&&bv<v){
					bv=v;
				}
			}
		}
		System.out.println("an:"+an+",bn:"+bn+"Ax:"+Ax+",Ay:"+Ay+",Bx:"+Bx+",By"+By+",m:"+m+",asum:"+(asum+av)+",bsum :"+(bsum+bv));
		if(m>=M){
			ares=asum+av;
			bres=bsum+bv;
			return;
		}
		solve(Ax+xl[A[m]],Ay+yl[A[m]],Bx+xl[B[m]],By+yl[B[m]],m+1,asum+av,bsum+bv);
	}

}
