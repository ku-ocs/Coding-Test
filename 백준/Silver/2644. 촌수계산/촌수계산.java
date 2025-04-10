import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz;
        int person = Integer.parseInt(br.readLine());

        stz = new StringTokenizer(br.readLine(), " ");
        int start = Integer.parseInt(stz.nextToken());
        int end = Integer.parseInt(stz.nextToken());

        if (start == end) {
            System.out.println(0);
            return;
        }

        int size = Integer.parseInt(br.readLine());

        int[][] map = new int[person+1][person+1];
        int[][] vis = new int[person+1][person+1];

        for(int i = 0; i < size; i++) {
            stz = new StringTokenizer(br.readLine(), " ");
            int parent = Integer.parseInt(stz.nextToken());
            int child = Integer.parseInt(stz.nextToken());

            map[parent][child] = 1;
            map[child][parent] = 1;
        }

        Stack<int[]> stack = new Stack<>();

        for(int i = 1; i < person+1; i++) {
            if (map[start][i] == 1) {
                stack.push(new int[] {start, i});
                vis[start][i] = 1;
            }
        }

        while(!stack.isEmpty()) {
            int[] se = stack.pop();
            int s = se[0];
            int e = se[1];

            for (int i = 1; i < person+1; i++) {
                if(map[e][i] == 1 && i == end) {
                    System.out.println(vis[s][e] + 1);
                    return;
                }

                if (map[e][i] == 1 && vis[e][i] == 0) {
                    stack.push(new int[]{e, i});
                    vis[e][i] = vis[s][e] + 1;
                }
            }
        }

        System.out.println(-1);
    }
}
