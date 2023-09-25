package algoProj;

import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int M;
	static int[] nums, arr;
	static List<String> result;
	static StringBuilder sb;
	
	static void recur(int depth, int s) {
		if(depth == M) {
			for(int i=0; i<M; i++) {
				sb.append(arr[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		int a = -1;
		for (int i = s; i < N; i++) {
			if(nums[i] != a) {			//중복제거
				a = nums[i];
				arr[depth] = nums[i];
				recur(depth + 1, i);
			}
        }
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		nums = new int[N];
		arr = new int[M];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(nums);	
		result = new ArrayList<>();
		
		recur(0, 0);
		
		System.out.println(sb);
	}
}