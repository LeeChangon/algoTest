package algoProj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);	//정렬

        int i1 = 0;			//투 포인터
        int i2 = n-1;
        
		int a1 = 0;
		int a2 = 0;
        int result = Integer.MAX_VALUE;
        
        while(i1 < i2) {	//앞 포인터가 뒷 포인터 보다 작을 때
            int a = arr[i1];
            int b = arr[i2];

            if(Math.abs(a + b) < result ) {	//a+b의 절댓값 비교
                result = Math.abs(a + b);
                a1 = a;
                a2 = b;
            }
            if(a + b > 0) i2 --;	//a+b가 양수이면 뒷 포인터를 --
            else i1 ++;				//a+b가 음수이면 앞 포인터를 ++
        }
        System.out.println(a1 + " " + a2);
    }
}