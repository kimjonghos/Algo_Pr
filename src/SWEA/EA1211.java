package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class EA1211 {
	static int [][]map;
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		for(int tc=1;tc<=10;tc++){
			br.readLine();
			map=new int[100][100];
			StringTokenizer st=null;
			int dy=0;
			for(int r=0;r<100;r++){
				st=new StringTokenizer(br.readLine());
				for(int c=0;c<100;c++){
					map[r][c]=Integer.parseInt(st.nextToken());
					if(map[r][c]==2)
						dy=c;
				}
			}
			for(int i=98;i>=0;i--){
				if(dy-1>=0&&map[i][dy-1]==1){
					int idx=2;
					while(dy-idx>=0&&map[i][dy-idx]==1)idx++;
					dy=dy-idx+1;
				}	
				else if(dy+1<100&&map[i][dy+1]==1){
					int idx=2;
					while(dy+idx<100&&map[i][dy+idx]==1)idx++;
					dy=dy+idx-1;
				}
			}
			System.out.println("#"+tc+" "+dy);
		}
	}
}
