import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        int[] stair = new int[num+1];

        for (int i = 1; i <= num; i++) {
            stair[i] = Integer.parseInt(br.readLine());
        }

        if (num == 1) {
            System.out.println(stair[1]);
            return;
        }

        int[][] score = new int[num+1][2];

        score[1][0] = stair[1];
        score[2][0] = stair[2];
        score[2][1] = stair[1] + stair[2];

        for (int i = 3; i <= num; i++) {
            score[i][0] = Math.max(score[i-2][0], score[i-2][1]) + stair[i];
            score[i][1] = score[i-1][0] + stair[i];
        }

        System.out.println(Math.max(score[num][0], score[num][1]));
    }
}