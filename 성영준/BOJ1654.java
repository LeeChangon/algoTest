package 성영준;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ1654 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] kn = br.readLine().split(" ");
		int k = Integer.parseInt(kn[0]);
		int n = Integer.parseInt(kn[1]);

		long tot = 0;
		int[] lans = new int[k];
		for (int i = 0; i < k; i++) {
			lans[i] = Integer.parseInt(br.readLine());
			tot += lans[i];
		}

		long right = tot / n * 2;
		long left = 0;
		long mid;
		long ans = 0;
		while (left <= right) {
			int cnt = 0;
			mid = (right + left) / 2;
			for (int lan : lans)
				cnt += lan / mid;
			if (cnt < n) {
				right = mid - 1;
				continue;
			}
			left = mid + 1;
			ans = mid;
		}
		System.out.println(ans);
	}
}