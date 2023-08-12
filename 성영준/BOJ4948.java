package 성영준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ4948 {
	static boolean[] decimal;
	public static void setDecimal() {
		decimal[1] = true;
		for(int i = 2; i < Math.sqrt(decimal.length); i++) {
			if(!decimal[i]) {
				int n = 2;
				while(i * n <= 246912)
					decimal[i*n++] = true;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		decimal = new boolean[246912 + 1];
		setDecimal();
		int n = Integer.parseInt(br.readLine());
		while(n != 0) {
			int cnt = 0;
			for(int i = n + 1; i <= 2*n; i++)
				if(!decimal[i])
					cnt++;
			System.out.println(cnt);
			n = Integer.parseInt(br.readLine());
		}
		
	}

}
