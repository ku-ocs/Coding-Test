import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        int[][] rgb = new int[num+1][3];
        int[][] cost = new int[num+1][3];
        int answer;

        for (int i = 1; i <= num; i++) {
            StringTokenizer stz = new StringTokenizer(br.readLine(), " ");
            rgb[i][0] = Integer.parseInt(stz.nextToken());
            rgb[i][1] = Integer.parseInt(stz.nextToken());
            rgb[i][2] = Integer.parseInt(stz.nextToken());
        }

        cost[1][0] = rgb[1][0];
        cost[1][1] = rgb[1][1];
        cost[1][2] = rgb[1][2];

        for (int i = 2; i <= num; i++) {
            cost[i][0] = Math.min(cost[i-1][1], cost[i-1][2]) + rgb[i][0];
            cost[i][1] = Math.min(cost[i-1][0], cost[i-1][2]) + rgb[i][1];
            cost[i][2] = Math.min(cost[i-1][0], cost[i-1][1]) + rgb[i][2];
        }

        answer = Math.min(Math.min(cost[num][0], cost[num][1]), cost[num][2]);

        System.out.println(answer);
    }
}