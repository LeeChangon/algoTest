package algoProj;

import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int M;
	static int[] nums;
	static int[] arr;
	static boolean[] visit;
	static List<String> result;
	
	static void recur(int a, int depth) {
		if(depth == M) {
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<M; i++) {
				sb.append(arr[i]).append(" ");
			}
			if(!result.contains(sb.toString())) result.add(sb.toString()); 
			return;
		}
		
		for (int i = a; i < N; i++) {
            if(!visit[i]) {
                arr[depth] = nums[i]; 
                visit[i] = true;	
                recur(i + 1, depth + 1);		//a를 시작점으로 잡아 작은 수를 제외함
                visit[i] = false;
            }
        }
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		nums = new int[N];
		arr = new int[M];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(nums);		//정렬해서 사전 순으로 증가하는 순서 만들기
		result = new ArrayList<>();
		visit = new boolean[N + 1];
		
		recur(0, 0);
		
		for(int i=0; i<result.size(); i++) {
			System.out.println(result.get(i));
		}
		
	}
}