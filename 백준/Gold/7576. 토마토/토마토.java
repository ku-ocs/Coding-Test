import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine(), " ");

        int col = Integer.parseInt(stz.nextToken());
        int row = Integer.parseInt(stz.nextToken());

        int[][] box = new int[row][col];


        Queue<int[]> queue = new LinkedList<>();
        int answer = 0;

        int[] dx = new int[] {-1, 0, 1, 0};
        int[] dy = new int[] {0, 1, 0, -1};

        boolean already = true;
        for (int i = 0; i < row; i++) {
            stz = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < col; j++) {
                int tomato = Integer.parseInt(stz.nextToken());

                if (tomato >= 1) {
                    queue.add(new int[] {i, j});
                    tomato = 1;
                }

                box[i][j] = tomato;

                if (tomato == 0) {
                    already = false;
                }
            }
        }

        if (already) {
            System.out.println(0);
            return;
        }

        while(!queue.isEmpty()) {
            int[] xy = queue.poll();
            int x = xy[0];
            int y = xy[1];
            int day = box[x][y];

            for (int z = 0; z < 4; z++) {
                int nx = x + dx[z];
                int ny = y + dy[z];

                if (nx < 0 || nx >= row || ny < 0 || ny >= col || day == -1) continue;
                if (box[nx][ny] != 0 && box[nx][ny] <= day + 1) continue;
                box[nx][ny] = day + 1;
                queue.add(new int[] {nx, ny});
            }
        }
        
        for(int[] rows : box) {
            for(int tmt : rows) {
                answer = Math.max(answer, tmt);
                if (tmt == 0) {
                    System.out.println(-1);
                    return;
                }
            }
        }

        System.out.println(answer - 1);
    }
}
