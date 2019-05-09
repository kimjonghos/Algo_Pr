package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Line4 {
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int nowlen=0,max=-1,h=0;
		for(int i=0;i<N;i++){
			int hgt=Integer.parseInt(br.readLine());
			nowlen++;
			if(h<=hgt){
				h=hgt;
				if(max<nowlen){
					max=nowlen;
				}
				nowlen=0;
			}
		}
		System.out.println(max);
	}
}
