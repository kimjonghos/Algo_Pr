package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class EA6109_2 {
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
					boolean []check=new boolean[N];
					for(int k=1;k<N;k++){
						if(map[k][i]!=0){
							//현재수 위를 검사
							int t=map[k][i];
							map[k][i]=0;
							for(int j=k-1;j>=0;j--){
								if(map[j][i]==t&&!check[j]){
									map[j+1][i]=0;
									map[j][i]*=2;
									check[j]=true;
									break;
								}
								else if(map[j][i]==0){
									map[j+1][i]=0;
									map[j][i]=t;
								}
								else if(map[j][i]!=t){
									map[j+1][i]=t;
									break;
								}
							}
						}
					}
				}
			}
			else if(move.equals("down")){
				for(int i=0;i<N;i++){
					boolean []check=new boolean[N];
					for(int k=N-2;k>=0;k--){
						if(map[k][i]!=0){
							//현재수 위를 검사
							int t=map[k][i];
							map[k][i]=0;
							for(int j=k+1;j<N;j++){
								if(map[j][i]==t&&!check[j]){
									map[j-1][i]=0;
									map[j][i]*=2;
									check[j]=true;
									break;
								}
								else if(map[j][i]==0){
									map[j-1][i]=0;
									map[j][i]=t;
								}
								else if(map[j][i]!=t){
									map[j-1][i]=t;
									break;
								}
							}
						}
					}
				}
			}
			else if(move.equals("left")){
				for(int i=0;i<N;i++){
					boolean []check=new boolean[N];
					for(int k=1;k<N;k++){
						if(map[i][k]!=0){
							//현재수 위를 검사
							int t=map[i][k];
							map[i][k]=0;
							for(int j=k-1;j>=0;j--){
								if(map[i][j]==t&&!check[j]){
									map[i][j+1]=0;
									map[i][j]=t*2;
									check[j]=true;
									break;
								}
								else if(map[i][j]==0){
									map[i][j+1]=0;
									map[i][j]=t;
									
								}else if(map[i][j]!=t){
									map[i][j+1]=t;
									break;
								}
								
							}
						}
					}
				}
			}
			else if(move.equals("right")){
				for(int i=0;i<N;i++){
					boolean []check=new boolean[N];
					for(int k=N-2;k>=0;k--){
						if(map[i][k]!=0){
							//현재수 위를 검사
							int t=map[i][k];
							map[i][k]=0;
							for(int j=k+1;j<N;j++){
								if(map[i][j]==t&&!check[j]){
									map[i][j-1]=0;
									map[i][j]=t*2;
									check[j]=true;
									break;
								}
								else if(map[i][j]==0){
									map[i][j-1]=0;
									map[i][j]=t;
								}
								else if(map[i][j]!=t){
									map[i][j-1]=t;
									break;
								}
							}
						}
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
		}
	}
}
