import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, K, length, sum, answer;
    static int[] arr;
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(stz.nextToken());
        K = Integer.parseInt(stz.nextToken());
        arr = new int[N];

        stz = new StringTokenizer(br.readLine()," ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(stz.nextToken());
        }

        int s = 0;
        int e = 0;

        while (true) {
            if (e == N || arr[e] % 2 != 0) {
                length = e-s;
                queue.add(length);
                sum += length;
                if (queue.size() > K+1) {
                    sum -= queue.poll();
                }
                answer = Math.max(sum, answer);
                if (e == N) {
                    break;
                } else {
                    e++;
                    s = e;
                }
            } else {
                e++;
            }
        }

        System.out.println(answer);
    }
}