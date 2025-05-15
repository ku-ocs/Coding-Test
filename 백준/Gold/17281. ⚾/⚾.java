import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N, score, answer, batIdx;
    static int[] batter, sel, tempBatter;
    static int[][] strike;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer stz;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        batter = new int[10];
        sel = new int[10];
        tempBatter = new int[9];
        strike = new int[N][10];

        for (int i = 0; i < N; i++) {
            stz = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j < 10; j++) {
                strike[i][j] = Integer.parseInt(stz.nextToken());
            }
        }

        batter[4] = 1;
        sel[1] = 1;

        selBatter(1);

        System.out.println(answer);

        br.close();
    }

    public static void selBatter(int b) {
        if (b == 9) {
            playGame();
            return;
        }

        for (int i = 2; i <= 9; i++) {
            if (sel[i] == 1) {
                continue;
            }

            sel[i] = 1;
            tempBatter[b] = i;
            selBatter(b+1);
            tempBatter[b] = 0;
            sel[i] = 0;
        }
    }

    public static void playGame() {
        score = 0;
        batIdx = 1;

        int tempIdx = 1;
        for (int i = 1; i < tempBatter.length; i++) {
            if (tempIdx == 4) {
                tempIdx++;
            }
            batter[tempIdx++] = tempBatter[i];
        }

        for (int i = 0; i < N; i++) {
            int[] field = new int[3];
            int outCnt = 0;

            while (true) {
                int bat = strike[i][batter[batIdx++]];

                if(batIdx > 9) {
                    batIdx = 1;
                }

                if (bat == 0) {
                    outCnt++;
                    if (outCnt == 3) {
                        break;
                    }
                }

                if (bat == 1) {
                    score += field[2];
                    field[2] = field[1];
                    field[1] = field[0];
                    field[0] = 1;
                    continue;
                }

                if (bat == 2) {
                    score += field[2];
                    score += field[1];
                    field[2] = field[0];
                    field[1] = 1;
                    field[0] = 0;
                    continue;
                }

                if (bat == 3) {
                    score += field[2];
                    score += field[1];
                    score += field[0];
                    field[2] = 1;
                    field[1] = 0;
                    field[0] = 0;
                    continue;
                }

                if (bat == 4) {
                    score += field[2];
                    score += field[1];
                    score += field[0];
                    score += 1;
                    field[2] = 0;
                    field[1] = 0;
                    field[0] = 0;
                }
            }
        }

        answer = Math.max(answer, score);
    }
}
