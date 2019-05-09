package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class EA1961 {
	static String [][]res;
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++){
			int N=Integer.parseInt(br.readLine());
			res=new String[N][3];
			String [][] map=new String[N][N];
			for(int i=0;i<N;i++){
				StringTokenizer st=new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++){
					map[i][j]=st.nextToken();
				}
			}
			String [][]temp=new String[N][N];
			for(int tt=0;tt<3;tt++){
				temp=new String[N][N];
				for(int i=0;i<N;i++){
					for(int j=0;j<N;j++){
						temp[j][N-1-i]=map[i][j];
					}
				}
				for(int i=0;i<N;i++){
					for(int j=0;j<N;j++){
						if(res[i][tt]==null){
							res[i][tt]="";
						}
						res[i][tt]+=temp[i][j];
					}
				}
				map=temp;
			}
			System.out.println("#"+tc);
			for(String []s:res){
				for(String ss:s){
					System.out.print(ss+" ");
				}
				System.out.println();
			}
			
		}
	}
}
