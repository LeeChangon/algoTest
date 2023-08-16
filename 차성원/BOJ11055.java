package algoTest.차성원;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ11055 {
    static int[] arr;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr=new int[n];
        dp=new int[n];
        arr[0] =Integer.parseInt(st.nextToken());
        dp[0]=arr[0];
        for(int i=1;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i]=arr[i];
            for(int j=i-1;j>=0;j--){
                if(arr[i]>arr[j]){
                    if(dp[i]<dp[j]+arr[i]){
                        dp[i]=dp[j]+arr[i];
                    }
                }
            }
        }
        System.out.println(Arrays.stream(dp).max().getAsInt());
    }
}
