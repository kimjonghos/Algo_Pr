package SWEA;

import java.util.Arrays;

public class Test4 {

	public static void main(String[] args) {
//		int [] h={200,120,150};
//		int [][] it={{30,100},{500,30},{100,400}};
		int [] h={300,200,50};
		int [][] it={{1000,100},{500,200},{900,100}};
		
		int [] res=solution(h,it);
		for(int k:res)
			System.out.println(k);
	}

	public static int[] solution(int[] healths, int[][] items) {
		int[] answer = {};
		int count=0;
		Arrays.sort(healths);
		boolean []check=new boolean[items.length];
		for(int i=0;i<healths.length;i++){
			int index=-1;
			for(int k=0;k<items.length;k++){
				int ki=healths[i]-items[k][1];
				if(100<=ki&&!check[k]){
					if(index==-1)
						index=k;
					else if(healths[i]-items[index][1]>ki){
						index=k;
					}
					if(items[index][0]>items[k][0]){
						continue;
					}else{
						index=k;
					}
				}
			}
			System.out.println("index : "+index);
			if(index!=-1){
				check[index]=true;
				
				count++;
			}
		}
		System.out.println("count : "+count);
		answer=new int[count];
		int t=0;
		for(int i=0;i<check.length;i++){
			if(check[i]){
				answer[t]=i+1;
				t++;
			}
		}
		Arrays.sort(answer);
		return answer;
	}
	public static void solve(int power,int itemsNum){
		
	}

}
