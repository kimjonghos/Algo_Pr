package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class EA5550_2 {

	public static void main(String [] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		for(int tc=0;tc<T;tc++){
			char [] str=br.readLine().toCharArray();
			//croak
			int [] croak=new int[5];
			int beforeflag=0,res=0;
			for(int i=0;i<str.length;i++){
				switch(str[i]){
					case 'c':
						croak[0]++;
						if(beforeflag>0){
							beforeflag--;
						}
						else{
							res++;
						}
						break;
					case 'r':
						croak[0]--;croak[1]++;
						if(croak[0]<0){
							res=-1;
						}
						break;
					case 'o':
						croak[1]--;croak[2]++;
						if(croak[1]<0){
							res=-1;
						}
						break;
					case 'a':
						croak[2]--;croak[3]++;
						if(croak[2]<0){
							res=-1;
						}
						break;
					case 'k':
						croak[3]--;
						if(croak[3]<0){
							res=-1;
						}
						else{
							beforeflag++;
						}
						break;
				}
				if(res==-1){
					break;
				}
			}
			for(int i=0;i<croak.length-1;i++){
				if(croak[i]!=croak[i+1])
					res=-1;
			}
			System.out.println("#"+(tc+1)+" "+res);
		}
	}
}
