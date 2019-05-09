package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class EA6855 {
	static int min;
	static int N,K;
	static int [] lo;
	static boolean [] check;
	static boolean [][] dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
//		Scanner sc=new Scanner(System.in);
//		int T=sc.nextInt();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

		for(int i=0;i<T;i++){
//			N=sc.nextInt();
//			K=sc.nextInt();
//			min=0;
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

			dp=new boolean[N][N];
			lo=new int[N];
			check=new boolean[N];
			 st = new StringTokenizer(br.readLine(), " ");
			for(int k=0;k<N;k++){
//				lo[k]=sc.nextInt();
				lo[k]=Integer.parseInt(st.nextToken());  
			}
			int sum=0;
			int [] dif=new int[N-1];
			for(int j=0;j<N-1;j++){
				dif[j]=lo[j+1]-lo[j];
			}
			Arrays.sort(dif);
			for(int s=0;s<N-K;s++){
				sum+=dif[s];
			}
			System.out.println("#"+(i+1)+" "+sum);
		}
	}
//	public static void solve(int nowK){
//		
//		if(nowK==K){
//			int nowV=getValue();
//			if(min==0)
//				min=nowV;
//			else if(nowV<min)
//				min=nowV;
//			return;
//		}
//		for(int i=0;i<N;i++){
//			if(check[i]==false){
//				dp[nowK][i]=true;
//				check[i]=true;
//				solve(nowK+1);
//				check[i]=false;
//			}
//		}
//	}
//	public static int getValue(){
//		int m=0;
//		int [] l=new int[K];
//		int idx=0;
//		for(int j=0;j<N;j++){
//			if(idx==K)
//				break;
//			if(check[j]==true){
//				l[idx]=j;
//				idx++;
//			}
//		}
//		for(int i=0;i<N;i++){
//			boolean c=false;
//			for(int k=0;k<K;k++){
//				if(i==l[k]){
//					c=true;
//					break;
//				}
//			}
//			if(!c){
//				int temp=-1;
//				for(int a=0;a<K;a++){
//					int v=Math.abs(lo[i]-lo[l[a]]);
//					if(temp==-1){
//						temp=v;
//					}
//					else if(temp>v){
//						temp=v;
//					}
//				}
//				m+=temp;
//			}
//		}
//		return m;
//	}

}
