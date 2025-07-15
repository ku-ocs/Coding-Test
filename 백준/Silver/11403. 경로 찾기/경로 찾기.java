import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];

        StringTokenizer stz;
        for (int i = 0; i < N; i++) {
            stz = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(stz.nextToken());
            }
        }

        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(graph[i][k] == 1 && graph[k][j] == 1) {
                        graph[i][j] = 1;
                    }
                }
            }
        }

        for (int[] arr : graph) {
            for (int i : arr) {
                bw.write(i + " ");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}