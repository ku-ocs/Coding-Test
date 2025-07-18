import java.util.*;
import java.io.*;

public class Main {
    static int N, depth = -1, end, answer;
    static boolean[] vis;
    static int[][] nArr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        vis = new boolean[N+1];
        nArr = new int[N+1][2];

        StringTokenizer stz;
        for (int i = 0; i < N; i++) {
            stz = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(stz.nextToken());
            int l = Integer.parseInt(stz.nextToken());
            int r = Integer.parseInt(stz.nextToken());
            nArr[n][0] = l;
            nArr[n][1] = r;
        }

        getAnswer(1);
        System.out.println(answer);
    }

    // 순회의 끝 찾기 및 1 에서 end 까지 depth 측정 - 이동 횟수 계산
    public static void getAnswer(int i) {
        depth++;
        if (nArr[i][1] != -1) {
            getAnswer(nArr[i][1]);
        } else {
            end = i;
            answer = 2 * (N - 1) - depth;
        }
    }
}