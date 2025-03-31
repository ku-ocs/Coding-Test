import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num1 = Integer.parseInt(br.readLine());
        int num2 = Integer.parseInt(br.readLine());
        int num3 = Integer.parseInt(br.readLine());

        int result = num1 * num2 * num3;
        String rs = result + "";

        String[] rsArr = rs.split("");
        int[] arr = new int[10];

        for(String s : rsArr) {
            switch (s) {
                case "0":
                    arr[0] += 1;
                    break;
                case "1":
                    arr[1] += 1;
                    break;
                case "2":
                    arr[2] += 1;
                    break;
                case "3":
                    arr[3] += 1;
                    break;
                case "4":
                    arr[4] += 1;
                    break;
                case "5":
                    arr[5] += 1;
                    break;
                case "6":
                    arr[6] += 1;
                    break;
                case "7":
                    arr[7] += 1;
                    break;
                case "8":
                    arr[8] += 1;
                    break;
                default:
                    arr[9] += 1;
            }
        }

        for(int i : arr) {
            System.out.println(i);
        }
    }
}