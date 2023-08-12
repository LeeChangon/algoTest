package 성영준;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ9020 {
	static boolean[] decimal;

	private static void setDecimal() {
		decimal[0] = decimal[1] = true;
		for (int i = 2; i <= 100; i++)
			if (!decimal[i])
				for (int j = i * 2; j <= 10000; j += i)
					decimal[j] = true;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		decimal = new boolean[10001];

		setDecimal();
		for (int tc = 1; tc <= T; tc++) {
			int n = Integer.parseInt(br.readLine());
			for (int i = n / 2; i >= 2; i--)
				if (!decimal[i] && !decimal[n - i]) {
					sb.append(i).append(" ").append(n - i).append("\n");
					break;
				}
		}
		System.out.println(sb);
	}
}
