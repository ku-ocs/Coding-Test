import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int n, m, dist, answer, hIdx, cIdx;
    static int[][] home, chicken, selChicken;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(stz.nextToken());
        m = Integer.parseInt(stz.nextToken());
        home = new int[2*n][2];
        chicken = new int[13][2];
        selChicken = new int[m][2];

        for(int i = 0; i < n; i++) {
            stz = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                int building = Integer.parseInt(stz.nextToken());
                if (building == 1) home[hIdx++] = new int[] {i ,j};
                if (building == 2) chicken[cIdx++] = new int[] {i, j};
            }
        }

        bt(0, 0);
        System.out.println(answer);
    }

    public static void bt(int idx, int depth) {
        if(depth == m) {
            dist = 0;
            calcDist();
            return;
        }

        for (int i = idx; i < cIdx; i++) {
            selChicken[depth] = chicken[i];
            bt(i+1, depth+1);
        }
    }

    public static void calcDist() {
        for (int i = 0; i < hIdx; i++) {
            int[] hArr = home[i];
            int tempDist = 0;
            for (int[] cArr : selChicken) {
                int dx = Math.abs(hArr[0] - cArr[0]);
                int dy = Math.abs(hArr[1] - cArr[1]);

                int d = dx + dy;

                if (tempDist == 0) tempDist = d;
                else tempDist = Math.min(tempDist, d);
            }
            dist += tempDist;
        }
        if (answer == 0) answer = dist;
        else answer = Math.min(answer, dist);
    }
}

