import java.io.*;
import java.util.*;

public class Main {
    static int N, answer;
    static int[][] arrs;
    static PriorityQueue<Integer> queue = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arrs = new int[N][2];
        StringTokenizer stz;
        for (int i = 0; i < N; i++) {
            stz = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(stz.nextToken());
            int e = Integer.parseInt(stz.nextToken());

            arrs[i] = new int[] {s, e};
        }

        Arrays.sort(arrs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                } else {
                    if (o1[1] != o2[1]) {
                        return o1[1] - o2[1];
                    }
                }
                return 0;
            }
        });

        for (int[] arr : arrs) {
            int s = arr[0];
            int e = arr[1];

            while (!queue.isEmpty() && s >= queue.peek()) {
                queue.poll();
            }
            queue.offer(e);
            answer = Math.max(answer, queue.size());
        }

        System.out.println(answer);
    }
}
