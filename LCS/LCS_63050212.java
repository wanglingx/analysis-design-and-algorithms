package LCS;

class LCS_63050212 {
    public static void main(String[] args) {
        String s1 = "cabcbaababb";
        String s2 = "abcdbcadba";

        char[] X = s1.toCharArray();
        char[] Y = s2.toCharArray();

        int m = X.length;
        int n = Y.length;

        int temp[][] = new int[m + 1][n + 1];

        try {
            for (int i = 0; i <= m; i++) {
                for (int j = 0; j <= n; j++) {
                    if (i == 0 || j == 0)
                        temp[i][j] = 0;
                    else if (X[i - 1] == Y[j - 1])
                        temp[i][j] = temp[i - 1][j - 1] + 1;
                    else
                        temp[i][j] = Math.max(temp[i - 1][j], temp[i][j - 1]);
                }

            }
        } catch (ArrayIndexOutOfBoundsException ex) {
        }

        display(temp);
        int row = m, col = n;
        int pos = temp[m][n];
        int map = pos;
        char tracking[] = new char[pos + 1];
        //char track[] = new char[pos + 1];
        try{
            while (row > 0 && col > 0) {
                if (temp[row - 1][col] == temp[row][col - 1]) {
                    tracking[pos] = Y[col - 1];
                    row--;
                    col--;
                    pos--;

                } else if (temp[row - 1][col] > temp[row][col - 1])
                    row--;
                else
                    col--;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
        }
    
    //     try{
    //     int pos2 = 1;
    //     for (int i = 1; i <= m; i++) {
    //         for (int j = 1; j <= n; j++) {
    //             if (temp[i][j] == temp[i+1][j - 1]) {
    //                 track[pos2] = X[i + 1];
    //                 pos2++;
    //                 if (pos2 == 5)
    //                 break;
    //         } else if (temp[i][j] < temp[i+1][j - 1]) {
    //             i++;
    //             }else j++;
                
    //         } 
    //     }
    // }catch(ArrayIndexOutOfBoundsException e){}
        // System.out.println("LCSs is "+X+" and "+Y+" >> ");
        for (int k = 0; k < map; k++) {
            System.out.print(tracking[k]);

        }
        System.out.println();
        System.out.println("Tracking length >> " + temp[m][n]);
    }

    static void display(int arr[][]) {
        for (int x = 0; x <= 11; x++) {
            for (int y = 0; y <= 10; y++) {
                System.out.print(arr[x][y] + " ");
            }
            System.out.println();
        }
    }
}
