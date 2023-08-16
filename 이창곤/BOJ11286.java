package algoProj;

import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		//priorityqueue를 선언 
		Queue<Integer> q = new PriorityQueue<>(new Comparator<Integer>() {
			
			@Override	//Comparator의 compare를 오버라이드
			public int compare(Integer o1, Integer o2) {
				if(Math.abs(o1) > Math.abs(o2)) {	//절대값으로 앞에 놈이 더 크면 순서 바꿈
					return Math.abs(o1) - Math.abs(o2);	//양수
				}
				else if(Math.abs(o1) == Math.abs(o2)) {	//절대값이 같으면 음수가 앞에가게 바꿈
					return o1 - o2;						//(1 - -1)=2   (-1 - 1) = -2
				}
				else {
					return -1;
				}
			}
			
		});
		
		while(N-->0) {//N번 반복 
			int num= Integer.parseInt(br.readLine());
			if(num == 0) {
				if(q.isEmpty()) {
					System.out.println(0);
				}
				else {
					System.out.println(q.poll());
				}
			}
			else {
				q.add(num);
			}
		}
		
	}
}