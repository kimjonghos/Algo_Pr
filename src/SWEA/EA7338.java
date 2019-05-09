package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class EA7338 {

	public static void main(String [] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++){
			String [] str=br.readLine().split(" ");
			long y=Long.parseLong(str[0]);
			long m=Long.parseLong(str[1]);
			long yt=y-2016;
			if(y>2016){
				long t=13*yt-yt;
				long i=t/13;//1435897434036
				long ng=t%13;
				y=2016+i;
				for(int j=0;j<ng;j++){
					m++;
					if(m>13){
						y++;
						m=1;
					}
				}
			}//111111109095
			
			else{
				
			}
			System.out.println(y+" "+m);
		}
	}
}
