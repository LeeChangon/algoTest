package algoProj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	static int cnt;
	static void count(int len, int r, int c) {
		if(len == 1) return;
		int a = len/2;
		
		//4분면으로 나눠서 찾아가기
		if(r < a && c < a) 			//1사분면
			count(a, r, c);
		else if(r < a && c >= a) {	//2사분면
			cnt += len * len / 4;
			count(a, r, c - a);
		}
		else if(r >= a && c < a) {	//3사분면
			cnt += (len * len / 4) * 2;
			count(len/2, r - a, c);
		}
		else {						//4사분면
			cnt += (len * len / 4) * 3;	//앞에 분면들을 전부 카운트에 더함
			count(a, r - a, c - a);
		}
	}
	
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int len = (int)(Math.pow(2, N)); //배열의 길이. 2의 N제곱
        
        count(len, r, c);
        System.out.println(cnt);
    }
}