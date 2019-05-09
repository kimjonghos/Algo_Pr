package SWEA;

import java.util.Scanner;

public class EA6781 {

//	static int[] num;
//	static String[] str;
	static boolean isWin;
//	static boolean[] check;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		sc.nextLine();
		for(int i=0;i<T;i++){
			String n=sc.nextLine();
			String s=sc.nextLine();
			isWin=false;
			int [][]map=new int[4][13];
			
			for(int k=0;k<n.length();k++){
				char nn=n.charAt(k);
				char ss=s.charAt(k);
				if(ss=='R'){
					map[1][nn-'0']++;
				}
				else if(ss=='G'){
					map[2][nn-'0']++;
				}
				else{
					map[3][nn-'0']++;
				}
			}
			int res=0;
			for(int j=1;j<map.length;j++){
				
				for(int k=1;k<map[1].length;k++){
					if(map[j][k]>0&&map[j][k+1]>0&&map[j][k+2]>0){
						int min=Math.min(map[j][k], Math.min(map[j][k+1], map[j][k+2]));
						map[j][k]-=min;map[j][k+1]-=min;map[j][k+2]-=min;
						res+=min;
					}
					if(map[j][k]>=3){
						res+=map[j][k]/3;
						map[j][k]=map[j][k]%3;
					}
					if(res>=3){
						isWin=true;
						break;
					}
				}
				if(isWin==true)
					break;
			}
			if(isWin)
				System.out.println("#"+(i+1)+" Win");
			else
				System.out.println("#"+(i+1)+" Continue");
			
//			String []t=n.split("");
//			num=new int[t.length];
//			check=new boolean[9];
//			for(int k=0;k<t.length;k++){
//				num[k]=Integer.parseInt(t[k]);
//			}
//			str=s.split("");
		}
		
	}
//	public static boolean solve(int nowNum,String RGB,int turn,int kind,int count){
//		
//		if(count==9){
//			return isWin;
//		}
//		
//		for(int i=0;i<num.length;i++){
//			if(check[i]!=false){
//				if(turn==1){
//					check[i]=true;
//					solve(num[i],str[i],2,1,count);
//					solve(num[i],str[i],2,2,count);
//					check[i]=false;
//				}
//				else{
//					if(kind==1){
//						//문자가 같고숫자를 빼서 절대값이 1이면 OK, 이때 turn이 2이면 한번더 호출 3이면 turn을 1로 바꿔서 호출 kind는 아무숫자나
//						int temp=Math.abs(num[i]-nowNum);
//						if(str[i].equals(RGB)&&temp==1){
//							check[i]=true;
//							if(turn==2){
//								solve(num[i],RGB,turn+1,kind,count+1);
//							}
//							else if(turn==3){
//								solve(num[i],RGB,1,kind,count+1);
//							}
//							check[i]=false;
//						}
//					}
//					else if(kind==2){
//						//문자가 같고 같은 숫자가 있나확인 ,turn이 2이면 한번더 호출 3이면 turn을 1로바까서 호출
//						
//					}
//				}
//			}
//		}
//		return res;
//	}
}
