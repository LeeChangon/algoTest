package 성영준;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ10819 {
	static boolean[] visit;
	static int[] nums;
	static int[] num;
	static int T;
	static int max;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		nums = new int[T];
		num = new int[T];
		visit = new boolean[T];
		max = 0;
		String[] ch = br.readLine().split(" ");
		for (int i = 0; i < T; i++)
			nums[i] = Integer.parseInt(ch[i]);
		swap(0);
		System.out.println(max);
	}

	private static void swap(int idx) {
		if (idx == T) {
			int sum = 0;
			for (int i = 0; i < T - 1; i++)
				sum += Math.abs(num[i] - num[i + 1]);
			if (max < sum)
				max = sum;
			return;
		}
		for (int i = 0; i < visit.length; i++) {
			if (visit[i] == false) {
				num[idx] = nums[i];
				visit[i] = true;
				swap(idx + 1);
				visit[i] = false;
			}
		}
	}
}
