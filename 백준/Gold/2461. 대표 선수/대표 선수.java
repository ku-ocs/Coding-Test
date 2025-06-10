import java.io.*;
import java.util.*;

public class Main {
    static int N, M, answer = Integer.MAX_VALUE;
    static int[] pointers;
    static int[][] classes;
    static PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
        @Override
        public int compare(int[] o1, int[] o2) {
            return o1[0] - o2[0];
        }
    });

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(stz.nextToken());
        M = Integer.parseInt(stz.nextToken());

        classes = new int[N][M];
        pointers = new int[N];

        for (int i = 0; i < N; i++) {
            int[] cls = new int[M];
            stz = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                int score = Integer.parseInt(stz.nextToken());
                cls[j] = score;
            }
            Arrays.sort(cls);
            pq.add(new int[] {cls[0], i});
            classes[i] = cls;
            pointers[i] = 0;
        }

        int maxScore = Integer.MIN_VALUE;
        for (int[] arr : pq) {
            maxScore = Math.max(arr[0], maxScore);
        }

        while (true) {
            int[] arr = pq.poll();
            int minScore = arr[0];
            int clsIdx = arr[1];

            int gap = maxScore - minScore;
            answer = Math.min(answer, gap);

            if (++pointers[clsIdx] >= M) {
                break;
            } else {
                int score = classes[clsIdx][pointers[clsIdx]];
                if (score > maxScore) {
                    maxScore = score;
                }
                pq.add(new int[] {score, clsIdx});
            }
        }

        System.out.println(answer);
    }
}
