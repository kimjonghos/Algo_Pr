package SWEA;

import java.util.Scanner;

public class ConnectProccesor1768_2 {
	static int resultCpu,resultLength;
	static int [][] core=new int[12][2];
	static int cpuNum,findCore;
	public static void main(String [] args){
		int [][]map=null;
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		for(int i=0;i<N;i++){
			int col=sc.nextInt();
			map=new int[col][col];
			resultCpu=-1;
			resultLength=0;
			cpuNum=0;
			for(int k=0;k<col;k++){
				for(int j=0;j<col;j++){
					map[k][j]=sc.nextInt();
					if(map[k][j]==1){
						core[cpuNum][0]=k;
						core[cpuNum][1]=j;
						cpuNum++;
					}
				}
			}
			search(map,0,0,0);
//			System.out.println("연결된 개수 : "+resultCpu+", 총 길이 : "+resultLength);
			System.out.println("#"+(i+1)+" "+resultLength);
		}
	}
	public static void search(int [][]map,int nowCpuNum,int nowFindNum,int nowLength){
		//nowCpuNum은 core배열에서 현재 찾는 cpu의 인덱스 nowFindNum은 지금까지 찾은 개수
//		System.out.println("now : "+nowCpuNum+" nowFInd : "+nowFindNum+ "cpuNum : "+cpuNum);
		if(nowCpuNum==cpuNum){
			if(resultCpu==-1){
				resultCpu=nowFindNum;
				resultLength=nowLength;
			}
			else if(resultCpu<nowFindNum){
				resultCpu=nowFindNum;
				resultLength=nowLength;
			}
			else if(resultCpu==nowFindNum&&resultLength>nowLength){
				resultLength=nowLength;
			}
			return;
		}
		int nowX=core[nowCpuNum][0];
		int nowY=core[nowCpuNum][1];
		if(nowX==0||nowY==0||nowX==map.length-1||nowY==map[0].length-1){
			search(map,nowCpuNum+1,nowFindNum+1,nowLength);
		}
		else{
			//오른쪽
			boolean isPossible=true;
			for(int y=nowY+1;y<map[0].length;y++){
				if(map[nowX][y]!=0){
					isPossible=false;
					break;
				}
			}
			if(isPossible){
				for(int y=nowY+1;y<map[0].length;y++){
					map[nowX][y]=2;
				}
				search(map,nowCpuNum+1,nowFindNum+1,nowLength+(map[0].length-1)-nowY);
				for(int y=nowY+1;y<map[0].length;y++){
					map[nowX][y]=0;
				}
			}
			//왼쪽
			isPossible=true;
			for(int y=nowY-1;y>=0;y--){
				if(map[nowX][y]!=0){
					isPossible=false;
					break;
				}
			}
			if(isPossible){
				for(int y=nowY-1;y>=0;y--){
					map[nowX][y]=2;
				}
				search(map,nowCpuNum+1,nowFindNum+1,nowLength+nowY);
				for(int y=nowY-1;y>=0;y--){
					map[nowX][y]=0;
				}
			}
			//위
			isPossible=true;
			for(int x=nowX-1;x>=0;x--){
				if(map[x][nowY]!=0){
					isPossible=false;
					break;
				}
			}
			if(isPossible){
				for(int x=nowX-1;x>=0;x--){
					map[x][nowY]=2;
				}
				search(map,nowCpuNum+1,nowFindNum+1,nowLength+nowX);
				for(int x=nowX-1;x>=0;x--){
					map[x][nowY]=0;
				}
			}
			//아래
			isPossible=true;
			for(int x=nowX+1;x<map.length;x++){
				if(map[x][nowY]!=0){
					isPossible=false;
					break;
				}
			}
			if(isPossible){
				for(int x=nowX+1;x<map.length;x++){
					map[x][nowY]=2;
				}
				search(map,nowCpuNum+1,nowFindNum+1,nowLength+(map.length-1-nowX));
				for(int x=nowX+1;x<map.length;x++){
					map[x][nowY]=0;
				}
			}
		}
		search(map,nowCpuNum+1,nowFindNum,nowLength);
	}
}
