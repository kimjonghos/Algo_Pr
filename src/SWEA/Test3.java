package SWEA;

import java.util.Arrays;

public class Test3 {
	static boolean[] check;

	public static void main(String[] args) {
		int[] p = { 2, 3, 9 };
		int[] t = { 3, 9,2  };
		System.out.println(solution(p, t));
	}

	public static int solution(int[] people, int[] tshirts) {
		int answer = 0;
		Arrays.sort(people);
		Arrays.sort(tshirts);
		for (int i = 0; i < people.length; i++) {
			for (int k = 0; k < tshirts.length; k++) {
				if (tshirts[k] != -1) {
					if (people[i] <= tshirts[k]) {
						answer++;
						tshirts[k] = -1;
						break;
					}
				}
			}
		}
//		for(int i=0;i<people.length;i++){
//			for(int k=0;k<tshirts.length;k++){
//				if(tshirts[k]!=-1){
//					if(people[i])
//				}
//			}
//		}
		return answer;
	}

}
