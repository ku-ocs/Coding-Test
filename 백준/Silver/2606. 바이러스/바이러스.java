import java.io.*;
import java.util.*;

public class Main {
    static int N, P, answer = 0;
    static int[][] network;
    static boolean[] vis;
    static Queue<Integer> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz;

        N = Integer.parseInt(br.readLine());
        P = Integer.parseInt(br.readLine());
        network = new int[N+1][N+1];
        vis = new boolean[N+1];

        for (int i = 0; i < P; i++) {
            stz = new StringTokenizer(br.readLine(), " ");
            int c1 = Integer.parseInt(stz.nextToken());
            int c2 = Integer.parseInt(stz.nextToken());
            for (int j = 1; j <= N; j++) {
                network[c1][c2] = 1;
                network[c2][c1] = 1;
            }
        }

        queue.offer(1);
        vis[1] = true;
        while(!queue.isEmpty()) {
            int c = queue.poll();
            for (int i = 1; i <= N; i++) {
                if (!vis[i] && network[c][i] == 1) {
                    queue.offer(i);
                    vis[i] = true;
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }
}