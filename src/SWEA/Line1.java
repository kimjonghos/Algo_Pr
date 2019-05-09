package SWEA;

import java.util.Scanner;

public class Line1 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int sp=2,sum=1;
		if(N==1){
			System.out.println(0);
		}
		else{
			while(true){
				int nmg=N%sp;
				if(sp==N){
					break;
				}
				if(nmg==0){
					N=N/sp;
					sum=sum*sp;
				}
				else{
					sp++;
				}
				
			}
			System.out.println(Math.abs(sp-sum));
		}

	}

}
