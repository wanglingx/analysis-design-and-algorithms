package Prim_Algorithms;
//minimum spanning tree
class DM7_1 {
    public static void main(String[] args) {
        Prim fx = new Prim();
        System.out.println("---Minimum Spanning Tree---");
        fx.condition();
    }
}

class Prim {
    // static Scanner dm = new Scanner(System.in);
    private int point; // Contructor
    private int ATC[][] = {
                                {0, 10, 0, 30, 45, 0}, //A
        						{10, 0, 50, 0, 40, 25}, //B
        						{0, 50, 0, 0, 35, 15},  //C
        						{30, 0, 0, 0, 0, 20},   //D
        						{45, 40, 35, 0, 0, 55}, //E
        						{0, 25, 15, 12, 55, 0}, //F
    };
    int count = ATC.length;
    private int sum [] = new int[count];
    public void condition() {
        point =0;
        boolean[] choose = new boolean[count];
        for (int q = 0; q < choose.length; q++) {
            choose[q] = false;
            choose[0] = true;
        }
        while (point < count) {
            int row = 0, col = 0, minimum = Integer.MAX_VALUE;
            for (int i = 0; i < count; i++) {
                if (choose[i] == true) {
                    for (int j = 0; j < count; j++) {
                        if (!choose[j] && ATC[i][j] != 0) {
                            if (minimum > ATC[i][j]) {
                                minimum = ATC[i][j];
                                row = i;
                                col = j;
                            }
                        }
                    }
                }
            }
            choose[col] = true;
            point += 1;
            if (point == choose.length) {
                continue;
            }
            // selected out of shortest distance.
            sum[point] = ATC[row][col];
            printGraph(row, col);
        }
        diasplay(sum);
    }
    void printGraph(int row,int col){
        int e1 = row+65;
        char edge1 = (char)e1;
        int e2 = col+65;
        char edge2 = (char)e2;
        System.out.printf("%-4s %-6s %-4d %-7s %-4s \n", edge1, "-----", ATC[row][col], "-----", edge2);
    }
    void diasplay(int sum[]){
        int ans = 0;
        for(int i = 1;i<sum.length;i++){
            ans = ans +sum[i];
        }
        System.out.println("total_distance : "+ ans);
    }
}
