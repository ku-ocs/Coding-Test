import java.io.*;
import java.util.StringTokenizer;

public class Main{

    public static int[] queue;
    public static int front = 0;
    public static int back = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stz;

        int cnt = Integer.parseInt( br.readLine() );

        queue = new int[cnt];

        for(int i = 0; i < cnt; i++) {
            stz = new StringTokenizer(br.readLine(), " ");

            switch (stz.nextToken()) {
                case "push":
                    push(Integer.parseInt(stz.nextToken()));
                    break;
                case "front":
                    bw.write(front() + "\n");
                    break;
                case "back":
                    bw.write(back() + "\n");
                    break;
                case "size":
                    bw.write(size() + "\n");
                    break;
                case "empty":
                    bw.write(empty() + "\n");
                    break;
                case "pop":
                    bw.write(pop() + "\n");
                    break;
                default:
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static void push(int i) {
        queue[back++] = i;
    }

    public static int pop() {
        int num = queue[front];
        if (num > 0) {
            queue[front++] = -1;
            return num;
        } else {
            return -1;
        }
    }

    public static int size() {
        return back - front;
    }

    public static int empty() {
        if (size() == 0) {
            return 1;
        } else {
            return 0;
        }
    }

    public static int front() {
        int num = queue[front];
        if (num == 0) {
            return -1;
        } else {
            return num;
        }
    }

    public static int back() {
        if(back > 0) {
            int num = queue[back - 1];
            if (num == 0) {
                return -1;
            } else {
                return num;
            }
        } else {
            return -1;
        }
    }
}