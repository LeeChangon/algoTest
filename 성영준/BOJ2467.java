package 성영준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ2467 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] solution = new int[n]; // n번 만큼 입력 받은 용액의 특성 값을 배열에 저장합니다.
        String[] str = br.readLine().split(" ");
        for (int i = 0; i < n; i++) solution[i] = Integer.parseInt(str[i]);

        Arrays.sort(solution); // 배열을 정렬합니다.

        int min = Integer.MAX_VALUE; // 두 용액의 특성의 혼합한 특성 값이 가장 작은 순간의 값을 저장할 변수입니다.
        int a = 0, b = 0; // 가장 작은 순간의 두 용액의 위치를 저장할 변수들 입니다.
        int left = 0, right = n - 1; // 혼합할 두 용액의 위치를 저장할 변수들 입니다.
        if (solution[0] >= 0) { // 만약 모든 용액이 양수(산성)라면
            a = 0; // 앞의 두 용액이 찾을 용액들 입니다.
            b = 1;
        } else if (solution[n - 1] <= 0) { // 반대로 모든 용액이 음수(알칼리성)라면
            a = n - 2; // 뒤의 두 용액이 찾을 용액들 입니다.
            b = n - 1;
        } else
            while (left < right) {
            int target = solution[left] + solution[right]; // 혼합한 특성 값을 구합니다.(다음 용액을 정하기 위한 계산)
            int targetAbs = Math.abs(target); // 혼합한 특성 값의 절대값을 구합니다.(찾을 용액 들을 정하기 위한 계산)

            if(targetAbs < min) { // 앞선 가장 작은 혼합된 특성 값과 현재 혼합한 특성 값을 비교합니다.
                a = left; // 더 작다면, 현재 혼합한 위치 들을 저장합니다.
                b = right;
                min = targetAbs; // 가장 작은 혼합도니 특성 값을 갱신합니다.
            }
            // 혼합한 특성 값이
            if(target < 0) left++; // 음수(알칼리성)라면 음수의 위치를 한단계 높입니다.
            else if(target > 0) right--; // 양수(산성)라면 양수의 위치를 한단계 낮춥니다.
            else break; // 0이라면 찾는 이상적인 용액들 이므로 탐색을 종료합니다.
        }
        System.out.println(solution[a] + " " + solution[b]);
    }
}
