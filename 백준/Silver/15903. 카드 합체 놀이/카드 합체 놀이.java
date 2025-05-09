import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static long answer;
    static PriorityQueue<Long> queue = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(stz.nextToken());
        M = Integer.parseInt(stz.nextToken());


        stz = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            queue.offer(Long.parseLong(stz.nextToken()));
        }

        for (int i = 0; i < M; i++) {
            long num1 = queue.poll();
            long num2 = queue.poll();

            queue.offer(num1+num2);
            queue.offer(num1+num2);
        }

        while (!queue.isEmpty()) {
            answer += queue.poll();
        }

        System.out.println(answer);
    }
}
