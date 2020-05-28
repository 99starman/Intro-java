public class Minesweeper {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);
        int k = Integer.parseInt(args[2]);
        boolean[][] bool = new boolean[m+2][n+2];
        Object[][] mine = new Object[m][n];

        int randi = 1;
        int randj = 1;
        for (int t = 1; t <= k; t++) {
            randi = 1 + (int) (m * Math.random());
            randj = 1 + (int) (n * Math.random());
            if (bool[randi][randj])
                t -= 1;
            else
                bool[randi][randj] = true;
        }


        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if ((bool[i][j]))
                    mine[i-1][j-1] = "*  ";
                else {
                    int count = 0;
                    for (int p = i-1; p <= i+1; p++) {
                        for (int q = j-1; q <= j+1; q++) {
                            if (bool[p][q])
                                count += 1;
                    mine[i-1][j-1] = count + "  "; } }
                    }
                System.out.print(mine[i-1][j-1]);
            }
            System.out.println("");
            }
        }
    }