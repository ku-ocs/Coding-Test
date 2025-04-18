import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int[][] paper;
    static int[][] sticker;
    static int r, c, sCnt, sr, sc, rCnt, answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine(), " ");

        r = Integer.parseInt(stz.nextToken());
        c = Integer.parseInt(stz.nextToken());
        sCnt = Integer.parseInt(stz.nextToken());

        paper = new int[r][c];

        nextSticker:
        for(int i = 0; i < sCnt; i++) {
            rCnt = 0;
            stz = new StringTokenizer(br.readLine(), " ");
            sr = Integer.parseInt(stz.nextToken());
            sc = Integer.parseInt(stz.nextToken());
            sticker = new int[sr][sc];

            for(int j = 0; j < sr; j++) {
                stz = new StringTokenizer(br.readLine(), " ");
                for (int k = 0; k < sc; k++) {
                    sticker[j][k] = Integer.parseInt(stz.nextToken());
                }
            }

            while(true) {
                if(rCnt == 4) {
                    break;
                }

                for(int j = 0; j < r; j++) {
                    for (int k = 0; k < c; k++) {
                        if(post(j, k)) {
                            continue nextSticker;
                        }
                    }
                }
                rotate();
                rCnt++;
            }
        }

        for(int[] arr : paper) {
            for (int i : arr) {
                if ( i == 1) {
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }

    public static boolean post(int x, int y) {
        for(int i = 0; i < sr; i++) {
            for(int j = 0; j < sc; j++) {
                if(x+i >= r || y + j >= c) {
                    return false;
                }

                if(paper[x+i][y+j] == 1 && sticker[i][j] == 1) {
                    return false;
                }
            }
        }

        for(int i = 0; i < sr; i++) {
            for (int j = 0; j < sc; j++) {
                if(sticker[i][j] == 1) {
                    paper[x+i][y+j] = 1;
                }
            }
        }
        return true;
    }

    public static void rotate() {
        int[][] rotSticker = new int[sc][sr];

        for (int i = 0; i < sr; i++) {
            for (int j = 0; j < sc; j++) {
                if(sticker[i][j] == 1) {
                    rotSticker[j][sr - 1 - i] = 1;
                }
            }
        }

        int temp = sc;
        sc = sr;
        sr = temp;
        sticker = rotSticker;
    }
}

