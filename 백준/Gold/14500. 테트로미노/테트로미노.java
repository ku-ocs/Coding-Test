import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, M, answer = Integer.MIN_VALUE;
    static int[][] paper;
    static List<int[][]> tetrominos = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(stz.nextToken());
        M = Integer.parseInt(stz.nextToken());
        paper = new int[N][M];

        // 종이 만들기
        for(int i = 0; i < N; i++) {
            stz = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                paper[i][j] = Integer.parseInt(stz.nextToken());
            }
        }

        // 테트로미노 만들기
        int[][] tetromino1 = new int[1][4];
        tetromino1[0][0] = 1;
        tetromino1[0][1] = 1;
        tetromino1[0][2] = 1;
        tetromino1[0][3] = 1;
        addTetrominos(tetromino1, 2);

        int[][] tetromino2 = new int[2][2];
        tetromino2[0][0] = 1;
        tetromino2[0][1] = 1;
        tetromino2[1][0] = 1;
        tetromino2[1][1] = 1;
        addTetrominos(tetromino2, 1);

        int[][] tetromino3 = new int[3][2];
        tetromino3[0][0] = 1;
        tetromino3[1][0] = 1;
        tetromino3[2][0] = 1;
        tetromino3[2][1] = 1;
        addTetrominos(tetromino3, 4);
        addTetrominos(reverse(tetromino3), 4);

        int[][] tetromino4 = new int[3][2];
        tetromino4[0][0] = 1;
        tetromino4[1][0] = 1;
        tetromino4[1][1] = 1;
        tetromino4[2][1] = 1;
        addTetrominos(tetromino4, 2);
        addTetrominos(reverse(tetromino4), 2);

        int[][] tetromino5 = new int[2][3];
        tetromino5[0][0] = 1;
        tetromino5[0][1] = 1;
        tetromino5[0][2] = 1;
        tetromino5[1][1] = 1;
        addTetrominos(tetromino5, 4);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int[][] tetromino : tetrominos) {
                    setAnswer(tetromino, i, j);
                }
            }
        }

        System.out.println(answer);
    }

    public static int[][] rotate(int[][] tetromino) {
        int r = tetromino.length;
        int c = tetromino[0].length;
        int[][] tempMino = new int[c][r];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                tempMino[j][r-1-i] = tetromino[i][j];
            }
        }

        return tempMino;
    }

    public static int[][] reverse(int[][] tetromino) {
        int r = tetromino.length;
        int c = tetromino[0].length;
        int[][] tempMino = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                tempMino[i][c-1-j] = tetromino[i][j];
            }
        }

        return tempMino;
    }

    public static void addTetrominos(int[][] tetromino, int cnt) {
        tetrominos.add(tetromino);
        for (int i = 1; i < cnt; i++) {
            tetromino = rotate(tetromino);
            tetrominos.add(tetromino);
        }
    }

    public static void setAnswer(int[][] tetromino, int sr, int sc) {
        int score = 0;
        int r = tetromino.length;
        int c = tetromino[0].length;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (sr+i >= N || sc+j >= M) {
                    return;
                }

                if (tetromino[i][j] == 1) {
                    score += paper[sr+i][sc+j];
                }
            }
        }

        answer = Math.max(answer, score);
    }
}