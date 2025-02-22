import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] board = new int[n][n];

        int answer = 0;

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(input[j]);
            }
        }

        br.close();

        int start = n / 2;
        int x = start;
        int y = start;

        int[][] directions = makeDirection();
        int[][][] spreads = makeSpreads();
        int[] spreadState = new int[] {1, 1, 2, 2, 5, 7, 7, 10, 10};
        int direction = 0;
        int continueTime = 1;
        int moveCount = 0;

        for (int i = 1; i < Math.pow(n, 2); i++) {

            if (moveCount == continueTime) {
                if (direction == 1 || direction == 3) {
                    continueTime++;
                }
                direction++;
                moveCount = 0;

                if (direction > 3) {
                    direction = 0;
                }
            }
            moveCount++;

            int moveX = x + directions[direction][0];
            int moveY = y + directions[direction][1];
            int sand = board[moveY][moveX];
            int remainSand = sand;

            for (int j = 0; j < spreadState.length; j++) {

                int nx = spreads[direction][j][0];
                int ny = spreads[direction][j][1];
                int spreadSand = sand * spreadState[j] / 100;

                int spreadX = x + nx;
                int spreadY = y + ny;

                if (spreadX < 0 || spreadX >= n || spreadY < 0 || spreadY >= n) {
                    answer += spreadSand;
                    remainSand -= spreadSand;
                    continue;
                }

                int originSand = board[spreadY][spreadX];
                board[spreadY][spreadX] = originSand + spreadSand;
                remainSand -= spreadSand;
            }

            board[moveY][moveX] = 0;
            int remainSandX = x + spreads[direction][9][0];
            int remainSandY = y + spreads[direction][9][1];

            if (remainSandX < 0 || remainSandX >= n || remainSandY < 0 || remainSandY >= n) {
                answer += remainSand;
            } else {
                board[remainSandY][remainSandX] += remainSand;
            }

            x = moveX;
            y = moveY;
        }

        System.out.println(answer);
    }


    public static int[][] makeDirection() {
        int[][] direction = new int[4][2];

        direction[0] = new int[]{-1, 0};
        direction[1] = new int[]{0, 1};
        direction[2] = new int[]{1, 0};
        direction[3] = new int[]{0, -1};

        return direction;
    }

    public static int[][][] makeSpreads() {
        int[][][] spread = new int[4][9][2];

        spread[0] = new int[][] {{0, -1}, {0, 1}, {-1, -2}, {-1, 2}, {-3, 0}, {-1, -1}, {-1, 1}, {-2, -1}, {-2, 1}, {-2, 0}};
        spread[1] = new int[][] {{-1, 0}, {1, 0}, {-2, 1}, {2, 1}, {0, 3}, {-1, 1}, {1, 1}, {-1, 2}, {1, 2}, {0, 2}};
        spread[2] = new int[][] {{0, -1}, {0, 1}, {1, -2}, {1, 2}, {3, 0}, {1, -1}, {1, 1}, {2, -1}, {2, 1}, {2, 0}};
        spread[3] = new int[][] {{-1, 0}, {1, 0}, {-2, -1}, {2, -1}, {0, -3}, {-1, -1}, {1, -1}, {-1, -2}, {1, -2}, {0, -2}};

        return spread;
    }
}
