package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class EA1208 {
	static int [] map;
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		for(int tc=1;tc<=10;tc++){
			int N=Integer.parseInt(br.readLine());
			map=new int[100];
			int size=0;
			StringTokenizer st=new StringTokenizer(br.readLine());
			while(st.hasMoreTokens()){
				map[size]=Integer.parseInt(st.nextToken());
				size++;
			}
			for(int i=0;i<N;i++){
				Arrays.sort(map);
				if(map[0]>=map[size-1])
					break;
				map[0]++;
				map[size-1]--;
			}
			Arrays.sort(map);
			System.out.println("#"+tc+" "+(map[size-1]-map[0]));
		}
		
	}
}
