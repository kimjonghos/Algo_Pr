package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class EA6109 {
	static int [][]map;
	public static void main(String [] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int T=Integer.parseInt(br.readLine());
		for(int tc=0;tc<T;tc++){
			StringTokenizer st=new StringTokenizer(br.readLine());
			int N=Integer.parseInt(st.nextToken());
			String move=st.nextToken();
			map=new int[N][N];
			for(int i=0;i<N;i++){
				st=new StringTokenizer(br.readLine());
				for(int k=0;k<N;k++){
					map[i][k]=Integer.parseInt(st.nextToken());
				}
			}
			if(move.equals("up")){
				for(int i=0;i<N;i++){
					int putindex=0;
					while(putindex<N&&map[putindex][i]!=0&&
							map[putindex][i]!=map[putindex+1][i]&&
							map[putindex+1][i]!=0)putindex++;
					if(putindex==N)
						continue;
					for(int k=putindex;k<N;k++){
						if(map[k][i]!=0){
							int idx=k+1;
							while(idx<N&&map[idx][i]==0)idx++;
							if(idx==N){
								int temp=map[k][i];
								map[k][i]=0;
								map[putindex][i]=temp;
								putindex++;
							}
							else if(map[k][i]==map[idx][i]){
								int temp=map[k][i];
								map[k][i]=0;
								map[idx][i]=0;
								map[putindex][i]=temp*2;
								putindex++;
							}
							else{
								int temp=map[k][i];
								map[k][i]=0;
								map[putindex][i]=temp;
								putindex++;
							}
						}
						if(putindex==N)
							break;
					}
				}
			}
			else if(move.equals("down")){
				for(int i=0;i<N;i++){
					int putindex=N-1;
					while(putindex>=0&&map[putindex][i]!=0&&
							map[putindex][i]!=map[putindex-1][i]&&
							map[putindex-1][i]!=0)putindex--;
					if(putindex==-1)
						continue;
					for(int k=putindex;k>=0;k--){
						if(map[k][i]!=0){
							int idx=k-1;
							while(idx>=0&&map[idx][i]==0)idx--;
							if(idx==-1){
								int temp=map[k][i];
								map[k][i]=0;
								map[putindex][i]=temp;
								putindex--;
							}
							else if(map[k][i]==map[idx][i]){
								int temp=map[k][i];
								map[k][i]=0;
								map[putindex][i]=temp*2;
								map[idx][i]=0;
								putindex--;
							}
							else{
								int temp=map[k][i];
								map[k][i]=0;
								map[putindex][i]=temp;
								putindex--;
							}
						}
						if(putindex==-1)
							break;
					}
				}
			}
			else if(move.equals("left")){
				for(int i=0;i<N;i++){
					int putindex=0;
					while(putindex<N&&map[i][putindex]!=0&&
							map[i][putindex]!=map[i][putindex+1]&&
							map[i][putindex+1]!=0)putindex++;
					if(putindex==N)
						continue;
					for(int k=putindex;k<N;k++){
						if(map[i][k]!=0){
							int idx=k+1;
							while(idx<N&&map[i][idx]==0)idx++;
							if(idx==N){
								int temp=map[i][k];
								map[i][k]=0;
								map[i][putindex]=temp;
								putindex++;
							}
							else if(map[i][k]==map[i][idx]){
								int temp=map[i][k];
								map[i][k]=0;
								map[i][putindex]=temp*2;
								map[i][idx]=0;
								putindex++;
							}
							else{
								int temp=map[i][k];
								map[i][k]=0;
								map[i][putindex]=temp;
								putindex++;
							}
						}
						if(putindex==N)
							break;
					}
				}
			}
			else if(move.equals("right")){
				for(int i=0;i<N;i++){
					int putindex=N-1;
					while(putindex>=0&&map[i][putindex]!=0&&
							map[i][putindex]!=map[i][putindex-1]&&
							map[i][putindex-1]!=0)putindex--;
					if(putindex==-1)
						continue;
					for(int k=putindex;k>=0;k--){
						if(map[i][k]!=0){
							int idx=k-1;
							while(idx>=0&&map[i][idx]==0)idx--;
							if(idx==-1){
								int temp=map[i][k];
								map[i][k]=0;
								map[i][putindex]=temp;
								putindex--;
							}
							else if(map[i][k]==map[i][idx]){
								int temp=map[i][k];
								map[i][k]=0;
								map[i][putindex]=temp*2;
								map[i][idx]=0;
								putindex--;
							}
							else{
								int temp=map[i][k];
								map[i][k]=0;
								map[i][putindex]=temp;
								putindex--;
							}
						}
						if(putindex==-1)
							break;
					}
				}
			}
			System.out.println("#"+(tc+1));
			for(int []a:map){
				for(int c:a){
					System.out.print(c+" ");
				}
				System.out.println();
			}
//			if(move.equals("up")){
//				for(int i=0;i<N;i++){
//					for(int k=1;k<N;k++){
//						if(map[k][i]!=0){
//							int idx=k-1;
//							while(map[idx][i]==0) idx--;
//							if(!check[idx][i]&&map[idx][i]==map[k][i]){
//								map[idx][i]=map[idx][i]*2;
//								map[k][i]=0;
//								check[k][i]=true;
//							}
//							
//						}
//					}
//				}
//			}
			
		}
	}
}
