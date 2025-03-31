import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine(), " ");

        int num1 = Integer.parseInt(stz.nextToken());
        int num2 = Integer.parseInt(stz.nextToken());
        int num3 = Integer.parseInt(stz.nextToken());

        StringBuilder sb = new StringBuilder();

        if (num1 > num2) {
            if (num1 > num3) {
                if (num2 > num3) {
                    sb.append(num3).append(" ").append(num2).append(" ").append(num1);
                } else {
                    sb.append(num2).append(" ").append(num3).append(" ").append(num1);
                }
            } else {
                sb.append(num2).append(" ").append(num1).append(" ").append(num3);
            }
        } else {
            if (num1 > num3) {
                sb.append(num3).append(" ").append(num1).append(" ").append(num2);
            } else {
                if (num2 > num3) {
                    sb.append(num1).append(" ").append(num3).append(" ").append(num2);
                } else {
                    sb.append(num1).append(" ").append(num2).append(" ").append(num3);
                }
            }
        }
        
        System.out.println(sb);
    }
}