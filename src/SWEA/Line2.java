package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Line2 {

	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String str=br.readLine();
		char []ary=str.toCharArray();
		String temp="";
		int idx=0;
		while(ary[idx]>64)idx++;
		int nidx=idx;
		for(int i=0;i<idx;i++){
			if(nidx>=ary.length){
				temp="error";
				break;
			}
			if(i+1<idx&&96<ary[i+1]){
				temp+=ary[i]+"";
				continue;
			}
			temp+=""+ary[i];
			if(ary[nidx]!='1'){
				temp+=""+ary[nidx];
			}
			nidx++;
		}
		System.out.println(temp);
	}

}
