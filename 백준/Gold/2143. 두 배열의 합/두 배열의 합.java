import java.io.*;
import java.util.*;

public class Main {
    static int T, N, M;
    static long answer;
    static int[] arrN, arrM;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        N = Integer.parseInt(br.readLine());
        arrN = new int[N];
        StringTokenizer stz = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) arrN[i] = Integer.parseInt(stz.nextToken());

        M = Integer.parseInt(br.readLine());
        arrM = new int[M];
        stz = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < M; i++) arrM[i] = Integer.parseInt(stz.nextToken());

        Map<Integer, Integer> map = new HashMap<>();

        if (N >= M) {
            for (int i = 0; i < M; i++) {
                int sum = 0;
                for (int j = i; j < M; j++) {
                    sum += arrM[j];
                    map.put(sum, map.getOrDefault(sum, 0) + 1);
                }
            }

            for (int i = 0; i < N; i++) {
                int sum = 0;
                for (int j = i; j < N; j++) {
                    sum += arrN[j];
                    answer += map.getOrDefault(T - sum, 0);
                }
            }

        } else {

            for (int i = 0; i < N; i++) {
                int sum = 0;
                for (int j = i; j < N; j++) {
                    sum += arrN[j];
                    map.put(sum, map.getOrDefault(sum, 0) + 1);
                }
            }

            for (int i = 0; i < M; i++) {
                int sum = 0;
                for (int j = i; j < M; j++) {
                    sum += arrM[j];
                    answer += map.getOrDefault(T - sum, 0);
                }
            }
        }

        System.out.println(answer);
    }
}
