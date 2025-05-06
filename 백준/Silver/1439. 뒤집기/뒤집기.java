import java.io.*;

public class Main {
    static int answer = 0;
    static String[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        arr = line.split("");

        String temp = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (!arr[i].equals(temp)) {
                temp = arr[i];
                answer++;
            }
        }
        
        System.out.println(answer/2 + answer%2);
    }
}
