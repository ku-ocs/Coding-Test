import java.util.*;

class Solution {
    static int answer;
    static Stack<Integer> stack = new Stack<>();
    static boolean[] isPrime = new boolean[3001];
    public int solution(int[] nums) {
        answer = 0;
        Arrays.fill(isPrime, true);
        for (int i = 2; i <= 3000; i++) {
            for (int j = 1; i*j <= 3000; j++) {
                int idx = i*j;
                if (j == 1) {
                    if (isPrime[idx]) {
                        continue;
                    } else {
                        break;
                    }
                }
                isPrime[idx] = false;
            }
        }
        
        bt(nums, 0, 0);

        return answer;
    }
    
    public static void bt(int[] nums, int s, int cnt) {
        if (cnt == 3) {
            int sum = 0;
            for (int i : stack) {
                sum += i;
            }
            if (isPrime[sum]) answer++;
            return;
        }
        
        for (int i = s; i < nums.length; i++) {
            stack.push(nums[i]);
            bt(nums, i+1, cnt+1);
            stack.pop();
        }
    }
}