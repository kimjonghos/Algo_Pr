package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class EA4796 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=0;tc<T;tc++){
			int c=Integer.parseInt(br.readLine());
			StringTokenizer st=new StringTokenizer(br.readLine());
			int [] mt=new int[c];
			for(int i=0;i<c;i++){
				String a=st.nextToken();
				System.out.println(a);
				mt[i]=Integer.parseInt(a);
			}
			int res=0;
			for(int i=1;i<c-1;i++){
				if(mt[i-1]<mt[i]&&mt[i]>mt[i+1]){
					res++;
					int le=0;
					for(int k=i-2;k>=0;k--){
						if(mt[k]<mt[k+1])
							le++;
						else
							break;
					}
					int ri=0;
					for(int k=i+2;k<c;k++){
						if(mt[k]<mt[k-1])
							ri++;
						else
							break;
					}
					if(ri==0||le==0)
						res+=le+ri;
					else
						res+=(le*(ri+1)+ri);
				}
				
			}
			System.out.println("#"+(tc+1)+" "+res);
			while(st.hasMoreTokens())st.nextToken();
		}
	}
}
