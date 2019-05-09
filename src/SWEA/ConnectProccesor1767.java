package SWEA;

import java.util.Arrays;
import java.util.Scanner;

public class ConnectProccesor1767 {
	static int temp;
	public static void main(String [] args){
		int [][]map=null;
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		for(int i=0;i<N;i++){
			int col=sc.nextInt();
			map=new int[col][col];
			for(int k=0;k<col;k++){
				for(int j=0;j<col;j++){
					map[k][j]=sc.nextInt();
				}
			}
			int res=solve(map);
			System.out.println(res);
			for(int []k:map){
				for(int l:k){
					System.out.print(l);
				}
				System.out.println();
			}
		}
	}
	public static int solve(int [][]map){
		int count=0;
		for(int i=0;i<map.length;i++){
			for(int k=0;k<map[0].length;k++){
				if(map[i][k]==1){
					if(i==0||k==0||i==map.length-1||k==map[0].length-1)
						continue;
					search(map,i,k+1,"r",1);
					search(map,i,k-1,"l",1);
					search(map,i-1,k,"u",1);
					search(map,i+1,k,"b",1);
					count+=temp;
					temp=0;
				}
			}
		}
		return count;
	}
	public static boolean search(int [][]map,int x,int y,String dir,int count){
		if(x<0||y<0||x>=map.length||y>=map[0].length){
			if(temp==0||count<temp){
				temp=count;
				return true;
			}
			else{
				return false;
			}
		}
		if(map[x][y]!=1&&map[x][y]!=2){
			map[x][y]=2;
			if(dir.equals("r")){
				if(!search(map,x,y+1,dir,++count)){
					map[x][y]=0;
					return false;
				}
				else{
					return true;
				}
			}
			else if(dir.equals("l")){
				if(!search(map,x,y-1,dir,++count)){
					map[x][y]=0;
					return false;
				}
				else{
					return true;
				}
			}
			else if(dir.equals("u")){
				if(!search(map,x-1,y,dir,++count)){
					map[x][y]=0;
					return false;
				}
				else{
					return true;
				}
			}else{
				if(!search(map,x+1,y,dir,++count)){
					map[x][y]=0;
					return false;
				}
				else{
					return true;
				}
			}
		}
		return false;
	}
}
