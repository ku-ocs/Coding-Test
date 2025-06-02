import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    static int M, N, answer;
    static int[][] spaces;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine(), " ");
        M = Integer.parseInt(stz.nextToken());
        N = Integer.parseInt(stz.nextToken());
        spaces = new int[M][N];

        for (int i = 0; i < M; i++) {
            int[] space = new int[N];
            TreeSet<Integer> set = new TreeSet<>();
            stz = new StringTokenizer(br.readLine()," ");

            for (int j = 0; j < N; j++) {
                int planet = Integer.parseInt(stz.nextToken());
                space[j] = planet;
                set.add(planet);
            }

            int[] clone = set.stream().mapToInt(Integer::intValue).toArray();

            for (int j = 0; j < N; j++) {
                space[j] = Arrays.binarySearch(clone, space[j]);
            }

            spaces[i] = space;
        }

        for (int i = 0; i < M-1; i++) {
            next:
            for (int j = i+1; j < M; j++) {
                for (int k = 0; k < N; k++) {
                    if (spaces[i][k] != spaces[j][k]) {
                        continue next;
                    }
                }
                answer++;
            }
        }

        System.out.println(answer);
    }
}