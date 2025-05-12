import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    static int N, answer, S, E;
    static int[][] lines;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        lines = new int[N][2];

        StringTokenizer stz;
        for (int i = 0; i < N; i++) {
            stz = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(stz.nextToken());
            int e = Integer.parseInt(stz.nextToken());
            lines[i] = new int[] {s, e};
        }

        Arrays.sort(lines, new Comparator<int[]>() {
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

        S = lines[0][0];
        E = lines[0][1];

        for (int i = 1; i < lines.length; i++) {
            if(lines[i][0] < E) {
                if (lines[i][1] > E) {
                    E = lines[i][1];
                }
            } else {
                answer += E-S;
                S = lines[i][0];
                E = lines[i][1];
            }
        }

        answer += E-S;

        System.out.println(answer);
    }
}
