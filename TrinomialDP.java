// Write a program TrinomialDP.java that takes two integer command-line arguments n and k and computes the trinomial coefficient 
// T(n,k) using (bottom-up) dynamic programming.
    
public class TrinomialDP {

    public static long trinomial(int n, int k) {
        k = k + n;
        int[][] temp = new int[n + 1][Math.max(2 * n + 1, 2 * k + 1)];
        if (Math.abs(k - n) > n)
            return 0;
        else {
            for (int i = 0; i <= n - 1; i++)
                for (int j = 0; j <= 2 * n; j++) {
                    if (j == n)
                        temp[0][j] = 1;
                    if (Math.abs(j - n) > i)
                        temp[i][j] = 0;
                    else if (i >= 1)
                        temp[i][j] = temp[i - 1][j - 1] + temp[i - 1][j] + temp[i - 1][j + 1];
                }
            if (k == 0 || k == 2 * n)
                temp[n][k] = 1;
            else
                temp[n][k] = temp[n - 1][k - 1] + temp[n - 1][k] + temp[n - 1][k + 1];

            return temp[n][k];
        }
    }


    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);

        System.out.print(trinomial(n, k));
    }
}
