import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int T, n1, n2;
    static int[] number = new int[4];
    static boolean isFound;
    static boolean[] arr = new boolean[10000];      // 소수면 true
    static boolean[] vis = new boolean[10000];      // 방문했으면 true
    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        T = Integer.parseInt(br.readLine());

        Arrays.fill(arr, true);
        for (int i = 2; i < 10000; i++) {
            if (!arr[i]) {
                continue;
            }
            for (int j = i; j*i < 10000; j++) {
                arr[j*i] = false;
            }
        }

        StringTokenizer stz;
        for (int i = 0; i < T; i++) {
            stz = new StringTokenizer(br.readLine(), " ");
            n1 = Integer.parseInt(stz.nextToken());
            n2 = Integer.parseInt(stz.nextToken());
            Arrays.fill(vis, false);
            queue.clear();
            isFound = false;

            queue.offer(new int[] {n1, 0});
            vis[n1] = true;

            while (!queue.isEmpty()) {
                int[] numArr = queue.poll();
                int num = numArr[0];
                int cnt = numArr[1];
                if (num == n2) {
                    bw.write(cnt + "\n");
                    isFound = true;
                    break;
                }
                number[0] = num / 1000;
                number[1] = num / 100 % 10;
                number[2] = num / 10 % 10;
                number[3] = num % 10;

                for (int j = 0; j < 4; j++) {
                    int origin = number[j];
                    for (int k = 0; k < 10; k++) {
                        if (j == 0 && k == 0) continue;
                        number[j] = k;
                        int newNum = number[0] * 1000 + number[1] * 100 + number[2] * 10 + number[3];
                        checkNum(newNum, cnt);
                    }
                    number[j] = origin;
                }
            }

            if (!isFound) {
                bw.write("Impossible" + "\n");
            }

        }
        bw.flush();
        bw.close();
        br.close();
    }

    public static void checkNum(int num, int cnt) {
        if (!arr[num] || vis[num]) {
            return;
        }
        vis[num] = true;

        queue.offer(new int[] {num, cnt+1});
    }
}
