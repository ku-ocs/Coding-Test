import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int N, answer;
    static int[] dx = new int[] {1, 0, -1, 0};
    static int[] dy = new int[] {0, -1, 0, 1};
    static int[][] board = new int[101][101];
    static Stack<int[]> stack = new Stack<>();
    static Stack<int[]> tempStack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer stz;
        for (int i = 0; i < N; i++) {
            stack.clear();
            tempStack.clear();
            stz = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(stz.nextToken());
            int y = Integer.parseInt(stz.nextToken());
            int d = Integer.parseInt(stz.nextToken());
            int g = Integer.parseInt(stz.nextToken());

            int nx = x + dx[d];
            int ny = y + dy[d];
            board[y][x] = 1;
            board[ny][nx] = 1;
            stack.push(new int[] {y, x});
            stack.push(new int[] {ny, nx});
            tempStack.push(new int[] {y, x});
            tempStack.push(new int[] {ny, nx});

            for (int j = 0; j < g; j++) {
                int[] xy = stack.pop();
                int y2 = xy[0];
                int x2 = xy[1];

                while (!stack.isEmpty()) {
                    int[] xy2 = stack.pop();
                    int y3 = xy2[0];
                    int x3 = xy2[1];
                    int nx2 = x2 - (y3 - y2);
                    int ny2 = y2 + (x3 - x2);

                    board[ny2][nx2] = 1;
                    tempStack.push(new int[] {ny2, nx2});
                }

                clearStack();
            }
        }

        getAnswer();
        System.out.println(answer);
    }

    public static void getAnswer() {
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (board[i][j] == 1 &&
                board[i+1][j] == 1 &&
                board[i][j+1] == 1 &&
                board[i+1][j+1] == 1) {
                    answer++;
                }
            }
        }
    }

    public static void clearStack() {
        stack.clear();

        for (int[] s : tempStack) {
            stack.push(s);
        }
    }
}
