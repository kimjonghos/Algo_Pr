package SWEA;

import java.util.Scanner;

public class ChangeMoneyCard {
	static int max;
	static int [][] check;
	public static void main(String[] args) {
		// 각 자리수 별로 높은숫자는 1 부터 카운트 같으면 동일 순위
		// 제일 숫자가 높은 순위부터 교환
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.nextLine();
		for (int w = 0; w < N; w++) {
			max=0;
			String m = sc.nextLine();
			String[] temp = m.split(" ");
			int changeNum = Integer.parseInt(temp[1]);
			check=new int[changeNum+1][1000000];
			temp = temp[0].split("");
			int[] card = new int[temp.length];
			int maxNum = 0;
			for (int i = 0; i < temp.length; i++) {
				int t = Integer.parseInt(temp[i]);
				card[i] = t;
				if (maxNum < t)
					maxNum = t;
			}
			solve(changeNum, card);
			System.out.println("#"+(w+1)+" "+max);
		}
	}

	public static void solve(int changeNum, int[] card) {
		int k = aryToInt(card);
		if(check[changeNum][k]!=0){
			return;
		}
		check[changeNum][k]++;
		if (changeNum == 0) {
			if (max < k)
				max = k;
			return;
		}
		
		for (int i = 0; i < card.length - 1; i++) {
			for (int j = i + 1; j < card.length; j++) {
				int tmp = card[i];
				card[i] = card[j];
				card[j] = tmp;
				solve(changeNum - 1, card);
				tmp = card[i];
				card[i] = card[j];
				card[j] = tmp;
			}
		}
		return;

	}

	public static int aryToInt(int[] ary) {
		int n = 0;
		for (int i = 0; i < ary.length; i++) {
			n = n * 10 + ary[i];
		}
		return n;
	}

}
