package SWEA;

import java.util.Arrays;
import java.util.Scanner;

public class GetMaxMoney {
	static int maxValue;
	static int [] value;
	static int [][] check;
	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		
		for(int i=0;i<N;i++){
			maxValue=0;
			
			int snum=sc.nextInt();
			check=new int[snum][4];
			value=new int[snum];
			for(int j=0;j<check.length;j++){
				for(int a=0;a<check[0].length;a++){
					check[j][a]=-1;
				}
			}
			int max=0;
			for(int k=0;k<snum;k++){
				value[k]=sc.nextInt();
				if(value[k]>max)
					max=value[k];
			}
			
			solve(0,new int[max+1],1,0);
			solve(0,new int[max+1],2,0);
			solve(0,new int[max+1],3,0);
			System.out.println("#"+i+ " "+maxValue); 
			for(int [] c:check){
				for(int cc:c){
					System.out.print(cc);
				}
				System.out.println();
			}
		}
	}
	public static void solve(int index,int [] countValue,int move,int nowValue){
		
		if(index==value.length){
			if(maxValue<nowValue) 
				maxValue=nowValue;
			return;
		}
		if(check[index][move]==nowValue){
			return;
		}
		check[index][move]=nowValue;
		for(int i=index;i<value.length;i++){
			if(move==1){
				int count=0;
				for(int j=0;j<countValue.length;j++){
					count+=countValue[j];
				}
				int temp=getValue(countValue);
				int nv=value[index]*count+nowValue-temp;
				solve(index+1,new int[countValue.length],1,nv);
				solve(index+1,new int[countValue.length],2,nv);
				solve(index+1,new int[countValue.length],3,nv);
				
			}
			else if(move==2){
				countValue[value[index]]++;
				solve(index+1,countValue,1,nowValue);
				solve(index+1,countValue,2,nowValue);
				solve(index+1,countValue,3,nowValue);
				countValue[value[index]]--;
			}
			else{
				solve(index+1,countValue,1,nowValue);
				solve(index+1,countValue,2,nowValue);
				solve(index+1,countValue,3,nowValue);
			}
			
		}
	}
	public static int getValue(int [] ary){
		int temp=0;
		for(int k=0;k<ary.length;k++){
			if(ary[k]!=0){
				temp+=k*ary[k];
			}
		}
		return temp;
	}
	

}
