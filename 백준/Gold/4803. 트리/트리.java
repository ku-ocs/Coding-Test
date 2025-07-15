import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static boolean isTree;
    static int node, line, cnt, number;
    static boolean[] vis;
    static List<ArrayList<Integer>> lineList = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stz;

        number = 0;
        while (true) {
            stz = new StringTokenizer(br.readLine(), " ");
            node = Integer.parseInt(stz.nextToken());
            line = Integer.parseInt(stz.nextToken());
            if (node == 0 && line == 0) {
                break;
            }
            number++;
            cnt = 0;
            vis = new boolean[node+1];
            lineList = new ArrayList<>();
            for (int i = 0; i <= node; i++) {
                lineList.add(new ArrayList<>());
            }

            for (int i = 1; i <= line; i++) {
                stz = new StringTokenizer(br.readLine(), " ");
                int s = Integer.parseInt(stz.nextToken());
                int e = Integer.parseInt(stz.nextToken());
                lineList.get(s).add(e);
                lineList.get(e).add(s);
            }

            for (int i = 1; i <= node; i++) {
                if (!vis[i]) {
                    isTree = true;
                    dfs(i, i);
                    if (isTree) {
                        cnt++;
                    }
                }
            }

            StringBuilder sb = new StringBuilder();
            sb.append("Case ").append(number).append(": ");

            if (cnt > 1) {
                sb.append("A forest of ").append(cnt).append(" trees.\n");
            } else if (cnt == 1) {
                sb.append("There is one tree.\n");
            } else {
                sb.append("No trees.\n");
            }

            bw.write(sb.toString());
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(int n, int p) {
        vis[n] = true;
        ArrayList<Integer> list = lineList.get(n);
        for (int i : list) {
            if (i == p) continue;
            if (vis[i]) isTree = false;
            else dfs(i, n);
        }
    }
}