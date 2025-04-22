class Solution {
    public int solution(int n, int[] tops) {        
        int[] D1 = new int[n+1];
        int[] D2 = new int[n+1];

        if (tops[0] == 1) {
            D1[1] = 3;
        } else {
            D1[1] = 2;
        }
        D2[1] = 1;

        for (int i = 1; i < n; i++) {
            if (tops[i] == 1) {
                D1[i+1] = (D1[i]*3 + D2[i]*2) % 10007;
            } else {
                D1[i+1] = (D1[i]*2 + D2[i]) % 10007;
            }
            D2[i+1] = (D1[i] + D2[i]) % 10007;
        }

        return (D1[n] + D2[n]) % 10007;
    }
}