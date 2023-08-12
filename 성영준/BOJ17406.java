package 성영준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ17406 {
    static int minA, n, m, k;
    static int[] order;
    static boolean[] visited;
    static int[][] table, tmp, info;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        table = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++)
                table[i][j] = Integer.parseInt(st.nextToken());
        }

        info = new int[k][3];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++)
                info[i][j] = Integer.parseInt(st.nextToken());
        }

        order = new int[k];
        for (int i = 0; i < k; i++)
            order[i] = i;
        visited = new boolean[k];

        minA = Integer.MAX_VALUE;

        permutation(0);

        System.out.println(minA);
    }

    // order
    private static void permutation(int cnt) {
        if (cnt == k) {
            int[][] tmp = getCopyTable();
            for (int i = 0; i < k; i++) {
                int idx = order[i];
                spinTable(info[idx][0] - 1, info[idx][1] - 1, 1, info[idx][2], tmp);
            }
            getMinA(tmp);
        }
        for (int i = 0; i < k; i++) {
            if (!visited[i]) {
                visited[i] = true;
                order[cnt] = i;
                permutation(cnt + 1);
                visited[i] = false;
            }
        }
    }

    private static void spinTable(int y, int x, int reach, int r, int[][] tmp) {
        if (reach > r) {
            return;
        }
        int startx = x - reach;
        int starty = y - reach;
        int endx = x + reach;
        int endy = y + reach;
        int start = tmp[starty][startx];
        for (int i = starty; i < endy; i++)
            tmp[i][startx] = tmp[i + 1][startx];

        for (int i = startx; i < endx; i++)
            tmp[endy][i] = tmp[endy][i + 1];

        for (int i = endy; i > starty; i--)
            tmp[i][endx] = tmp[i - 1][endx];

        for (int i = endx; i > startx; i--)
            tmp[starty][i] = tmp[starty][i - 1];

        tmp[starty][startx + 1] = start;
        spinTable(y, x, reach + 1, r, tmp);
    }

    private static void getMinA(int[][] tmp) {
        for (int i = 0; i < n; i++) {
            int min = 0;
            for (int j = 0; j < m; j++)
                min += tmp[i][j];
            minA = Math.min(minA, min);
        }
    }

    private static int[][] getCopyTable() {
        tmp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++)
                tmp[i][j] = table[i][j];
        }
        return tmp;
    }
}