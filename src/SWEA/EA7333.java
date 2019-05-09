package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class EA7333 {
	static int max;
	static Map<String,Integer> map;
	public static void main(String [] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++){
			int N=Integer.parseInt(br.readLine());
			max=0;
			int [] box=new int[N];
			int [] tmbox=new int[N];
			for(int i=0;i<N;i++){
				box[i]=tmbox[i]=Integer.parseInt(br.readLine());
			}
			map=new HashMap<String,Integer>();
			int res=0;
			int sum=0,cnt=0,temp=0,idx=0;
			
			while(isPos(tmbox)){
				boolean c=false;
				temp=sum;
				cnt++;
				for(int i=0;i<N;i++){
					if(tmbox[i]!=0){
						if((sum+tmbox[i])*cnt>=50){
							c=true;
							if(temp==sum){
								temp=sum+tmbox[i];
								tmbox[i]=0;
								idx=i;
							}
							else{
								if(Math.abs(50-(temp*cnt))>Math.abs(50-((sum+tmbox[i])*cnt))){
									tmbox[idx]=box[idx];
									temp=sum+tmbox[i];
									tmbox[i]=0;
									idx=i;
								}
							}
						}
					}
				}
				if(!c){
					int min=-1;
					for(int i=0;i<N;i++){
						if(tmbox[i]!=0){
							if(min==-1){
								min=i;
							}
							else if(min!=-1&&Math.abs(50-((sum+tmbox[i])*cnt))<Math.abs(50-((sum+tmbox[min])*cnt))){
								min=i;
							}
						}
					}
					sum+=tmbox[min];
					tmbox[min]=0;
				}
				else{
					sum=0;
					cnt=0;
					res++;
					temp=0;
					idx=0;
				}
			}
			System.out.println("#"+tc+" "+res);
//			for(int i=N-1;i>=0;i--){
//				if(box[i]!=0){
//					int cnt=1;
//					if(box[i]>=50){
//						res++;
//						box[i]=0;
//						continue;
//					}
//					else{
//						int sum=box[i];
//						box[i]=0;
//						cnt++;
//						for(int j=0;j<i;j++){
//							if(box[j]!=0){
//								if((sum+box[j])*cnt>=50){
//									res++;
//									box[j]=0;
//									break;
//								}
//								else{
//									cnt++;
//									sum+=box[j];
//									box[j]=0;
//								}
//							}
//						}
//					}
//				}
//			}
//			System.out.println(res);
//			solve(box,"",0,1,0);
//			System.out.println("#"+tc+" "+max);
		}
	}
	//1 3 27 29
	public static boolean isPos(int []ary){
		
		boolean res=false;
		for(int a:ary){
			if(a!=0)
				res=true;
		}
		return res;
	}
	public static void solve(int [] ary,String key,int sum,int cnt,int res){
		boolean check=false;
		if(key!=""&&map.containsKey(key)){
			System.out.println("if Key : "+key);
			return;
		}
		map.put(key,cnt);
		System.out.println("key : "+key);
		for(int i=0;i<ary.length;i++){
			if(ary[i]!=0){
				check=true;
				int temp=ary[i];
				ary[i]=0;
				if((sum+temp)*cnt>=50){
					solve(ary,"",0,1,res+1);
				}
				else{
					String k=key+i;
					solve(ary,change(k),sum+temp,cnt+1,res);
				}
				
				ary[i]=temp;
			}
		}
		if(!check){
			if(max<res){
				max=res;
			}
			return;
		}
	}
	public static String change(String str){
		char [] arr=str.toCharArray();
		Arrays.sort(arr);
		String re="";
		for(char c:arr)
			re+=c;
		return re;
	}
}
