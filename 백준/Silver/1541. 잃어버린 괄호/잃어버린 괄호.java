import java.io.*;

public class Main {
    static long answer, temp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        String[] arr = line.split("-");
        for (int i = 0; i < arr.length; i++) {
            String[] arr2 = arr[i].split("\\+");
            temp = 0;

            for(String s : arr2) {
                temp += Long.parseLong(s);
            }

            if (i == 0) {
                answer += temp;
            } else {
                answer -= temp;
            }
        }

        System.out.println(answer);
        br.close();
    }
}