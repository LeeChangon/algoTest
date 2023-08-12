package 성영준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ18111 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int[][] blocks = new int[n][m];
		int min = 256;
		int max = 0;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				blocks[i][j] = Integer.parseInt(st.nextToken());
				if (min > blocks[i][j])
					min = blocks[i][j];
				else if (max < blocks[i][j])
					max = blocks[i][j];
			}
		}
		int time = Integer.MAX_VALUE;
		int high = 0;
		for (int i = min; i <= max; i++) {
			int cnt = 0;
			int block = b;
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < m; k++) {
					if (i < blocks[j][k]) {
						cnt += (blocks[j][k] - i) * 2;
						block += blocks[j][k] - i;
					} else {
						cnt += i - blocks[j][k];
						block -= i - blocks[j][k];
					}
				}
			}
			if (block < 0)
				break;

			if (time >= cnt) {
				time = cnt;
				high = i;
			}
		}
		System.out.println(time + " " + high);
	}

}