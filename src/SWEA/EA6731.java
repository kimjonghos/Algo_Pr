package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class EA6731 {
	static char [][]map;
	static int [][] count;
 	public static void main(String [] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		for(int i=0;i<T;i++){
			
			int N=Integer.parseInt(br.readLine());
			map=new char[N][N];
			count=new int[N][N];
			String [] str=new String[N];
			for(int k=0;k<N;k++){
				str[k]=br.readLine();
				for(int j=0;j<N;j++){
					if(str[k].charAt(j)=='W'){
						map[k][j]='W';
					}
					else{
						map[k][j]='B';
					}
						
				}
			}
			int res=0;
			for(int k=0;k<N;k++){
				for(int j=0;j<N;j++){
					if(map[k][j]=='B')
						count[k][j]++;
					for(int a=0;a<N;a++){
						if(j!=a&&map[k][a]=='B'){
							count[k][j]++;
						}
						if(k!=a&&map[a][j]=='B'){
							count[k][j]++;
						}
					}
					if(count[k][j]%2!=0)
						res++;
				}
			}
			
			System.out.println("#"+(i+1)+" "+res);
			
			
			
		}
		
	}
	
}
