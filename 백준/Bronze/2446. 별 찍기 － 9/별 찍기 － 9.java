import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        for (int i = num; i > 0; i--) {
            for(int j = 0; j < num - i; j++) {
                System.out.print(" ");
            }
            for(int j = 0; j < i; j++) {
                System.out.print("*");
            }
            for(int j = 0; j < i - 1; j++) {
                System.out.print("*");
            }
            System.out.print(" ");
            System.out.println();
        }

        for (int i = 2; i <= num; i++) {
            for(int j = 0; j < num - i; j++) {
                System.out.print(" ");
            }
            for(int j = 0; j < i; j++) {
                System.out.print("*");
            }
            for(int j = 0; j < i - 1; j++) {
                System.out.print("*");
            }
            if(num == i) {
                break;
            }
            System.out.print(" ");
            System.out.println();
        }
    }
}