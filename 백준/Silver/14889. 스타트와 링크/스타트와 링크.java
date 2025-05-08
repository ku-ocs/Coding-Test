import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, sel, answer = Integer.MAX_VALUE;
    static int[] person;
    static int[] team1, team2;
    static int[][] status;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stz.nextToken());
        sel = N/2;
        person = new int[N+1];
        Arrays.fill(person, 1);
        team1 = new int[sel];
        team2 = new int[sel];
        status = new int[N+1][N+1];

        for (int i = 1; i < N+1; i++) {
            stz = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j < N+1; j++) {
                status[i][j] = Integer.parseInt(stz.nextToken());
            }
        }

        bt(0, 1);
        System.out.println(answer);
    }

    public static void bt(int cnt, int s) {
        if(cnt == sel) {
            int idx2 = 0;
            int stat1 = 0;
            int stat2 = 0;
            for (int i = 1; i < N+1; i++) {
                if (person[i] == 0) {
                    continue;
                }
                team2[idx2++] = i;
            }

            for (int i = 0; i < sel-1; i++) {
                for (int j = i+1; j < sel; j++) {
                    int person11 = team1[i];
                    int person12 = team1[j];
                    int person21 = team2[i];
                    int person22 = team2[j];
                    stat1 += status[person11][person12];
                    stat1 += status[person12][person11];
                    stat2 += status[person21][person22];
                    stat2 += status[person22][person21];
                }
            }
            answer = Math.min(answer, Math.abs(stat1 - stat2));
            return;
        }

        for (int i = s; i < N+1; i++) {
            if (person[i] == 0) {
                continue;
            }

            person[i] = 0;
            team1[cnt] = i;
            bt(cnt + 1, i+1);
            person[i] = 1;
        }
    }
}
