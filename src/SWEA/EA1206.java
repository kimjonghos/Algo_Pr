package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class EA1206 {
	static int []map;
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		for(int tc=1;tc<=10;tc++){
			int T=Integer.parseInt(br.readLine());
			map=new int[T];
			StringTokenizer st=new StringTokenizer(br.readLine());
			for(int i=0;i<T;i++){
				map[i]=Integer.parseInt(st.nextToken());
			}
			int res=0;
			for(int i=2;i<T;i++){
				if(map[i]>map[i-1]&&map[i]>map[i-2]&&map[i]>map[i+1]&&map[i]>map[i+2]){
					res+=Math.min(Math.min(map[i]-map[i-1],map[i]-map[i-2]),
							Math.min(map[i]-map[i+1],map[i]-map[i+2]));
					
				}
			}
			System.out.println("#"+tc+" "+res);
			
		}
	}
}
