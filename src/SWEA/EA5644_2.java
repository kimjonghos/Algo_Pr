package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class EA5644_2 {
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
		int av=-1,bv=-1;
		if(an==1&&bn==1){
			for(int i=0;i<ach.length;i++){
				if(ach[i])
					av=i;
				if(bch[i])
					bv=i;
			}
			if(av==bv){
				bv=BC[av][3]/2;
				av=BC[av][3]/2;
			}else{
				av=BC[av][3];
				bv=BC[bv][3];
			}
		}
		else if(an==1&&bn>1){
			int aidx=0;
			while(!ach[aidx])aidx++;
			boolean check=false;
			if(bch[aidx]) check=true;
			av=BC[aidx][3];
			for(int i=0;i<bch.length;i++){
				if(i==aidx)continue;
				if(bch[i]&&bv==-1){bv=i;continue;}
				if(bch[i]&&BC[bv][3]<BC[i][3]){
					bv=i;
				}
			}
			bv=BC[bv][3];
			if(check&&bv<av/2){
				av=av/2;
				bv=av;
			}
		}
		else if(an>1&&bn==1){
			int bidx=0;
			while(!bch[bidx])bidx++;
			boolean check=false;
			if(ach[bidx]) check=true;
			bv=BC[bidx][3];
			for(int i=0;i<ach.length;i++){
				if(i==bidx)continue;
				if(ach[i]&&av==-1){av=i;continue;}
				if(ach[i]&&BC[av][3]<BC[i][3]){
					av=i;
				}
			}
			av=BC[av][3];
			if(check&&av<bv/2){
				bv=bv/2;
				av=bv;
				
			}
		}
		else if(an>1&&bn>1){
			for(int i=0;i<ach.length;i++){
				if(ach[i]&&av==-1){av=i;continue;}
				if(ach[i]&&BC[av][3]<BC[i][3]){
					av=i;
				}
			}
			for(int i=0;i<bch.length;i++){
				if(av==i)continue;
				if(bch[i]&&bv==-1){bv=i;continue;}
				if(bch[i]&&BC[bv][3]<BC[i][3]){
					bv=i;
				}
			}
			int temp=-1;
			if(bch[av]){
				for(int i=0;i<ach.length;i++){
					if(av==i)continue;
					if(ach[i]&&BC[bv][3]<BC[i][3]){
						if(temp==-1)temp=i;
						else if(temp!=-1&&BC[temp][3]<BC[i][3]){
							temp=i;
						}
					}
				}
			}
			if(temp!=-1){
				bv=BC[av][3];
				av=BC[temp][3];
			}
			else{
				av=BC[av][3];
				bv=BC[bv][3];
			}
		}
		else{
			if(an>0){
				for(int i=0;i<ach.length;i++){
					if(ach[i]&&av==-1){av=i;continue;}
					if(ach[i]&&BC[av][3]<BC[i][3])av=i;
				}
			}
			if(bn>0){
				for(int i=0;i<bch.length;i++){
					if(bch[i]&&bv==-1){bv=i;continue;}
					if(bch[i]&&BC[bv][3]<BC[i][3])bv=i;
				}
			}
			if(av!=-1){av=BC[av][3];}
			else{ av=0;}
			if(bv!=-1){bv=BC[bv][3];}
			else {bv=0;}
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
