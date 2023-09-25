package algoProj;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Map<String, Integer> map = new HashMap<>();
		String[] arr = br.readLine().split(" ");
		
		int lp = 0;
		int rp = 0;
		int max = 0;

		while(rp < N) {	//map.getOrDefault(key, default)를 사용하면 키가 없어도 디폴트 값을 줘 널포인트 방지가 가능해요
			while(rp < N && map.getOrDefault((arr[rp]), 0) + 1 <= K) {
				map.put(arr[rp], map.getOrDefault(arr[rp], 0) + 1);
				rp++;
			}
			max = Math.max(rp - lp, max);
			map.put(arr[lp], map.get(arr[lp]) - 1);
			lp++;
		}
		System.out.println(max);
	}
}