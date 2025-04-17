import java.io.*;
import java.util.StringTokenizer;

public class Main {
    // 2차원 배열을 1차원 배열 좌표로 나타냄
    static int[][] locArr;

    // 2차원 room 배열
    static int[][] room;

    // 각종 변수들 설정
    static int row, col, answer = -1, cnt, camCnt, size;

    // 카메라 방향과 관계된 배열 및 모음
    static int[][] dir = new int[][] {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static int[][][] cam1 = new int[][][] {{dir[0]}, {dir[1]}, {dir[2]}, {dir[3]}};
    static int[][][] cam2 = new int[][][] {{dir[0], dir[2]}, {dir[1], dir[3]}};
    static int[][][] cam3 = new int[][][] {{dir[0], dir[1]}, {dir[1], dir[2]}, {dir[2], dir[3]}, {dir[0], dir[3]}};
    static int[][][] cam4 = new int[][][] {{dir[0], dir[1], dir[2]}, {dir[1], dir[2], dir[3]}, {dir[2], dir[3], dir[0]}, {dir[3], dir[0], dir[1]}};
    static int[][][] cam5 = new int[][][] {{dir[0], dir[1], dir[2], dir[3]}};
    static int[][][][] cam = new int[][][][] {cam1, cam2, cam3, cam4, cam5};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine(), " ");

        row = Integer.parseInt(stz.nextToken());
        col = Integer.parseInt(stz.nextToken());

        size = row*col;
        locArr = new int[size][2]; // 좌표 담기위한 크기 2
        room = new int[row][col];
        int loc = 0;

        for (int i = 0; i < row; i++) {
            stz = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < col; j++) {
                int dat = Integer.parseInt(stz.nextToken());
                room[i][j] = dat;
                locArr[loc++] = new int[] {i, j};

                if(dat == 0 || dat == 6) {
                    continue;
                }

                camCnt++;
            }
        }

        if(camCnt == 0) {
            getArea();
            System.out.println(answer);
            return;
        }

        bt(0);

        System.out.println(answer);
    }

    public static void bt(int loc) {
        if (cnt == camCnt) {
            getArea();
            return;
        }

        for (int i = loc; i < size; i++) {
            int x = locArr[i][0];
            int y = locArr[i][1];

            int camera = room[x][y];
            if(camera > 0 &&
                    camera != 6) {
                drawCam(i, camera);
            }
        }
    }

    public static void drawCam(int loc, int camera) {
        int x = locArr[loc][0];
        int y = locArr[loc][1];
        int[][][] camDirArr = cam[camera - 1];

        for(int[][] camDir : camDirArr) {
            for(int[] dir : camDir) {
                int nx = x;
                int ny = y;

                while(true) {
                    nx += dir[0];
                    ny += dir[1];

                    if(nx < 0 || ny < 0 || nx >= row || ny >= col) break;
                    if(room[nx][ny] == 6) break;
                    if(room[nx][ny] <= 0) room[nx][ny] = room[nx][ny] - 1; // 보이는 곳 -1 로 변경.
                }
            }

            cnt++;
            bt(loc+1);
            cnt--;

            for(int[] dir : camDir) {
                int nx = x;
                int ny = y;

                while(true) {
                    nx += dir[0];
                    ny += dir[1];

                    if(nx < 0 || ny < 0 || nx >= row || ny >= col) break;
                    if(room[nx][ny] == 6) break;
                    if(room[nx][ny] < 0) room[nx][ny] = room[nx][ny] + 1;
                }
            }
        }
    }

    public static void getArea() {
        int size = 0;

        for(int[] arr : room) {
            for(int i : arr) {
                if (i == 0) {
                    size++;
                }
            }
        }

        if (answer < 0) {
            answer = size;
        } else {
            answer = Math.min(answer, size);
        }
    }
}

