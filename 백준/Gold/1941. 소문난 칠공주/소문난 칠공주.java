import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int[][][] cls = new int[5][5][2];    // classroom 배열
    static int[] btVis = new int[26];           // 백트래킹 방문 배열
    static int[][] locArr = new int[26][2];     // btVis 와 cls 배열 위치 연결확인용
    static int[] dx = {-1, 0, 1, 0};            // x 방향 배열 - bfs
    static int[] dy = {0, 1, 0, -1};            // y 방향 배열 - bfs
    static int answer = 0;                      // 총 경우의 수
    static int S = 0;                           // S 파의 수 - bt 시 입력
    static int Y = 0;                           // Y 파의 수 - bt 시 입력
    static int cnt = 0;                         // 백트래킹 방문 시 증가, 차감

    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sCount = 0;

        // S 와 Y 에 해당하는 값 classroom 배열에 입력
        int loc = 1;
        for(int i = 0; i < 5; i++) {
            String[] arr = br.readLine().split("");
            for (int j = 0; j < 5; j++) {
                if (arr[j].equals("S")) {
                    sCount++;
                    cls[i][j] = new int[] {1, loc};  // S 는 1
                } else {
                    cls[i][j] = new int[] {0, loc};  // Y 는 0
                }
                locArr[loc] = new int[] {i, j};
                loc++;
            }
        }

        // 총 S 파가 4명 보다 작으면 경우의수는 0
        if (sCount < 4) {
            System.out.println(0);
            return;
        }

        // 백트래킹 시작
        bt(1);

        System.out.println(answer);
    }

    public static void bt(int s) {
        // Y파가 3명을 넘아가면 자동으로 실패
        // S파 4명 이상 불가능
        if(Y > 3) {
            return;
        }

        // 7명을 채웠을 때 bfs 검사 - boolean
        if(cnt == 7) {
            if(bfs()) {
                answer++;
            }
            return;
        }

        for (int i = s; i <= 25; i++) {
            if(btVis[i] == 0) {
                btVis[i] = 1;
                int x = locArr[i][0];
                int y = locArr[i][1];
                boolean pa = false; // S 파일 경우 true / 아니면 false

                if (cls[x][y][0] == 1) {
                    pa = true;
                }

                if (pa) {
                    S++;
                } else {
                    Y++;
                }

                cnt++;
                bt(i + 1);
                btVis[i] = 0;
                cnt--;

                if (pa) {
                    S--;
                } else {
                    Y--;
                }
            }
        }
    }

    public static boolean bfs() {
        int[][] bfsVis = new int[5][5];
        int bfsCnt = 0;
        queue.clear();

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                int loc = cls[i][j][1];
                if(btVis[loc] == 1 && bfsVis[i][j] == 0) {
                    queue.offer(new int[] {i, j});
                    bfsVis[i][j] = 1;
                    bfsCnt++;
                }

                if (bfsCnt > 1) {
                    return false;
                }

                while (!queue.isEmpty()) {
                    int[] xy = queue.poll();
                    int x = xy[0];
                    int y = xy[1];

                    for (int k = 0; k < 4; k++) {
                        int nx = x + dx[k];
                        int ny = y + dy[k];

                        if (nx < 0 || nx >= 5 || ny < 0 || ny >= 5) continue;
                        int nLoc = cls[nx][ny][1];

                        if (btVis[nLoc] == 0 || bfsVis[nx][ny] == 1) continue;
                        bfsVis[nx][ny] = 1;
                        queue.offer(new int[] {nx, ny});
                    }
                }
            }
        }
        return true;
    }
}

